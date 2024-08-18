
/**
 * Write a description of class EjecutableCliente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EjecutableCliente {
    public static void main(String[] args) {
        if(args.length > 0) {

            Cliente cli1 = new Cliente(43205368, "Arnica" , "Saul Agustin", 10000);
            int dni = Integer.parseInt(args[0]);
            double sald = Double.parseDouble(args[3]);
            Cliente cli2 = new Cliente(dni, args[1], args[2], sald);
            cli1.mostrar();
            cli2.mostrar();
        }else{
            System.out.println("No se ingreso nada por el metodo main..");
        }
    }
}
