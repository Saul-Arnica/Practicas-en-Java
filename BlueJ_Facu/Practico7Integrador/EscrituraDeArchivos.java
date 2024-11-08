
package Practico7Integrador;

import java.io.*;

@SuppressWarnings("all")

public class EscrituraDeArchivos {

    public static void main(String[] args) {
        //Para la escritura de archivos secuenciales (Binarios), lo que debemos hace es lo siguiente:
        try {
            BufferedReader ingresoTeclado = new BufferedReader(new InputStreamReader(System.in));
            
            //Declaramos el flujo de salida al archivo en modo "append" (agregar al final, es decir no sobreescribir)
            FileOutputStream crearArchivo = new FileOutputStream(
            "C:\\Users\\saula\\WorkSpace\\Java\\BlueJ_Facu\\Practico7Integrador\\ArchivoPrueba.dat", true);
            
            //Luego declaramos un DataOutputStream.
            DataOutputStream grabacion = new DataOutputStream(crearArchivo);
        
            int key = 0;
            String cadena = "";
            char opcion = 's';
            while (opcion != 'n' && opcion != 'N') {
                System.out.print("Escriba el valor de key: ");
                key = Integer.parseInt(ingresoTeclado.readLine());
                grabacion.writeInt(key);
                System.out.print("Escriba la cadena: ");
                cadena = ingresoTeclado.readLine();
                grabacion.writeUTF(cadena);
                
                System.out.println("Más datos ? (S/N): ");
                opcion = ingresoTeclado.readLine().charAt(0);
            }
        
            grabacion.close();
            
         // Una vez que terminamos, cerramos las entradas y liberamos la memora.
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo o crearlo");
        } catch (IOException e) {
            System.out.println("Error al leer el ingreso por teclado");
        }
        catch(NumberFormatException e) {
            System.out.println("Error al ingresar el numero o key");
        }
    }

    
}
