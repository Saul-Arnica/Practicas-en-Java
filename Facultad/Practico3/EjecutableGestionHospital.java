import java.util.*;
public class EjecutableGestionHospital {
    public static void main(String[] args) {

        Scanner ingreso = new Scanner(System.in);
        
        System.out.print("Ingrese le nombre del Hospital:");
        String nombreHospital = ingreso.nextLine();
        System.out.print("Ingrese el director del Hospital:");
        String nombreDirector = ingreso.nextLine();
        System.out.print("Ingrese el nombre del paciente:");
        String nombrePaciente = ingreso.nextLine();
        System.out.print("Ingrese el numero de Historia Clinica:");
        int historiaClinica = ingreso.nextInt();
        ingreso.nextLine(); //para evitar que el proximo ingreso se tome como salto de linea
        System.out.println("Ingrese el domicilio del paciente:");
        String domicilio = ingreso.nextLine();
        System.out.println("Ingrese el nombre de la localidad donde nacio:");
        String nombreLocalidadNacio = ingreso.nextLine();
        System.out.println("Ingrese el nombre de la provincia donde nacio:");
        String nombreProvinciaNacio = ingreso.nextLine();
        System.out.println("Ingrese el nombre de la localidad donde vive actualmente:");
        String nombreLocalidadVive = ingreso.nextLine();
        System.out.println("Ingrese el nombre de la provincia donde vive actualmente:");
        String nombreProvinciaVive = ingreso.nextLine();
        ingreso.close();
        Hospital hospi = new Hospital(nombreHospital, nombreDirector);
        Localidad localidadNacio = new Localidad(nombreLocalidadNacio, nombreProvinciaNacio);
        Localidad localidadVive = new Localidad(nombreLocalidadVive, nombreProvinciaVive);
        Paciente paciente1 = new Paciente(historiaClinica, nombrePaciente, domicilio, localidadNacio, localidadVive);

        hospi.consultaDatosFiliatorios(paciente1);

    }
}
