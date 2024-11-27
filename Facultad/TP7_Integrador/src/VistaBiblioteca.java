/**
 * Write a description of interface BibliotecaVista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class VistaBiblioteca extends JFrame {
    
    private ControladorArchivos control;
    private Biblioteca biblioteca;
    
    // Componentes de la interfaz
    private JPanel panelPrincipal;
    private JPanel panelLibros, panelSocios, panelPrestamos, panelPrestamosVencidos, panelNavegacion, panelEncabezado, panelInicio;
    private JTextArea areaLibros, areaSocios, areaPrestamos, areaPrestamosVencidos;
    private JButton btnAgregarLibro, btnQuienTieneElLibro, btnRegistrarSocio, btnEliminarSocio, btnPrestarLibro, btnDevolverLibro;
    private JButton btnVerLibros, btnVerSocios, btnVerPrestamos, btnVerPrestamosVencidos, btnIngresar;
    
    // Atributos del menú
    private JMenuBar barraMenu;
    private JMenu menuOpciones;
    private JMenuItem itemSalir;
    private JMenu menuAcercaDe;
    private JMenuItem itemCantSocios, itemDocentesResponsables;
    
    public VistaBiblioteca(Biblioteca p_biblioteca, ControladorArchivos p_control) {
        
        this.setBiblioteca(p_biblioteca);
        this.setControladorArchivos(p_control);
        
        // Configuración de la ventana
        this.configurarVentana();
        this.configurarJOptionPane();
        //this.crearPanelNavegacion();
        
        //Creamos el menu
        this.setMenu();
        // Crear el panel principal con CardLayout para cambiar entre vista
        this.crearPanelPrincipal();
        // Acción de navegación
        this.getBtnVerLibros().addActionListener(e -> mostrarVista("Libros"));
        this.getBtnVerSocios().addActionListener(e -> mostrarVista("Socios"));
        this.getBtnVerPrestamos().addActionListener(e -> mostrarVista("Prestamos"));
        this.getBtnVerPrestamosVencidos().addActionListener(e -> mostrarVista("Prestamos Vencidos"));
        this.getBtnIngresar().addActionListener(e -> mostrarVista("Libros"));
    }
    
    //setters - getters
    
    private void setControladorArchivos(ControladorArchivos p_control) {
        this.control = p_control;
    }
    
    public ControladorArchivos getControladorArchivos(){
        return this.control;
    }
    
    private void setBiblioteca(Biblioteca p_biblioteca){
        this.biblioteca = p_biblioteca;
    }
    
    public Biblioteca getBiblioteca(){
        return this.biblioteca;
    }
    
    private void salida() {
        this.getControladorArchivos().guardarSocios(this.getBiblioteca());
        this.getControladorArchivos().guardarLibros(this.getBiblioteca());
        this.getControladorArchivos().guardarPrestamos(this.getBiblioteca());
        System.exit(0);
    }
    
    private void salirYGuardar() {
        this.getControladorArchivos().guardarSocios(this.getBiblioteca());
        this.getControladorArchivos().guardarLibros(this.getBiblioteca());
        this.getControladorArchivos().guardarPrestamos(this.getBiblioteca());
    }
    
    //setters-getters de los paneles
    private void setPanelPrestamosVencidos(JPanel p_panelPrestamosVencidos) {
        this.panelPrestamosVencidos = p_panelPrestamosVencidos;
    }
    public JPanel getPanelPrestamosVencidos() {
        return this.panelPrestamosVencidos;
    }
    public JPanel getPanelPrincipal() {
        return this.panelPrincipal;
    }
    
    private void setPanelPrincipal(JPanel p_panelPrincipal) {
        this.panelPrincipal = p_panelPrincipal;
    }
    
    public JPanel getPanelLibros() {
        return this.panelLibros;
    }
    
    private void setPanelLibros(JPanel p_panelLibros) {
        this.panelLibros = p_panelLibros;
    }
    
    public JPanel getPanelSocios() {
        return this.panelSocios;
    }
    
    public void setPanelSocios(JPanel p_panelSocios) {
        this.panelSocios = p_panelSocios;
    }
    
    public JPanel getPanelPrestamos() {
        return this.panelPrestamos;
    }
    
    public void setPanelPrestamos(JPanel p_panelPrestamos) {
        this.panelPrestamos = p_panelPrestamos;
    }
    
    public JPanel getPanelNavegacion(){
        return this.panelNavegacion;
    }
    
    private void setPanelNavegacion(JPanel p_panelNavegacion) {
        this.panelNavegacion = p_panelNavegacion;
    }
    
    public JPanel getPanelEncabezado(){
        return this.panelEncabezado;
    }
    
    private void setPanelInicio(JPanel p_panelInicio) {
        this.panelInicio = p_panelInicio;
    }
    
    public JPanel getPanelInicio() {
        return this.panelInicio;
    }
    
    //setters-getters areas de texto
    public JTextArea getAreaLibros() {
        return this.areaLibros;
    }
    
    private void setAreaPrestamosVencidos(JTextArea p_areaPrestamosVencidos) {
        this.areaPrestamosVencidos = p_areaPrestamosVencidos; 
    }
    
    public JTextArea getAreaPrestamosVencidos() {
        return this.areaPrestamosVencidos;
    }
    
    public void setAreaLibros(JTextArea p_areaLibros) {
        this.areaLibros = p_areaLibros;
    }
    
    public JTextArea getAreaSocios() {
        return this.areaSocios;
    }
    
    public void setAreaSocios(JTextArea p_areaSocios) {
        this.areaSocios = p_areaSocios;
    }
    
    public JTextArea getAreaPrestamos() {
        return this.areaPrestamos;
    }
    
    public void setAreaPrestamos(JTextArea p_areaPrestamos) {
        this.areaPrestamos = p_areaPrestamos;
    }
    
    //setters-getters botones
    private void setBtnVerPrestamosVencidos(JButton p_BtnVerPrestamosVencidos) {
        this.btnVerPrestamosVencidos = p_BtnVerPrestamosVencidos;
    }
    
    public JButton getBtnVerPrestamosVencidos() {
        return this.btnVerPrestamosVencidos;
    }
    
    private void setBtnVerPrestamos(JButton p_BtnVerPrestamos) {
        this.btnVerPrestamos = p_BtnVerPrestamos;
    }
    
    public JButton getBtnVerPrestamos() {
        return this.btnVerPrestamos;
    }
    
    private void setBtnDevolverLibro(JButton p_BtnDevolverLibro) {
        this.btnDevolverLibro = p_BtnDevolverLibro;
    }
    
    public JButton getBtnDevolverLibro() {
        return this.btnDevolverLibro;
    }
    
    public JButton getBtnAgregarLibro() {
        return this.btnAgregarLibro;
    }
    
    public void setBtnAgregarLibro(JButton p_btnAgregarLibro) {
        this.btnAgregarLibro = p_btnAgregarLibro;
    }
    
    public JButton getBtnRegistrarSocio() {
        return this.btnRegistrarSocio;
    }
    
    public void setBtnRegistrarSocio(JButton p_btnRegistrarSocio) {
        this.btnRegistrarSocio = p_btnRegistrarSocio;
    }

    public void setBtnEliminarSocio(JButton p_btnEliminarSocio){
        this.btnEliminarSocio=p_btnEliminarSocio;
    }
    
    public JButton getBtnEliminarSocio(){
        return this.btnEliminarSocio;
    }

    public JButton getBtnPrestarLibro() {
        return this.btnPrestarLibro;
    }
    
    public void setBtnPrestarLibro(JButton p_btnPrestarLibro) {
        this.btnPrestarLibro = p_btnPrestarLibro;
    }
    
    public JButton getBtnVerLibros() {
        return this.btnVerLibros;
    }
    
    private void setBtnVerLibros(JButton p_btnVerLibros) {
        this.btnVerLibros = p_btnVerLibros;
    }
    
    public JButton getBtnVerSocios() {
        return this.btnVerSocios;
    }
    
    private void setBtnIngresar(JButton p_ingresar){
        this.btnIngresar = p_ingresar;
    }
    
    public JButton getBtnIngresar(){
        return this.btnIngresar;
    }
    
    public void setBtnVerSocios(JButton p_btnVerSocios) {
        this.btnVerSocios = p_btnVerSocios;
    }
    
    private void setBtnQuienTieneElLibro(JButton p_btn){
        this.btnQuienTieneElLibro = p_btn;
    }
    
    public JButton getBtnQuienTieneElLibro(){
        return this.btnQuienTieneElLibro;
    }
    
    //setters-getters componentes del menú
    public JMenuBar getBarraMenu() {
        return this.barraMenu;
    }
    
    public void setBarraMenu(JMenuBar p_menuBar) {
        this.barraMenu = p_menuBar;
    }
    
    public void setItemCantSocios(JMenuItem p_item) {
        this.itemCantSocios = p_item;
    }
    
    public JMenuItem getItemCantSocios() {
        return this.itemCantSocios;
    }
    
    private void setItemDocentesResponsables(JMenuItem p_item) {
        this.itemDocentesResponsables = p_item;
    }
    
    public JMenuItem getItemDocentesResponsables(){
        return this.itemDocentesResponsables;
    }
    
    public JMenu getMenuOpciones() {
        return this.menuOpciones;
    }
    
    public void setMenuOpciones(JMenu p_menuOpciones) {
        this.menuOpciones = p_menuOpciones;
    }
    
    public JMenuItem getItemSalir() {
        return this.itemSalir;
    }
    
    public void setItemSalir(JMenuItem p_itemSalir) {
        this.itemSalir = p_itemSalir;
    }
    
    public JMenu getMenuAcercaDe() {
        return this.menuAcercaDe;
    }
    
    public void setMenuAcercaDe(JMenu p_menuAcercaDe) {
        this.menuAcercaDe = p_menuAcercaDe;
    }
    
    private void configurarVentana() {
        setTitle("Gestión de Biblioteca");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //ACA DICE NO HACER NADA AL CIERRE! POR ESO...
        //Agregamos un WindowListener para capturar el evento de cierre.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                salirYGuardar();
                System.exit(0);
            }
        });
        setLayout(new BorderLayout());
    }
    
    private void configurarJOptionPane() {
        UIManager.put("OptionPane.background", new Color(31, 35, 35));
        UIManager.put("Panel.background", new Color(31, 35, 35));
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 14));
        JButton aceptar = new JButton();
        JButton cancelar = new JButton();
        this.estilizarBoton(aceptar);
        this.estilizarBoton(cancelar);
    }
    
    public void mostrarDocentesResponsables() {
        // Crear el panel para mostrar la lista de docentes
        JPanel panelDocentes = new JPanel(new BorderLayout());
        // Crear un área de texto para mostrar la lista
        JTextArea areaDocentes = new JTextArea(10, 30);
        JScrollPane scrollPanel = this.crearScrollPanel(areaDocentes);
        // Crear el texto que se mostrará (listar docentes)
        
    }
    
    private void setMenu() {
        // Crear la barra de menú
        this.setBarraMenu(new JMenuBar());
        this.getBarraMenu().setBackground(new Color(31, 35, 35)); // Fondo oscuro de la barra de menú
        this.getBarraMenu().setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        
        // Crear menú "Opciones"
        this.setMenuOpciones(new JMenu("Opciones"));
        this.estilizarMenu(this.getMenuOpciones()); // Estilizar menú "Opciones"
        this.setItemSalir(new JMenuItem("Salir"));
        this.estilizarMenuItem(this.getItemSalir()); // Estilizar el item de menú "Salir"
        this.getItemSalir().addActionListener(e -> salida()); // Acción para salir
        this.getMenuOpciones().add(this.getItemSalir());
    
        // Crear menú "Acerca de la biblioteca"
        this.setMenuAcercaDe(new JMenu("Acerca de la biblioteca"));
        this.estilizarMenu(this.getMenuAcercaDe()); // Estilizar menú "Acerca de"
        this.setItemCantSocios(new JMenuItem("Cantidad de socios"));
        this.estilizarMenuItem(this.getItemCantSocios()); // Estilizar item "Cantidad de socios"
        this.getMenuAcercaDe().add(this.getItemCantSocios());
        this.setItemDocentesResponsables(new JMenuItem("Docentes responsables"));
        this.estilizarMenuItem(this.getItemDocentesResponsables());
        this.getMenuAcercaDe().add(this.getItemDocentesResponsables());
        
        // Añadir los menús a la barra de menú
        this.getBarraMenu().add(this.getMenuOpciones());
        this.getBarraMenu().add(this.getMenuAcercaDe());
    
        // Establecer la barra de menú
        setJMenuBar(this.getBarraMenu());
    }
    
    // Estilizar el menú (JMenu)
    private void estilizarMenu(JMenu p_menu) {
        p_menu.setForeground(Color.WHITE);  // texto blanco
        p_menu.setBackground(new Color(31, 35, 35));  // Fondo oscuro para los menús
        p_menu.setBorder(new LineBorder(new Color(31, 35, 35)));
        p_menu.setFont(new Font("Arial", Font.BOLD, 13));  // Fuente y tamaño
        p_menu.setBorderPainted(false);
        p_menu.setOpaque(true); // Hacer el fondo opaco
    }
    
    // Estilizar los items de menú (JMenuItem)
    private void estilizarMenuItem(JMenuItem menuItem) {
        menuItem.setForeground(Color.WHITE);  // texto blanco
        menuItem.setBackground(new Color(31, 35, 35));  // Fondo oscuro para los menús
        menuItem.setBorder((BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        menuItem.setFont(new Font("Arial", Font.BOLD, 13));  // Fuente y tamaño
        menuItem.setBorderPainted(false);
        menuItem.setOpaque(true); // Hacer el fondo opaco
        // Eliminar borde por defecto
        menuItem.setFocusPainted(false);
        // Efecto al pasar el ratón sobre el item de menú
        menuItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                menuItem.setBackground(new Color(31, 35, 35));  // Fondo más claro al pasar el ratón
            }
    
            @Override
            public void mouseExited(MouseEvent e) {
                menuItem.setBackground(new Color(31, 35, 35));  // Fondo original cuando el ratón sale
            }
        });
    }
    
    private JLabel mensajeBienvenida() {
        JLabel labelBienvenida;
        labelBienvenida = new JLabel("¡Bienvenido a la Biblioteca " + this.getBiblioteca().getNombre() + "!",SwingConstants.CENTER);
        labelBienvenida.setFont(new Font("Arial", Font.BOLD, 18));
        labelBienvenida.setForeground(Color.WHITE);
        labelBienvenida.setPreferredSize(new Dimension(800, 40));
        return labelBienvenida;
    }
    
    private void crearPanelLibros() {
        
        this.setPanelLibros(new JPanel(new BorderLayout()));
        this.setAreaLibros(new JTextArea(10, 30));
        this.getAreaLibros().setBackground(new Color(28, 32, 32));
        this.getAreaLibros().setEditable(false);
        this.getAreaLibros().setText(this.getBiblioteca().listaDeLibros());
        JScrollPane scrollPanel = crearScrollPanel(this.getAreaLibros());
        // Añadir el JScrollPane al panel en la parte central (CENTER)
        this.getPanelLibros().add(scrollPanel, BorderLayout.CENTER);
        this.getPanelLibros().add(this.botonesPanelLibro(), BorderLayout.SOUTH);
        
    }
    
    private JPanel botonesPanelLibro() {

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(12, 12, 12));
        this.setBtnAgregarLibro(new JButton("Agregar Libro"));
        this.estilizarBoton(this.getBtnAgregarLibro());
        this.setBtnQuienTieneElLibro(new JButton("¿Quién tiene el libro?"));
        this.estilizarBoton(this.getBtnQuienTieneElLibro());
        panelBotones.add(this.getBtnAgregarLibro());
        panelBotones.add(this.getBtnQuienTieneElLibro());
        return panelBotones;
    }
    
    private void crearPanelSocios() {

        // Crear el panel de socios con un BorderLayout
        this.setPanelSocios(new JPanel(new BorderLayout()));
        
        // Crear el JTextArea con un tamaño
        this.setAreaSocios(new JTextArea(10, 30)); 
        this.getAreaSocios().setBackground(new Color(28, 32, 32));
        this.getAreaSocios().setEditable(false);
        this.getAreaSocios().setFont(new Font("Arial", Font.PLAIN, 12));
        this.getAreaSocios().setForeground(Color.WHITE);
        this.getAreaSocios().setText(this.getBiblioteca().listaDeSocios());
        // Crear un JScrollPane para contener el JTextArea
        JScrollPane scrollPanel = crearScrollPanel(this.getAreaSocios());
        // Añadir el JScrollPane al panel en la parte central (CENTER)
        this.getPanelSocios().add(scrollPanel, BorderLayout.CENTER);
        // Añadir el panel de botones al panel de socios en la parte sur (SOUTH)
        this.getPanelSocios().add(this.botonesPanelSocios(), BorderLayout.SOUTH);
    }
    
    private JScrollPane crearScrollPanel(JTextArea p_area) {
        JScrollPane scrollPanel = new JScrollPane(p_area);
        scrollPanel.setPreferredSize(new Dimension(150, 100));  // Ajustar el tamaño del JScrollPane
        p_area.setForeground(Color.WHITE);
        scrollPanel.setBackground(new Color(12, 12, 12));
        scrollPanel.setBorder(new LineBorder(new Color(28, 32, 32), 2, true));
        return scrollPanel;
    }
    
    private JPanel botonesPanelSocios() {
        JPanel panelBotones = new JPanel();  // Panel donde se colocarán los botones
        panelBotones.setBackground(new Color(12, 12, 12));
        // Crear y añadir los botones al panel de botones
        this.setBtnRegistrarSocio(new JButton("Registrar Socio"));
        this.estilizarBoton(this.getBtnRegistrarSocio());
        panelBotones.add(this.getBtnRegistrarSocio());
        this.setBtnEliminarSocio(new JButton("Eliminar Socio"));
        this.estilizarBoton(this.getBtnEliminarSocio());
        panelBotones.add(this.getBtnEliminarSocio());
        return panelBotones; // Devolvemos el panel con los botones
    }
    
    private void estilizarBoton(JButton boton) {
        
        boton.setPreferredSize(new Dimension(170, 45));
        boton.setBorder(null); // Borde simple
        // Fondo y color de texto
        boton.setBackground(new Color(28, 32, 32)); // Color de fondo
        boton.setForeground(Color.WHITE); // Color de texto blanco
        // Fuente
        boton.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente moderna y tamaño
        boton.setFocusPainted(false); // Elimina el borde de enfoque
        boton.setContentAreaFilled(true); // el área del botón se rellene con el color de fondo
        // Efecto cuando el ratón pasa sobre el botón
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(new Color(78, 91, 89)); // Color más claro al pasar el ratón
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(new Color(28, 32, 32)); // Color original cuando el ratón sale
            }
        });
    }
    
    private void crearPanelPrestamosVencidos() {
        //Prestamos Vencidos
        this.setPanelPrestamosVencidos(new JPanel(new BorderLayout()));
        this.setAreaPrestamosVencidos(new JTextArea(10, 30));
        this.getAreaPrestamosVencidos().setBackground(new Color(28, 32, 32));
        this.getAreaPrestamosVencidos().setEditable(false);
        this.getAreaPrestamosVencidos().setFont(new Font("Arial", Font.PLAIN, 12));
        this.getAreaPrestamosVencidos().setForeground(Color.WHITE);
        JScrollPane scrollPanelVencidos = crearScrollPanel(this.getAreaPrestamosVencidos());
        // Añadir el JScrollPane al panel en la parte central (CENTER)
        this.getPanelPrestamosVencidos().add(scrollPanelVencidos, BorderLayout.CENTER);
    
    }
       
        private void crearPanelPrestamos() {
        this.setPanelPrestamos(new JPanel(new BorderLayout()));
        // Crear JTextArea y JScrollPane para Préstamos Actuales
        this.setAreaPrestamos(new JTextArea(10, 30));
        this.getAreaPrestamos().setBackground(new Color(28, 32, 32));
        this.getAreaPrestamos().setEditable(false);
        this.getAreaPrestamos().setFont(new Font("Arial", Font.PLAIN, 12));
        this.getAreaPrestamos().setForeground(Color.WHITE);
        JScrollPane scrollPanelActuales = crearScrollPanel(this.getAreaPrestamos());
        this.getPanelPrestamos().add(scrollPanelActuales, BorderLayout.CENTER);
        // Añadir el panel de botones al panel de Préstamos en la parte inferior
        this.getPanelPrestamos().add(this.botonesPanelPrestamos(), BorderLayout.SOUTH);
    }
    private JPanel botonesPanelPrestamos() {

        JPanel panelBotones = new JPanel();// Panel donde se colocarán los botones
        panelBotones.setBackground(new Color(12,12,12));

        this.setBtnPrestarLibro(new JButton("Realizar Préstamo"));
        this.estilizarBoton(this.getBtnPrestarLibro());
        panelBotones.add(this.getBtnPrestarLibro());
        this.setBtnDevolverLibro(new JButton("Devolver Libro"));
        this.estilizarBoton(this.getBtnDevolverLibro());
        panelBotones.add(this.getBtnDevolverLibro());
        
        return panelBotones;

    }
    
    private void agregarPaneles(){

        this.getPanelPrincipal().add(this.getPanelInicio(), "Inicio");
        this.getPanelPrincipal().add(this.getPanelLibros(), "Libros");
        this.getPanelPrincipal().add(this.getPanelSocios(), "Socios");
        this.getPanelPrincipal().add(this.getPanelPrestamos(), "Prestamos");
        this.getPanelPrincipal().add(this.getPanelPrestamosVencidos(), "Prestamos Vencidos");
        
        add(this.getPanelPrincipal(), BorderLayout.CENTER);
        
    }
    
    private void crearPanelNavegacion() {

        this.setPanelNavegacion(new JPanel());
        this.getPanelNavegacion().setBackground(new Color(12, 12, 12));
        this.setBtnVerLibros(new JButton("Ver Libros"));
        this.estilizarBoton(this.getBtnVerLibros());
        this.setBtnVerSocios(new JButton("Ver Socios"));
        this.estilizarBoton(getBtnVerSocios());
        
        this.setBtnVerPrestamos(new JButton("Ver Prestamos"));
        this.estilizarBoton(this.getBtnVerPrestamos());
        
        this.setBtnVerPrestamosVencidos(new JButton("Ver Prestamos Vencidos"));
        this.estilizarBoton(this.getBtnVerPrestamosVencidos());
        
        this.getPanelNavegacion().add(this.getBtnVerLibros());
        this.getPanelNavegacion().add(this.getBtnVerSocios());
        this.getPanelNavegacion().add(this.getBtnVerPrestamos());
        this.getPanelNavegacion().add(this.getBtnVerPrestamosVencidos());
       

    }

    private void crearPanelInicio() {
        // Creamos el panel de inicio con BorderLayout para posicionar los componentes adecuadamente
        this.setPanelInicio(new JPanel(new BorderLayout()));
        // Crear el mensaje de bienvenida
        JLabel labelBienvenida = mensajeBienvenida(); // método para el mensaje
        labelBienvenida.setPreferredSize(new Dimension(800, 50)); //  tamaño del mensaje
        // Crear el botón de ingresar
        this.setBtnIngresar(new JButton("Ingresar"));
        this.estilizarBoton(this.getBtnIngresar()); //método de estilización de botones
        //solo el mensaje y el botón se muestren en el panel de inicio
        JPanel panelBoton = new JPanel(); // Panel para contener el botón
        panelBoton.setBackground(new Color(12, 12, 12)); // Fondo del panel
        panelBoton.add(this.getBtnIngresar()); // Añadir el botón al panel
        // Añadir los componentes al panel de inicio
        this.getPanelInicio().add(labelBienvenida, BorderLayout.NORTH); // Añadimos el mensaje en la parte superior
        this.getPanelInicio().add(panelBoton, BorderLayout.CENTER); // Añadimos el panel con el botón en el centro

    }
    
    private void crearPanelPrincipal() {
        this.crearPanelNavegacion();

        this.setPanelPrincipal(new JPanel(new CardLayout()));

        this.crearPanelInicio();
        // Panel de libros
        this.crearPanelLibros();
        // Panel de Socios
        this.crearPanelSocios();
        // Panel de Préstamos
        this.crearPanelPrestamos();
      
        this.crearPanelPrestamosVencidos();
        // Añadir los paneles al panel principal (CardLayout)
        this.agregarPaneles();        
        add(this.getPanelPrincipal(), BorderLayout.CENTER);
    }
    
    // Método para cambiar la vista activa
    public void mostrarVista(String p_vista) {
        CardLayout cl = (CardLayout)(this.getPanelPrincipal().getLayout());
        cl.show(this.getPanelPrincipal(), p_vista);
    }
    
    // Método para actualizar la vista de los paneles (Libros, Socios, Prestamos)
    public void actualizarVista(String tipo, String datos) {
        JTextArea area = null;
        
        // Según el tipo de vista, asignar el JTextArea correspondiente
        switch(tipo) {
            case "Libros":
                area = this.getAreaLibros();
                add(this.getPanelNavegacion(), BorderLayout.NORTH);
                break;
            case "Socios":
                area = this.getAreaSocios();
                add(this.getPanelNavegacion(), BorderLayout.NORTH);
                break;
            case "Prestamos":
                area = this.getAreaPrestamos();
                add(this.getPanelNavegacion(), BorderLayout.NORTH);
                break;
            case "Prestamos Vencidos":
                area = this.getAreaPrestamosVencidos();
                add(this.getPanelNavegacion(), BorderLayout.NORTH);
                break;
            case "Inicio":
                area = null;
                break;
        }
        if(area != null) {
            area.setText("");
            area.setText(datos); // Actualizar el área de texto con los datos proporcionados
        }
        // Mostrar el panel correspondiente usando el CardLayout
        CardLayout cl = (CardLayout) (this.getPanelPrincipal().getLayout());
        cl.show(this.getPanelPrincipal(), tipo); // Cambiar a la vista adecuada (Libros, Socios, Prestamos)
    }
}