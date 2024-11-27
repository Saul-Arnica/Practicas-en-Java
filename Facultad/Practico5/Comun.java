package Practico5;
/**
 * 
    @author Saul Agustin Arnica
    @version 20/10/2024
    */
public class Comun extends Etiqueta {
    
    private double plus;

    public Comun(double p_costo, double p_plus){
        super(100);
        this.setPlus(p_plus);
    }

    public double getPlus(){
        return this.plus;
    }
    private void setPlus(double p_plus){
        this.plus = p_plus;
    }

    public double precio(int q){
        return (this.getCosto() * q) + this.getPlus() - this.descuento(q);
    }

    public double descuento(int q){
        if(q<=10){
            return 0;
        }else if(q<=50){
            return (this.getCosto() * 0.02) * q;
        }else if(q<=100){
            return (this.getCosto() * 0.05) * q;
        }else{
            int decenas = (int)Math.floor(q/10);
            return this.getCosto() * 0.01 * decenas;
        }
    }

    protected String tipo(){
        return "Comun";
    }

    public String toString(){
        return super.toString() + " - Diseño: " + this.getPlus();
    }
}
