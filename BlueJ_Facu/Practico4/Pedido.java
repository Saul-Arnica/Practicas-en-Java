import java.util.*;
/**
 * 
 */

public class Pedido {
    
    private Calendar fecha;
    private ArrayList<Producto> productos;
    Cliente cliente;
    @SuppressWarnings("all")
    public Pedido(Calendar p_fecha, Cliente p_cliente, ArrayList p_productos) {
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(p_productos);
    }

    public Pedido(Calendar p_fecha, Cliente p_cliente, Producto p_producto) {
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(new ArrayList<Producto>());
        this.agregarProducto(p_producto);
        
    }

    private void setFecha(Calendar p_fecha) {
        this.fecha = p_fecha;
    }
    private void setCliente(Cliente p_cliente) {
        this.cliente = p_cliente;
    }
    @SuppressWarnings("all")
    private void setProductos(ArrayList p_productos) {
        this.productos = p_productos;
    }
    @SuppressWarnings("all")
    public ArrayList getProductos() {
        return this.productos;
    }

    public Calendar getFecha() {
        return this.fecha;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public double totalAlContado() {
        double total = 0;
        for(Object obj: this.getProductos()) {
            Producto p = (Producto) obj;
            total = total + p.precioContado(); // o tambien asi: total += p.precioContado();
        }
        return total;
    }
    public double totalFinanciado() {
        double total = 0;

        for(Object obj: this.getProductos()) {
            Producto p = (Producto) obj;
            total = total + p.precioLista();
        }
        return total;
    }

    @SuppressWarnings("all")
    public boolean agregarProducto(Producto p_producto) {
        return this.getProductos().add(p_producto);
    }

    public boolean quitarProducto(Producto p_producto) {
        return this.getProductos().remove(p_producto);
    }

    public void mostrarPedido() {
        System.out.println("****** Detalle del pedido ****** " + this.getFecha().get(0) + "/" + this.getFecha().get(1) + "/" + this.getFecha().get(2));
        System.out.println("Producto\tPrecio Lista\tPrecio Contado");
        System.out.println("------------------------------------------------------------------");
        for(Object obj: this.getProductos()) {
            Producto p = (Producto) obj;
            System.out.println(p.getDescripcion()+ "\t" + p.precioLista() + "\t" + p.precioContado());
        }
        System.out.println("*** Total ------ $" + this.totalFinanciado() + "\t$" + this.totalAlContado());
    }

}
