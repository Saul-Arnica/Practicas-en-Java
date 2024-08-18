/**
 * 8_ Crear una clase denominada OperarVector que permita ingresar por teclado (Scanner) 5 notas de alumnos, las que serán almacenadas en un array de enteros. 
 * Calcular el promedio y determinar la mayor nota. El promedio debe permitir resultado con decimales (aplicar cast a los elementos enteros cuando sea necesario para obtener dicho resultado). 
 * Mostrar los elementos ingresados, separados por un tabulador. 
 * Mostrar el promedio y la mayor nota con el mensaje respectivo. 
 * @author (Saul Agustin Arnica)
 * @version (18/8/24)
*/
import java.util.Scanner;

public class OperarVector {
    public static void main(String[] args) {

        int[] A_notas = new int[5];
        Scanner ingreso = new Scanner(System.in);

        for(int i = 0;i<5; i++) {
            System.out.println("Ingrese la nota"+ (i + 1) + ":");
            A_notas[i] = ingreso.nextInt();
        }
        ingreso.close();
        
        float promedio = 0;
        int maxNota = 0;

        for(int i = 0;i<5;i++) {
            promedio = promedio + A_notas[i];
            if(A_notas[i] > maxNota) {
                maxNota = A_notas[i];
            }
        }
        
        promedio = promedio / 5;
        System.out.println("El promedio es: " + promedio +"\t y la mayor nota es:" + maxNota);
    }
}