public class Sensor extends Thread{

    private int id;
    private int numeroEventos;
    private Buzon buzonEntrada;
    private int numeroServidores;

    public Sensor(int id, int numeroEventos, Buzon buzonEntrada, int numeroServidores) {
        this.id = id;
        this.numeroEventos = numeroEventos;
        this.buzonEntrada = buzonEntrada;
        this.numeroServidores = numeroServidores;
    }

    public int getIdSensor() {
        return id;
    }

    public void setIdSensor(int id) {
        this.id = id;
    }

    public int getNumeroEventos() {
        return numeroEventos;
    }

    public void setNumeroEventos(int numeroEventos) {
        this.numeroEventos = numeroEventos;
    }

    public Buzon getBuzonEntrada() {
        return buzonEntrada;
    }

    public void setBuzonEntrada(Buzon buzonEntrada) {
        this.buzonEntrada = buzonEntrada;
    }

    public void run() {

        for (int i = 0; i < numeroEventos; i++) {
            boolean esFin = false;
            int numeroAleatorio = (int) (Math.random() * numeroServidores) + 1;
            int idEvento = this.id * 100 + i;
            Evento evento = new Evento (idEvento, numeroAleatorio, esFin, numeroServidores);
            buzonEntrada.agregarEvento(evento);
        }
    }

}