/*
La fórmula Pi * r *s permite determinar la superficie de una elipse, donde r representa el semieje mayor y s al semieje 
menor, mientras que la superficie de un círculo está dada por Pi * r * r, o lo que es lo mismo Pi * r2
. Es decir que en 
el círculo r y s asumen el mismo valor, comúnmente llamado radio. Por lo
tanto el círculo es un caso especial de elipse.
Dado el siguiente diagrama de clases, implementar la solución teniendo 
en cuenta las clases Punto y Circulo definidas en las series anteriores. 
Tanto el círculo como la elipse deben poder desplazarse desde el punto 
actual a otra posición. Nótese que es necesario realizar una 
generalización.
Es necesario además agregar el método nombreFigura(), que retorna en 
cada caso:
****** Elipse ******
****** Circulo ******
El método caracteristicas() para la elipse tiene el siguiente formato:
****** Elipse ******
Centro: (5.0, 3.0) - Semieje Mayor: 20.44 - Semieje Menor: 46.86
Superficie: 3009.08 
*/

package Practico5;

import java.util.*;
@SuppressWarnings("all")
public class Elipse {
    private double sEjeMayor;
    private double sEjeMenor;
    private Punto centro;
    

    public Elipse(Punto p_centro, double p_sEjeMayor, double p_sEjeMenor) {
        this.setCentro(p_centro);
        this.setSEjeMayor(p_sEjeMayor);
        this.setSEjeMenor(p_sEjeMenor);
    }

    //Accesor's
    private void setCentro(Punto p_centro) {
        this.centro = p_centro;
    }
    private void setSEjeMayor(double p_sEjeMayor) {
        this.sEjeMayor = p_sEjeMayor;
    }
    private void setSEjeMenor(double p_sEjeMenor) {
        this.sEjeMenor = p_sEjeMenor;
    }

    public Punto getCentro() {
        return this.centro;
    }
    public double getSEjeMayor() {
        return this.sEjeMayor;
    }
    public double getSEjeMenor() {
        return this.sEjeMenor;
    }

    //Resto de metodos solicitidos

    public String nombreFigura() {
        return "****** Elipse ******";
    }

    public void caracteristicas() {
        System.out.println(nombreFigura());
        System.out.println("Centro:" + "(" + this.getCentro().getX() + " , " + this.getCentro().getY() + ") - ");
        System.out.println("Semieje Mayor:" + this.getSEjeMayor()+ "Semieje Menor:" + this.getSEjeMenor());
        System.out.println("\nSuperficie:" + this.superficie());
    }

    public double superficie() {
        return  Math.PI * this.getSEjeMayor() * this.getSEjeMenor(); 
    }

    public void desplazar(double p_dx, double p_dy) {
        this.getCentro().desplazar(p_dx, p_dy);
    }

    public double distaciaA(Elipse p_otraElipse) {
        return this.getCentro().distanciaA(p_otraElipse.getCentro());
    }

    public Elipse elMayor(Elipse p_otraElipse) {
        Elipse elMayor;
        if(p_otraElipse.superficie() > this.superficie()) {
            elMayor = p_otraElipse;
        }else{
            elMayor = this;
        }
        return elMayor;
    }



}