import java.util.ArrayList;

public class Buzon {

    private ArrayList<Evento> eventos;
    private int capacidad;

    public Buzon(ArrayList<Evento> eventos, int capacidad) {
        this.eventos = eventos;
        this.capacidad = capacidad;
    }

    public Buzon(int capacidad) {
        this.eventos = new ArrayList<>();
        this.capacidad = capacidad;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public synchronized void agregarEvento(Evento evento) {
        while (eventos.size() >= capacidad) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        eventos.add(evento);
        notifyAll();
    }

    public synchronized Evento eliminarEvento() {

        while(eventos.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        Evento evento = eventos.remove(0);
        notify();
        return evento;
    }

    public synchronized Evento obtenerEvento(){

        return eventos.get(0);

    }

}