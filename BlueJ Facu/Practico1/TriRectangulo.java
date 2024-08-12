
public class TriRectangulo {

    private static double a, b, c, hipotenusa;
    private static double cateto1, cateto2;
    public static void main(String[] args) {
        
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
