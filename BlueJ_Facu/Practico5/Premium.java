package Practico5;

public class Premium extends Etiqueta{
    private int colores;

    public Premium(double p_costo, int p_colores) {
        super(p_costo);
        this.setColores(p_colores);
    }
    //Accesor´s

    private void setColores(int p_colores) {
        this.colores = p_colores;
    }
    
    public int getColores() {
        return this.colores;
    }

    public double precio(int p_q) {
        return (this.getCosto() + this.adicional()) * p_q;
    }

    public double adicional() {
        double adicional = 0;
        if(this.getColores() > 3) {
            adicional = this.getCosto() * 0.03 * this.getColores();
        }else if(this.getColores() == 3) {
            adicional = (this.getCosto() * 0.07);
        }else if(this.getColores() == 2) {
            adicional = (this.getCosto() * 0.05);
        }else if(this.getColores() == 1) {
            adicional = 0.0;
        }
        return adicional;
    }
    protected String tipo() {
        return "Premium";
    }
    public String toString() {
        return super.toString() + "- Colores:" + this.getColores();
    }
}
