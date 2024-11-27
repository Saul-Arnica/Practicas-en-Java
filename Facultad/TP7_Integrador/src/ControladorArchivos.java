/**
 * Clase controladora de archivos para la gestion de la biblioteca
 * @author Saul & Segio
 * @version 09/11/24 : 5:02:06 AM
 */
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;


@SuppressWarnings("all")
public class ControladorArchivos {
    /*
     * 1. Inicia el programa
     *      a.Verificar que haya archivos. En caso de haber, cargar a memoria
     * 2.Biblioteca genera libros, socios, prestamos, etc.
     * 3.Antes de cerrar, guardar los los datos en los archivos y luego cerrar.
     *
     */

    private String archiSocios;
    private String archiPrestamos;
    private String archiLibros;
    
    public ControladorArchivos(String p_socios, String p_prestamos, String p_libros) {
        this.setArchiSocios(p_socios);
        this.setArchiPrestamos(p_prestamos);
        this.setArchiLibros(p_libros);
    }

    public String getArchiSocios(){
        return this.archiSocios;
    }

    public String getArchiPrestamos() {
        return this.archiPrestamos;
    }

    public String getArchiLibros() {
        return this.archiLibros;
    }

    private void setArchiSocios(String p_socios) {
        this.archiSocios = p_socios;
    }

    private void setArchiPrestamos(String p_prestamos) {
        this.archiPrestamos = p_prestamos;
    }

    private void setArchiLibros(String p_libros) {
        this.archiLibros = p_libros;
    }
    
    private void verificarDuplicado(String p_Archivo) {
        try {
            //1. Abrir el archivo original en modo lectura:
            FileInputStream archiFIS = new FileInputStream(p_Archivo);
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

    
    /**
     * Guardamos los registros de cada socio en el archivo correspondiente
     * @param biblio_socios
     */
    public void guardarSocios(Biblioteca biblio_socios) {

        HashSet<Socio> socios = biblio_socios.getSocios();

        try (
            //Declaramos el flujo de salida al archivo en modo
            FileOutputStream crearArchivo = new FileOutputStream(this.getArchiSocios(), false);
            
            //Luego declaramos un DataOutputStream.
            DataOutputStream grabacion = new DataOutputStream(crearArchivo);){

            
        
            int dni = 0;
            String tipo = "";
            String nombre = "";
            int diasPrestamo = 0;
            String area_carrera = "";
            
            for(Socio socio : socios) {
                if(socio.soyDeLaClase().equals("Docente")) {
                    Docente docente = (Docente) socio;

                    dni = docente.getDniSocio();
                    grabacion.writeInt(dni);

                    tipo = "Docente";
                    grabacion.writeUTF(tipo);

                    nombre = docente.getNombre();
                    grabacion.writeUTF(nombre);

                    diasPrestamo = docente.getDiasPrestamo();
                    grabacion.writeInt(diasPrestamo);

                    area_carrera = docente.getArea();
                    grabacion.writeUTF(area_carrera);
                    
                }else{
                    Estudiante estudiante = (Estudiante) socio;

                    dni = estudiante.getDniSocio();
                    grabacion.writeInt(dni);

                    tipo = "Estudiante";
                    grabacion.writeUTF(tipo);

                    nombre = estudiante.getNombre();
                    grabacion.writeUTF(nombre);

                    diasPrestamo = estudiante.getDiasPrestamo();
                    grabacion.writeInt(diasPrestamo);

                    area_carrera = estudiante.getCarrera();
                    grabacion.writeUTF(area_carrera);
                }
            }
        
        }catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar o crear el archivo: " + e.getMessage());
        }catch (NumberFormatException e) {
            System.out.println("Error al formatear número: " + e.getMessage());
        }catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    /**
     * Guardamos los registros de cada Libro 
     * @param biblio_libros
     */
    public void guardarLibros(Biblioteca biblio_libros) {
        ArrayList<Libro> libros = biblio_libros.getLibros();
        try (//Declaramos el flujo de salida al archivo en modo "append" (agregar al final, es decir no sobreescribir)
            FileOutputStream crearArchivo = new FileOutputStream(this.getArchiLibros(), false);
            
            //Luego declaramos un DataOutputStream.
            DataOutputStream grabacion = new DataOutputStream(crearArchivo);) {
            
            
            String titulo = "";
            int edicion = 0;
            String editorial = "";
            int anio = 0;

            for(Libro libro : libros) {
                titulo = libro.getTitulo();
                grabacion.writeUTF(titulo);
                
                edicion = libro.getEdicion();
                grabacion.writeInt(edicion);

                editorial = libro.getEditorial();
                grabacion.writeUTF(editorial);

                anio = libro.getAnio();
                grabacion.writeInt(anio);
            }

        }catch(FileAlreadyExistsException e) {
            System.out.println("El archivo o directorio a crear ya existe!" + e.getMessage());
        }catch(EOFException e) {
            System.out.println("Se alcanzo inesperadamente el final del archivo o del flujo durante la entrada!" + e.getMessage());
        }catch(FileNotFoundException e) {
            System.out.println("No se localizo el archivo [Ruta invalida o no existe], o no se puede acceder a el por permisos" + e.getMessage());
        }catch(IOException e) {
            System.out.println("Ocurrio un error en la entrada o salida!" + e.getMessage());
        }
    }
    
    /**
     * Guardamos los registros de cada prestamo en el archivo correspondiente
     * @param biblio_prestamos
     */
    public void guardarPrestamos(Biblioteca biblio_prestamos) {

        ArrayList<Prestamo> prestamos = new ArrayList<>();

        for (Socio socio : biblio_prestamos.getSocios()) {
            prestamos.addAll(socio.getPrestamos());
        }
        
        try (
            //Declaramos el flujo de salida al archivo
            FileOutputStream crearArchivo = new FileOutputStream(this.getArchiPrestamos(), false);
            
            //Luego declaramos un DataOutputStream. Para le manejo de datos primitivos dentro del archivo binario
            DataOutputStream grabacion = new DataOutputStream(crearArchivo);) {
            
        
            int dni = 0;
            String tituloLibro = "";
            int anioDevolucion = 0;
            int mesDevolucion  = 0;
            int diaDevolucion  = 0;
            int anioRetiro = 0;
            int mesRetiro  = 0;
            int diaRetiro  = 0;
            
            for(Prestamo prestamo: prestamos) {
                
                dni = prestamo.getSocio().getDniSocio();
                grabacion.writeInt(dni);
                
                tituloLibro = prestamo.getLibro().getTitulo();
                grabacion.writeUTF(tituloLibro);

                if(prestamo.getFechaDevolucion() != null) {
                    anioDevolucion = prestamo.getFechaDevolucion().get(Calendar.YEAR);
                    grabacion.writeInt(anioDevolucion);

                    mesDevolucion  = prestamo.getFechaDevolucion().get(Calendar.MONTH);
                    grabacion.writeInt(mesDevolucion);

                    diaDevolucion  = prestamo.getFechaDevolucion().get(Calendar.DAY_OF_MONTH);
                    grabacion.writeInt(diaDevolucion);

                    
                }else{

                    anioDevolucion = 0;
                    grabacion.writeInt(anioDevolucion);
                    mesDevolucion  = 0;
                    grabacion.writeInt(mesDevolucion);
                    diaDevolucion  = 0;
                    grabacion.writeInt(diaDevolucion);

                }
                
                anioRetiro = prestamo.getFechaRetiro().get(Calendar.YEAR);
                grabacion.writeInt(anioRetiro);


                mesRetiro  = prestamo.getFechaRetiro().get(Calendar.MONTH);
                grabacion.writeInt(mesRetiro);

                diaRetiro  = prestamo.getFechaRetiro().get(Calendar.DAY_OF_MONTH);
                grabacion.writeInt(diaRetiro);

            }
            
        }catch(FileAlreadyExistsException e) {
            System.out.println("El archivo o directorio a crear ya existe! :" + e.getMessage());
        }catch(EOFException e) {
            System.out.println("Se alcanzo inesperadamente el final del archivo o del flujo durante la entrada! :" + e.getMessage());
        }catch(FileNotFoundException e) {
            System.out.println("No se localizo el archivo [Ruta invalida o no existe], o no se puede acceder a el por permisos :" + e.getMessage());
        }catch(IOException e) {
            System.out.println("Ocurrio un error en la entrada o salida! :" + e.getMessage());
        }
    }
    

    public void cargarDatos(Biblioteca biblio) {
        this.siExiste();
        //Colecciones de la biblioteca
        HashSet<Socio> socios = new HashSet<>();
        ArrayList<Libro> libros = new ArrayList<>();
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        //variables auxiliares
        Docente docente = null;
        Estudiante estudiante = null;
        Prestamo prestamo = null;
        Libro libro = null;

        
        

        try {
            FileInputStream archiSociosFIS = new FileInputStream(this.getArchiSocios());//1ro
            DataInputStream archiSociosDIS = new DataInputStream(archiSociosFIS);//1ro
            

            //Atributos de un Socio 
            int dniSocio = 0;
            String tipo = "";
            String nombre = "";
            int diasPrestamo = 0;
            String area_carrera = "";
            

            

            //Comenzamos con Socios. cargamos el HashSet de socios sin prestamos.
            while(archiSociosDIS.available() > 0) {

                dniSocio = archiSociosDIS.readInt();
                
                tipo = archiSociosDIS.readUTF();

                nombre = archiSociosDIS.readUTF();

                diasPrestamo = archiSociosDIS.readInt();

                area_carrera = archiSociosDIS.readUTF();
                
                if(tipo.equals("Docente")) {

                    docente = new Docente(dniSocio, nombre, diasPrestamo, area_carrera);
                    socios.add(docente);
                    docente = null;

                }else{
                    
                    estudiante = new Estudiante(dniSocio, nombre, diasPrestamo, area_carrera);
                    socios.add(estudiante);
                    estudiante = null;
                }
                
            }
            archiSociosDIS.close();
        }catch(FileAlreadyExistsException e) {
            System.out.println("El archivo o directorio a crear ya existe!" + e.getMessage());
        }catch(EOFException e) {
            System.out.println("Se alcanzo inesperadamente el final del archivo o del flujo durante la entrada!" + e.getMessage());
        }catch(FileNotFoundException e) {
            System.out.println("No se localizo el archivo [Ruta invalida o no existe], o no se puede acceder a el por permisos" + e.getMessage());
        }catch(IOException e) {
            System.out.println("Ocurrio un error en la entrada o salida!" + e.getMessage());
        }
            
        
        try {
            
            FileInputStream archiLibrosFIS = new FileInputStream(this.getArchiLibros());//2do
            DataInputStream archiLibrosDIS = new DataInputStream(archiLibrosFIS);//2do
        
            //Atributos de un libro
            String titulo = "";
            int edicion = 0;
            String editorial = "";
            int anioLibro = 0;
        
            
            
            //Comenzamos con Libros, cargamos el ArrayList de libros sin prestamos.
            while(archiLibrosDIS.available() > 0) {
                titulo = archiLibrosDIS.readUTF();

                edicion = archiLibrosDIS.readInt();
                
                editorial = archiLibrosDIS.readUTF();

                anioLibro = archiLibrosDIS.readInt();
                
                libro = new Libro(titulo, edicion, editorial, anioLibro);
                libros.add(libro);
                libro = null;
            }
            archiLibrosDIS.close();
            archiLibrosFIS.close();
            
        }catch(FileAlreadyExistsException e) {
            System.out.println("El archivo o directorio a crear ya existe!" + e.getMessage());
        }catch(EOFException e) {
            System.out.println("Se alcanzo inesperadamente el final del archivo o del flujo durante la entrada!" + e.getMessage());
        }catch(FileNotFoundException e) {
            System.out.println("No se localizo el archivo [Ruta invalida o no existe], o no se puede acceder a el por permisos" + e.getMessage());
        }catch(IOException e) {
            System.out.println("Ocurrio un error en la entrada o salida!" + e.getMessage());
        }

        try {   

            FileInputStream archiPrestamosFIS = new FileInputStream(this.getArchiPrestamos());//3ro
            DataInputStream archiPrestamosDIS = new DataInputStream(archiPrestamosFIS);//3ro
            //Atributos de un Prestamo
            Calendar fechaDevolucion;
            Calendar fechaRetiro;
            
            int dniPrestamo = 0;
            String tituloLibro = "";
            int anioDevolucion = 0;
            int mesDevolucion  = 0;
            int diaDevolucion  = 0;
            int anioRetiro = 0;
            int mesRetiro  = 0;
            int diaRetiro  = 0;
            Socio socioPrestamo = null;
            Libro libroPrestamo = null;

            //Comenzamos finalmente con Prestamo
            while(archiPrestamosDIS.available() > 0) {

                dniPrestamo = archiPrestamosDIS.readInt();
                
                tituloLibro = archiPrestamosDIS.readUTF();

                anioDevolucion = archiPrestamosDIS.readInt();

                mesDevolucion  = archiPrestamosDIS.readInt();

                diaDevolucion  = archiPrestamosDIS.readInt();

                anioRetiro = archiPrestamosDIS.readInt();

                mesRetiro  = archiPrestamosDIS.readInt();

                diaRetiro  = archiPrestamosDIS.readInt();

                //Configurar fechas de retiro y devolucion
                fechaRetiro = new GregorianCalendar(anioRetiro, mesRetiro, diaRetiro);
                if(anioDevolucion != 0) {
                    fechaDevolucion = new GregorianCalendar(anioDevolucion, mesDevolucion, diaDevolucion);
                }else{
                    fechaDevolucion = null;
                }

                /*if(anioDevolucion != 0) {
                    fechaDevolucion.set(anioDevolucion, mesDevolucion - 1, diaDevolucion);
                }else{
                    fechaDevolucion = null;
                }*/

                for(Socio socio : socios) {
                    if (socio.getDniSocio() == dniPrestamo) {
                        socioPrestamo = socio; //Si, el DNI del socio es igual al DNI del prestamo, agregamos el socio al prestamo.
                        break;
                    }
                } 

                for(Libro lib : libros){
                    if(lib.getTitulo().equals(tituloLibro) ) {
                        libroPrestamo = lib;
                        break;
                    }
                }

                prestamo = new Prestamo(fechaRetiro, socioPrestamo, libroPrestamo);
                

                if(fechaDevolucion != null) {
                    prestamo.registrarFechaDevolucion(fechaDevolucion);
                }

                prestamos.add(prestamo);
                prestamo = null;
            }
            archiPrestamosDIS.close();
        }catch(FileAlreadyExistsException e) {
            System.out.println("El archivo o directorio a crear ya existe!" + e.getMessage());
        }catch(EOFException e) {
            System.out.println("Se alcanzo inesperadamente el final del archivo o del flujo durante la entrada!" + e.getMessage());
        }catch(FileNotFoundException e) {
            System.out.println("No se localizo el archivo [Ruta invalida o no existe], o no se puede acceder a el por permisos" + e.getMessage());
        }catch(IOException e) {
            System.out.println("Ocurrio un error en la entrada o salida!" + e.getMessage());
        }
            //Ahora utilizamos ya las colecciones cargadas de Socio, libro y prestamos, para completar las relaciones.
            for(Prestamo prest : prestamos) {
                
                for(Libro lib : libros) {
                    
                    if(lib != null && prest.getLibro() != null) {
                        if(lib.getTitulo().equals(prest.getLibro().getTitulo())) {
                            try{
                                lib.agregarPrestamo(prest);
                            }catch(PrestamoInvalidoException e) {
                                System.out.println(e);
                            }
                        }
                    }
                }
                
                for(Socio soc : socios) {
                    if(soc != null && prest.getSocio() != null && soc.getDniSocio() == prest.getSocio().getDniSocio()) {
                        soc.agregarPrestamo(prest);
                    }
                }
            }

            for(Socio soc : socios) {
                biblio.agregarSocio(soc);
            }
            for(Libro lib : libros) {
                biblio.agregarLibro(lib);
            }

        }
    
    /*
    Verifica la existencia de los archivos que van a ser leidos por el motedo cargarDato Si no existen los crea
    */
    private void siExiste() {
        try {
            //Esto no crea archivos.
            File socios = new File(this.getArchiSocios());
            File prestamos = new File(this.getArchiPrestamos());
            File libros = new File(this.getArchiLibros());

            //Verificamos existencia de todos los archivos:
            //Socios
            if(socios.exists()) {
                System.out.println("El archivo Socios esta disponible.");
            }else{
                System.out.println("El archivo Socios no existe, creando archivo");
                socios.createNewFile();
            }
            //Prestamos
            if(prestamos.exists()) {
                System.out.println("El archivo Prestamos esta disponible.");
            }else{
                System.out.println("El archivo Prestamos no existe, creando archivo");
                prestamos.createNewFile();
            }
            //Libros
            if(libros.exists()) {
                System.out.println("El archivo Libros esta disponible.");
            }else{
                System.out.println("El archivo Libros no existe, creando archivo");
                libros.createNewFile();
            }
        }catch(FileAlreadyExistsException e) {
            System.out.println("El archivo o directorio a crear ya existe!" + e.getMessage());
        }catch(EOFException e) {
            System.out.println("Se alcanzo inesperadamente el final del archivo o del flujo durante la entrada!" + e.getMessage());
        }catch(FileNotFoundException e) {
            System.out.println("No se localizo el archivo [Ruta invalida o no existe], o no se puede acceder a el por permisos" + e.getMessage());
        }catch(IOException e) {
            System.out.println("Ocurrio un error en la entrada o salida!" + e.getMessage());
        }
    }
}   
