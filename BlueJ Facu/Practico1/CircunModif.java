/**
 *Modificar la clase Circunferencia para permitir que el usuario pueda calcular el perímetro de muchas circunferencias, utilizando la estructura while. 
 *Modificar además el ingreso de datos, utilizando la clase Scanner.
 * 
 *@author (Saul Agustin Arnica)
 *@version (18/8/24)
 */
import java.util.Scanner;

public class CircunModif {
    public static void main(String[] args) {
        double perimetro;
        double PI = Math.PI;
        int radio = -1;
        Scanner ingreso = new Scanner(System.in);
        while(radio != 0) {
        System.out.print("Escriba el radio de la circunferencia (0 para salir):");
        radio = ingreso.nextInt();
        if(radio == 0) {
            break;
        }else{
            perimetro = 2 * PI * radio;
            System.out.println("El perimetro de la circunferencia es:" + perimetro);
            }
        }
    ingreso.close();
    }
}