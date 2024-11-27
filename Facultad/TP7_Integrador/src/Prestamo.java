
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * @author Arduino De Michielis Ana Fiorella
 * @version 1.1
 */
public class Prestamo{
    private Calendar fechaRetiro;
    private Calendar fechaDevolucion;
    private Socio socio;
    private Libro libro;
    /**
     * Constructor que inicializa un prestamo.
     * @param Calendar p_fechaRetiro
     * @param Libro p_libro
     * @param Socio p_socio
     */
    public Prestamo(Calendar p_fechaRetiro, Socio p_socio,Libro p_libro){
        this.setFechaRetiro(p_fechaRetiro);
        this.setFechaDevolucion(null);
        this.setLibro(p_libro);
        this.setSocio(p_socio);
    }
    
    private void setFechaRetiro(Calendar p_fechaRetiro){
        this.fechaRetiro = p_fechaRetiro;
    }
    private void setFechaDevolucion(Calendar p_fechaDevolucion){
        this.fechaDevolucion = p_fechaDevolucion;
    }
    private void setLibro(Libro p_libro){
        this.libro = p_libro;
    }
    private void setSocio(Socio p_socio){
        this.socio = p_socio;
    }
    public Calendar getFechaRetiro(){
        return this.fechaRetiro;
    }
    public Calendar getFechaDevolucion(){
        return this.fechaDevolucion;
    }
    public Libro getLibro(){
        return this.libro;
    }
    public Socio getSocio(){
        return this.socio;
    }
    public void registrarFechaDevolucion(Calendar p_fecha) {
        this.setFechaDevolucion(p_fecha);
    }
    public boolean vencido(Calendar p_fecha){
        Calendar fechaLimite = new GregorianCalendar();
        int añoRetiro = this.getFechaRetiro().get(Calendar.YEAR);
        int mesRetiro = this.getFechaRetiro().get(Calendar.MONTH);
        int diaRetiro = this.getFechaRetiro().get(Calendar.DATE);
        fechaLimite.set(añoRetiro, mesRetiro, diaRetiro);
        
        fechaLimite.add(Calendar.DATE, this.getSocio().getDiasPrestamo());
        return p_fecha.after(fechaLimite);
    }
    public String toString(){
        String fecha = this.getFechaRetiro().get(Calendar.YEAR) + 
                 "/" + this.getFechaRetiro().get(Calendar.MONTH)+
                 "/" + this.getFechaRetiro().get(Calendar.DATE);
        if(this.getFechaDevolucion()!= null){
            String fechaDevolucion = this.getFechaDevolucion().get(Calendar.YEAR)+"/"
                                   + this.getFechaDevolucion().get(Calendar.MONTH)+"/"
                                   + this.getFechaDevolucion().get(Calendar.DATE);
            String mensaje = "Retiro: "+ fecha +"- Devolución: "+
                        fechaDevolucion +"\nLibro: " + this.getLibro().toString() +
                        "\nSocio: " + this.getSocio().getNombre();
            return mensaje;
        }else{
            String mensaje = "Retiro:" + fecha + "- Devolución:" +
                        this.getFechaDevolucion() + "\nLibro: " + this.getLibro().toString() +
                        "\nSocio: " + this.getSocio().getNombre();
            return mensaje;
        }
    }
}
