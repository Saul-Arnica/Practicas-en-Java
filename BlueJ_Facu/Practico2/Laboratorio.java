/**
 * Una droguería que comercia con laboratorios que producen medicamentos modeló la clase Laboratorio 
 * representada en el diagrama de clases adjunto.
 * Implemente en Java la clase Laboratorio. 
 * La salida impresa del método mostrar() debe ser la siguiente (los valores en negrita dependen del estado del objeto):
 * Laboratorio: Colgate S.A. 
 * Domicilio: Junín 5204 - Teléfono: 54-11 -4239-8447
 * Nota: 
 * Observe que la clase tiene dos formas de instanciarse (constructores sobrecargados).
 * Los atributos que no figuran en el constructor deben tener un modo de acceso público,debido a que la empresa puede variar su política o reglas de negocio con el tiempo.
 * Con este propósito se agregan los métodos nuevaCompraMinima(int) y nuevoDiaEntrega(int) 
 * que permiten modificar esos datos, asignándoles un nuevo valor.
 * 
 * @author Saul Agustin Arnica
 * @version 1
 */
public class Laboratorio {

    private String nombre;
    private String domicilio;
    private String telefono;
    private int compraMinima;
    private int diaEntrega;

    /**
     * Constructor que permite crear un objeto Laboratorio con todos los datos.
     * @param p_nombre Nombre del laboratorio.
     * @param p_domicilio Dirección del laboratorio.
     * @param p_telefono Teléfono de contacto del laboratorio.
     * @param p_compraMin Monto mínimo de compra requerido.
     * @param p_diaEnt fecha en el que se realizan las entregas.
     */
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono, int p_compraMin, int p_diaEnt) {
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setTelefono(p_telefono);
        this.setCompraMinima(p_compraMin);
        this.setDiaEntrega(p_diaEnt);
    }

    /**
     * Constructor que permite crear un objeto Laboratorio con los datos básicos.
     * @param p_nombre Nombre del laboratorio.
     * @param p_domicilio Dirección del laboratorio.
     * @param p_telefono Teléfono de contacto del laboratorio.
     */
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono) {
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setTelefono(p_telefono);
    }

    /**
     * Establece un nuevo día de entrega para el laboratorio.
     * @param diaEntrega El nuevo día de entrega.
     */
    public void setDiaEntrega(int diaEntrega) {
        this.diaEntrega = diaEntrega;
    }

    /**
     * Establece un nuevo nombre para el laboratorio.
     * @param nombre El nuevo nombre del laboratorio.
     */
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece un nuevo domicilio para el laboratorio.
     * @param domicilio El nuevo domicilio del laboratorio.
     */
    private void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Establece un nuevo teléfono para el laboratorio.
     * @param telefono El nuevo teléfono del laboratorio.
     */
    private void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Establece un nuevo valor mínimo de compra.
     * @param compraMinima El nuevo valor mínimo de compra.
     */
    public void setCompraMinima(int compraMinima) {
        this.compraMinima = compraMinima;
    }

    /**
     * Obtiene el nombre del laboratorio.
     * @return El nombre del laboratorio.
     */
    public String getNombre() {
        return this.nombre;
    }
    /**
     * Obtiene el domicilio del laboratorio.
     * @return El domicilio del laboratorio.
     */
    public String getDomicilio() {
        return this.domicilio;
    }
    /**
     * Obtiene el teléfono del laboratorio.
     * @return El teléfono del laboratorio.
     */
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
    /**
     * Obtiene el día de entrega del laboratorio.
     * @return El día de entrega.
     */
    public int getDiaEntrega() {
        return this.diaEntrega;
    }

    /**
     * Método que muestra los datos del laboratorio.
     * @return Cadena de texto con la información del laboratorio.
     */
    public String mostrar() {
        return "Laboratorio: " + this.getNombre() + "\n" + "Domicilio: " + this.getDomicilio() + "\t - " + "Teléfono: " + this.getTelefono() + "\n";
    }
}
