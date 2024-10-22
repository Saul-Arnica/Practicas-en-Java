/*
El generador de figuras geométricas también debe permitir definir rectángulos. La clase Rectangulo tiene como datos 
miembro: el origen (esquina inferior izquierda) que es un objeto de la clase Punto y las dimensiones ancho y alto. El 
constructor que recibe sólo las dimensiones (ancho-alto) crea un rectángulo cuyo origen está situado en el punto (0, 0). El 
otro constructor crea un rectángulo situado en un determinado punto p y con las dimensiones que recibe como 
parámetros. Se desea poder desplazar el rectángulo, trasladando su origen a otra posición, sin cambiar sus dimensiones. 
Para ello se deberá desplazar el objeto colaborador Punto que representa al origen. Además, se desea calcular el área y el 
perímetro e implementar un método que permita mostrar todas las características del rectángulo, con el siguiente 
formato:
            ****** Rectangulo ******
            Origen: (0.0, 0.0) - Alto: 200.0 - Ancho: 100.0
            Superficie: 20000.0 - Perímetro: 600.0  

Implementar además un método que permita calcular la 
distancia entre dos rectángulos, que estará representada 
por la distancia entre sus orígenes, y otro método que 
indique, entre dos rectángulos, cual es el mayor, en 
función del tamaño de su superficie. 
En la clase CreaFigura creada previamente agregar:
• crear un rectángulo situado en el punto (0, 0) y cuyas 
dimensiones sean generadas a partir de números 
aleatorios
• desplazar el rectángulo a otro punto situado 40 
unidades hacia la derecha y 20 hacia abajo
• mostrar las características del rectángulo creado
• crear otro rectángulo con origen en el punto (7.4, 4.5) 
y cuyas dimensiones sean nuevos números aleatorios.
• mostrar las características del mayor de los dos rectángulos
• mostrar la distancia entre los dos rectángulos

 */


public class Rectangulo {
    private Punto origen;
    private double ancho;
    private double alto;
    //Construcctor 
    public Rectangulo (Punto p_origen, double p_ancho, double p_alto) {
        this.setOrigen(p_origen);
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
    }

    public Rectangulo (double p_ancho, double p_alto) {

        this.setAncho(p_ancho);
        this.setAlto(p_alto);
    }

    //Accesor's (setter's)

    private void setOrigen(Punto p_origen) {
        this.origen = p_origen;
    }

    private void setAncho(double p_ancho) {
        this.ancho = p_ancho;
    }

    private void setAlto(double p_alto) {
        this.alto = p_alto;
    }
    //(getter's)

    public Punto getOrigen () {
        return this.origen;
    }
    
    public double getAncho() {
        return this.ancho;
    }

    public double getAlto() {
        return this.alto;
    }

    //Resto de funciones establecidas en el UML.

    public void desplazar (double p_dx, double p_dy) {
        Punto p_origen = new Punto(p_dx, p_dy);
        this.setOrigen(p_origen);
    }
    
    public void caracteristicas() {
        System.out.println("\n******* Rectangulo *******");
        System.out.print("Origen: (" + this.getOrigen().getX() + ", " + this.getOrigen().getY() + ")");
        System.out.println("- Alto: " + this.getAlto() + " - Ancho: " + this.getAncho());
        System.out.println("Superficie: " + this.superficie() + " - Perimetro: " + this.perimetro());
    }

    public double perimetro() {
        return 2 * (this.getAlto() + this. getAncho());
    }

    public double superficie() {
        return this.getAlto() * this.getAncho();
    }

    public double distanciaA(Rectangulo otroRectangulo) {
        return Math.sqrt(Math.pow(otroRectangulo.getOrigen().getX() - this.getOrigen().getX(), 2) 
                            + (Math.pow( otroRectangulo.getOrigen().getY() - this.getOrigen().getY(), 2)));

    }
    //Math.sqrt(Math.pow(otroCirculo.getCentro().getX() - this.getCentro().getX(), 2) + (Math.pow(otroCirculo.getCentro().getY() - this.getCentro().getY(), 2)));
    public Rectangulo elMayor(Rectangulo otroRectangulo) {
        Rectangulo elMayor;
        if(otroRectangulo.superficie() > this.superficie()) {
            elMayor = otroRectangulo;
        }else{
            elMayor = this;
        }
        return elMayor;
    }
}
