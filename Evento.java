 
public class Evento{

    private int id;
    private int seudoaleatorio;
    private boolean esFin;

    public Evento(int id, int seudoaleatorio, boolean esFin) {
        this.id = id;
        this.seudoaleatorio = seudoaleatorio;
        this.esFin = esFin;
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