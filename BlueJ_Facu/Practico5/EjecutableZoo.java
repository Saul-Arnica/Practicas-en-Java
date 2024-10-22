package Practico5;

import java.util.*;

public class EjecutableZoo {
    public static void main(String[] args) {
        Calendar fecha = new GregorianCalendar();
        fecha.set(2001, 1, 9);

        Calendar fecha2 = new GregorianCalendar();
        fecha.set(2000, 10, 15);

        Calendar fecha3 = new GregorianCalendar();
        fecha.set(1902, 4, 15);

        Calendar fecha4 = new GregorianCalendar();
        fecha.set(2024, 10, 20);

        Persona persona1 = new Persona(43205368, "Saul", "Arnica", fecha);
        Persona persona2 = new Persona(43063333, "Sergio", "Navarro", fecha2);
        Persona persona3 = new Persona(22807239, "Metini", "Abandonado", fecha3);

        Individuo individuo1 = new Individuo(fecha4, persona1);
        Individuo individuo2 = new Individuo(fecha4, persona2);
        Individuo individuo3 = new Individuo(fecha4, persona3);

        HashSet<Individuo> integrantes = new HashSet<>();
        integrantes.add(individuo1);
        integrantes.add(individuo2);

        Delegacion delegacion1 = new Delegacion("PAMI", fecha4, integrantes);

        ArrayList<Visitante> visitantes = new ArrayList<>();
        visitantes.add(delegacion1);
        visitantes.add(individuo3);
        Zoologico ZooCts = new Zoologico("El Caribu", visitantes);

        
        ZooCts.listarTipoVisitantePorFecha(fecha4, "Delegacion");
        ZooCts.listarTipoVisitantePorFecha(fecha4, "Individuo");
        ZooCts.listarVisitantePorFecha(fecha4);
        for(Persona p: ZooCts.listarPersonasQueVisitaronElZoo()) {
            p.mostrar();
        }
        System.out.println("La recaudacion total desde fecha 3 hasta fecha 4 es de:" + ZooCts.recaudacion(fecha3, fecha4));
        System.out.println("La recaudacion total desde fecha hasta fecha 2 es de:" + ZooCts.recaudacion(fecha, fecha2));
        
























    }
}
