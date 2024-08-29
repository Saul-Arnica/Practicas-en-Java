
public class GestionStock {
    public static void main(String[] args) {
        Laboratorio laboratorio1 = new Laboratorio("Colgate S.A", "Milan 2630", "3794834167");
        Producto producto1 = new Producto(1, "Perfumeria", "Jabon Deluxe", 5.25, laboratorio1);

        producto1.ajuste(500);
        producto1.mostrar();
        System.out.println(producto1.mostrarLinea());
        producto1.stockValorizado();
        producto1.ajuste(-200);
        producto1.mostrar();
        System.out.println(producto1.mostrarLinea());
    }
}
