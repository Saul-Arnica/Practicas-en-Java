package Practico5;

import java.util.*;

@SuppressWarnings("all")

public abstract class Visitante {
    private String nombre;
    private Calendar fechaVisitante;
    
    public Visitante(String p_nombre, Calendar p_fechaVisitante) {
        this.setNombre(p_nombre);
        this.setFechaVisitante(p_fechaVisitante);
    }

    //Accesor´s 

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setFechaVisitante(Calendar p_fechaVisitante) {
        this.fechaVisitante = p_fechaVisitante;
    }

    public String getNombre() {
        return this.nombre;
    }
    public Calendar getfechaVisitante() {
        return this.fechaVisitante;
    }

    public abstract void mostrar();
    public abstract double entrada();
    public abstract void listarPorFecha(Calendar p_fecha, String p_visitante);
    public abstract String tipoVisitante();
    public abstract HashSet<Persona> listarPersonas();


}
