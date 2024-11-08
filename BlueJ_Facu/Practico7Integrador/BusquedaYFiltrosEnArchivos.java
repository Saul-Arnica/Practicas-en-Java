package Practico7Integrador;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class BusquedaYFiltrosEnArchivos {
    public static void main(String[] args) {
        //Busqueda en archivos secuenciales y Filtros y Condiciones
        try {
            //Primero instanciamos un objeto FileInputStream -> hace que podamos leer un archivo ya hecho.
            FileInputStream archiFIS = new FileInputStream(
                    "C:\\Users\\saula\\WorkSpace\\Java\\BlueJ_Facu\\Practico7Integrador\\ArchivoPrueba.dat");
            //Luego, heredando de FileInputStream, instanciamos DataInputStream -> hace que podamos declarar un objeto que tome los datos del archivo
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
