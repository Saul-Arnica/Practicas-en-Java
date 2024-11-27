import java.util.*;
/**
 * Write a description of class EjecutableProducto here.
 * 
 * @author Sergio Navarro
 * @version 28/8/2024
 */
public class GestionStock{
    public static void main(String[] args){
        int opcion = 0;
        boolean seguir = true;
        Scanner ingreso = new Scanner(System.in);
        Laboratorio lab = null;
        Producto produ = null;
        while(seguir){
            System.out.println("-------MENÚ-------");
            System.out.println("1- Instanciar Laboratorio");
            System.out.println("2- Instanciar producto");
            System.out.println("3- Ajustar stock de producto");
            System.out.println("4- Mostrar datos de producto");
            System.out.println("5- Mostrar datos de laboratorio");
            System.out.println("0- salir");
            opcion = ingreso.nextInt();
            ingreso.nextLine();
            switch(opcion){
                case 1: 
                    System.out.print("Ingrese el nombre del Laboratorio:");
                    String nombre = ingreso.nextLine();
                    System.out.print("Ingrese el domicilio del Laboratorio:");
                    String domicilio = ingreso.nextLine();
                    System.out.print("Ingrese el numero de telefono:");
                    String telefono = ingreso.nextLine();
                    Laboratorio nuevoLab = new Laboratorio(nombre, domicilio, telefono);
                    System.out.println("Laboratorio instanciado!");
                    lab = nuevoLab;
                    break;
                case 2: 
                    System.out.print("Ingrese el codigo de producto:");
                    int codigo = ingreso.nextInt();
                    ingreso.nextLine();
                    System.out.print("Ingrese el rubro:");
                    String rubro = ingreso.nextLine();
                    System.out.print("Ingrese la descripcion:");
                    String descripcion = ingreso.nextLine();
                    System.out.print("Ingrese el precio");
                    double costo = ingreso.nextDouble();
                    ingreso.nextLine();
                    Producto nuevoProducto = new Producto(codigo, rubro, descripcion, costo, lab);
                    System.out.println("Producto instanciado!");
                    produ = nuevoProducto;
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo Stock:");
                    int stock = ingreso.nextInt();
                    ingreso.nextLine();
                    produ.ajuste(stock);
                    System.out.println("Stock ajustado!");
                    break;
                case 4:
                    produ.mostrar();
                    break;
                case 5:
                    System.out.println(lab.mostrar());
                    break;
                case 0:
                    seguir = false;
                    break;
                default:
                    System.out.println("Opcion invalida!");
                    break;
            }
        }
        ingreso.close();
    }
}