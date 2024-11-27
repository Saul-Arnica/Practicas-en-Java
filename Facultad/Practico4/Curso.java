import java.util.*;
@SuppressWarnings("all")
/**
 * 
 */
public class Curso {
    private String nombre;
    private HashMap <Integer, Alumno> alumnos;

    public Curso(String p_nombre) {
        this.setNombre(p_nombre);
        this.setAlumnos(new HashMap<Integer, Alumno>());
    }

    public Curso(String p_nombre, HashMap<Integer, Alumno> p_alumnos) {
        this.setNombre(p_nombre);
        this.setAlumnos(p_alumnos);
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    private void setAlumnos(HashMap<Integer, Alumno> p_alumnos) {
        this.alumnos = p_alumnos;
    }
    public void inscribirAlumno(Alumno p_alumno) {
        this.getAlumnos().put(p_alumno.getLu(), p_alumno);
    }

    public HashMap <Integer, Alumno> getAlumnos() {
        return this.alumnos;
    }

    public Alumno quitarAlumno(int p_lu) {
        return this.getAlumnos().remove(p_lu);
    }
    public int cantidadDeAlumnos() {
        return this.getAlumnos().size(); //forma corta pal parcial
        //otra forma:
        /*for(Integer clave: this.getAlumnos().keySet()) {
            cantidad = cantidad + 1;
        }
        return cantidad;*/
    }

    public boolean estaInscripto(int p_lu) {
        return this.getAlumnos().containsKey(p_lu);
    }

    public boolean estaInscripto(Alumno p_alumno) {
        return this.getAlumnos().containsValue(p_alumno);
    }

    public void imprimirPromedioDelAlumno(int p_lu) {
        Alumno alumno = this.getAlumnos().get(p_lu); // Buscamos el alumno usando su LU como clave
        if (alumno != null) { // Verificamos que exista el alumno
            System.out.println("Promedio del alumno " + p_lu + ": " + alumno.promedio());
        } else {
            System.out.println("No se encontró ningún alumno con el LU " + p_lu);
        }
    }
    public void mostrarInscriptos() {
        System.out.println("****-- Cantidad de inscriptos: " + this.cantidadDeAlumnos());
        for(Alumno a: this.getAlumnos().values()) {
            System.out.println(a.getLu() + " " + a.nomYApe());
        }
    }



    /*
****-- Cantidad de inscriptos: 4 
32555 Pedro Gomez 
23564 Maria Vasquez 
30123 Juan Perez 
32655 Marcela Martinez 
****-- Se da de baja a Pedro porque abandona el curso --**** 
Está Pedro Gomez inscripto ?? --> false 
****-- Alumnos inscriptos actualmente: 3 
23564 Maria Vasquez 
30123 Juan Perez 
32655 Marcela Martinez 
****-- Busca y muestra el alumno con numero de libreta 30123 --**** 
Apellido y nombre: Juan Perez 
LU: 30123 Notas: 7.0, 9.0 
Promedio: 8.0 Aprobado 
****-- Mostrar promedio del alumno 23564 --**** 
Promedio: 5.5
*/
}