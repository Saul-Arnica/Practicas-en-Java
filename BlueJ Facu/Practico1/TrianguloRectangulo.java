/**
 * 6_ Crear una clase denominada TrianguloRectangulo, en la que se determine si un triangulo es rectángulo (Teorema de Pitágoras → h2 = cateto1^2 + cateto2^2). 
 * Los lados se deben ingresar por teclado, utilizando el argumento del main(). 
 * Nota: probar con hipotenusa = 5; cateto1 = 3; cateto2 = 4;
 * @author (Saul Agustin Arnica)
 * @version (18/8/24)
*/

public class TrianguloRectangulo {
    public static void main(String[] args) {
        double a, b, c, hipotenusa;
        double cateto1, cateto2;
        
        if(args.length > 0) {
            a = Double.parseDouble(args[0]);
            b = Double.parseDouble(args[1]);
            c = Double.parseDouble(args[2]);
            hipotenusa = Math.max(a , Math.max(b , c));
            //tambien se puede utilizar un switch
            if(hipotenusa == a) {
                cateto1 = b;
                cateto2 = c;
            }else if(hipotenusa == b) {
                cateto1 = a;
                cateto2 = c;
            }else{
                cateto1 = a;
                cateto2 = b;
            }
            if(Math.pow(hipotenusa, 2) == Math.pow(cateto1, 2) + Math.pow(cateto2, 2)){
                System.out.println("El triangulo es rectangulo.");
            }else{
                System.out.println("El triangulo no es rectangulo.");
            }
        }else{
            System.out.println("No se ingreso nada en los argumentos del main.");
        }
    }   
}
