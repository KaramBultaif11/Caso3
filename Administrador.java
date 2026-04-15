public class Administrador extends Thread{

    private boolean inicio;
    private Buzon buzonEntrada;
    private Buzon buzonClasificacion;
    private int eventosFin;
    private int nc;

    public Administrador(boolean inicio, Buzon buzonEntrada, Buzon buzonClasificacion, int eventosFin, int nc) {
        this.inicio = inicio;
        this.buzonEntrada = buzonEntrada;
        this.buzonClasificacion = buzonClasificacion;
        this.eventosFin = eventosFin;
        this.nc = nc;
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

    public void run() {

        Evento eventoAnalisis = buzonEntrada.eliminarEvento(); 

        while (!eventoAnalisis.isEsFin()){

            this.eventosFin++;

            int numeroAleatorio = (int) (Math.random() * 20);

            if (numeroAleatorio % 4 == 0){

                buzonClasificacion.agregarEvento(eventoAnalisis);

            }

            eventoAnalisis = buzonEntrada.eliminarEvento();

        }

        for (int i = 0; i < nc; i++) {
            Evento eventoFin = new Evento(-1, 0, true, 0);
            buzonClasificacion.agregarEvento(eventoFin);
        }

    }

}