
public class EjecutableCliente {
    public static void main(String[] args) {

        //Hacemos una validacion para no tener alguna excepcion en tiempo de ejecucion.
        if(args.length == 4) {

            //Cliente cli1 = new Cliente(43205368, "Arnica" , "Saul Agustin", 10000);
            int dni = Integer.parseInt(args[0]);
            double saldo = Double.parseDouble(args[3]);
            Cliente cliente2 = new Cliente(dni, args[1], args[2], saldo);
            //cli1.mostrar();
            //System.out.println(cli1.getSaldo());
            //System.err.println(cli1.nomYApe());
            //System.err.println(cli1.apeYNom());
            System.out.println(cliente2.getSaldo());
            System.out.println(cliente2.nomYApe());
            System.out.println(cliente2.apeYNom());
            System.out.println(cliente2.agregarSaldo(5));
            System.out.println(cliente2.getSaldo());
            System.out.println(cliente2.agregarSaldo(saldo));
            System.out.println(cliente2.getSaldo());
            cliente2.mostrar();
            
        }else{
            System.out.println("No se ingreso nada por el metodo main..");
        }
    }
}
