/*
    * Crear una clase denominada “Ecuación” que calcule las raíces reales de una ecuación de segundo grado. 
    * Los valores de los coeficientes a, b y c se ingresarán por teclado como argumentos del método main(). 
    * Considerar que si el discriminante > 0 se deben calcular las 2 raíces, si el discriminante = 0 se debe calcular una sola raíz,especificando por pantalla que x1 = x2. 
En caso de ser negativo, mostrar un mensaje indicando que se 
encuentra frente a una solución compleja (numero imaginario).
Nota: probar con a= -1; b=500; c=-62500;
*/
public class Ecuacion {
    private static double a, b, c;
    private static double discriminante;
    public static void main(String[] args) {
        if(args.length > 0) {
            
            a = Double.parseDouble(args[0]);
            b = Double.parseDouble(args[1]);
            c = Double.parseDouble(args[2]);
            discriminante = b * b - 4 * a * c;

            if(discriminante > 0) {
                double r1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                double r2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                System.out.println("Las raices son reales y distintas, ellas son:/n" + "Raiz 1:" + r1 + "/nRaiz 2:" + r2);
            }else if(discriminante == 0) {
                double raiz = -b / (2 * a);
                System.out.println("La raiz es real y doble, es:" + raiz);
            }else{
                System.out.println("La ecuacion se encuentra frente a una solución compleja (numeros imaginarios)");
            }
        }else{
            System.out.println("No se ingreso nada en los argumentos del main.");
        }
    }
}