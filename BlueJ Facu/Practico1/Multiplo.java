
/**
 * 2. Crear la clase “Multiplo”, que contenga el método main(), en el que se determinen y muestren por pantalla los 
números múltiplos de 4 a partir de 42 y hasta el 150 inclusive. Usar la instrucción iterativa más apropiada.
 * @author (Saul Agustin Arnica) 
 * @version (1)
 */
public class Multiplo {
    
    private static int a;
    private static int b;
    
    public static void main(String[] args) {
        System.out.println("Los multiplos de 4 a partir de 42 son:");
        for(int i = 42;i <= 150;i++){
            if(i % 4 == 0) {
                System.out.println(+i);
            }
        }
    }
}
