import java.util.*;
/**
 * 
 */
public class ArrayDePuntos {
    public static void main(String[] args) {
        Punto[] arrayPuntos = new Punto[6]; 
        Scanner ingreso = new Scanner(System.in);
    
        for(int i = 0;i < arrayPuntos.length;i++) {
            System.out.println("Ingrese coordenada X para la posicion " + (i+1) + " :");
            double x = ingreso.nextDouble();
            ingreso.nextLine();
            System.out.println("Ingrese coordenada Y:");
            double y = ingreso.nextDouble();
            Punto punto = new Punto(x, y);
            arrayPuntos[i] = punto;
        }
        ingreso.close();
        for(int i = 0; i < arrayPuntos.length; i++) {
            System.out.println("Coordenadas punto " + (i+1) + " :" + arrayPuntos[i].coordenadas());
        }
        for(int i = 0; i < arrayPuntos.length; i++) {
            if(i%2 == 0){
                System.out.println("La distancia entre el punto " + (i+1) + " y el punto " + (i+2) + " es: " + arrayPuntos[i].distanciaA(arrayPuntos[i+1]));
            }
        }
    }
} 

/*
1. Crear una clase ejecutable llamada ArrayDePuntos, donde se haga lo siguiente:
1.1. Crear un contenedor estático de seis elementos de tipo Punto, llamado puntos. 
1.2. Agregar como elementos instancias de la clase Punto. Ingresar los datos por teclado.
1.3. Recorrer el array e imprimir las coordenadas de cada elemento, utilizando el método previsto en la clase Punto.
1.4. Imprimir en pantalla la distancia cada 2 elementos consecutivos del contenedor (Ej: distancia pto1-pto2, distancia 
pto2-pto3, etc)
 */