
/**
 *  3_ Crear una clase ejecutable denominada “Circunferencia”, en la que se calcule el perímetro de una circunferencia, 
    ingresando el radio de tipo entero a través del argumento del main().
 * 
 *@author (Saul Agustin Arnica)
 *@version (18/8/24)
 */
public class Circunferencia {
    public static void main(String[] args) {
        int radio;
        double perimetro;
        double PI = Math.PI;
        if(args.length > 0) {
            radio = Integer.parseInt(args[0]);
            perimetro = 2 * PI * radio;
            System.out.println("El perimetro de la circunferencia es:" +perimetro);
        }else{
            System.out.println("No se paso ningun argumento al main");
        }
    }
}
