/**
 * En esta clase, realizamos la abstraccion de un o varios laboratorios que trabajan con una Drogueria.
 * 
 * @author Saul Agustin Arnica
 * @version 23/8/24
 */
public class Laboratorio {

    private String nombre;
    private String domicilio;
    private String telefono;
    private int compraMinima;
    private int diaEntrega;

    /**
     * Constructor que permite instanciar con todos los datos.
     * @param p_nombre 
     * @param p_domicilio 
     * @param p_telefono 
     * @param p_compraMin Compra minima.
     * @param p_diaEnt dia en el que se realizan las entregas.
     */
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono,
                        int p_compraMin, int p_diaEnt) {
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setTelefono(p_telefono);
        this.setCompraMinima(p_compraMin);
        this.setDiaEntrega(p_diaEnt);
    }

    /**
     * Constructor que permite instanciar con los datos básicos.
     * @param p_nombre 
     * @param p_domicilio 
     * @param p_telefono 
     */
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono) {
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setTelefono(p_telefono);
    }

    /**
     * Establece un nuevo día de entrega para el laboratorio.
     * @param p_diaEntrega El nuevo día de entrega.
     */
    public void setDiaEntrega(int p_diaEntrega) {
        this.diaEntrega = p_diaEntrega;
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setDomicilio(String p_domicilio) {
        this.domicilio = p_domicilio;
    }

    private void setTelefono(String p_telefono) {
        this.telefono = p_telefono;
    }

    /**
     * Establece un nuevo valor mínimo de compra.
     * @param p_compraMinima El nuevo valor mínimo de compra.
     */
    public void setCompraMinima(int p_compraMinima) {
        this.compraMinima = p_compraMinima;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public String getTelefono() {
        return this.telefono;
    }

    /**
     * Obtiene la compra mínima requerida por el laboratorio.
     * @return El valor mínimo de compra.
     */
    public int getCompraMinima() {
        return this.compraMinima;
    }

    public int getDiaEntrega() {
        return this.diaEntrega;
    }

    /**
     * @return Cadena de texto con la información del laboratorio.
     */
    public String mostrar() {
        return "Laboratorio: " + this.getNombre() + "\n" + "Domicilio: " + this.getDomicilio() +
                                                    "\t - " + "Teléfono: " + this.getTelefono() + "\n";
    }
}
