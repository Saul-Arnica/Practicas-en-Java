/**
 * Esta clase, es el controlador de las ventanas.
 * 
 * @author Fiorella - Saul - Ruth - Angel
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class BibliotecaControlador {
    
    private VistaBiblioteca vista;
    private Biblioteca biblioteca;

    public BibliotecaControlador(VistaBiblioteca vista, Biblioteca biblioteca) {
    
        this.setBiblioteca(biblioteca);
        this.setVistaBiblioteca(vista);
        
        //Aca seteamos los Eventos a los botones.
        this.setEventos_Botones();
        //settear eventos a los items (no son lo mismo que los botones)
        this.setEventos_Items();
    }
    
    private void setVistaBiblioteca(VistaBiblioteca p_bibliotecaVista) {
        this.vista = p_bibliotecaVista;
    }
    
    private void setBiblioteca(Biblioteca p_biblioteca) {
        this.biblioteca = p_biblioteca;
    }
    
    public VistaBiblioteca getVistaBiblioteca() {
        return this.vista;
    }
    
    public Biblioteca getBiblioteca() {
        return this.biblioteca;
    }
    
    private void setEventos_Items(){
        this.getVistaBiblioteca().getItemCantSocios().addActionListener(this :: mostrarCantSociosPorTipo);
        this.getVistaBiblioteca().getItemDocentesResponsables().addActionListener(this :: listaResponsables);
    }
    //Lo hago privado porque es de uso propio de la clase y no es necesario que se vea ni se vuelva a usar.
    private void setEventos_Botones() {
        
        // Asociar los eventos a los botones (Btn es: boton).
                //:: Es una referencia a método, que se utiliza para pasar el método como un objeto funcional.
                //Si usamos . solo es para llamar directamente al metodo, cosa que no queremos en este caso.
                
        this.getVistaBiblioteca().getBtnVerLibros().addActionListener(this :: verLibros);
        this.getVistaBiblioteca().getBtnVerSocios().addActionListener(this :: verSocios);
        this.getVistaBiblioteca().getBtnVerPrestamos().addActionListener(this :: verPrestamos);
        this.getVistaBiblioteca().getBtnVerPrestamosVencidos().addActionListener(this :: verPrestamosVencidos);
        this.getVistaBiblioteca().getBtnIngresar().addActionListener(this :: ingresar);
        //
        this.getVistaBiblioteca().getBtnAgregarLibro().addActionListener(this :: agregarLibro);
        this.getVistaBiblioteca().getBtnQuienTieneElLibro().addActionListener(this :: buscarQuienTiene);
        this.getVistaBiblioteca().getBtnRegistrarSocio().addActionListener(this :: registrarSocio);
        this.getVistaBiblioteca().getBtnEliminarSocio().addActionListener(this :: eliminarSocio);
        this.getVistaBiblioteca().getBtnPrestarLibro().addActionListener(this :: prestarLibro);
        
        this.getVistaBiblioteca().getBtnDevolverLibro().addActionListener(this :: devolverLibro);
        
    }

    private void ingresar(ActionEvent event){
        
        this.getVistaBiblioteca().actualizarVista("Libros",this.getBiblioteca().listaDeLibros());
    }

    // Método para mostrar la lista de libros
    private void verLibros(ActionEvent event) {
        String listaLibros = this.getBiblioteca().listaDeLibros();
        this.getVistaBiblioteca().actualizarVista("Libros", listaLibros);
    }

    // Método para mostrar la lista de socios
    private void verSocios(ActionEvent event) {
        String listaSocios = this.getBiblioteca().listaDeSocios();
        this.getVistaBiblioteca().actualizarVista("Socios", listaSocios);
    }

    // Método para mostrar los préstamos
    private void verPrestamos(ActionEvent event) { 
        String prestamos = this.listarPrestamos(this.getBiblioteca()); 
        this.getVistaBiblioteca().actualizarVista("Prestamos", prestamos);
    }
    
    private boolean esNombreValidoSinNumeros(String p_nombre) {
        return p_nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ &$*+]+");
    }
    
    private boolean esNombreValidoConNumeros(String p_nombre) {
        return p_nombre.matches("[A-Za-z áéíóúÁÉÍÓÚñÑ 0-9 &$*+]+");
    }
    
    private boolean sonNumerosValidos(String p_ingreso) {
        return p_ingreso.matches("[0-9]+");
    }
    
    public void listaResponsables(ActionEvent event) {
        // Crear el StringBuilder para construir la lista de docentes
        StringBuilder docentesListados = new StringBuilder();
        docentesListados.append("Lista de Docentes Responsables:\n");
        // Mostrar los docentes responsables en el área de texto
        for (Docente docente : this.getBiblioteca().docentesResponsables()) {
            // Agregar cada docente a la lista (nombre y área)
            docentesListados.append(docente.getNombre())
                            .append(" - Área: ")
                            .append(docente.getArea())
                            .append("\n");
        }
        String mensaje = docentesListados.toString();
        // Asignar el texto generado al JTextArea
        if(this.getBiblioteca().docentesResponsables().isEmpty()){
            mensaje ="Lista vacía";
        }
        JOptionPane.showMessageDialog(this.getVistaBiblioteca(), mensaje,
                "Acerca de la Biblioteca", JOptionPane.INFORMATION_MESSAGE);  
    }
    
    public void mostrarCantSociosPorTipo(ActionEvent event) {
        // Contadores por tipo de socio
        int countEstudiantes = this.getBiblioteca().cantidadDeSociosPorTipo("Estudiante");
        int countDocentes = this.getBiblioteca().cantidadDeSociosPorTipo("Docente");
        // Crear el mensaje con la cantidad de socios por tipo
        String mensaje = "Cantidad de socios de la biblioteca:\nEstudiantes: " + countEstudiantes +
                            "\nDocentes: " + countDocentes;
        // Mostrar el mensaje en un JOptionPane
        JOptionPane.showMessageDialog(this.getVistaBiblioteca(), mensaje, "Acerca de la Biblioteca", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Método para agregar un libro
    public void agregarLibro(ActionEvent event) {
        
        String titulo, editorial;
        int edicion, anio;
        
        titulo = this.obtenerTitulo();
        if(titulo == null) {
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Registro cancelado");
            return;
        }
        
        edicion = this.obtenerEdicion();
        if(edicion == 0) {
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Registro cancelado");
            return;
        }
        editorial = this.obtenerEditorial();
        if(editorial == null) {
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Registro cancelado");
            return;
        }
        anio = this.obtenerAnio();
        if(anio == 0){
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Registro cancelado");
            return;
        }
        
        Libro nuevoLibro = new Libro(titulo, edicion, editorial, anio);        
        if(this.getBiblioteca().agregarLibro(nuevoLibro)) {
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Libro agregado correctamente");
        } else {
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "No se pudo agregar el libro");
        }
        // Actualizar la vista
        verLibros(null);
    } 
    
    private void buscarQuienTiene(ActionEvent event) {
        String titulo = this.obtenerTituloLibro();
        Libro libroBuscado = this.buscarLibroPorTitulo(titulo);

        if (libroBuscado != null) {
            try {
                String resultado = this.getBiblioteca().quienTieneElLibro(libroBuscado);
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "El libro está prestado a: " + resultado);
            } catch (LibroNoPrestadoException e) {
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(), e.getMessage());
            }
        } else {
            if(!titulo.equals("obtenerTituloLibro-cancelado")){
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "El libro no se encuentra en la biblioteca.");
            }
        }
    }
    
    public String obtenerTituloLibro() {
        String titulo = null;
        while (titulo == null) {
            // Solicitar al usuario el título del libro
            titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
            // Si el usuario cancela la entrada (el valor de titulo será null)
            if (titulo == null) {
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Búsqueda cancelada.");
                // Retornamos "obtenerTituloLibro-cancelado" para indicar que la operación fue cancelada
                return "obtenerTituloLibro-cancelado";  
            }
            // Verificación si el título está vacío o si es inválido según las reglas (aquí, por ejemplo, un método esTituloValido)
            if (titulo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(),
                        "El título ingresado no es válido. Por favor ingrese un título correcto.");
                titulo = null;  // Reiniciamos titulo para que el bucle lo pida de nuevo
            }
        }
        return titulo;  // Si todo está correcto, retornamos el título ingresado
    }
    
    //buscar un libro por titulo y devolver dicho titulo
    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : this.getBiblioteca().getLibros()) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }
    
    // Método para registrar un nuevo socio
    private void registrarSocio(ActionEvent event) {
        
        int dni = this.obtenerDniSocio();
        if(dni == 0) {
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Registro cancelado");
            return;  // Se cancela el registro si el DNI es inválido o el usuario cancela
        }else if(this.getBiblioteca().buscarSocio(dni) != null) {
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(),
                    "El socio ya se encuentra registrado\n por favor ingrese un nuevo socio.");
            dni = obtenerDniSocio();
        }
        
        String tipo = this.obtenerTipoSocio();
        if(tipo == null) {
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Registro cancelado");
            return;  // Se cancela el registro si el tipo es inválido o el usuario cancela
        }
        
        String nombre = this.obtenerNombreSocio();
        if(nombre == null) {
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Registro cancelado");
            return;  // Se cancela el registro si el nombre es inválido o el usuario cancela
        }
        
        int diasPrestamo = this.obtenerDiasPrestamo(tipo);
        if(diasPrestamo == 0) {
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Registro cancelado");
            return;  // Se cancela el registro si los días de préstamo son inválidos o el usuario cancela
        }
        
        // Según el tipo de socio, se procede a obtener la carrera (para estudiante) o área (para docente)
        if(tipo.equalsIgnoreCase("Estudiante")) {
            String carrera = obtenerCarreraEstudiante();
            if (carrera == null) {
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Registro cancelado");
                return;  // Se cancela el registro si la carrera es inválida o el usuario cancela
            }
            this.getBiblioteca().nuevoSocioEstudiante(dni, nombre, diasPrestamo, carrera);
        }else if(tipo.equalsIgnoreCase("Docente")) {
            String area = obtenerAreaDocente();
            if (area == null) {
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Registro cancelado");
                return;  // Se cancela el registro si el área es inválida o el usuario cancela
            }
            this.getBiblioteca().nuevoSocioDocente(dni, nombre, diasPrestamo, area);
        }
        JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Socio registrado correctamente");
        verSocios(null);  // Actualizar la vista
    }
    
    private String obtenerTitulo() {
        String titulo = null;
        boolean tituloExiste = false;
        while(titulo == null) {
            
            titulo = JOptionPane.showInputDialog("Ingrese el titulo del libro:");
            if(titulo ==  null || titulo.trim().isEmpty()) {
                return null;
            }
            for(Libro libros : this.getBiblioteca().getLibros()) {
                if(libros.getTitulo().equals(titulo)) {
                    JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "El libro ingresado ya existe");
                    tituloExiste = true;
                    break;
                }
            }
            //Reinicia el titulo para volver a ingresar, si es que existe.
            if(tituloExiste) {
                titulo = null;
            }
        }
        if(esNombreValidoConNumeros(titulo)){
            return titulo;
        }else{
            titulo = null;
        }
        return titulo;
    }
    
    private int obtenerEdicion() {
        String edicionStr = null;
        int edicion = 0;
        
        while(edicionStr == null) {
            
            edicionStr = JOptionPane.showInputDialog("Ingrese la edicion del libro:");
            if(edicionStr == null || edicionStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(),
                                        "No ingreso la edicion. Por favor ingrese una edicion para el libro.");
                edicionStr = null;
            }else if(sonNumerosValidos(edicionStr)) {
                edicion = Integer.parseInt(edicionStr);
            }else{
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(),
                                        "La edicion ingresada no es permitida, por favor ingresar numeros del 1-9.");
                edicionStr = null;
            }
        }
        return edicion;
    }
        
    private String obtenerEditorial() {
        String editorial = null;
        
        while(editorial == null) {
            editorial = JOptionPane.showInputDialog("Ingrese la editorial del libro:");
            if(editorial == null || editorial.trim().isEmpty()){
                return null;
            }else if(!esNombreValidoConNumeros(editorial)) {
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(),
                    "La editorial ingresada no es valida, ingrese de nuevo.");
                editorial = null;
            }
        }
        return editorial;
    }
    
    private int obtenerAnio() {
        int anio = 0;
        String anioStr = null;
        
        while(anioStr == null) {
            anioStr = JOptionPane.showInputDialog("Ingrese el año de publicacion del libro:");
            if(anioStr == null || anioStr.trim().isEmpty()){
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(),
                    "No ingresó el año. Por favor ingrese un año para el libro.");
                anioStr = null;
            }else if(!sonNumerosValidos(anioStr) || Integer.parseInt(anioStr) <= 0){
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(),
                        "Los numeros ingresados no son permitidos. Ingrese solo números positivos.");
                anioStr = null;
            }else{
                anio = Integer.parseInt(anioStr);
            }
        }
        return anio;
    }
    // Método para obtener el tipo de socio
    private String obtenerTipoSocio() {
        String tipo = null;
        while (tipo == null) {
            tipo = JOptionPane.showInputDialog("Ingrese el tipo de socio (Estudiante/Docente):");
            if(tipo == null || tipo.trim().isEmpty()) {
                return null;  // Si el tipo es nulo o vacío, se cancela el registro
            }
            if (!tipo.equalsIgnoreCase("Estudiante") && !tipo.equalsIgnoreCase("Docente")) {
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Tipo de socio no válido.");
                tipo = null;  // Si el tipo no es válido, se pide nuevamente
            }
        }
        return tipo;  // Se asegura que tipo siempre tendrá un valor válido
    }
    // Método para obtener el nombre del socio
    private String obtenerNombreSocio() {
        String nombre = null;
        while (nombre == null) {
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del socio:");
            if (nombre == null) {
                return null;  // Si el nombre es nulo (usuario canceló), se cancela el registro
            }
            if (nombre.trim().isEmpty() || !esNombreValidoSinNumeros(nombre)) {
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "El nombre ingresado no es válido.");
                nombre = null;  // Si el nombre es vacío o inválido, se pide nuevamente
            }
        }
        return nombre;  // Se asegura que el nombre es válido
    }
    // Método para obtener el DNI del socio
    private int obtenerDniSocio() {
        int dni = 0;
        while (dni == 0) {
            String dniStr = JOptionPane.showInputDialog("Ingrese el DNI del socio sin puntos:");
            if (dniStr == null) {
                return 0;  // Si el DNI es nulo (usuario canceló), se cancela el registro
            }
            if (dniStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "El D.N.I de socio no puede estar vacío");
            } else if (dniStr.length() != 8) {
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "El D.N.I de socio no es válido, ingrese 8 dígitos");
            } else {
                try {
                    dni = Integer.parseInt(dniStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "El D.N.I debe contener solo números.");
                }
            }
        }
        return dni;  // Se asegura que el DNI es válido
    }
    // Método para obtener los días de préstamo
    private int obtenerDiasPrestamo(String tipo) {
        int diasPrestamo = 0;
        while (diasPrestamo == 0) {
            String diaPrestamoStr = JOptionPane.showInputDialog("Ingrese los días de préstamo:");
            if (diaPrestamoStr == null) {
                return 0;  // Si el usuario cancela, se cancela el registro
            }
            try {
                int diasIngreso = Integer.parseInt(diaPrestamoStr);
                if ((tipo.equalsIgnoreCase("Estudiante") && diasIngreso > 20) ||
                    (tipo.equalsIgnoreCase("Docente") && diasIngreso > 5)) {
                    JOptionPane.showMessageDialog(this.getVistaBiblioteca(), 
                        "El número ingresado es superior al permitido para un Estudiante o Docente.");
                } else {
                    diasPrestamo = diasIngreso;  // Si el número es válido, se guarda
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(), 
                    "Por favor, ingrese un número válido para los días de préstamo.");
            }
        }
        return diasPrestamo;  // Se asegura que los días de préstamo son válidos
    }
    // Método para obtener la carrera del estudiante
    private String obtenerCarreraEstudiante() {
        String carrera = null;
        while (carrera == null) {
            carrera = JOptionPane.showInputDialog("Ingrese la carrera del estudiante:");
            if (carrera == null) {
                return null;  // Si el usuario cancela, se cancela el registro
            }
            if (esNombreValidoSinNumeros(carrera)) {
                return carrera;  // Se asegura que la carrera es válida
            } else {
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "El nombre de la carrera ingresada es inválido.");
                carrera = null;  // Si la carrera es inválida, se pide nuevamente
            }
        }
        return carrera;  // Se asegura que la carrera es válida
    }
    // Método para obtener el área del docente
    private String obtenerAreaDocente() {
        String area = null;
        while (area == null) {
            area = JOptionPane.showInputDialog("Ingrese el área del docente:");
            if(area == null) {
                return null;  // Si el usuario cancela, se cancela el registro
            }
            if(esNombreValidoConNumeros(area)) {
                return area;  // Se asegura que el área es válida
            } else {
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "El nombre del área ingresada es inválido.");
                area = null;  // Si el área es inválida, se pide nuevamente
            }
        }
        return area;  // Se asegura que el área es válida
    }
    // Método para realizar un préstamo
    public void prestarLibro(ActionEvent event) {
        int DNI;
        DNI = this.obtenerDniSocio();
        if(DNI == 0) {
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Prestamo Cancelado");
            return;
        }

        Socio socio = this.getBiblioteca().buscarSocio(DNI);
        if(socio != null) {
            String titulo = JOptionPane.showInputDialog("Ingrese el titulo del libro:");
            if(titulo == null || titulo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Prestamo cancelado");
                return;
            }
            Libro libroAPrestar = null;
            for (Libro libro : this.getBiblioteca().getLibros()) {
                                    //equalsIgnoreCase ignora mayusculas/minusculas
                if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                    libroAPrestar = libro;
                    break;
                }
            }
            if(libroAPrestar != null) {
                Calendar fecha = Calendar.getInstance();
                if (this.getBiblioteca().prestarLibro(fecha, socio, libroAPrestar)) {
                    JOptionPane.showMessageDialog(this.getVistaBiblioteca(),
                                                "Préstamo realizado con éxito");
                } else {
                    JOptionPane.showMessageDialog(this.getVistaBiblioteca(),
                                                "El libro no está disponible para el préstamo");
                }
            } else {
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(),
                                                "El libro no se encuentra en la biblioteca");
            }
            // Actualizar la vista
            verPrestamos(null);
        } else {
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Socio no encontrado");
        }

    }
    
    public void devolverLibro(ActionEvent event){
        int DNI = obtenerDniSocio();
        if(DNI == 0) {
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Devolucion Cancelada");
            return;
        }

        Socio socio = this.getBiblioteca().buscarSocio(DNI);
        if(socio != null) {
            String titulo = JOptionPane.showInputDialog("Ingrese el titulo del libro:");
            if(titulo == null || titulo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Devolucion cancelada");
                return;
            }
            Libro libroADevolver = null;
            for (Libro libro : this.getBiblioteca().getLibros()) {
                                    //equalsIgnoreCase ignora mayusculas/minusculas
                if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                    libroADevolver = libro;
                    break;
                }
            }
            try{
                if(libroADevolver != null) {

                    if (this.getBiblioteca().devolverLibro(libroADevolver)) {
                        JOptionPane.showMessageDialog(this.getVistaBiblioteca(), 
                                                                        "Libro devuelto con éxito");
                    } else {
                        JOptionPane.showMessageDialog(this.getVistaBiblioteca(),
                                                                        "El libro no fue prestado a este socio");
                    }
                }else {
                JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "El libro no se encuentra en la biblioteca");
                }
            }catch(LibroNoPrestadoException e) {
                System.out.println(e);
            }
            // Actualizar la vista
            verPrestamos(null);
        } else {
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Socio no encontrado");
        }
    }
    
    private void eliminarSocio(ActionEvent event) {
        int dni = this.obtenerDniSocio();
        int opcion;
        if(dni == 0){
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Eliminar Socio Cancelado ");
            return; //Se cancela la eliminacion del socio si el DNI es invalido o el usuario cancela
        }else if(this.getBiblioteca().buscarSocio(dni) == null){
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "El socio no se encuentra registrado");
            dni = obtenerDniSocio();
        }
        Socio socio = this.getBiblioteca().buscarSocio(dni);
        opcion = JOptionPane.showConfirmDialog(this.getVistaBiblioteca(), socio.toString() + "\n Desea eliminarlo?");
        if(opcion == 1 || opcion == 2) {
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Eliminar Socio Cancelado");
        }else if(this.getBiblioteca().quitarSocio(socio)) {
            JOptionPane.showMessageDialog(this.getVistaBiblioteca(), "Socio Eliminado");
        }  
        verSocios(null);
    }
    
    public String listarPrestamos(Biblioteca p_biblioteca) {
        // Obtener los socios de la biblioteca
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        StringBuilder listaDePrestamos = new StringBuilder();
        
        listaDePrestamos.append("Prestamos:\n");
        // Recorrer cada socio
        for(Socio socio : p_biblioteca.getSocios()) {
            prestamos.addAll(socio.getPrestamos());
        }
        for(Prestamo prestamo : prestamos){
            // Si el socio tiene préstamos, agregarlos a la lista
            if (prestamos != null && !prestamos.isEmpty()) {
                
                // Verificar que el préstamo tenga tanto un libro como un socio
                if (prestamo.getLibro() != null && prestamo.getSocio() != null) {
                    listaDePrestamos.append(prestamo.toString()).append("\n");
                } else {
                    listaDePrestamos.append("Prestamo incompleto (falta Libro o Socio)\n");
                }
            }
        }
        return listaDePrestamos.toString();
    }
    
    public void verPrestamosVencidos(ActionEvent event) {
        // Obtener los socios de la biblioteca
        ArrayList<Prestamo> prestamos = this.getBiblioteca().prestamosVencidos();
        StringBuilder listaDePrestamosVencidos = new StringBuilder();
        
        listaDePrestamosVencidos.append("Prestamos Vencidos:\n");
        // Recorrer cada socio
        if(prestamos != null){
            for(Prestamo prestamo : prestamos) {
            // Si el socio tiene préstamos, agregarlos a la lista
            if (prestamo != null) {
                // Verificar que el préstamo tenga tanto un libro como un socio
                if (prestamo.getLibro() != null && prestamo.getSocio() != null) {
                    listaDePrestamosVencidos.append(prestamo.toString()).append("\n");
                }else {
                    listaDePrestamosVencidos.append("Prestamo incompleto (falta Libro o Socio)\n");
                }
            }
        }
    }
     this.getVistaBiblioteca().actualizarVista("Prestamos Vencidos", listaDePrestamosVencidos.toString());
    }
}