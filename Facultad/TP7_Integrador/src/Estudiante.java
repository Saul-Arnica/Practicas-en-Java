 
/**
 * 
 * 
 * @author (Aquino Ruth) 
 * @version ()
 */
import java.util.Calendar;
import java.util.ArrayList;

@SuppressWarnings("all")

public class Estudiante extends Socio
{
  private String carrera;
  
   /**
     * Estudiante es el construcctor de la clase, asigna un valor a los atributos de manera segura con los setter's.
     * @param p_dni solicitamos por paso de parametros el DNI del Socio
     * @param p_nombre solicitamos por paso de parametros el Nombre del Socio
     * @param p_diasPrestamo solocitamos por paso de parametro la cntidad de dias que se le da el prestamo 
     * @param p_carrera solicitamos por paso de parametros la carrera del estudiante
     */
   public Estudiante(int p_dniSocio,String p_nombre,int p_diasPrestamo,String p_carrera){
      super(p_dniSocio,p_nombre,p_diasPrestamo);
      this.setCarrera(p_carrera);
  }
  /**
     * Estudiante es el construcctor de la clase, asigna un valor a los atributos de manera segura con los setter's.
     * @param p_dni solicitamos por paso de parametros el DNI del Socio
     * @param p_nombre solicitamos por paso de parametros el Nombre del Socio
     * @param p_diasPrestamo solocitamos por paso de parametro la cntidad de dias que se le da el prestamo 
     * @param p_carrera solicitamos por paso de parametros la carrera del estudiante
     * @param p_prestamos es el array de prestamos
     */
    public Estudiante(int p_dniSocio,String p_nombre,int p_diasPrestamo,ArrayList<Prestamo> p_prestamos,String p_carrera){
      super(p_dniSocio,p_nombre,p_diasPrestamo,p_prestamos);
      this.setCarrera(p_carrera);
  }
  //setter
  private void setCarrera(String p_carrera){
      this.carrera = p_carrera;
  }
  //getter
  public String getCarrera(){
      return this.carrera;
  }
  // se declara los metodos
  /**
   * un Estudiante solo puede pedir si no tiene mas de 3 libro en su poder y si no hay ninguna devolucion vencida
   */
    public boolean puedePedir(){
      if (this.cantLibrosPrestados() >=3 && !super.puedePedir()){
            return false;
        }
        return true;
  }
  
  /**
   * @reurn un String con la clase de Socio que es
   */
  public String soyDeLaClase(){
      return "Estudiante";
  }
  
}
