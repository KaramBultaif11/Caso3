import java.util.HashMap;
import java.util.concurrent.CyclicBarrier;

public class Clasificadores extends Thread{

    private int id;
    private Buzon buzonClasificacion;
    private HashMap<Integer, Servidor> servidores;
    private CyclicBarrier barrera;
    private int ns;

    public Clasificadores(int id, Buzon buzonClasificacion, HashMap<Integer, Servidor> servidores, CyclicBarrier barrera, int ns) {
        this.id = id;
        this.buzonClasificacion = buzonClasificacion;
        this.servidores = servidores;
        this.barrera = barrera;
        this.ns = ns;
    }

    public int getIdClasificador() {
        return id;
    }

    public void setIdClasificador(int id) {
        this.id = id;
    }

    public Buzon getBuzonClasificacion() {
        return buzonClasificacion;
    }

    public void setBuzonClasificacion(Buzon buzonClasificacion) {
        this.buzonClasificacion = buzonClasificacion;
    }
    public HashMap<Integer, Servidor> getServidores() {
        return servidores;
    }

    public CyclicBarrier getBarrera() {
        return barrera;
    }

    public void setBarrera(CyclicBarrier barrera) {
        this.barrera = barrera;
    }

    public void run() {

        Evento eventoAnalisis = buzonClasificacion.eliminarEvento();
        while (!eventoAnalisis.isEsFin()){

            servidores.get(eventoAnalisis.getServidorAsignado()).getBuzonConsolidacion().agregarEvento(eventoAnalisis);
            eventoAnalisis = buzonClasificacion.eliminarEvento();
        }
        try {
            barrera.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}