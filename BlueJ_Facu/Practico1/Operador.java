    
/**
 *  1_ Crear la clase ejecutable “Operador”, que contenga el método main().
 *  En él declarar las variables a y b de tipo entero.
 *  Inicializarlas con los valores 8 y 3 respectivamente. 
 *  Realizar y mostrar por pantalla las siguientes operaciones aritméticas:suma, resta, multiplicación, división y resto.
 *  @author (Saul Agustin Arnica)
 *  @version (18/8/24)
 */
public class Operador {
    public static void main(String[] args) {
        int a, b;
        a=8;
        b=3;
        System.out.println("SUMA:" + "A + B:" + (a + b));
        System.out.println("RESTA:" + "A - B:" + (a - b));
        System.out.println("MULTIPLICACION:" + "A * B:" + (a * b));
        System.out.println("DIVISION:" + "A / B:" + (a / b));
        System.out.println("RESTO:" + "A % B:" + (a % b));
    }
}