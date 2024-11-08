package Practico7Integrador;
/**
*Un socio docente no tiene límite
*en cuanto a la cantidad de libros prestados, pero solo puede pedir prestado un libro si no tiene alguna
*devolución vencida (superados los días de préstamos que tiene cada docente, desde la fecha de retiro).
*Inicialmente todos los docentes tienen 5 días de préstamo, pero si es responsable se le van agregando días de
*préstamo, individualmente.
 * @author (Aquino Ruth) 
 * @version ()
 */
import java.util.ArrayList;
import java.util.Calendar;
public class Docente extends Socio
{
  private String area;
  
   /**
     * Docente es el construcctor de la clase, asigna un valor a los atributos de manera segura con los setter's.
     * @param p_dni solicitamos por paso de parametros el DNI del Socio
     * @param p_nombre solicitamos por paso de parametros el Nombre del Socio
     * @param p_diasPrestamo solocitamos por paso de parametro la cntidad de dias que se le da el prestamo 
     * @param p_area solicitamos por paso de parametros 
     */
   public Docente(int p_dniSocio,String p_nombre,int p_diasPrestamo,String p_area){
      super(p_dniSocio,p_nombre,p_diasPrestamo);
      this.setArea(p_area);
  }
  /**
     * Docente es el construcctor de la clase, asigna un valor a los atributos de manera segura con los setter's.
     * @param p_dni solicitamos por paso de parametros el DNI del Socio
     * @param p_nombre solicitamos por paso de parametros el Nombre del Socio
     * @param p_diasPrestamo solocitamos por paso de parametro la cntidad de dias que se le da el prestamo 
     * @param p_area solicitamos por paso de parametros 
     * @param p_prstamos es el array de prestamos
     */
    public Docente(int p_dniSocio,String p_nombre,int p_diasPrestamo,ArrayList<Prestamo> p_prestamos,String p_area){
      super(p_dniSocio,p_nombre,p_diasPrestamo,p_prestamos);
      this.setArea(p_area);
  }
  //setter
  private void setArea(String p_area){
      this.area = p_area;
  }
  //getter
  public String getArea(){
      return this.area;
  }
  // se declara los metodos
  /***
   * sirve para saber si un docente es responsable(si no tiene alguna devolución vencida)
   * @return devuelve un boolean
   */public boolean esResponsable(){
       Calendar hoy = Calendar.getInstance();
       for (Prestamo prestamo : this.getPrestamos()) {
            if (prestamo.getFechaDevolucion() == null){ // si es prestamo activo
                if(prestamo.vencido(hoy)){
                    return false;
                }
            }else{ // prestamo pasado
                if(prestamo.vencido(prestamo.getFechaDevolucion())){
                    return false;
                }
            }
        }
        return true;
  }
  
  /***
   * si el docente es responsable se puede cambiar los dias de prestamo del los libros
   */
  public void cambiarDiasDePrestamo(int p_dia){
      if(this.esResponsable()){
          int masDias = this.getDiasPrestamo() + p_dia;
          this.setDiasPrestamo(masDias);
      }
  }
  
  /***
   * un Docente solo puede pedir si no tiene una devolucion vencida
   */
  public boolean puedePedir(){
      return super.puedePedir();
  }
  
  /**
   * @reurn un String con la clase de Socio que es
   */
  public String soyDeLaClase(){
      return "Docente";
  }
}
