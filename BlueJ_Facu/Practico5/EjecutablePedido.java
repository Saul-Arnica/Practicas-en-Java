package Practico5;

import java.util.ArrayList;

public class EjecutablePedido {


    public static void main(String[] args) {
        // Crear etiquetas de tipo Premium y Común
        Etiqueta etiquetaPremium1 = new Premium(200, 10);
        Etiqueta etiquetaComun = new Comun(100, 100);
        Etiqueta etiquetaPremium2 = new Premium(200, 7);

        // Crear renglones correspondientes a las etiquetas
        Renglon renglon1 = new Renglon(7, 1820, etiquetaPremium1);
        Renglon renglon2 = new Renglon(57, 5510, etiquetaComun);
        Renglon renglon3 = new Renglon(94, 22748, etiquetaPremium2);

        // Crear una lista de renglones
        ArrayList<Renglon> renglones = new ArrayList<>();
        renglones.add(renglon1);
        renglones.add(renglon2);
        renglones.add(renglon3);

        // Crear un pedido con los renglones
        Pedido pedido = new Pedido(renglones);

        // Mostrar el pedido
        pedido.mostrar();
    }
}
