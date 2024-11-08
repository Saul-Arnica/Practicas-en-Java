package Practico7Integrador;


import java.util.*;

@SuppressWarnings("all")

public class Biblioteca{
    
    private String nombre;
    private HashSet<Socio> socios;
    private ArrayList<Libro> libros;
    
    //Constructores
    public Biblioteca(String p_nombre){
        this.setNombre(p_nombre);
        this.setSocios(new HashSet<Socio>());
        this.setLibros(new ArrayList<Libro>());
    }
    public Biblioteca(String p_nombre, HashSet<Socio> p_socios){
        this.setNombre(p_nombre);
        this.setSocios(p_socios);
        this.setLibros(new ArrayList<Libro>());
    }
    public Biblioteca(String p_nombre, ArrayList<Libro> p_libros){
        this.setNombre(p_nombre);
        this.setSocios(new HashSet<Socio>());
        this.setLibros(p_libros);
    }
    public Biblioteca(String p_nombre, HashSet<Socio> p_socios,ArrayList<Libro> p_libros){
        this.setNombre(p_nombre);
        this.setSocios(p_socios);
        this.setLibros(p_libros);
    }
    public Biblioteca(String p_nombre, Libro p_libro){
        this.setNombre(p_nombre);
        this.setSocios(new HashSet<Socio>());
        ArrayList<Libro> libros = new ArrayList<Libro>();
        libros.add(p_libro);
        this.setLibros(libros);
    }
    public Biblioteca(String p_nombre, Socio p_socio){
        this.setNombre(p_nombre);
        HashSet<Socio> socios = new HashSet<Socio>();
        socios.add(p_socio);
        this.setSocios(socios);
        this.setLibros(new ArrayList<Libro>());
    }
    public Biblioteca(String p_nombre, HashSet<Socio> p_socios,Libro p_libro){
        this.setNombre(p_nombre);
        this.setSocios(p_socios);
        ArrayList<Libro> libros = new ArrayList<Libro>();
        libros.add(p_libro);
        this.setLibros(libros);
    }
    public Biblioteca(String p_nombre, Socio p_socio, ArrayList<Libro> p_libros){
        this.setNombre(p_nombre);
        HashSet<Socio> socios = new HashSet<Socio>();
        socios.add(p_socio);
        this.setSocios(socios);
        this.setLibros(p_libros);
    }
    public Biblioteca(String p_nombre, Socio p_socio, Libro p_libro){
        this.setNombre(p_nombre);
        HashSet<Socio> socios = new HashSet<Socio>();
        socios.add(p_socio);
        this.setSocios(socios);
        ArrayList<Libro> libros = new ArrayList<Libro>();
        libros.add(p_libro);
        this.setLibros(libros);
    }
    //Accesors
    public String getNombre(){
        return this.nombre;
    }
    public HashSet<Socio> getSocios(){
        return this.socios;
    }
    public ArrayList<Libro> getLibros(){
        return this.libros;
    }
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    private void setSocios(HashSet<Socio> p_socios){
        this.socios = p_socios;
    }
    private void setLibros(ArrayList<Libro> p_libros){
        this.libros = p_libros;
    }
    //Metodos de agregar y eliminar elementos de las colecciones (en el uml no estan pero los pongo igual xd)
    public boolean agregarLibro(Libro p_libro){
        return this.getLibros().add(p_libro);
    }
    public boolean quitarLibro(Libro p_libro){
        return this.getLibros().remove(p_libro);
    }
    public boolean agregarSocio(Socio p_socio){
        return this.getSocios().add(p_socio);
    }
    public boolean quitarSocio(Socio p_socio){
        return this.getSocios().remove(p_socio);
    }
    /**
     * Crea un nuevo libro y lo agrega a la coleccion de libros
     */
    public void nuevoLibro(String p_titulo, int p_edicion, String p_editorial, int p_anio){
        Libro nuevo = new Libro(p_titulo, p_edicion, p_editorial, p_anio);
        
        this.getLibros().add(nuevo);
    }
    /**
     * Crea un socio del tipo Estudiante y lo agrega a la coleccion de socios
     */
    public void nuevoSocioEstudiante(int p_dniSocio, String p_nombre,int p_diasPrestamo, String p_carrera){
        Estudiante estudiante = new Estudiante(p_dniSocio, p_nombre,p_diasPrestamo, p_carrera);
        
        this.getSocios().add(estudiante);
    }
    /**
     * Crea un socio del tipo Docente y lo agrega a la coleccion de socios
     */
    public void nuevoSocioDocente(int p_dniSocio, String p_nombre,int p_diasPrestamo, String p_area){
        Docente docente = new Docente(p_dniSocio, p_nombre, p_diasPrestamo, p_area);
        
        this.getSocios().add(docente);
    }
    /**
     * Crea un prestamo y lo agrega en un libro y un socio
     * @param p_fecha fecha de devolución
     * @param p_socio socio que pide el prestamo
     * @param p_libro lirbo que se va a prestar
     */
    public boolean prestarLibro(Calendar p_fecha, Socio p_socio, Libro p_libro){
        if(this.getSocios().contains(p_socio) && (p_socio.puedePedir() == true) && this.getLibros().contains(p_libro) && (p_libro.prestado() == false)){
            Prestamo prestamo = new Prestamo(p_fecha, p_socio, p_libro);
            
            p_socio.getPrestamos().add(prestamo);
            p_libro.getPrestamos().add(prestamo);
            
            return true;
        }else{
            return false;
        }
    }
    /**
     * Si el libro está prestado establece la fecha de devolucion del ultimo prestamo como la fecha de hoy y devuelve true, si no está prestado lanza un LibroNoPrestadoException
     */
    public boolean devolverLibro(Libro p_libro) throws LibroNoPrestadoException{
        if(p_libro.prestado() == true && this.getLibros().contains(p_libro)){
            Calendar fechaHoy = Calendar.getInstance();
            
            p_libro.getPrestamos().get(p_libro.getPrestamos().size() - 1).registrarFechaDevolucion(fechaHoy);
            
            return true;
        }else{
            throw new LibroNoPrestadoException("El libro " + p_libro.getTitulo() + " no se puede devolver ya que se encuentra en la biblioteca");
        }
    }
    /**
     * Contador de socios de una clase determinada
     * @param p_objeto nombre de la clase
     * @return total de socios de dicha clase
     */
    public int cantidadDeSociosPorTipo(String p_objeto){
        int total = 0;
        
        for(Socio socio : this.getSocios()){
            if(socio.soyDeLaClase() == p_objeto){
                total++;
            }
        }
        
        return total;
    }
    /**
     * Recorre la coleccion de socios y devuelve los prestamos vencidos
     * @return prestamosVen ArrayList con los prestamos vencidos
     */
    public ArrayList<Prestamo> prestamosVencidos(){
        ArrayList<Prestamo> prestamosVen = new ArrayList();
        Calendar fechaHoy = Calendar.getInstance();
        
        for(Socio socio : this.getSocios()){
            for(Prestamo prestamo : socio.getPrestamos()){
                if(prestamo.vencido(fechaHoy)){
                    prestamosVen.add(prestamo);
                }
            }
        }
        
        return prestamosVen;
    }
    /** Devuelve el nombre del socio que tiene el libro con el titulo ingresado,si no se encuentra prestado
     * lanza una excepcion con el mensaje "El libro se encuentra en la biblioteca"
     * @param Libro p_libro
     * @return String con el nombre del socio
     * @exception String con el mensaje "El libro se encuentra en la biblioteca"
     */
    public String quienTieneElLibro(Libro p_libro) throws LibroNoPrestadoException{
        if(p_libro.prestado()){
            return p_libro.ultimoPrestamo().getSocio().getNombre();
        } else{
            throw new LibroNoPrestadoException("El libro se encuentra en la biblioteca");
        }
    }
    /**
     * Devuelve un String con la lista de socios con el siguiente formato:
     * 1) D.N.I.: <<dni>> || <<nombre y apellido>> (<<tipo>>) || Libros Prestados: <<cant. prést. actuales >>
     * 2) D.N.I.: <<dni>> || <<nombre y apellido>> (<<tipo>>) || Libros Prestados: <<cant. prést. actuales >>
     * 3) D.N.I.: <<dni>> || <<nombre y apellido>> (<<tipo>>) || Libros Prestados: <<cant. prést. actuales >>
     * @return devuelve un String
     */
    public String listaDeSocios(){
        String listado="";
        int contador=0;
        for(Socio unSocio : this.getSocios()){
            contador++;
            listado= listado + contador +")"+ unSocio.toString()+"\n";
        }
        return listado;
    }
    /**
     * Devuelve el Socio que tiene el mismo dni que fue pasado como parametro si no lo encuentra devuelve nulo
     * @param p_dni el dni a comparar
     * @return Socio si se encontro, null si no se encontro
     */
    public Socio buscarSocio(int p_dni){
        Socio socioEncontrado=null;
        for(Socio unSocio: this.getSocios()){
            if(unSocio.getDniSocio() == p_dni){
                socioEncontrado=unSocio;
                break;
            }
        }
        return socioEncontrado;
    }
    /**
     * Retorna una lista con los docentes responsables
     * @return ArrayList docentesResponsables
     */
    public ArrayList<Docente> docentesResponsables(){
        ArrayList<Docente> docentesResponsables = new ArrayList();
        for(Socio unSocio: this.getSocios()){
            if(unSocio.soyDeLaClase() == "Docente"){
                Docente unDocente = (Docente)unSocio;
                if(unDocente.esResponsable()){
                    docentesResponsables.add(unDocente);
                }
            }
        }
        return docentesResponsables;
    }
    /**
     * @return lista con los titulos de los libros de la biblioteca
     */
    public String listaDeTitulos(){
        String lista = "";
        int contador = 0;
        for(Libro libro : this.getLibros()){
            contador++;
            lista = lista + contador + ") Titulo: " + libro.getTitulo() + "\n";
        }
        return lista;
    }
    /**
     * @return lista de los libros
     */
    public String listaDeLibros(){
        String lista = "";
        int contador = 0;
        for(Libro libro : this.getLibros()){
            contador++;
            lista = lista + contador + ") Titulo: " + libro.getTitulo() + " || Prestado: " + (libro.prestado() ? "(si)" : "(no)") + "\n";
        }
        return lista;
    }
    /**
     * Retorna un String con la lista de docentes responsables. Con el siguiente formato:
     * *D.N.I.: <<dni>> || <<nombre y apellido>> (<<tipo>>) || Libros Prestados: <<cant. prést. actuales >>
     * *D.N.I.: <<dni>> || <<nombre y apellido>> (<<tipo>>) || Libros Prestados: <<cant. prést. actuales >>
     * @return String listaDocentesResponsables;
     */
    public String listaDeDocentesResponsables(){
        String listaDocentesResponsables="";
        for(Docente unDocente: this.docentesResponsables()){
            listaDocentesResponsables= listaDocentesResponsables + unDocente.toString() +"\n";
        }
        return listaDocentesResponsables;
    }
}
