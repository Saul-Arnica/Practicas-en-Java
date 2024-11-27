public class Docente {

    private String nombre;
    private String grado;
    private double sueldoBasico;
    private double asignacionFamiliar;

    /**
     * Construcctor explicito, donde se ingresa todos los parametros de un Docente.
     * @param p_nombre
     * @param p_grado
     * @param p_sueldoBasico
     * @param p_asignacionFamiliar
     */
    public Docente(String p_nombre, String p_grado, double p_sueldoBasico, double p_asignacionFamiliar) {
        this.setNombre(p_nombre);
        this.setGrado(p_grado);
        this.setSueldoBasico(p_sueldoBasico);
        this.setAsignacionFamiliar(p_asignacionFamiliar);
    }

    //Construcctor con parametros minimos.
    /**
     * Construcctor con parametros minimos.
     * @param p_nombre
     * @param p_grado
     */
    public Docente(String p_nombre, String p_grado) {
        this.setNombre(p_nombre);
        this.setGrado(p_grado);
        this.setSueldoBasico(0);
        this.setAsignacionFamiliar(0);
    }

    //Accsessor's (setter's)

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setGrado(String p_grado) {
        this.grado = p_grado;
    }

    private void setSueldoBasico(double p_sueldoBasico) {
        this.sueldoBasico = p_sueldoBasico;
    }

    private void setAsignacionFamiliar(double p_asignacionFamiliar) {
        this.asignacionFamiliar = p_asignacionFamiliar;
    }

    //(getter's)

    public String getNombre() {
        return this.nombre;
    }
    public String getGrado() {
        return this.grado;
    }

    public double getSueldoBasico() {
        return this.sueldoBasico;
    }

    public double getAsignacionFamiliar() {
        return this.asignacionFamiliar;
    }
    //Lo solicitado en el UML.
    public double calcularSueldo() {
        return this.getSueldoBasico() + this.getAsignacionFamiliar();
    }
}
