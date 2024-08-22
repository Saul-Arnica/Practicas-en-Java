import java.util.*;
@SuppressWarnings("all")
/**
 * Una empresa desea administrar automáticamente la liquidación de sueldo de sus empleados. 
 * Para ello se modela la abstracción del concepto “empleado”, teniendo en cuenta las características relevantes al problema, brindando el comportamiento adecuado.
 * Implemente en java la clase Empleado según lo indicado en el diagrama de clases.
 * El método antiguedad() devuelve la cantidad de años desde el ingreso a la empresa. 
 * El método descuento() corresponde al 2% del sueldo básico en concepto de obra social, mas $1500 de seguro de vida. 
 * El método adicional() es una asignación que se realiza sobre el sueldo básico, en base a la antigüedad, según la siguiente tabla:
 * Antigüedad      | Asignación con respecto al Sueldo Básico
 * < 2             |               2%
 * >= 2 y <10      |               4%
 * >= 10           |               %6
 * El sueldo neto se calcula como la suma del sueldo básico más el adicional, menos el descuento.
 * La salida impresa del método mostrar() debe ser la siguiente (los valores en negrita dependen del estado interno del objeto):
 * Nombre y Apellido: Juan Perez
 * CUIL: 20351234385 Antigüedad: 22 años de servicio
 * Sueldo Neto: $ 300000.00
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
    
    //Aca se encuentra el constructor de la clase Empleado, que es el encargado de asignar valor a los atributos del mismo.
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
        return descuento = this.getSueldoBasico() * 0.02 + 1500;
    }

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
