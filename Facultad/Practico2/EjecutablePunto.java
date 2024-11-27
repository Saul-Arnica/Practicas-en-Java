import java.util.Scanner;

public class EjecutablePunto {
    public static void main(String[] args) {
        Scanner ingreso = new Scanner(System.in);
        System.out.println("Ingrese la coordenada X:");
        double p_X = ingreso.nextDouble();
        System.out.println("Ingrese la coordenada Y:");
        double p_Y = ingreso.nextDouble();
        ingreso.close();
        
        Punto punto = new Punto();
        punto.mostrar();
        punto = new Punto(p_X, p_Y);
        punto.mostrar();
        punto.desplazar(5.0, 9.1);
        punto.mostrar();
        punto.coordenadas();
    }
}
