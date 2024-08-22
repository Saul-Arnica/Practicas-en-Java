/**
 * 9_ Crear una clase denominada OrdenVector, que permita ingresar por teclado (Scanner) 4 elementos de tipo doble, y almacenarlos en un array. 
 * Determinar el menor elemento y mostrarlo. Ordenar los elementos del vector de menor a mayor. 
 * Mostrar los elementos ordenados, separados por un tabulador.
 * Usar instrucción FOR para el ingreso de datos. Utilizar método de la Burbuja
 * @author (Saul Agustin Arnica)
 * @version (18/8/24)
*/
import java.util.Scanner;

public class OrdenVector {
    public static void main(String[] args) {
        final int v_max = 4;
        double[] A_double = new double[v_max];
        double numMenor  = Double.MAX_VALUE;
        double aux;
        Scanner ingreso = new Scanner(System.in);
        
        for(int i = 0;i < v_max;i++) {
            System.out.print("Ingrese su numero decimal:");
            A_double[i] = ingreso.nextDouble();
        }
        ingreso.close();

        for(int i = 0;i < v_max; i++) {

            if(A_double[i] < numMenor) {
                numMenor = A_double[i];
            }

            for(int j = 0;j < v_max - 1;j++) {

                if(A_double[j] > A_double[j + 1]) {
                    aux = A_double[j];
                    A_double[j] = A_double[j + 1];
                    A_double[j + 1] = aux;
                }
            }
        }
        System.out.println("Los elementos ordenados son:");
        for(int i = 0;i < v_max;i++) {
            System.out.print(A_double[i] + "\t");
        }
        System.out.println("El menor elemento es: ");
        System.out.format("%2.2f", numMenor);
    }
}
