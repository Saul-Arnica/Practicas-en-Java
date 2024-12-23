
import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class LecturaDeArchivosSecuenciales {
    
    public static void main(String [] args) {
        // Lectura de Archivos secuenciales.
        
        try{
        FileInputStream archiFIS = new FileInputStream("C:\\Users\\saula\\WorkSpace\\Java\\BlueJ_Facu\\TP7_Integrador\\socios.dat");
        
        DataInputStream archiDIS = new DataInputStream(archiFIS);
        //ESTO ES PRESTAMO
        /*while(archiDIS.available() > 0) { //Mientras haya bytes para leer...
            System.out.println(archiDIS.readInt());
            System.out.println(archiDIS.readUTF());
            System.out.println(archiDIS.readInt());
            System.out.println(archiDIS.readInt());
            System.out.println(archiDIS.readInt());
            System.out.println(archiDIS.readInt());
            System.out.println(archiDIS.readInt());
            System.out.println(archiDIS.readInt());

            }*/
        
        //ESTO ES LIBRO
        /*while(archiDIS.available() > 0) { //Mientras haya bytes para leer...
        
            System.out.println(archiDIS.readUTF());
            System.out.println(archiDIS.readInt());
            System.out.println(archiDIS.readUTF());
            System.out.println(archiDIS.readInt());
            }*/
        
        
        //ESTO ES SOCIO.
        while(archiDIS.available() > 0) { //Mientras haya bytes para leer...
        System.out.println(archiDIS.readInt());
        System.out.println(archiDIS.readUTF());
        System.out.println(archiDIS.readUTF());
        System.out.println(archiDIS.readInt());
        System.out.println(archiDIS.readUTF());
        }

        archiDIS.close();
        
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
