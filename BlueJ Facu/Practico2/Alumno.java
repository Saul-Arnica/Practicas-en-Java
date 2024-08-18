
/**
 * It is wanted to get the average of grade points of Object Oriented Programming students. 
For this, the abstract concept "pupil" is modeled. 
When an instance of Alumno is created, as grade points are not known yet, they are initialized in zero. 
The method promedio() returns the average of student's grade points. 
The method aprueba() returns true or false according to whether the student's grade points average is greate than 7.0 and if both grade points are equal or greater than 6.0. 
The method leyendaAprueba() returns a string APROBADO or DESAPROBADO according to the method aprueba() returns. 
The printed output of the method mostrar() must be: (boldedvalues show internal state of object)
 * 
 * @author (Saul Agustin Arnica)  
 * @version (15/8/24)
 */
public class Alumno {

    private int lu;
    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;

    public Alumno(int p_lu, String p_nombre, String p_apellido, double p_nota1, double p_nota2) {
        setLU(p_lu);
        setNombre(p_nombre);
        setApellido(p_apellido);
        setNota1(p_nota1);
        setNota2(p_nota2);
    }   

    private void setLU(int p_lu) {
        lu = p_lu;
    }

    private void setNombre(String p_nombre) {
        nombre = p_nombre;
    }

    private void setApellido(String p_apellido) {
        apellido = p_apellido;
    }

    public void setNota1(double p_nota1) {
        nota1 = p_nota1;
    }

    public void setNota2(double p_nota2) {
        nota2 = p_nota2;
    }

    public double promedio() {
        return (nota1 + nota2) / 2;
    }
    
    private boolean aprueba() {
        if(promedio() > 7.0 && nota1 >= 6.0 && nota2 >= 6.0 ) {
            return true;
        }else{
            return false;
        }
    }
    private String leyendaAprueba() {
        if(aprueba() == true) {
            return "APROBADO";
        }else{
            return "DESAPROBADO";
        }
    }

    public String nomYApe() {
        return nombre + " " + apellido;
    }
    public String apeYNom() {
        return apellido + " " + nombre;
    }
    public void mostrar() {
        System.out.println("Nombre y Apellido: " +nomYApe());
        System.out.println("LU: " + lu + " " + "Notas:" + nota1 + "  -  " + nota2);
        System.out.println("Promedio: " + promedio() + "-" + leyendaAprueba() + "\n");

    }
}
