public class CajaDeAhorro {

    private int nroCuenta;
    private double saldo;
    private int extraccionesPosibles;
    private Persona titular;

    public CajaDeAhorro(int p_nroCuenta, Persona p_titular) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular); 
        this.setExtraccionesPosibles(10);
        this.setSaldo(0);

    }
    public CajaDeAhorro(int p_nroCuenta, Persona p_titular, double p_saldo) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
        this.setExtraccionesPosibles(10);
    }

    //Accessor's (setter's)
    private void setNroCuenta(int p_nroCuenta) {
        this.nroCuenta = p_nroCuenta;
    }

    private void setTitular(Persona p_titular) {
        this.titular = p_titular;
    }

    private void setExtraccionesPosibles(int p_extraccionesPosibles) {
        this.extraccionesPosibles = p_extraccionesPosibles;
    }

    private void setSaldo(double p_saldo) {
        this.saldo = p_saldo;
    }

    //(getter's)
    public int getNroCuenta() {
        return this.nroCuenta;
    }

    public Persona getTitular() {
        return this.titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getExtraccionesPosibles() {
        return this.extraccionesPosibles;
    }
    
    //Resto de metodos declarados en el UML.
    private boolean puedeExtraer(double p_importe) {
        if(p_importe < this.getSaldo() && this.getExtraccionesPosibles() > 0) {
            return true;
        }else{
            return false;
        }
    }

    private void extraccion(double p_importe) {
        if(puedeExtraer(p_importe)) {

            this.setSaldo(this.getSaldo() - p_importe);
            this.setExtraccionesPosibles(this.getExtraccionesPosibles() - 1);

        }
    }

    public void extraer(double p_importe) {
        if(this.puedeExtraer(p_importe)) {
            this.extraccion(p_importe);
        }else if(this.getSaldo() < p_importe){
            System.out.println("No puede extraer mas que el saldo!");
        }else if(this.getExtraccionesPosibles() <= 0) {
            System.out.println("No tiene habilitadas mas extracciones!");
        }
    }

    public void depositar(double p_importe) {
        this.setSaldo(this.getSaldo() + p_importe);
    }

    public void mostrar() {
        System.out.println("\t- Caja de Ahorro -");
        System.out.println("Nro. Cuenta: " + this.getNroCuenta() + " - Saldo: $" + this.getSaldo());
        System.out.println("Titular: " + this.getTitular().nomYApe());
        System.out.println("Extracciones posibles: " + this.getExtraccionesPosibles());
    }
/*
Si la cuenta se instancia sin saldo, este tomará el valor 0. 
En todos los casos, la cantidad máxima de extracciones es 10. 
El método depositar(p_importe) sólo agrega el importe al saldo actual. 
El método extraer(p_importe)coordina la operación, de acuerdo a si se cumplen las condiciones de extracción, si no pudiera informará el motivo por el cual no se pudo extraer. 
El método puedeExtraer(p_importe) devuelve true si el importe a retirar no supera el saldo disponible y si aún no usó todas las extracciones posibles. 
El método extraccion(p_importe) es el que realiza efectivamente la extracción y descuenta 1 al número de extracciones posibles. 
Caja de Ahorro –
Nro. Cuenta: 2135 - Saldo: 155.25 
Titular: Juán Pérez 
Extracciones posibles: 10

*/

}
