public class BrokerDeEventos extends Thread{

    private Buzon buzonEntrada;
    private Buzon buzonFalla;
    private Buzon buzonPasa;
    private int contador;
    private int eventosTotales;

    public BrokerDeEventos(Buzon buzonEntrada, Buzon buzonFalla, Buzon buzonPasa, int contador, int eventosTotales) {
        this.buzonEntrada = buzonEntrada;
        this.buzonFalla = buzonFalla;
        this.buzonPasa = buzonPasa;
        this.contador = contador;
        this.eventosTotales = eventosTotales;
    }

    public Buzon getBuzonEntrada() {
        return buzonEntrada;
    }

    public void setBuzonEntrada(Buzon buzonEntrada) {
        this.buzonEntrada = buzonEntrada;
    }

    public Buzon getBuzonFalla() {
        return buzonFalla;
    }

    public void setBuzonFalla(Buzon buzonFalla) {
        this.buzonFalla = buzonFalla;
    }

    public Buzon getBuzonPasa() {
        return buzonPasa;
    }

    public void setBuzonPasa(Buzon buzonPasa) {
        this.buzonPasa = buzonPasa;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getEventosTotales() {
        return eventosTotales;
    }

    public void setEventosTotales(int eventosTotales) {
        this.eventosTotales = eventosTotales;
    }

}