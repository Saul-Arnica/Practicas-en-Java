
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
        long cuil = ingreso.nextLong();
        ingreso.nextLine();
        System.out.println("Ingrese el Apellido: ");
        String apellido = ingreso.nextLine();
        System.out.println("Ingrese el Nombre: ");
        String nombre = ingreso.nextLine();
        System.out.println("Ingrese el Importe: ");
        double importe = ingreso.nextDouble();
        System.out.println("Ingrese el anio de Ingreso: ");
        int anioIngreso = ingreso.nextInt();

        Empleado empleado = new Empleado(cuil, apellido, nombre , importe , anioIngreso);
        
        empleado.mostrar();
    }
}
