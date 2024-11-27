public class Hospital {
    private String nombreHospital;
    private String nombreDirector;

    public Hospital(String p_nombreHospital, String p_nombreDirector) {
        this.setNombreHospital(p_nombreHospital);
        this.setNombreDirector(p_nombreDirector);
    }
    private void setNombreHospital(String p_nombreHospital) {
        this.nombreHospital = p_nombreHospital;
    }
    private void setNombreDirector(String p_nombreDirector) {
        this.nombreDirector = p_nombreDirector;
    }
    public String getNombreHospital() {
        return this.nombreHospital;
    }
    public String getNombreDirector() {
        return this.nombreDirector;
    }

    public void consultaDatosFiliatorios(Paciente p_paciente) {
        System.out.println("Hospital: " + this.getNombreHospital() + " Director: " + this.getNombreDirector());
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Paciente: " + p_paciente.getNombre() + "\tHistoria Clinica: " + p_paciente.getHistoria() + "\tDomicilio: " + p_paciente.getDomicilio());
        System.out.println("Localidad: " + p_paciente.getVive().getNombre() + "\tProvincia: " + p_paciente.getVive().getProvincia());
    }

}
