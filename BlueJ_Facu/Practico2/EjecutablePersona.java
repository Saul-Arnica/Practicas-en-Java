
/**
 * Write a description of class EjecutablePersona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class EjecutablePersona {
    public static void main(String[] args) {
        Persona persona1 = new Persona(43205368, "Saul Agustin", "Arnica", 2001);
        Persona persona2 = new Persona(43063333, "Sergio Ignacio", "Navarro", 2000);
        
        persona1.mostrar();
        persona2.mostrar(); 
    }
}
