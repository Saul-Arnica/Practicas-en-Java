/**
 * Esta clase, es la abstraccion de un cliente.
 * 
 * @author Saul Agustin Arnica
 * @version 14/8/24
 */
public class Cliente {

    private int nroDNI; 
    private String apellido;
    private String nombre;
    private double saldo;

    /**
     * Constructor de la clase.
     * @param p_dni Documento Nacionl de Identidad
     * @param p_apellido 
     * @param p_nombre 
     * @param p_importe 
     */
    public Cliente(int p_dni, String p_apellido, String p_nombre, double p_importe) {
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setDNI(p_dni);
        this.setImporte(p_importe);
    }
    //Creo los accessor's (set y get) para cada atributo.
    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setDNI(int p_dni) {
        this.nroDNI = p_dni;
    }

    private void setImporte(double p_importe) {
        this.saldo = p_importe;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    public int getDNI() {
        return this.nroDNI;
    }
    public double getSaldo() {
        return this.saldo;
    }
    //A partir de aqui, declaro los metodos solicitados en el UML.
    public double nuevoSaldo(double p_importe) {
        this.saldo = p_importe;
        return this.saldo;
    }

    public double agregarSaldo(double p_importe) {
        this.saldo = this.getSaldo() + p_importe;
        return this.saldo;
    }

    public String nomYApe() {
        return this.getNombre() + " " + this.getApellido() + " " + "(" + this.getDNI() + ")";
    }

    public String apeYNom() {
        return this.getApellido() + " " + this.getNombre() + " " + "(" + this.getDNI() + ")";
    }

    public void mostrar() {
        System.out.println("- Cliente -");
        System.out.println("Nombre y Apellido: " + this.nomYApe());
        System.out.println("Saldo: $" + this.getSaldo());
    }
}
