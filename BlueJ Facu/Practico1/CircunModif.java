import java.util.Scanner;

public class CircunModif {

    private static float perimetro;
    private static final float PI = 3.14F;
    
    public static void main(String[] args) {
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