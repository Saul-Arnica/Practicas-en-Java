
/**
 * Write a description of class Laboratorio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laboratorio {
    
    private String nombre;
    private String domicilio;
    private String telefono;
    @SuppressWarnings("unused")
    private int compraMinima;
    @SuppressWarnings("unused")
    private int diaEntrega;
    
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono, int p_compraMin, int p_diaEnt){
        this.nombre = p_nombre;
        this.domicilio = p_domicilio;
        this.telefono = p_telefono;
        this.compraMinima = p_compraMin;
        this.diaEntrega = p_diaEnt;
    }
    
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono){
        this.nombre = p_nombre;
        this.domicilio = p_domicilio;
        this.telefono = p_telefono;
    }
    
    public void nuevaCompraMinima(int p_compraMin){
        this.compraMinima = p_compraMin;
    }
    
    public void nuevoDiaEntrega(int p_diaEnt){
        this.diaEntrega = p_diaEnt;
    }
    
    public String mostrar() {
        return "Laboratorio: " + nombre + "\n" + "Domicilio: " + domicilio + "\t - " + "Telefono: " + telefono;
    }
}
