/**
 * Esta clase es una abstraccion un punto, dentro de figuras geometricas, con sus respectivos atributos, la abscisa X y la ordenada Y.
 * Nos ayuda a ubicarnos en coordenadas exactas de las figuras.
 * @author Saul Agustin Arnica
 * @version 24/08/24
 */

public class Punto {
    @SuppressWarnings("all")
    //Declaramos los atributos de la clase.
    private double x;
    private double y;

    /**
     * Construcctor de la clase donde instanciamos en 0 X e Y
     */
    public Punto() {
        this.setX();
        this.setY();
    }
    /**
     * Construcctor donde damos valores ingresados por teclado.
     * @param p_X coordenada X
     * @param p_Y   coordenada Y
     */
    public Punto(double p_X, double p_Y) {
        this.setX(p_X);
        this.setY(p_Y);
    }
    //Declaramos los setter's (El que instancia en 0 el valor interno de los atributos y el que recibe por parametros)
    private void setX() {
        this.x = 0;
    }
    private void setX(double p_X) {
        this.x = p_X;
    }
    private void setY() {
        this.y = 0;
    }
    private void setY(double p_Y) {
        this.y = p_Y;
    }
    //Declaramos los getter's 
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    /**
     * Desplazar(dx, dy) cambia la posición del punto desde (x, y) a (x+dx, y+dy).
     * @param p_dx 
     * @param p_dy
     */
    //Declaramos los metodos indicados en el UML.
    public void desplazar(double p_dx, double p_dy) {
        this.setX(this.getX() + p_dx);
        this.setY(this.getY() + p_dy);
    }
    /**
     * 
     * @return las coordenadas
     */
    public String coordenadas() {
        String cadena, cadena2;
        cadena = String.format("%.1f", this.getX());
        cadena2 = String.format("%.1f", this.getY());
        return "(" + cadena +  " , " + cadena2 + ")" ;
    }
    /**
     * 
     */
    public double distanciaA(Punto p_ptoDistante) {
        return Math.sqrt(Math.pow(p_ptoDistante.getX() - this.getX() , 2) + Math.pow(p_ptoDistante.getY() - this.getY(), 2));
    }
    /**
     * imprime las coordenadas
     */
    public void mostrar() {
        System.out.println("Punto X: " + this.getX() + " , " + "Y: " + this.getY());
    }
}