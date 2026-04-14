public class Servidor extends Thread{

    private int id;
    private Buzon buzonConsolidacion;
    private int eventosRecibidos;

    public Servidor(int id, Buzon buzonConsolidacion, int eventosRecibidos) {
        this.id = id;
        this.buzonConsolidacion = buzonConsolidacion;
        this.eventosRecibidos = eventosRecibidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Buzon getBuzonConsolidacion() {
        return buzonConsolidacion;
    }

    public void setBuzonConsolidacion(Buzon buzonConsolidacion) {
        this.buzonConsolidacion = buzonConsolidacion;
    }

    public int getEventosRecibidos() {
        return eventosRecibidos;
    }

    public void setEventosRecibidos(int eventosRecibidos) {
        this.eventosRecibidos = eventosRecibidos;
    }

}