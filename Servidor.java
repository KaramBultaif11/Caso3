public class Servidor extends Thread{

    private int idServidor;
    private Buzon buzonConsolidacion;
    private int eventosRecibidos;

    public Servidor(int idServidor, Buzon buzonConsolidacion, int eventosRecibidos) {
        this.idServidor = idServidor;
        this.buzonConsolidacion = buzonConsolidacion;
        this.eventosRecibidos = eventosRecibidos;
    }

    public int getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(int id) {
        this.idServidor = id;
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
    public void run() {
        int tiempoProcesamiento = (int) (Math.random() * 1000);
        try {
            Thread.sleep(tiempoProcesamiento);
        } catch (InterruptedException e) {
            e.printStackTrace();
        
    }
    }

}