public class Autor {
    private String nombre;
    private String institucion;
    private String mail;

    public Autor(String p_nombre, String p_institucion, String p_mail) {
        setNombre(p_nombre);
        setInstitucion(p_institucion);
        setMail(p_mail);
    }
    public String getNombre() {
        return nombre;
    }
    public String getInstitucion() {
        return institucion;
    }
    public String getMail() {
        return mail;
    }
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    private void setInstitucion(String p_institucion) {
        this.institucion = p_institucion;
    }
    private void setMail(String p_mail) {
        this.mail = p_mail;
    }
    public void mostrar() {
        System.out.println("Autor: " + this.getNombre());
        System.out.println("Institucion: " + this.getInstitucion());
        System.out.println("Mail: " + this.getMail());
    }
}
