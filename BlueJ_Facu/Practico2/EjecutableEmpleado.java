
/**
 * Es el ejecutable de la clase Empleado.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

@SuppressWarnings("all")

public class EjecutableEmpleado {
    public static void main(String[] args) {

        Scanner ingreso = new Scanner(System.in);

        System.out.println("Ingrese el CUIL: ");
        long p_cuil = ingreso.nextLong();
        System.out.println("Ingrese el Apellido: ");
        String p_apellido = ingreso.nextLine();
        System.out.println("Ingrese el Nombre: ");
        String p_nombre = ingreso.nextLine();
        System.out.println("Ingrese el Importe: ");
        double p_importe = ingreso.nextDouble();
        System.out.println("Ingrese el anio de Ingreso: ");
        int p_anioIngreso = ingreso.nextInt();

        Empleado empleado = new Empleado(p_cuil, p_apellido,p_nombre ,p_importe ,p_anioIngreso);
    }
}
