/**
 * Probamos los metodos de la clase Persona.
 */
public class EjecutablePersona {
    public static void main(String[] args) {
        Persona persona1 = new Persona(43205368, "Saul Agustin", "Arnica", 2001);
        Persona persona2 = new Persona(43063333, "Sergio Ignacio", "Navarro", 2000);
        
        System.out.println(persona1.edad());
        System.out.println(persona2.edad());
        System.out.println(persona1.nomYApe());
        System.out.println(persona2.nomYApe());
        System.out.println(persona1.apeYNom());
        System.out.println(persona2.apeYNom());
        persona1.mostrar();
        persona2.mostrar(); 
    }
}
