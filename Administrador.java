public class Administrador extends Thread{

    private boolean inicio;
    private Buzon buzonEntrada;
    private Buzon buzonClasificacion;
    private int eventosFin;

    public Administrador(boolean inicio, Buzon buzonEntrada, Buzon buzonClasificacion, int eventosFin) {
        this.inicio = inicio;
        this.buzonEntrada = buzonEntrada;
        this.buzonClasificacion = buzonClasificacion;
        this.eventosFin = eventosFin;
    }

    public boolean isInicio() {
        return inicio;
    }

    public void setInicio(boolean inicio) {
        this.inicio = inicio;
    }

    public Buzon getBuzonEntrada() {
        return buzonEntrada;
    }

    public void setBuzonEntrada(Buzon buzonEntrada) {
        this.buzonEntrada = buzonEntrada;
    }

    public Buzon getBuzonClasificacion() {
        return buzonClasificacion;
    }

    public void setBuzonClasificacion(Buzon buzonClasificacion) {
        this.buzonClasificacion = buzonClasificacion;
    }

    public int getEventosFin() {
        return eventosFin;
    }

    public void setEventosFin(int eventosFin) {
        this.eventosFin = eventosFin;
    }

}