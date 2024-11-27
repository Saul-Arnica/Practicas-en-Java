import java.io.*;
import java.nio.file.FileAlreadyExistsException;

@SuppressWarnings("all")
/*  Baja o eliminación en archivos secuenciales:
Eliminar o dar de baja en un archivo secuencial, implica procesar dos archivos a la vez. El segundo de ellos es un archivo temporal. 
El algoritmo de eliminación es el siguiente: 
*/
public class EliminacionDeArchivos {
    public static void main(String[] args) {
        //Para el manejo de excepciones, colocamos todo dentro de un bloque try.
        try {
            //1. Abrir el archivo original en modo lectura:
            FileInputStream archiFIS = new FileInputStream(
                "this.getArchivo().dat");
            //Luego para poder leer de forma secuencial y en orden:
            DataInputStream archiDIS = new DataInputStream(archiFIS);

            //2. Abrir un archivo temporal en modo escritura. 
            FileOutputStream archiFOS = new FileOutputStream(
                "C:\\Users\\saula\\WorkSpace\\Java\\BlueJ_Facu\\Practico7Integrador\\ArchivoTemporal.dat", false);

            DataOutputStream archiDOS = new DataOutputStream(archiFOS);

            //Colocamos una bandera para determinar hasta donde queremos leer o si llegamos a terminar de eliminar lo deseado
            boolean flag = false;
            // 3. Iniciar un ciclo de lectura del archivo original.
                //Mientras en el archivo haya datos/bytes y la bandera no sea true, hacer el pase de info
            while(archiDIS.available() > 0 && flag != true) {
                //a. Dentro del ciclo leer un registro. (En este caso, al ser un archivo estructurado, es decir con un campo ID o primarykey)
                int ID = archiDIS.readInt();
                String texto = archiDIS.readLine();
                //b. Colocar una condición para determinar si copiamos o no en el registro nuevo. Si no, se dará de baja o eliminara.
                if(ID != 10) {
                    archiDOS.writeInt(ID);
                    archiDOS.writeUTF(texto);
                }
                //c. Fin de ciclo (cerrar el ciclo).
            }
            
            //4. Cerrar ambos archivos.
            archiDIS.close();
            archiFIS.close();
            //5. Eliminar el archivo original. 
            File archivoOriginal = new File("C:\\Users\\saula\\WorkSpace\\Java\\BlueJ_Facu\\Practico7Integrador\\ArchivoOriginal.dat");//Pasamos la ruta
            //solamente si eliminamos el archivo Original.(Esto funciona ya que solo se elimina el archivo fisico, pero queda en memoria(virtual))
            if(archivoOriginal.delete()) {

                //6. Renombramos el archivo temporal con el nombre de archivo original. 
                File archivoTemporal = new File("C:\\Users\\saula\\WorkSpace\\Java\\BlueJ_Facu\\Practico7Integrador\\ArchivoTemporal.dat");//Pasamos la ruta
                archivoTemporal.renameTo(archivoOriginal); //Renombramos el temporal, con la "firma" del original para que sea reemplazado
                System.out.println("Proceso de baja/modificacion completado");

            }else{
                System.out.println("No se pudo eliminar el archivo original");
            }

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
