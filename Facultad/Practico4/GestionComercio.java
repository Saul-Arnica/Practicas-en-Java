import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
@SuppressWarnings("all")
public class GestionComercio {

    public static void main(String[] args) {
        // Crear el comercio
        Comercio comercio = new Comercio("Avanti SRL");

        // Crear algunos empleados
        Calendar fecha = new GregorianCalendar();
        fecha.set(0, 2024);
        fecha.set(1, 22);
        fecha.set(2, 9);
        Empleado empleado1 = new Empleado(30100623, "Gonzalez", "Juan", 102750.00, fecha);
        Empleado empleado2 = new Empleado(37045987, "Martinez", "Mercedes", 100719.00, fecha);
        Empleado empleado3 = new Empleado(32550096, "Gomez", "Virginia", 150120.00, fecha);

        // Alta de empleados
        comercio.altaEmpleado(empleado1);
        comercio.altaEmpleado(empleado2);
        comercio.altaEmpleado(empleado3);

        // Emitir nómina
        comercio.nomina();

        // Verificar las demás funcionalidades
        System.out.println("\nCantidad de empleados: " + comercio.cantidadDeEmpleados());
        System.out.println("¿Es empleado con CUIL 30100623?: " + comercio.esEmpleado(30100623));
        
        // Buscar empleado
        Empleado buscado = comercio.buscarEmpleado(37045987);
        if (buscado != null) {
            System.out.println("Empleado encontrado: " + buscado.getNombre() + " " + buscado.getApellido());
        } else {
            System.out.println("Empleado no encontrado.");
        }

        // Mostrar sueldo neto
        comercio.sueldoNeto(32550096);

        // Baja de un empleado
        Empleado dadoDeBaja = comercio.bajaEmpleado(30100623);
        System.out.println("\nEmpleado dado de baja: " + (dadoDeBaja != null ? dadoDeBaja.getNombre() : "No encontrado"));

        // Reemisión de la nómina
        System.out.println("\nReemisión de nómina después de la baja:");
        comercio.nomina();
    }
}

