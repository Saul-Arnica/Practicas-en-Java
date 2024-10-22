package Practico5;

public abstract class Etiqueta {
    private double costo;

    public Etiqueta(double p_costo) {
        this.setCosto(p_costo);
    }

    //Accesor´s 

    private void setCosto(double p_costo) {
        this.costo = p_costo;
    }
    public double getCosto() {
        return this.costo;
    }
    protected abstract String tipo();
    public abstract double precio(int p_q);
    public String toString(){
        return "tipo " + this.tipo() + " - Costo:" + this.getCosto();
    }
}
