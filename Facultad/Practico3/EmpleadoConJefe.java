import java.util.*;
/**
 * 
 */
public class EmpleadoConJefe {
    private long cuil;
    private String apellido;
    private String nombre;
    private double sueldoBasico;
    private Calendar fechaIngreso;
    private EmpleadoConJefe jefe;

    public EmpleadoConJefe(long p_cuil, String p_apellido, String p_nombre, double p_sueldoBasico, Calendar p_fecha, EmpleadoConJefe p_jefe) {
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_sueldoBasico);
        this.setFechaIngreso(p_fecha);
        this.setJefe(p_jefe);
    }

    public EmpleadoConJefe(long p_cuil, String p_apellido, String p_nombre, double p_sueldoBasico, Calendar p_fecha) {
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_sueldoBasico);
        this.setFechaIngreso(p_fecha);
    }

    public EmpleadoConJefe(long p_cuil, String p_apellido, String p_nombre, double p_sueldoBasico, int p_anio) {
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_sueldoBasico);
        Calendar fecha = Calendar.getInstance();
        fecha.set(2020,6,6);
        this.setFechaIngreso(fecha);
        this.setAnioIngreso(p_anio);
    }
    //setter´s
    private void setCuil(long p_cuil) {
        this.cuil = p_cuil;
    }

    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setSueldoBasico(double p_sueldoBasico) {
        this.sueldoBasico = p_sueldoBasico;
    }

    private void setAnioIngreso(int p_anio) {
        this.fechaIngreso.set(Calendar.YEAR, p_anio);
        //this.fechaIngreso.set(0, p_anio); otra forma
    }

    private void setFechaIngreso(Calendar p_fecha) {
        this.fechaIngreso = p_fecha;
    }

    private void setJefe(EmpleadoConJefe p_jefe) {
        this.jefe = p_jefe;
    }

    public long getCuil() {
        return this.cuil;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getSueldoBasico() {
        return this.sueldoBasico;
    }

    public int getAnioIngreso() {
        return this.fechaIngreso.get(Calendar.YEAR);
    }

    public Calendar getFechaIngreso() {
        return this.fechaIngreso;
    }

    public EmpleadoConJefe getJefe() {
        return this.jefe;
    }   
    //Metodos solicitados en el UML.
    public int antiguedad() {
        Calendar fechaHoy = Calendar.getInstance();          //fecha actual
        int anioHoy = fechaHoy.get(Calendar.YEAR);          //año actual
        int mesHoy = fechaHoy.get(Calendar.MONTH);         //mes actual
        int diaHoy = fechaHoy.get(Calendar.DAY_OF_MONTH); //día actual

        int anioIngreso = this.fechaIngreso.get(Calendar.YEAR);          // Obtiene el año de ingreso
        int mesIngreso = this.fechaIngreso.get(Calendar.MONTH);         // Obtiene el mes de ingreso
        int diaIngreso = this.fechaIngreso.get(Calendar.DAY_OF_MONTH); // Obtiene el día de ingreso

        // Cálculo inicial de la edad basado solo en el año
        int antiguedad = anioHoy - anioIngreso;
        // Si el mes de ingreso es mayor al mes actual, o si es el mismo mes pero el día de ingreso es mayor, restamos 1.
        if (mesIngreso > mesHoy || (mesIngreso == mesHoy && diaIngreso > diaHoy)) {
            antiguedad = antiguedad - 1;
        }

        return antiguedad;
    }
    private double descuento() {
        return (this.getSueldoBasico() * 0.02) + 1500;
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
    public String nomYape() {
        return this.getNombre() + " " + this.getApellido();
    }
    public String apeYNom() {
        return this.getApellido() + " " + this.getNombre();
    }

    public boolean esAniversario(){
        Calendar hoy = Calendar.getInstance();
        return (hoy.get(Calendar.MONTH) == this.getFechaIngreso().get(Calendar.MONTH)) && 
            (hoy.get(Calendar.DAY_OF_MONTH) == this.getFechaIngreso().get(Calendar.DAY_OF_MONTH));
    }

    public void mostrarPantalla() {
        System.out.println("Nombre y Apellido: " + this.nomYape());
        System.out.println("CUIL: " + this.getCuil() + " Antigüedad: " + this.antiguedad() + " años de servicio");
        System.out.println("Sueldo Neto: $" + this.sueldoNeto());
        if(this.getJefe() == null) {
            System.out.println("Responde a: GERENTE GENERAL");
        }else{
            System.out.println("Responde a: " + this.getJefe().apeYNom());
        }
    }

    public String mostrarLinea() {
        return this.getCuil() + this.apeYNom() + "$ " + this.sueldoNeto();
    }



}
