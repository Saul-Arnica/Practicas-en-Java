package Practico5;
import java.util.*;
public class Empresa {
    public static void main(String[] args) {

        Calendar fecha = new GregorianCalendar();
        fecha.set(2022,9,30);

        Persona persona1 = new Persona(43205368, "Agustin", "Arnica", 2001);
        Persona persona2 = new Persona(44522923, "Fiorella", "Arduino", 2001);
        Empleado empleado1 = new Empleado(41007890, "Mariana", "Lopez", 2003, 21410078908L, 110, fecha);
        Empleado empleado2 = new Empleado(38445678, "Jorge", "Perez", fecha, 11384456780L, 200, 2022);

        persona1.mostrar();
        persona2.mostrar();
        empleado1.mostrar();
        empleado2.mostrar();
    }
}
