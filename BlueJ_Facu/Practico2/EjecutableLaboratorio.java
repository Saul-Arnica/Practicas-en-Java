/**
 * Esta clase es encargada de ejecutar o probar, la clase Laboratorio, al tener 2 constructores, probamos ambos en el mismo "ejecutable"
 */
public class EjecutableLaboratorio {
    public static void main(String[] args) {

        Laboratorio laboratorio1 = new Laboratorio("Colgate S.A", "Cazadores Correntinos 4565", "+ 54 - 3794 - 558899",  500, 25);
        Laboratorio laboratorio2 = new Laboratorio("No te Cuelges S.A", "Av. Libertad 5089", "+54 - 3794 - 456589");
        System.out.print(laboratorio1.mostrar());
        System.out.print(laboratorio2.mostrar());
        /* Si quiere ver que se asigan los valores a compra minima y dia de entrega puede borrar esto.
        System.out.print(laboratorio1.getCompraMinima());
        System.out.print(laboratorio1.getDiaEntrega());
        */
    }
}

