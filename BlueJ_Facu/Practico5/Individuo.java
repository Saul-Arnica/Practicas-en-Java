package Practico5;

import java.util.*;

@SuppressWarnings("all")

public class Individuo extends Visitante {

    private Persona persona;

    /**
     * Constructor
     * @param p_persona es el atributo propio de la clase.
     * @param p_fechaVisitante es el atributo heredado del padre Visitante.
     * @param p_nombre es el atributo heredado del padre Visitante.
     */
    public Individuo(Calendar p_fechaVisitante, Persona p_persona) {
        super(p_persona.apeYNom(), p_fechaVisitante);
        this.setPersona(p_persona);
    }

    //Accesor´s
    private void setPersona(Persona p_persona) {
        this.persona = p_persona;
    }

    public Persona getPersona() {
        return this.persona;
    }

    //Resto de metodos
    public String tipoVisitante() {
        return "Individuo";
    }
    /**
     * Aca verificamos que la fecha enviada es igual a la fecha del visitante
     * y si el individuo tiene el mismo nombre que el visitante
     * @param p_fecha
     * @param p_visitante
     *  
     */
    
    public void listarPorFecha(Calendar p_fecha, String p_visitante) {
        if(this.getfechaVisitante().equals(p_fecha) && this.tipoVisitante().equals(p_visitante)) {
            this.mostrar();
        }
    }
    /**
     * 
     */
    public HashSet<Persona> listarPersonas() {
        HashSet<Persona> personas = new HashSet<>();
        personas.add(this.getPersona());
        return personas;
    }
    /**
     * 
     */
    public double entrada() {
        return 10;
    }
    /**
     * 
     */
    public void mostrar() {
        //this.getPersona().mostrar();
        System.out.println("Nombre y Apellido: " + this.getPersona().nomYApe());
        System.out.println("DNI: " + this.getPersona().getDNI() + "Edad: " + this.getPersona().edad() + " años ");
        
    }
}

