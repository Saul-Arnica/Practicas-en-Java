
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Write a description of class GestionDeBiblioteca here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
@SuppressWarnings("all")

public class GestionBiblioteca {
    public static void main(String[] args) {

        ControladorArchivos control = new ControladorArchivos("socios.dat","prestamos.dat","libros.dat");
        Biblioteca biblio = new Biblioteca("Aguante POO");
        Calendar fechavieja = new GregorianCalendar();
        fechavieja.set(2024, 7, 14);
        Socio socio = new Docente(43063333, "Sergio", 5, "Programacion");
        Libro libro = new Libro("A ver que sale", 1, "lol", 2024);
        VistaBiblioteca vista = new VistaBiblioteca(biblio, control);
        BibliotecaControlador controlVista = new BibliotecaControlador(vista, biblio);
        control.cargarDatos(biblio);
        biblio.agregarSocio(socio);
        biblio.agregarLibro(libro);
        biblio.prestarLibro(fechavieja, socio, libro);
        
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}

