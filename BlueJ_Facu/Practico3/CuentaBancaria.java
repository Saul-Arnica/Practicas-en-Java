/*
A bank needs to model the concept of a bank account, which has to allow deposits and withdrawals. The method 
depositar(p_importe) increases the current balance with the amount passed as a parameter. The method 
extraer(p_importe) decreases the current balance. Both methods return the resulting balance after the operation.


*/
public class CuentaBancaria {

    private int nroCuenta;
    private double saldo;
    private Persona titular;

    public CuentaBancaria(int p_nroCuenta, Persona p_titular) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
    }

    public CuentaBancaria(int p_nroCuenta, Persona p_titular, double p_saldo) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
    }
    //(Acsessor's) setter's

    private void setNroCuenta(int p_nroCuenta) {
        this.nroCuenta = p_nroCuenta;
    }

    private void setTitular(Persona p_titular) {
        this.titular = p_titular;
    }

    private void setSaldo(double p_saldo) {
        this.saldo = p_saldo;
    }

    //getter's

    public int getNroCuenta() {
        return this.nroCuenta;
    }

    public Persona getTitular() {
        return this.titular;
    }
    
    public double getSaldo() {
        return this.saldo;
    }

    //Resto de metodos propuestos en el UML.

    public double depositar(double p_importe) {
        this.setSaldo(this.getSaldo() + p_importe);
        return this.getSaldo();
    }
    public double extraer(double p_importe) {   
        this.setSaldo(this.getSaldo() - p_importe);
        return this.getSaldo();
    }
    public void mostrar() {
        System.out.println("\t- Cuenta Bancaria -");
        System.out.println("Titular: " + this.getTitular().nomYApe() + "  " + "(" + this.getTitular().edad() + ")");
        System.out.println("Saldo: " + this.getSaldo());
    }
    public String toString() {
        return this.getNroCuenta() + " " + this.getTitular().nomYApe() + " $" + this.getSaldo();
    }

}
