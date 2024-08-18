
/**
 * Write a description of class EjecutableAlumno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EjecutableAlumno {
    public static void main(String[] args) {
        if(args.length > 0) {
            int p_lu = Integer.parseInt(args[0]);
            double p_nota1 = Double.parseDouble(args[3]);
            double p_nota2 = Double.parseDouble(args[4]);
            Alumno alumno1 = new Alumno(p_lu, args[1], args[2], p_nota1, p_nota2);
            alumno1.mostrar();
        }else{
            System.out.println("No se ingreso nada por el main.");
        }
    }   
}
