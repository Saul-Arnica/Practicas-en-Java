/**
 * 
 */
package Practico5;

import java.util.*;

@SuppressWarnings("all")

public class Delegacion extends Visitante {
    
    private HashSet<Individuo> integrantes;

    public Delegacion(String p_nombre, Calendar p_fechaVisitante, HashSet<Individuo> p_integrantes) {
        super(p_nombre, p_fechaVisitante);
        this.setIntegrantes(p_integrantes);
    }

    //Accesor´s

    private void setIntegrantes(HashSet<Individuo> p_integrantes) {
        this.integrantes = p_integrantes;
    }

    public HashSet<Individuo> getIntegrantes() {
        return this.integrantes;
    }

    public String tipoVisitante() {
        return "Delegacion";
    }
    //Metodos agregar y quitar

    public void inscribirIndividuo(Individuo p_individuo) {
        this.getIntegrantes().add(p_individuo);
    }

    public boolean quitarIntegrante(Individuo p_individuo) {
        return this.getIntegrantes().remove(p_individuo);
    }

    public int cantidadIntegrantes() {
        //Forma 1
        int cantidad = 0;
        for(Individuo individuo : this.getIntegrantes()) {
            cantidad++;
        }
        return cantidad;
        //Forma 2:
        //cantidad = this.getIntegrantes().size();
        //return cantidad;
    }

    public double entrada() {
        //Forma 1
        //double totalEntrada = 0;
        //for(int i = 0; i < this.cantidadIntegrantes(); i++) {
            //totalEntrada += 10;
        //}
        //return totalEntrada - totalEntrada * 0.10;
        //Forma 2
        //double totalEntrada = this.cantidadIntegrantes() * 10;
        //return totalEntrada - totalEntrada * 0.10;
        //Forma 3
        double total = 0;
        for(Individuo i : this.getIntegrantes()) {
            total += i.entrada();
        }
        return total - total * 0.10;
    }

    public void listarPorFecha(Calendar p_fecha, String p_visitante) {
        for(Individuo individuo : this.getIntegrantes()) {
            if(p_fecha.equals(this.getfechaVisitante()) && p_visitante.equals(this.tipoVisitante())) {
                individuo.mostrar();
            }
        }
    }

    public HashSet<Persona> listarPersonas() {
        HashSet<Persona> personas = new HashSet<>();
        for(Individuo i: this.getIntegrantes()) {
            personas.add(i.getPersona());
        }
        return personas;
    }

    public void mostrar() {
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Delegacion: " + this.getNombre());
        System.out.println("Integrantes");
        for(Individuo i: this.getIntegrantes()) {
            i.mostrar();
            System.out.println("\n");
        }
        System.out.println("Cantidad de Integrantes: " + this.cantidadIntegrantes());
        System.out.println("--------------------------------------------------------------------------------------------------\n");

    }
}
