
public class EjecutableAlumno {
    public static void main(String[] args) {
        if(args.length > 0) {
            int p_lu = Integer.parseInt(args[0]);
            double p_nota1 = Double.parseDouble(args[3]);
            double p_nota2 = Double.parseDouble(args[4]);
            Alumno alumno1 = new Alumno(p_lu, args[1], args[2], p_nota1, p_nota2);
            System.out.println(alumno1.promedio());
            alumno1.setNota1(8);
            System.out.println(alumno1.getNota1());
            alumno1.setNota2(9);
            System.out.println(alumno1.getNota2());
            alumno1.setNota1(p_nota1);
            alumno1.setNota2(p_nota2);
            alumno1.mostrar();
            
        }else{
            System.out.println("No se ingreso nada por el main.");
        }
    }   
}
