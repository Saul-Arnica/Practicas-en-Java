package Practico7Integrador;

import java.io.*;

public class LecturaDeArchivosSecuenciales {
    
    public static void main(String [] args) {
        // Lectura de Archivos secuenciales.
        
        try{
        FileInputStream archiFIS = new FileInputStream(
        "C:\\Users\\saula\\WorkSpace\\Java\\BlueJ_Facu\\Practico7Integrador\\ArchivoPrueba.dat");
        
        DataInputStream archiDIS = new DataInputStream(archiFIS);
        
        while(archiDIS.available() > 0) { //Mientras haya bytes para leer...
        System.out.println(archiDIS.readInt());
        System.out.println(archiDIS.readUTF());
        }
        archiFIS.close();
        archiDIS.close();
        } catch(FileNotFoundException ioe) {
        System.out.println("Archivo no encontrado.");
        } catch(IOException e) {
        System.out.println("Error en la apertura o cierre del archivo.");
        }
    }
}
