 
public class Evento{

    private int id;
    private int seudoaleatorio;
    private boolean esFin;
    private int ns;
    private int servidorAsignado;

    public Evento(int id, int seudoaleatorio, boolean esFin, int ns) {
        this.id = id;
        this.seudoaleatorio = seudoaleatorio;
        this.esFin = esFin;
        this.ns = ns;
        this.servidorAsignado = (int) (Math.random() * ns);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeudoaleatorio() {
        return seudoaleatorio;
    }

    public void setSeudoaleatorio(int seudoaleatorio) {
        this.seudoaleatorio = seudoaleatorio;
    }

    public boolean isEsFin() {
        return esFin;
    }

    public void setEsFin(boolean esFin) {
        this.esFin = esFin;
    }

}