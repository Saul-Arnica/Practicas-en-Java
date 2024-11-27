package Practico5;

import java.util.*;

@SuppressWarnings("all")

/**
 * Clase donde resolvemos como llevar el registro de las entradas que vende un Zoologico.
 * 
 */
public class Zoologico {
    
    private String nombre;
    private ArrayList<Visitante> visitantes;
    /**
     * Constructor con cardinalidad de 1 a muchos 
     * @param p_nombre
     * @param p_visitantes
     */
    public Zoologico(String p_nombre, ArrayList <Visitante> p_visitantes) {
        this.setNombre(p_nombre);
        this.setVisitante(p_visitantes);
    }
    /**
     * Constructor con cardinalidad de 0 a 1
     * @param p_nombre
     * @param p_visitante
     */
    public Zoologico(String p_nombre, Visitante p_visitante) {
        this.setNombre(p_nombre);
        ArrayList<Visitante> listaVisitantes = new ArrayList<>();
        listaVisitantes.add(p_visitante);
        this.setVisitante(listaVisitantes);
    }
    /**
     * Constructor con cardinalidad de 0 a 0 (es decir, vacio)
     * @param p_nombre
     */
    public Zoologico(String p_nombre) {
        this.setNombre(p_nombre);
        this.setVisitante(new ArrayList<Visitante>());
    }

    //Accesor´s

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    private void setVisitante(ArrayList<Visitante> p_Visitantes) {
        this.visitantes = p_Visitantes;
    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<Visitante> getVisitante() {
        return this.visitantes;
    } 

    public void nuevoVisitante(Visitante p_visitante) {
        this.getVisitante().add(p_visitante);
    }
    public boolean quitarVisitante(Visitante p_visitante) {
        return this.getVisitante().remove(p_visitante);
    }

    public void listarTipoVisitantePorFecha(Calendar p_fecha, String p_tipoVisitante) {
        for(Visitante v: this.getVisitante()) {
            v.listarPorFecha(p_fecha, p_tipoVisitante);
        }
    }
    public void listarVisitantePorFecha(Calendar p_fecha) {
        for(Visitante v: this.getVisitante()) {
            if( v.getfechaVisitante().equals(p_fecha)) {
                v.mostrar();
            }
        }
    }

    public double recaudacion(Calendar p_fechaDesde, Calendar p_fechaHasta) {
        double recaudacionTotal = 0;

        for(Visitante v: this.getVisitante()) {
            if(v.getfechaVisitante().compareTo(p_fechaDesde) >= 0 && v.getfechaVisitante().compareTo(p_fechaHasta) <= 0) {
                recaudacionTotal += v.entrada();
            }
            
        }
        return recaudacionTotal;
    }

    public HashSet<Persona> listarPersonasQueVisitaronElZoo() {
        HashSet<Persona> personas = new HashSet<>();
        for(Visitante v: this.getVisitante()) {
            personas.addAll(v.listarPersonas());
        }
        return personas;
    }



}
