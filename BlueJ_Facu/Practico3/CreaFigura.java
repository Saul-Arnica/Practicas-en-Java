import java.util.*;
import java.util.Scanner;
/*
Por último, implementar una clase ejecutable CreaFigura donde deberá:
• crear un círculo centrado en el punto (0, 0) y cuyo radio surja de un número aleatorio
• desplazar el círculo a otro punto situado 240 unidades hacia la izquierda y 230 hacia abajo
• mostrar las características del círculo creado 
• crear otro círculo centrado en el punto (5.2, 0.5) y cuyo radio sea un nuevo número aleatorio.
• mostrar las características del mayor de los dos círculos
• mostrar la distancia entre los dos círculos 
• Nota 1: A los efectos de este ejercicio, considerar que siempre existe un mayor (es una simplificación de la realidad, que cumple con 
los objetivos de este ejercicio)
• Nota 2: para obtener un numero aleatorio (importar el paquete java.util.Random)
Random unNumero = new Random();
double radio = unNumero.nextDouble() * 100.0;
*/
public class CreaFigura {
    public static void main(String[] args) {
        
        Scanner ingreso = new Scanner(System.in);
        Random unNumero = new Random();
        double radio = unNumero.nextDouble() * 100;

        System.out.print("Ingrese los valores del centro: X:");
        double x = ingreso.nextDouble();
        System.out.println("Ingrese Y:");
        double y = ingreso.nextDouble();

        ingreso.close();
        
        Punto centro = new Punto(x, y);
        Circulo circulo1 = new Circulo(radio, centro);
        circulo1.caracteristicas();
        circulo1.desplazar(-240, -230);
        circulo1.caracteristicas();
        
        Random unNumero2 = new Random();
        double radio2 = unNumero2.nextDouble() * 100;
        x = 5.2;
        y = 0.5;
        Punto centro2 = new Punto(x,y);
        Circulo circulo2 = new Circulo(radio2, centro2);
        Circulo elMayor = new Circulo();
        circulo2.caracteristicas();
        elMayor = circulo1.elMayor(circulo2);
        elMayor.caracteristicas();
        
    }
}
