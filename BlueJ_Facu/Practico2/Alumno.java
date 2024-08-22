/**
 * It is wanted to get the average of grade points of Object Oriented Programming students. 
 * For this, the abstract concept "pupil" is modeled. 
 * When an instance of Alumno is created, as grade points are not known yet, they are initialized in zero. 
 * The method promedio() returns the average of student's grade points. 
 * The method aprueba() returns true or false
 * according to whether the student's grade points average is greate than 7.0 and if both grade points are equal or greater than 6.0. 
 * The method leyendaAprueba() returns a string APROBADO or DESAPROBADO according to the method aprueba() returns. 
 * The printed output of the method mostrar() must be: (boldedvalues show internal state of object)
 * 
 * @author (Saul Agustin Arnica)  
 * @version (15/8/24)
 */
public class Alumno {
    //Declaramos los atributos de la clase.
    private int lu;
    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;
    /**
     * Constructor de la clase Alumno con sus respectivos parametros que recibe.
     * @param p_lu  Libreta Universitaria
     * @param p_nombre  
     * @param p_apellido
     * @param p_nota1   
     * @param p_nota2
     */
    public Alumno(int p_lu, String p_nombre, String p_apellido, double p_nota1, double p_nota2) {
        this.setLU(p_lu);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setNota1(p_nota1);
        this.setNota2(p_nota2);
    }   

    private void setLU(int p_lu) {
        this.lu = p_lu;
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }

    public void setNota1(double p_nota1) {
        this.nota1 = p_nota1;
    }

    public void setNota2(double p_nota2) {
        this.nota2 = p_nota2;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    public long getLu() {
        return this.lu;
    }
    public double getNota1() {
        return this.nota1;
    }
    public double getNota2() {
        return this.nota2;
    }
    public double promedio() {
        return (this.getNota1() + this.getNota2()) / 2;
    }
    
    private boolean aprueba() {
        if(this.promedio() > 7.0 && this.getNota1() >= 6.0 && this.getNota2() >= 6.0 ) {
            return true;
        }else{
            return false;
        }
    }
    private String leyendaAprueba() {
        if(this.aprueba() == true) {
            return "APROBADO";
        }else{
            return "DESAPROBADO";
        }
    }

    public String nomYApe() {
        return this.getNombre() + " " + this.getApellido();
    }
    public String apeYNom() {
        return this.getApellido() + " " + this.getNombre();
    }
    public void mostrar() {
        System.out.println("Nombre y Apellido: " + this.nomYApe());
        System.out.println("LU: " + this.getLu() + " " + "Notas:" + this.getNota1() + "  -  " + this.getNota2());
        System.out.println("Promedio: " + this.promedio() + "-" + this.leyendaAprueba() + "\n");
    }
}
