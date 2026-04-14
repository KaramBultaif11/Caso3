
public class Sensor extends Thread{

    private int id;
    private int numeroEventos;
    private Buzon buzonEntrada;

    public Sensor(int id, int numeroEventos, Buzon buzonEntrada) {
        this.id = id;
        this.numeroEventos = numeroEventos;
        this.buzonEntrada = buzonEntrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    

}