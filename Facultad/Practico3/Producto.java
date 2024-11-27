
public class Producto {
    private int codigo;
    private String rubro;    
    private String descripcion;
    private double costo;
    private int stock;
    private double porcPtoRepo;
    private int existMinima;
    private Laboratorio laboratorio;
    //Constructor 
    public Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, double p_porcPtoRepo, int p_existMinima, Laboratorio p_lab) {
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setPorcPtoRepo(p_porcPtoRepo);
        this.setExisMinima(p_existMinima);
        this.setLaboratorio(p_lab);
        this.setStock(0);
    }
    //Constructor Sobrecargado
    public Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, Laboratorio p_lab) {
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setLaboratorio(p_lab);
        this.setStock(0);
    }
    //Aplicamos los Accessor's 
    //Setter's
    private void setCodigo(int p_codigo) {
        this.codigo = p_codigo;
    }
    private void setRubro(String p_rubro) {
        this.rubro = p_rubro;
    }
    private void setDescripcion(String p_desc) {
        this.descripcion = p_desc;
    }
    private void setCosto(double p_costo) {
        this.costo = p_costo;
    }
    private void setPorcPtoRepo(double p_porcPtoRepo) {  //Porcentaje de punto de reposicion
        this.porcPtoRepo = p_porcPtoRepo;
    }
    private void setExisMinima(int p_existMinima) {
        this.existMinima = p_existMinima;
    }
    private void setLaboratorio(Laboratorio p_lab) {
        this.laboratorio = p_lab;
    }
    private void setStock(int stockInicial) {
        this.stock = stockInicial;
    }
    //Getter's
    public int getCodigo() {
        return this.codigo;
    }
    public String getRubro() {
        return this.rubro;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public double getCosto() {
        return this.costo;
    }
    public double getPorcPuntoRepo() {
        return this.porcPtoRepo;
    }
    public int getExistenciaMin() {
        return this.existMinima;
    }
    public Laboratorio getLaboratorio() {
        return this.laboratorio; 
    }
    public int getStock() {
        return this.stock;
    }
    //Metodos establecidos en el UML.
    /**
     * Muestra
     */
    public void mostrar() {
        System.out.println("Laboratorio: " + this.getLaboratorio().getNombre());
        System.out.print("Domicilio: " + this.getLaboratorio().getDomicilio());
        System.out.println(" Telefono: " + this.getLaboratorio().getTelefono());
        System.out.println("Rubro: " + this.getRubro());
        System.out.println("Descripcion: " + this.getDescripcion());
        System.out.println("Precio Costo: " + this.getCosto());
        System.out.println("Stock: " + this.getStock() + " - " + "Stock Valorizado: " + this.stockValorizado());
    }
    /**
     * Agrega o quita productos del stock
     */
    public void ajuste(int p_cantidad) {
        this.setStock(this.getStock() + p_cantidad);
    }
    /**
     * 
     * @return el resultado de multiplicar el stock por el precio de cosyo mas una rentabilidad del 12%
     */
    public double stockValorizado() {
        double stockValorizado;
        stockValorizado = this.getStock() * this.getCosto() + (this.getStock() * this.getCosto() * 0.12);
        return stockValorizado;
    }
    /**
     * 
     * @return el resultado de agregar un 12% al precio de costo.
     */
    public double precioLista() {
        double precioLista, agregado;
        agregado = this.getCosto() * 0.12;
        precioLista = this.getCosto() + agregado;
        return precioLista;
    }
    /**
     * 
     * @return el precio de lista menos un 5%
     */
    public double precioContado() {
        double precioContado;
        precioContado = this.precioLista() - (this.precioLista() * 0.05);
        return precioContado; 
    }
    /**
     * 
     * @return una concatenacion de la descripcion del producto luego el precio de lista y por ultimo el precio de contado.
     */
    public String mostrarLinea() {
        return this.getDescripcion() + " $" + this.precioLista() + " $" + this.precioContado();
    } 
    /**
     * ajusta el porcentaje de punto de reposicion.
     */
    public void ajustarPtoRepo(double p_porce) {
        this.porcPtoRepo = p_porce;
    }
    /**
     * ajusta la existencia minima.
     */
    public void ajustarExistMin(int p_cantidad) {
        this.existMinima = p_cantidad;
    }
}
