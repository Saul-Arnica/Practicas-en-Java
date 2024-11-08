/**
    Esta clase ejecutable explica a detalle como manejar archivos, en este caso, como manejar entrada por teclado.
    @author Saul-Agustin-Arnica
    @date 07/11/24
 **/
package Practico7Integrador;

import java.io.*; //Aca nos olvidamos de poner biblioteca a biblioteca

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
        
        // Luego creamos un bloque try para el manejo de excepciones que es muy comun en
        // la entrada de datos por teclado/lectura de archivos
        /*try {
        // Primero declaramos:
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Prueba, escribí algo:");
            String frase = teclado.readLine();
            System.out.println(frase);
            teclado.close();
        }
        catch(IOException e) {
        System.out.println("Error al leer el ingreso por teclado");
        //Aca, nos imprime la seguidilla por asi decirlo de la entrada hasta el erro producido
        e.printStackTrace();
        }*/
        
        

        

        // Busqueda en archivos secuenciales y Filtros y Condiciones
        try {
            FileInputStream archiFIS = new FileInputStream(
                    "C:\\Users\\saula\\WorkSpace\\Java\\BlueJ_Facu\\Practico7Integrador\\ArchivoPrueba.dat");

            DataInputStream archiDIS = new DataInputStream(archiFIS);

            boolean encontro = false;

            while (archiDIS.available() > 0 && encontro != true) {
                int id = archiDIS.readInt(); // Lee el ID
                String nombre = archiDIS.readUTF(); // Lee el nombre

                // Procesar solo si el ID cumple con la condición
                if (id == 40) {
                    System.out.println("ID: " + id + ", Nombre: " + nombre);
                    encontro = true;
                }
            }
            if(encontro == false) {
                System.out.println("Registro no encontrado");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}