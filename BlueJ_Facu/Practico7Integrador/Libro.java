package Practico7Integrador;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase Libro representa un ejemplar de un libro que pertenece a una biblioteca, cuyas características son su titulo, edición, editorial, año, y préstamos.
 * @author (Mercedes Fernández) 
 * @version (1.0) 2/11/2024
 */
public class Libro
{
    //atributos
    private String titulo;
    private int edicion;
    private String editorial;
    private int anio;
    private ArrayList<Prestamo> prestamos;
    /**
     * Constructor para objeto de la clase Libro sin colección de préstamos
     * @param String p_titulo titulo del ejemplar
     * @param int p_edicion número de edición del ejemplar 
     * @param String p_editorial nombre de la editorial
     * @int p_anio año de edición del ejemplar
     */
    public Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio)
    {
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(new ArrayList<Prestamo>());
    }
    /**
     * Constructor para objeto de la clase Libro con colección de préstamos
     * @param String p_titulo titulo del ejemplar
     * @param int p_edicion número de edición del ejemplar 
     * @param String p_editorial nombre de la editorial
     * @int p_anio año de edición del ejemplar
     * @param 
     */
    public Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio,
                 ArrayList<Prestamo> p_prestamos)
    {
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(p_prestamos);
    }    
    //getters
    public String getTitulo(){
        return this.titulo;
    }
    public int getEdicion(){
        return this.edicion;
    }
    public String getEditorial(){
        return this.editorial;
    }
    public int getAnio(){
        return this.anio;
    }
    public ArrayList<Prestamo> getPrestamos(){
        return this.prestamos;
    }
    //setters
    private void setTitulo(String p_titulo){
        this.titulo = p_titulo;
    }
    private void setEdicion(int p_edicion){
        this.edicion = p_edicion;
    }
    private void setEditorial(String p_editorial){
        this.editorial = p_editorial;
    }
    private void setAnio(int p_anio){
        this.anio = p_anio;
    }
    private void setPrestamos(ArrayList<Prestamo> p_prestamos){
        this.prestamos = p_prestamos;
    }
    public boolean agregarPrestamo(Prestamo p_prestamo) throws PrestamoInvalidoException{
        if(p_prestamo.getLibro().equals(this)){
            return this.getPrestamos().add(p_prestamo);
       }else{
        throw new PrestamoInvalidoException("El préstamo no pertenece a este libro"); 
        }
    }
    public boolean quitarPrestamo(Prestamo p_prestamo){
        return this.getPrestamos().remove(p_prestamo);
    }
    public boolean prestado(){
        if(this.getPrestamos().size() >= 1){
            Calendar fechaDevolucion = this.ultimoPrestamo().getFechaDevolucion();
            boolean siguePrestado = (fechaDevolucion == null);
            return siguePrestado;
        }
        return false;
    }
    public Prestamo ultimoPrestamo(){
        if(this.getPrestamos().size() >= 1){
            Prestamo ultimo = this.getPrestamos().get(this.getPrestamos().size() - 1);
            return ultimo;
        }
        return null;
    }
    public String toString(){
        return "Título: " + this.getTitulo();
    }
}
