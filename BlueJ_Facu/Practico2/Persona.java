import java.util.*;
/**
 * En esta clase, representaremos la abstraccion de una persona, tendremos como atributos:
 * -su numero de documento
 * -su nombre completo.
 * -su edad, a partir de su año de nacimiento.
 * Es preciso aclarar esto, ya que no usaremos fechas exactas para determinar su edad. solo el año actual - su año de nacimiento.
 * 
 * @author Saul Agustin Arnica 
 * @version 23/8/24
 */
//Aca declaramos la clase Persona.
public class Persona {

    //Declaracion de atributos de la clase. Claramente de manera privada para que nadie fuera de la misma pueda modificar su estado interno.
    private int dni, anioNacimiento;
    private String nombre, apellido;

    /**
     * Constructor.
     * @param p_dni solicitamos el Documento Nacional de Identidad.
     * @param p_nombre 
     * @param p_apellido 
     * @param p_anio solicitamos el año de nacimiento.
     */
    public Persona(int p_dni, String p_nombre, String p_apellido, int p_anio) {
        this.setDNI(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setAnio(p_anio);
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

    public String getNombre() {
        return this.nombre;
    }
    
    public String getApellido() {
        return this.apellido;
    }

    public int getAnioNacimiento() {
        return this.anioNacimiento;
    }
    /**
     * @return la edad de la persona restando el año actual con el de su nacimiento.
     */
    public int edad() {

        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);
        
        return anioHoy - this.getAnioNacimiento();
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
}
