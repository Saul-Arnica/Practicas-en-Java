package Practico5;

public class Escuela {
    public static void main(String[] args) {
        Persona persona1 = new Persona(43205368, "Agustin", "Arnica", 23);
        Persona persona2 = new Persona(44522923, "Fiorella", "Arduino", 21);
        Alumno alumno1 = new Alumno(43205368, "Saul", "Agustin", 23, 43205368);
        Alumno alumno2 = new Alumno(44252015, "Angel", "Bareiro", 21, 44252015);

        persona1.mostrar();
        persona2.mostrar();
        alumno1.mostrar();
        alumno2.mostrar(); 

    }    
}
