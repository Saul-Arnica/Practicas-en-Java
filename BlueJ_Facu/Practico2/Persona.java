import java.util.*;
/**
 * El diagrama de clase adjunto representa una abstracción del concepto “persona”. 
 * Implemente en java la clase Persona. 
 * El método edad() devuelve la cantidad de años cumplidos a la fecha, considerando para el cálculo sólo la diferencia entre años. 
 * La salida impresa del método mostrar() debe ser la siguiente (los valores en negrita dependen del estado del objeto):
 * Nombre y Apellido: Juan Perez
 * DNI: 35123456 Edad: 22 años
 * Nota: Para trabajar con fechas, agregar: import java.util.*;
 * Para saber el año actual usar:
 * Calendar fechaHoy = new GregorianCalendar();
 * int anioHoy = fechaHoy.get(Calendar.YEAR);
 * 
 * @author (Saul Agustin Arnica) 
 * @version (1)
 */
//Aca declaramos la clase Persona.
public class Persona {

    //Aca hago la declaracion de atributos de la clase. Claramente de manera privada para que nadie fuera de la misma pueda modificar su estado interno.
    private int dni, anioNacimiento;
    private String nombre, apellido;

    /**
     * Persona es el construcctor de la clase, asigna un valor a los atributos de manera segura con los setter's.
     * @param p_dni solicitamos por paso de parametros el DNI
     * @param p_nombre solicitamos por paso de parametros el Nombre
     * @param p_apellido solicitamos por paso de parametros el Apellido   
     * @param p_anio solicitamos por paso de parametros el Anio de naciomiento
     */
    public Persona(int p_dni, String p_nombre, String p_apellido, int p_anio) {
        setDNI(p_dni);
        setNombre(p_nombre);
        setApellido(p_apellido);
        setAnio(p_anio);
    }

    //declaramos los setter's (Asignamos valor a los atributos de manera segura)
    private void setDNI(int p_dni) {
        this.dni = p_dni;
    }
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }
    private void setAnio(int p_anio) {
        this.anioNacimiento = p_anio;
    }

    /**
     * 
     * @return el Documento Nacional de Identidad
     */
    public int getDNI() {
        return this.dni;
    }
    /**
     * 
     * @return el Nombre
     */
    public String getNombre() {
        return this.nombre;
    }
    /**
     * 
     * @return el Apellido
     */
    public String getApellido() {
        return this.apellido;
    }
    /**
     * 
     * @return la edad actual de la persona.
     */
    public int edad() {
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);
        
        return anioHoy - anioNacimiento;
    }
    /**
     * 
     * @return Nombre y Apellido
     */
    public String nomYApe() {
        return nombre + " " + apellido;
    }
    /**
     * 
     * @return Apellido y Nombre
     */
    public String apeYNom() {
        return apellido + " " + nombre;
    }
    /**
     * Imprimimos en pantalla/consola lo solicitado.
     */
    public void mostrar() {
        System.out.println("Nombre y Apellido: "+ this.nomYApe());
        System.out.println("DNI: " + dni + "\t" + "Edad: " + this.edad() + " Años ");
    }
}
