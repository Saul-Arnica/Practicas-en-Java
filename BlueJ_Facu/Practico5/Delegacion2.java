package Practico5;

import java.util.*;


public class Delegacion2 extends Visitante {
    //Atritbuto
    private ArrayList<Individuo> integrantes;
    
    //Constructor
    /**
   * Constructor para objetos de la clase Delegacio.
   * 
   * @param p_nombre Parametro que representa el nombre del visitante (String).
   * @param p_fechaVisita Parametro que representa la fecha de visita.
   * @param p_integrantes Parametro que representa una lista de integrantes de tipo ArrayList<Individuo>.
   */
    public Delegacion2(String p_nombre, Calendar p_fechaVisita, ArrayList<Individuo> p_integrantes) {
        super(p_nombre, p_fechaVisita);
        this.setIntegrantes(p_integrantes);
    }
    
    //Setter
    private void setIntegrantes(ArrayList<Individuo> p_integrantes) {
        this.integrantes = p_integrantes;
    }
    
    //Getter
    public ArrayList<Individuo> getIntegrantes() {
        return this.integrantes;
    }
    
    //Métodos de agregar y quitar
    /**
     * Metodo que agrega un individuo a la delegacion,
     * @param p_individuo Representa el individuo a agregar (Objeto)
     */
    public void inscribirIndividuo(Individuo p_individuo) {
        //Verifico si existe el individuo en la delegacion
        boolean existeIntegrante = this.listarPersonas().contains(p_individuo.getPersona());
        
        //Si NO existe lo añado
        if (!existeIntegrante) {
            this.getIntegrantes().add(p_individuo);
        } else {
            //Sino imprimo por pantalla que ya existe en la delegación
            System.out.println("El individuo ya esta añadido a la delegación");
        }
    }
    
    /**
     * Metodo que elimina un individuo de la delegacion.
     * @return devuelve un valor logico.
     */
    public boolean quitarIntegrante(Individuo p_individuo) {
        return this.getIntegrantes().remove(p_individuo);
    }
    
    //Otros métodos
    /**
     * @return devuelve un String con el tipo de visitante "Delegacion"
     */
    public String tipoVisitante() {
        return "Delegación";
    }
    
    /**
     * @return devuelve la cantidad de integrantes de la delegacion (int)
     */
    public int cantidadIntegrantes() {
        return this.getIntegrantes().size();
    }
    
    
    /**
   * Imprime el nombre de la delegacion, una lista de los integrantes y la cantidad de integrantes.
   */
    public void mostrar() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Delegación: " + this.getNombre());
        System.out.println("Integrantes");
        for (Individuo unIndividuo: this.getIntegrantes()) {
            unIndividuo.mostrar();
        }
        System.out.println("\nCantidad de Integrantes: " + this.cantidadIntegrantes());
        System.out.println("--------------------------------------------------------------");
    }
    
    /**
   * @return El costo de la entrada de cada integrante con un descuento del 10%.
   */
    public double entrada() {
        float totalEntradas = this.cantidadIntegrantes() * 10;
        return totalEntradas - totalEntradas * 0.1;
    }
    
    /**
     * Metodo que lista los visitantes que asistieron en una determinada fecha.
   * @param p_fecha     La fecha del dia que se quiere saber quienes asistieron (Calendar).
   * @param p_visitante El tipo de visitante a consultar.
   */
    public void listarPorFecha(Calendar p_fecha, String p_visitante) {
        //verifico si fecha y tipo de visitante coinciden con lo pasado como parámetro
        if (this.getfechaVisitante() == p_fecha && this.tipoVisitante() == p_visitante) {
            this.mostrar();
        }
    }
    
    /**
     * @return devuelve una lista con los integrantes de la delegacion del tipo
     * HashSet<Persona>.
     */
    public HashSet<Persona> listarPersonas() {
        HashSet<Persona> personas = new HashSet<>();
        for (Individuo unIndividuo: this.getIntegrantes()) {
            personas.add(unIndividuo.getPersona());
        }
        return personas;
    }
}