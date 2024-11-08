import java.util.*;

public class Comercio {
    // Atributo privado
    private String nombre;

    // HashMap para almacenar los empleados, donde la clave es el CUIL (long) y el valor es un objeto Empleado
    private HashMap<Long, Empleado> empleados;

    // Constructor 1: Inicializa solo el nombre
    public Comercio(String p_nombre) {
        this.setNombre(p_nombre);
        this.setEmpleados(new HashMap<Long, Empleado>()); // Inicializa el HashMap vacío
    }

    // Constructor 2: Inicializa el nombre y el HashMap de empleados
    public Comercio(String p_nombre, HashMap<Long, Empleado> p_empleados) {
        this.setNombre(p_nombre);
        this.setEmpleados(p_empleados);
    }
    
    //Setter´s 
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setEmpleados(HashMap<Long, Empleado> p_empleados) {
        this.empleados = p_empleados;
    }

    //getter´s
    public String getNombre() {
        return this.nombre;
    }

    public HashMap<Long, Empleado> getEmpleados() {
        return this.empleados;
    }

    // Método para dar de alta a un empleado
    public void altaEmpleado(Empleado p_empleado) {
        this.empleados.put(p_empleado.getCuil(), p_empleado); // Usa el CUIL del empleado como clave
    }

    // Método para dar de baja a un empleado (eliminarlo del HashMap)
    public Empleado bajaEmpleado(long p_cuil) {
        return this.empleados.remove(p_cuil); // Elimina y devuelve al empleado eliminado
    }

    // Método para obtener la cantidad de empleados
    public int cantidadDeEmpleados() {
        return this.empleados.size(); // Devuelve el tamaño del HashMap
    }

    // Método para verificar si un CUIL pertenece a un empleado
    public boolean esEmpleado(long p_cuil) {
        return this.empleados.containsKey(p_cuil); // Verifica si existe la clave en el HashMap
    }

    // Método para buscar un empleado por su CUIL
    public Empleado buscarEmpleado(long p_cuil) {
        return this.empleados.get(p_cuil); // Devuelve el empleado asociado al CUIL
    }

    // Método para calcular el sueldo neto de un empleado (supongo que aquí deberías definir el cálculo)
    public void sueldoNeto(long p_cuil) {
        Empleado empleado = this.empleados.get(p_cuil);
        if (empleado != null) {
            System.out.println("El sueldo neto del empleado con CUIL " + p_cuil + " es: " + empleado.getSueldo());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    // Método para imprimir la nómina (lista de empleados)
    public void nomina() {
        System.out.println("Nómina de empleados del comercio " + this.nombre + ":");
        for (Empleado empleado : this.getEmpleados().values()) {
            System.out.println("CUIL: " + empleado.getCuil() + " - Nombre: " + empleado.getNombre());
        }
    }
}
