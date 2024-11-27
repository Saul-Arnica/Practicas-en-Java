package Practico5;

/**
 * 
 * 
 * @author Saul Agustin Arnica
 * @version 29/08/24 : 20:47:25 PM
 */
public class Circulo {
    private double radio;
    private Punto centro;

    public Circulo(double p_radio, Punto p_centro) {
        this.setCentro(p_centro);
        this.setRadio(p_radio);
    }
    public Circulo() {
        this.setRadio(0);
    }
    private void setCentro(Punto p_centro) {
        this.centro = p_centro;
    }
    private void setRadio(double p_radio) {
        this.radio = p_radio;
    }
    public Punto getCentro() {
        return this.centro;
    }
    public double getRadio() {
        return this.radio;
    }

    public void nombreFigura() {
        System.out.println("****** Circulo ******");
    }
    public void desplazar(double p_dx, double p_dy) {
        this.getCentro().desplazar(p_dx, p_dy);
    }
    public void caracteristicas() {
        System.out.println("\n******* Circulo *******");
        System.out.print("Centro: (" + this.getCentro().getX() + ", " + this.getCentro().getY() + ")");
        System.out.println("- Radio: " + this.getRadio());
        System.out.println("Superficie: " + this.superficie() + " - Perimetro: " + this.perimetro());
    }
    public double perimetro() {       
        double PI = Math.PI;
        return 2 * PI * this.getRadio();
    }
    public double superficie() {
        double PI = Math.PI;
        return  (PI * Math.pow(this.getRadio(), 2)); //Aca retornamos la formula de PI x r^2 que seria para calcular la superficie.
    }
    /**
     * Usamos la formula de Pitagoras.
     * @param otroCirculo
     * @return la distancia entre dos circulos, que se representa por la distancia entre sus centros.
     */
    public double distanciaA(Circulo otroCirculo) {
        return Math.sqrt(Math.pow(otroCirculo.getCentro().getX() - this.getCentro().getX(), 2) 
                        + (Math.pow(otroCirculo.getCentro().getY() - this.getCentro().getY(), 2)));
    }
    /**
     * 
     * @param otroCirculo
     * @return el circulo mas grande en superficie.
     */
    public Circulo elMayor(Circulo otroCirculo) {
        Circulo elMayor;
        if(otroCirculo.superficie() > this.superficie()) {
            elMayor = otroCirculo;
        }else{
            elMayor = this;
        }
        return elMayor;
    }
}

