package Practico7Integrador;

import java.util.ArrayList;
import java.util.Calendar;
/**
 * @author Arduino De Michielis Ana Fiorella
 * @version 1.1
 */
public abstract class Socio{
    private int dniSocio;
    private String nombre;
    private int diasPrestamo;
    private ArrayList<Prestamo> prestamos;
    /**
     * Constructor que inicializa la lista de prestamos en 0. 
     * @param int p_dniSocio
     * @param Stringç p_nombre
     * @param int p_diasPrestamo
     */
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo){
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(new ArrayList<>());
    }
    /**
     * Constructor que recibe un prestamo
     * @param int p_dniSocio
     * @param String p_nombre
     * @param int p_diasPrestamo
     * @param Prestamo p_prestamos
     */
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo, Prestamo p_prestamo){
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(new ArrayList<>());
        this.agregarPrestamo(p_prestamo);
    }
    /**
     * Constructor que recibe una lista de préstamos.
     * @param int p_dniSocio
     * @param Stringç p_nombre
     * @param int p_diasPrestamo
     * @param ArrayList<Prestamo> p_prestamos
     */
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo, ArrayList<Prestamo> p_prestamos){
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(p_prestamos);
    }
    //Metodos mutadores - Setters
    private void setDniSocio(int p_dni){
        this.dniSocio = p_dni;
    }
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    protected void setDiasPrestamo(int p_dias){
        this.diasPrestamo = p_dias;
    }
    private void setPrestamos(ArrayList<Prestamo> p_prestamo){
        this.prestamos = p_prestamo;
    }
    //Metodos observadores- Getters
    public int getDniSocio(){
        return this.dniSocio;
    }
    public String getNombre(){
        return this.nombre;
    }
    public int getDiasPrestamo(){
        return this.diasPrestamo;
    }
    public ArrayList<Prestamo> getPrestamos(){
        return this.prestamos;
    }
    public int cantLibrosPrestados(){
        return this.getPrestamos().size();
    }
    /**
     *Recorre la lista de prestamos del socio para verificar si existe algún prestamo vencido
     *@return true en caso de que exista un prestamo vencido, en caso contrario retorna false
     */
    public boolean puedePedir(){
        Calendar hoy = Calendar.getInstance();
        for (Prestamo prestamo : this.getPrestamos()) {
            if (prestamo.getFechaDevolucion() == null && prestamo.vencido(hoy)){ // si es prestamo activo
                return false;        
            }
        }
        return true;
    }
    //metodos para agregar y quitar un prestamo
    public boolean agregarPrestamo(Prestamo p_prestamo){
        if(this.puedePedir() && p_prestamo.getSocio().equals(this)){
            return this.getPrestamos().add(p_prestamo);
        }else{
            return false;
        }
    }
    public boolean quitarPrestamo(Prestamo p_prestamo){
        return this.getPrestamos().remove(p_prestamo);
    }
    /**
     * @return un String con los datos del socio: DNI, nombre completo y clase
     */
    public String toString(){
        String mensaje = "D.N.I.: "+this.getDniSocio()+" || "+this.getNombre()+" ("+this.soyDeLaClase()+")";
        return mensaje;
    }
    /**
     * método abstracto que se implementa en las subclases
     * @return la clase del socio.
     */
    public abstract String soyDeLaClase();
}