/**
    Esta clase ejecutable explica a detalle como manejar archivos, en este caso, como manejar entrada por teclado.
    @author Saul-Agustin-Arnica
    @date 07/11/24
 **/
package Practico7Integrador;

import java.io.*; //Aca nos olvidamos de poner biblioteca a biblioteca
import java.nio.file.FileAlreadyExistsException;

@SuppressWarnings("all")

public class ManejoDeArchivos {
    // Siempre cuando queremos leer caracteres por ingreso de teclado, se hará en la
    // clase ejecutable.

    public static void main(String[] args) {
        
        /* En resumen, dentro de java.io.BufferedReader tenemos 2 constructores:
        bufferedReader(Reader in) -> (Crea un flujo de entrada de caracteres con
        almacenamiento en búfer usando un tamaño por defecto de buffer, mayormente 8192 bytes -> 8kb)
        BufferedReader(Reader in, int sz) -> (Crea un flujo de entrada de caracteres con almacenamiento en buffer usando un buffer de un tamaño en especifico)
        Resumen de metodos:
        int read() -> lee un caracter.
        String readLine() -> lee una linea de texto.
        void reset() -> Reestablece la transmisión hacia la marca mas reciente, esto
        se usa para cuando queremos marcar(con el metodo "mark()") una posicion en
        especifica dentro del texto a leer, esto es parecido al uso de fseek en C (para que tomen como referencia).
        */
        
        //Luego creamos un bloque try para el manejo de excepciones que es muy comun en la entrada de datos por teclado/lectura de archivos
        try {
        // Primero declaramos:
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Prueba, escribí algo:");
            String frase = teclado.readLine();
            System.out.println(frase);
            teclado.close();

        }catch(FileAlreadyExistsException e) {
            System.out.println("El archivo o directorio a crear ya existe!");
        }catch(EOFException e) {
            System.out.println("Se alcanzo inesperadamente el final del archivo o del flujo durante la entrada!");
        }catch(FileNotFoundException e) {
            System.out.println("No se localizo el archivo [Ruta invalida o no existe], o no se puede acceder a el por permisos");
        }catch(IOException e) {
            System.out.println("Ocurrio un error en la entrada o salida!");
        }
    }
}