
/**
 * El diagrama de clase adjunto representa una abstracción del concepto “persona”. 
Implemente en java la clase Persona. 
El método edad() devuelve la cantidad de años cumplidos a la fecha, considerando para el cálculo sólo la diferencia entre años. 
La salida impresa del método mostrar() debe ser la siguiente (los valores en negrita dependen del estado del objeto):
Nombre y Apellido: Juan Perez
DNI: 35123456 Edad: 22 años
Nota: Para trabajar con fechas, agregar: 
import java.util.*;
Para saber el año actual usar:
Calendar fechaHoy = new GregorianCalendar();
int anioHoy = fechaHoy.get(Calendar.YEAR);
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Persona {
    //atributos
    private int dni, anioNacimiento;
    private String nombre, apellido;
    //constructor
    public Persona(int p_dni, String p_nombre, String p_apellido, int p_anio) {
        this.dni = p_dni;
        this.nombre = p_nombre;
        this.apellido = p_apellido;
        this.anioNacimiento = p_anio;
    }
    
    
    public int edad(){
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);
        
        return anioHoy - anioNacimiento;
    }
    
    public String nomYApe() {
        return nombre + " " + apellido;
    }
    public String apeYNom() {
        return apellido + " " + nombre;
    }
    
    public void mostrar() {
        System.out.println("Nombre y Apellido: "+ nomYApe());
        System.out.println("DNI: " + dni + "\t" + "Edad: " + edad() + " Años ");
    }
    
    
}
