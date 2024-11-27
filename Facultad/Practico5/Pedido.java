package Practico5;

import java.util.*;

    /**
    @author Saul Agustin Arnica
    @version 20/10/2024
    */
public class Pedido {

    private ArrayList<Renglon> renglones = new ArrayList<Renglon>();

    public Pedido(ArrayList<Renglon> p_renglones){
        this.setRenglones(p_renglones);
    }

    public ArrayList<Renglon> getRenglones(){
        return this.renglones;
    }

    private void setRenglones(ArrayList<Renglon> p_renglones){
        this.renglones = p_renglones;
    }

    public boolean agregarRenglon(Renglon p_renglon){
        return this.getRenglones().add(p_renglon);
    }

    public boolean quitarRenglon(Renglon p_renglon){
        if(this.getRenglones().size()<=1){
            return false;
        }else{
            return this.getRenglones().remove(p_renglon);
        }
    }

    public void mostrar(){
        int totalEtiquetas = 0;
        double importeTotal = 0;
        int contador = 1;
        System.out.println("Pedido:");
        System.out.println("Cantidad de items: " + this.getRenglones().size());
        for(Renglon unRenglon : this.getRenglones()) {
            System.out.print("Item " + contador + ":");
            totalEtiquetas += unRenglon.getCantidad();
            importeTotal += unRenglon.getImporte();
            unRenglon.mostrar();
            contador++;
        }
        System.out.println("--Total pedido: " + totalEtiquetas + " etiquetas por un importe total de: $" + importeTotal);
    }

}
