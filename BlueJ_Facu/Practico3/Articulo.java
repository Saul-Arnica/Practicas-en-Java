
/**
 * Write a description of class Articulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Articulo {
    private int codigo;
    private String titulo;
    private String area;
    private Autor autor;
    public Articulo(int p_codigo, String p_titulo, String p_area, Autor p_autor) {
        setCodigo(p_codigo);
        setTitulo(p_titulo);
        setArea(p_area);
        setAutor(p_autor);
    }
    public int getCodigo() {
        return codigo;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getArea() {
        return area;
    }
    public Autor getAutor() {
        return autor;   
    }
    private void setCodigo(int p_codigo) {
        this.codigo = p_codigo;
    }

    private void setTitulo(String p_titulo) {
        this.titulo = p_titulo;
    }
    private void setArea(String p_area) {
        this.area = p_area;
    }

    private void setAutor(Autor p_autor) {
        this.autor = p_autor;
    }
    public void mostrar() {
        System.out.println("Articulo: " + this.getTitulo());
        System.out.println("Area: " + this.getArea());
        this.getAutor().mostrar();
    }
}
