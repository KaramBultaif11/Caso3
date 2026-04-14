import java.util.concurrent.CyclicBarrier;

public class Clasificadores extends Thread{

    private int id;
    private Buzon buzonClasificacion;
    private Servidor[] servidores;
    private CyclicBarrier barrera;

    public Clasificadores(int id, Buzon buzonClasificacion, Servidor[] servidores, CyclicBarrier barrera) {
        this.id = id;
        this.buzonClasificacion = buzonClasificacion;
        this.servidores = servidores;
        this.barrera = barrera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Buzon getBuzonClasificacion() {
        return buzonClasificacion;
    }

    public void setBuzonClasificacion(Buzon buzonClasificacion) {
        this.buzonClasificacion = buzonClasificacion;
    }

    public Servidor[] getServidores() {
        return servidores;
    }

    public void setServidores(Servidor[] servidores) {
        this.servidores = servidores;
    }

    public CyclicBarrier getBarrera() {
        return barrera;
    }

    public void setBarrera(CyclicBarrier barrera) {
        this.barrera = barrera;
    }

}