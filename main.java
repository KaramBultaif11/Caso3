import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CyclicBarrier;
 
public class main { 
    public static void main(String[] args) {
 
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
 
        int ns = 0;
        int nc = 0;
        int numeroSensor = 0;
        int numeroEventoPorSensor = 0;
        int capacidadBuzon = 0;
        int capacidadBuzonesNuevos = 0;
 
        try {
 
            System.out.println("Ingrese el numero de servidores con que trabajar: ");
            ns = Integer.parseInt(br.readLine());
            System.out.println("Ingrese el numero de clasificadores con que trabajar: ");
            nc = Integer.parseInt(br.readLine());
            System.out.println("Ingrese el numero de sensores con que trabajar: ");
            numeroSensor = Integer.parseInt(br.readLine());
            System.out.println("Ingrese el numero de eventos por sensor: ");
            numeroEventoPorSensor = Integer.parseInt(br.readLine());
            System.out.println("Ingrese la capacidad de los buzones de clasificacion: ");
            capacidadBuzon = Integer.parseInt(br.readLine());
            System.out.println("Ingrese la capacidad de los buzones de los servidores: ");
            capacidadBuzonesNuevos = Integer.parseInt(br.readLine());
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        int totalEventos = numeroSensor * numeroEventoPorSensor;
 
        // nc clasificadores + main = nc+1 parties en la barrera
        CyclicBarrier barrera = new CyclicBarrier(nc + 1);
 
        Buzon buzonEntrada = new Buzon(new ArrayList<>(), capacidadBuzon);
        Buzon buzonFalla  = new Buzon(new ArrayList<>(), capacidadBuzon);
        Buzon buzonPasa   = new Buzon(new ArrayList<>(), capacidadBuzon);
 
        BrokerDeEventos brokerDeEventos = new BrokerDeEventos(buzonEntrada, buzonFalla, buzonPasa, totalEventos);
        Administrador administrador = new Administrador(false, buzonFalla, buzonPasa, 0, nc);
 
        // 1. Crear servidores primero (los clasificadores los necesitan)
        HashMap<Integer, Servidor> servidores = new HashMap<>();
        for (int i = 0; i < ns; i++) {
            Buzon buzonNuevo = new Buzon(new ArrayList<>(), capacidadBuzonesNuevos);
            servidores.put(i, new Servidor(i, buzonNuevo, 0));
            servidores.get(i).start();
        }
 
        // 2. Iniciar clasificadores ANTES del broker para que buzonPasa nunca se llene sin consumidor
        for (int i = 0; i < nc; i++) {
            Clasificadores clasificador = new Clasificadores(i, buzonPasa, servidores, barrera, ns);
            clasificador.start();
        }
 
        // 3. Ahora sí iniciar sensores, broker y administrador
        for (int i = 0; i < numeroSensor; i++) {
            Sensor sensor = new Sensor(i + 1, numeroEventoPorSensor, buzonEntrada, ns);
            sensor.start();
        }
 
        System.out.println("Broker iniciando...");
        brokerDeEventos.start();
        System.out.println("Administrador iniciando...");
        administrador.start();
 
        // 4. Esperar UNA SOLA VEZ a que todos los clasificadores terminen
        try {
            barrera.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        // 5. Enviar fin a cada servidor y mostrar resultados
        for (Servidor servidor : servidores.values()) {
            servidor.getBuzonConsolidacion().agregarEvento(new Evento(-1, 0, true, 0));
        }
 

    }
}
 