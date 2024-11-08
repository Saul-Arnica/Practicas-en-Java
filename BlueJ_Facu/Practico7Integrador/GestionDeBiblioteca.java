package Practico7Integrador;

import java.util.*;
/**
 * Write a description of class GestionDeBiblioteca here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GestionDeBiblioteca{
    public static void main(String[] args){
        Libro libro = new Libro("POO", 2, "Juancito srl", 2010);
        Estudiante socio1 = new Estudiante(200, "Juancito", 3, "Ingenieria Agricola");
        Docente socio2 = new Docente(201, "Mettini", 5, "Programación");
        
        Calendar fecha1 = Calendar.getInstance();
        fecha1.set(2024, 10, 15);
        Calendar fecha2 = Calendar.getInstance();
        fecha2.set(2024, 11, 4);
        
        Prestamo prestamo1 = new Prestamo(fecha1, socio1, libro);
        Prestamo prestamo2 = new Prestamo(fecha2, socio2, libro);
        
        if(socio1.puedePedir()){
            try{
            libro.agregarPrestamo(prestamo1);
            socio1.agregarPrestamo(prestamo1);
            }catch(PrestamoInvalidoException e){
            System.out.println(e);
            }
        }
        
        if(socio2.puedePedir()){
            try{
            libro.agregarPrestamo(prestamo2);
            socio2.agregarPrestamo(prestamo2);
            }catch(PrestamoInvalidoException e){
            System.out.println(e);
            }
        }
        
        HashSet<Socio> socios = new HashSet<Socio>();
        socios.add(socio1);
        socios.add(socio2);
        
        Biblioteca biblio = new Biblioteca("Biblio Facena", socios, libro);
        
        System.out.println("Cantidad de docentes: " + biblio.cantidadDeSociosPorTipo("Docente"));
        System.out.println("Lista de titulos: " + biblio.listaDeTitulos());
        System.out.println("Lista de libros: " + biblio.listaDeLibros());
        System.out.println("Lista de socios: \n" + biblio.listaDeSocios());
        System.out.println("Lista de docentes responsables: \n" + biblio.listaDeDocentesResponsables());
        biblio.nuevoLibro("Mettini y la POO", 1, "Greiner EDITORIAL", 2023);
        System.out.println("Lista de titulos: " + biblio.listaDeTitulos());
        System.out.println("Lista de libros: " + biblio.listaDeLibros());
        biblio.prestarLibro(Calendar.getInstance(), socio2, biblio.getLibros().get(biblio.getLibros().size() - 1));
        System.out.println("Lista de libros: " + biblio.listaDeLibros());
        try{
            System.out.println(biblio.quienTieneElLibro(biblio.getLibros().get(biblio.getLibros().size() - 1)));
        }catch(LibroNoPrestadoException e){
            System.out.println(e);
        }
        try{
            biblio.devolverLibro(biblio.getLibros().get(biblio.getLibros().size() - 1));
        }catch(LibroNoPrestadoException e){
            System.out.println(e);
        }
        
        System.out.println("Lista de libros: " + biblio.listaDeLibros());
    }
}
