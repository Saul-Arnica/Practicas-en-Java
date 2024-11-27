package Practico5;

public class Renglon {
    private int cantidad;
    private double importe;
    private Etiqueta item;

    public Renglon(int p_cantidad, double p_importe, Etiqueta p_item) {
        this.setCantidad(p_cantidad);
        this.setImporte(p_item.precio(p_cantidad));
        this.setItem(p_item);
    }

    //Accesor´s
    private void setCantidad(int p_cantidad) {
        this.cantidad = p_cantidad;
    }
    private void setImporte(double p_importe) {
        this.importe = p_importe;
    }
    private void setItem(Etiqueta p_item) {
        this.item = p_item;
    }

    public int getCantidad() {
        return this.cantidad;
    }
    public double getImporte() {
        return this.importe;
    }
    public Etiqueta getItem() {
        return this.item;
    }

    //Metodos 
    public void mostrar() {

        System.out.println(this.getCantidad() + " Etiquetas de " + this.getItem().toString());
        System.out.println("Precio: $" + this.getImporte());
    }
    // La clase Renglon muestra:
        //7 Etiquetas de tipo Premiun - Costo: $200.0 - Colores: 10

}
