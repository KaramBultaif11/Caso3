import java.util.concurrent.CyclicBarrier;

public class Clasificadores extends Thread{

    private int id;
    private Buzon buzonClasificacion;
    private CyclicBarrier barrera;
    private int ns;

    public Clasificadores(int id, Buzon buzonClasificacion, CyclicBarrier barrera, int ns) {
        this.id = id;
        this.buzonClasificacion = buzonClasificacion;
        this.barrera = barrera;
        this.ns = ns;
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

    public CyclicBarrier getBarrera() {
        return barrera;
    }

    public void setBarrera(CyclicBarrier barrera) {
        this.barrera = barrera;
    }

    public void run() {

        Evento eventoAnalisis = buzonClasificacion.eliminarEvento();

    }

}