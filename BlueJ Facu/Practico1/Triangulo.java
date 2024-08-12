/**
 *4. Crear clase ejecutable “Triangulo”, declarar las variables a, b y c de tipo double, 
 *que corresponden a los lados de un triángulo. 
 *Los valores deben ser ingresados por teclado como argumentos del método main(). 
 *Calcular y mostrar el semiperímetro y el área del triángulo.
        semiperimetro = (a+b+c)/2 
        area = raíz cuadrada(semiperimetro*(semiperimetro-a)*(semiperimetro-b)*(semiperimetro-c))
        Nota: probar con a = 2, b = 2.7, c = 3.5
 * 
 * @author (Saul Agustin Arnica) 
 * @version (1)
 */
public class Triangulo {

    private static double a;
    private static double b;
    private static double c;
    
    public static void main(String[] args) {
        double semiperimetro, area;
        if(args.length > 0) {
            a = Double.parseDouble(args[0]);
            b= Double.parseDouble(args[1]);
            c = Double.parseDouble(args[2]);
            semiperimetro = ((a + b + c) / 2);
            area = Math.sqrt(semiperimetro *(semiperimetro - a) * semiperimetro *(semiperimetro - b) * semiperimetro *(semiperimetro - c));
            System.out.println("El semiperimetro es:" + semiperimetro + " El area es:" + area);
        }else{
            System.out.println("No se paso ningun argumento al main");
        }
    }
}
