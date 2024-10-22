package Practico5;
/**
 * En esta clase, abstraemos lo que seria un alumno con sus atributos, desde su identificacion para con la facultad,
 * hasta la nota de 2 de sus parciales en la materia Programacion Orientada a Objetos.
 * @author (Saul Agustin Arnica)  
 * @version (15/8/24)
 */
public class Alumno extends Persona {
    //Declaramos los atributos de la clase.
    private int lu;
    private double nota1;
    private double nota2;
    /**
     * @param p_lu  Libreta Universitaria
     * @param p_nombre  
     * @param p_apellido
     * @param p_nota1   
     * @param p_nota2
     */
    public Alumno(int p_dni, String p_nombre, String p_apellido, int p_anio, int p_lu) {
        super(p_dni,p_nombre,p_apellido,p_anio);
        this.setLU(p_lu);
        this.setNota1(0);
        this.setNota2(0);
    }   
    //Setter's para los atributos de la clase.
    private void setLU(int p_lu) {
        this.lu = p_lu;
    }

    public void setNota1(double p_nota1) {
        this.nota1 = p_nota1;
    }

    public void setNota2(double p_nota2) {
        this.nota2 = p_nota2;
    }

    //Getter's para obtener el valor interno de los atributos de la clase de manera segura.
    public int getLu() {
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

    public void mostrar() {
        System.out.println("Nombre y Apellido: " + super.nomYApe());
        System.out.println("LU: " + this.getLu() + " " + "Notas:" + this.getNota1() + "  -  " + this.getNota2());
        System.out.println("Promedio: " + this.promedio() + "-" + this.leyendaAprueba() + "\n");
    }
}
