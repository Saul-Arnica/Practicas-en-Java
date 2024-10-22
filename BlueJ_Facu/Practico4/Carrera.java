import java.util.*;
@SuppressWarnings("all")
public class Carrera {

    public static void main(String[] args) {
        // 5.1.1. Crear una instancia de Curso y varias de la clase Alumno
        Curso curso = new Curso("Programación I");
        
        Alumno alumno1 = new Alumno(43063333, "Sergio", "Navarro", 10, 8);
        Alumno alumno2 = new Alumno(43205368, "Saul", "Arnica", 9, 9);

        // 5.1.3. Inscribir los alumnos al curso creado anteriormente
        curso.inscribirAlumno(alumno1);
        curso.inscribirAlumno(alumno2);

        // 5.1.4. Imprimir la cantidad y la lista de alumnos inscriptos al curso
        System.out.println("Cantidad de alumnos inscriptos: " + curso.cantidadDeAlumnos());
        curso.mostrarInscriptos();;

        // 5.1.5. Dar de baja un alumno del curso, y luego verificar que no esté inscripto
        curso.quitarAlumno(43205368);  

        // 5.1.6. Imprimir nuevamente la lista de alumnos y la cantidad total de inscriptos
        System.out.println("\nCantidad de alumnos inscriptos después de la baja: " + curso.cantidadDeAlumnos());
        curso.mostrarInscriptos();

        // 5.1.7. Buscar un alumno por su LU y mostrarlo
        Alumno alumnoEncontrado = curso.getAlumnos().get(43063333);
        if (alumnoEncontrado != null) {
            System.out.println("\nAlumno encontrado: " + alumnoEncontrado.apeYNom());
        }else{
            System.out.println("El alumno no se encuentra inscripto");
        }

        // 5.1.8. Mostrar el promedio del alumno solicitado, según libreta
        curso.imprimirPromedioDelAlumno(43205368);  
    }
}
