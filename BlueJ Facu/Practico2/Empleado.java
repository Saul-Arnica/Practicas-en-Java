
/**
* Una empresa desea administrar automáticamente la liquidación de sueldo de sus empleados. 
Para ello se modela la abstracción del concepto “empleado”, teniendo en cuenta las características relevantes al problema, brindando el comportamiento adecuado.
Implemente en java la clase Empleado según lo indicado en el diagrama de clases.
El método antiguedad() devuelve la cantidad de años desde el ingreso a la empresa. 
El método descuento() corresponde al 2% del sueldo básico en concepto de obra social, mas $1500 de seguro de vida. 
El método adicional() es una asignación que se realiza sobre el sueldo básico, en base a la antigüedad, según la siguiente tabla:
        Antigüedad      | Asignación con respecto al Sueldo Básico
        < 2             |               2%
        >= 2 y <10      |               4%
        >= 10           |               %6
El sueldo neto se calcula como la suma del sueldo básico más el adicional, menos el descuento.
La salida impresa del método mostrar() debe ser la siguiente (los valores en negrita dependen del estado interno del objeto):
Nombre y Apellido: Juan Perez
CUIL: 20351234385 Antigüedad: 22 años de servicio
Sueldo Neto: $ 300000.00 
 * @author (Saul Agustin Arnica) 
 * @version (15/8/24)
 */
@SuppressWarnings("all")
public class Empleado {
    private long cuil;
    private String apellido;
    private String nombre;
    private double sueldoBasico;
    private int anioIngreso;
    
    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, int p_anio) {
        setCuil(p_cuil);
        setApellido(p_apellido);
        setNombre(p_nombre);
        setSueldoBasico(p_importe);
        setAnioIngreso(p_anio);
    }

    private void setCuil(long p_cuil) {
        cuil = p_cuil;
    }

    private void setApellido(String p_apellido){
        apellido = p_apellido;
    }

    private void setNombre(String p_nombre){
        nombre = p_nombre;
    }

    private void setSueldoBasico(double p_importe){
        sueldoBasico = p_importe;
    }

    private void setAnioIngreso(int p_anio){
        anioIngreso = p_anio;
    }

    public int antiguedad() {
        return 1;
    }
    private double descuento() {
        return 2.0;
    }
    private double adicional() {
        return 2.0;
    }
    public double sueldoNeto() {

    }
    public String nomYApe() {

    }
    public String apeYNom() {

    }
    
}
