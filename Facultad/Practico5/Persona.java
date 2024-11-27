package Practico5;
import java.util.*;
/**
 * En esta clase, representaremos la abstraccion de una persona, tendremos como atributos:
 * -su numero de documento
 * -su nombre completo.
 * -su edad, a partir de su año de nacimiento.
 * 
 * Es preciso aclarar esto, ya que no usaremos fechas exactas para determinar su edad. solo el año actual - su año de nacimiento.
 * 
 * @author Saul Agustin Arnica 
 * @version 23/8/24 - (Ultima modificacion 07/09/24)
 */
//Aca declaramos la clase Persona.
public class Persona {

    //Declaracion de atributos de la clase. Claramente de manera privada para que nadie fuera de la misma pueda modificar su estado interno.
    private int dni;
    private String nombre, apellido;
    private Calendar fechaNacimiento;

    /**
     * Constructor que mantiene el protocolo.
     * @param p_dni solicitamos el Documento Nacional de Identidad.
     * @param p_nombre 
     * @param p_apellido 
     * @param p_anio solicitamos el año de nacimiento.
     */

    public Persona(int p_dni, String p_nombre, String p_apellido, int p_anio) {
        this.setDNI(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setAnioNacimiento(p_anio);
    }

    /**
     * Constructo que quita el parametro p_anio(int) y lo reemplaza por p_fecha(Calendar).
     * @param p_dni
     * @param p_nombre
     * @param p_apellido
     * @param p_fecha 
     */

    public Persona(int p_dni, String p_nombre, String p_apellido, Calendar p_fecha) {
        this.setDNI(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setFechaNacimiento(p_fecha);
    }

    //Declaracion de los setter's (Asignamos valor a los atributos de manera segura)
    private void setDNI(int p_dni) {
        this.dni = p_dni;
    }
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }
    private void setAnioNacimiento(int p_anio) {
        Calendar fecha = new GregorianCalendar();
        fecha.set(p_anio, 1, 1);
        this.fechaNacimiento = fecha;
        
    }
    private void setFechaNacimiento(Calendar p_anio) {
        this.fechaNacimiento = p_anio;
    }

    /**
     * 
     * @return el Documento Nacional de Identidad
     */
    public int getDNI() {
        return this.dni;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public String getApellido() {
        return this.apellido;
    }

    public int getAnioNacimiento() {
        return this.fechaNacimiento.get(Calendar.YEAR);
    }
    public Calendar getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    /**
     * @return la edad de la persona restando el año actual con el de su nacimiento.
     */
    public int edad() {
        Calendar fechaHoy = Calendar.getInstance();          //fecha actual
        int anioHoy = fechaHoy.get(Calendar.YEAR);          //año actual
        int mesHoy = fechaHoy.get(Calendar.MONTH);         //mes actual
        int diaHoy = fechaHoy.get(Calendar.DAY_OF_MONTH); //día actual
        
        int anioNacimiento = this.fechaNacimiento.get(Calendar.YEAR);          // Obtiene el año de nacimiento
        int mesNacimiento = this.fechaNacimiento.get(Calendar.MONTH);         // Obtiene el mes de nacimiento
        int diaNacimiento = this.fechaNacimiento.get(Calendar.DAY_OF_MONTH); // Obtiene el día de nacimiento
    
        // Cálculo inicial de la edad basado solo en el año
        int edad = anioHoy - anioNacimiento;
        // Si el mes de nacimiento es mayor al mes actual, o si es el mismo mes pero el día de nacimiento es mayor, restamos 1 a la edad.
        if (mesNacimiento > mesHoy || (mesNacimiento == mesHoy && diaNacimiento > diaHoy)) {
            edad = edad - 1;
        }

        return edad;
    }

    /**
     * @return Nombre y Apellido
     */
    public String nomYApe() {
        return this.getNombre() + " " + this.getApellido();
    }
    /**
     * 
     * @return Apellido y Nombre
     */
    public String apeYNom() {
        return this.getApellido() + " " + this.getNombre();
    }
    /**
     * Imprimimos en pantalla/consola lo solicitado.
     */
    public void mostrar() {
        System.out.println("Nombre y Apellido: "+ this.nomYApe());
        System.out.println("DNI: " + this.getDNI() + "\t" + "Edad: " + this.edad() + " Años ");
    }
    public boolean esCumpleaños() {

        Calendar fechaActual = Calendar.getInstance();
        int diaNacimiento = this.getFechaNacimiento().get(Calendar.DAY_OF_MONTH);
        int mesNacimiento = this.getFechaNacimiento().get(Calendar.MONTH);
        int diaHoy = fechaActual.get(Calendar.DAY_OF_MONTH);
        int mesHoy = fechaActual.get(Calendar.MONTH);
        if(mesNacimiento == mesHoy && diaNacimiento == diaHoy) {
            return true;
        }else{
            return false;
        }
        //return mesNacimiento == mesHoy && diaNacimiento == diaHoy;
    }
}
