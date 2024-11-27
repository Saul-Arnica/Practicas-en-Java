import java.util.*;

public class GestionPedido {

    public static void main(String[] args) {
        // Simular un cliente
        Cliente cliente = new Cliente(123456789, "Perez", "Juan", 0);
        Laboratorio lab = new Laboratorio("prueba", "Donde sea", "800-444-6567");
        Calendar fecha = new GregorianCalendar();
        fecha.set(Calendar.YEAR, 2024);
        fecha.set(Calendar.MONTH, 5);
        fecha.set(Calendar.DAY_OF_MONTH, 10);
        // Crear algunos productos
        Producto prod1 = new Producto(0, "Higiene", "Crema anti arrugas", 5.000, lab); //("Laptop", 1500.00, 1400.00); // Precio lista y contado
        Producto prod2 = new Producto(0, "Personal", "Omeprazol", 5.000, lab);//(1 , "Mouse", 50.00, 45.00);
        Producto prod3 = new Producto(0, "Que paja", "Ya me canse de esto", 5.000, lab);//(2 ,"Teclado", 70.00, 65.00);

        // Crear una lista de productos
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(prod1);
        productos.add(prod2);
        productos.add(prod3);

        // Crear un pedido
        Pedido pedido = new Pedido(fecha, cliente, productos);

        // Mostrar el detalle inicial del pedido
        System.out.println("** Detalle del pedido inicial **");
        pedido.mostrarPedido();

        // Quitar un producto (por ejemplo, el "Mouse")
        pedido.quitarProducto(prod2);

        // Mostrar el detalle del pedido después de quitar el producto
        System.out.println("\n** Detalle del pedido después de quitar el Mouse **");
        pedido.mostrarPedido();
    }
}
