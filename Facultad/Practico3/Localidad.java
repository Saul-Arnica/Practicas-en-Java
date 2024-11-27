public class Localidad {
    private String nombre;
    private String provincia;

    public Localidad(String p_nombre, String p_provincia) {
        this.setNombre(p_nombre);
        this.setProvincia(p_provincia);
    }
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    private void setProvincia(String p_provincia) {
        this.provincia = p_provincia;
    }

    public String getNombre() {
        return this.nombre;
    }
    public String getProvincia() {
        return this.provincia;
    }
    public String mostrar() {
        return "Localidad: " + this.getNombre() + "\t" + "Provincia: " + this.getProvincia();
    }

}
