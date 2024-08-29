import java.util.*;
/**
 * Clase Empleado, es la abstraccion de un empleado desde el punto de vita de una empresa, que desea adminstrar automaticamente la liquidacion de sueldo de sus empleados.
 * 
 * @author (Saul Agustin Arnica) 
 * @version (15/8/24)
 */

public class Empleado {
    //Atributos de la Clase, las cuales siempre deben ser privadas por seguridad, ya que de esa forma controlamos quien puede y quien no modificar sus valores(estados).

    private long cuil;
    private String apellido;
    private String nombre;
    private double sueldoBasico;
    private int anioIngreso;
    
    //Constructor de la clase Empleado, que es el encargado de asignar valor a los atributos del mismo.
    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, int p_anio) {
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setAnioIngreso(p_anio);
    }

    /*Luego del constructor se encuentan los accessor's:Son los setter's y getter's, se encargan de modificar y obtener
        los estados internos de un atributo de manera segura.
    */
    private void setCuil(long p_cuil) {
        this.cuil = p_cuil;
    }

    private void setApellido(String p_apellido){
        this.apellido = p_apellido;
    }

    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }

    private void setSueldoBasico(double p_importe){
        this.sueldoBasico = p_importe;
    }

    private void setAnioIngreso(int p_anio){
        this.anioIngreso = p_anio;
    }

    public double getSueldo() {
        return this.sueldoBasico;
    }

    public int getAnio() {
        return this.anioIngreso;
    }

    public double getSueldoBasico() {
        return this.sueldoBasico;
    }
    public String getApellido() {
        return this.apellido;
    }
    public String getNombre() {
        return this.nombre;
    }
    public long getCuil() {
        return this.cuil;
    }

    public int antiguedad() {
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);
        return anioHoy - this.getAnio();
    }
    
    private double descuento() {
        double descuento;
        descuento = this.getSueldoBasico() * 0.02 + 1500;
        return descuento;
    }
    //Dependiendo de la antiguedad, se calcula su adicional.
    private double adicional() {
        double adicional = 0;
        if(this.antiguedad() >= 10){
            adicional = this.getSueldoBasico() * 0.06; 
        }else if(this.antiguedad() >= 2 && this.antiguedad() < 10){
            adicional = this.getSueldoBasico() * 0.04; 
        }else if(antiguedad() < 2){
            adicional = this.getSueldoBasico() * 0.02; 
        }
        return adicional;
    }

    public double sueldoNeto() {
        return this.getSueldoBasico() + this.adicional() - this.descuento();
    }

    public String nomYApe() {
        return this.getNombre() + " " + this.getApellido();
    }

    public String apeYNom() {
        return this.getApellido() + " " + this.getNombre();
    }

    public String mostrarLinea() {
        return this.getCuil() + this.apeYNom() + "$ " + this.sueldoNeto();
    }
    
    public void mostrar() {
        System.out.println("Nombre y Apellido: " + this.nomYApe());
        System.out.println("CUIL: " + this.getCuil() + " " + "Antiguedad: " + this.antiguedad() + " años de servicio");
        System.out.println("Sueldo Neto: $" + this.sueldoNeto());
    }
}
