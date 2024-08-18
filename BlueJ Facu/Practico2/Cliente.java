
/**
 * En la clase Cliente, el método agregaSaldo(p_importe) agrega p_importe al saldo actual (lo actualiza) y devuelve el nuevo saldo. 
El método nuevoSaldo(p_importe) reemplaza el saldo actual por p_importe y devuelve el nuevo saldo. 
La salida impresa del método mostrar() debe ser la siguiente: (los valores en negrita dependen del estado del objeto).
 * 
 * @author Saul Agustin Arnica
 * @version 14/8/24
 */
public class Cliente {

    private int nroDNI;
    private String apellido;
    private String nombre;
    private double saldo;

    public Cliente(int p_dni, String p_apellido, String p_nombre, double p_importe) {
        setApellido(p_apellido);
        setNombre(p_nombre);
        setDNI(p_dni);
        setImporte(p_importe);
    }

    private void setApellido(String p_apellido) {
        apellido = p_apellido;
    }

    private void setNombre(String p_nombre) {
        nombre = p_nombre;
    }

    private void setDNI(int p_dni) {
        nroDNI = p_dni;
    }

    private void setImporte(double p_importe) {
        saldo = p_importe;
    }

    public void mostrar() {
        System.out.println("- Cliente -");
        System.out.println("Nombre y Apellido: " + nomYApe());
        System.out.println("Saldo: $" + saldo);
    }

    public double nuevoSaldo(double p_importe) {
        saldo = p_importe;
        return saldo;
    }

    public double agregarSaldo(double p_importe) {
        saldo = saldo + p_importe;
        return saldo;
    }

    public String nomYApe() {
        return nombre + " " + apellido + " " + "(" + nroDNI + ")";
    }

    public String apeYNom() {
        return apellido + " " + nombre + " " + "(" + nroDNI + ")";
    }
}
