public class CuentaCorriente {
    

        private int nroCuenta;
        private double saldo;
        private double limiteDescrubierto;
        private Persona titular;
    
        public CuentaCorriente(int p_nroCuenta, Persona p_titular) {
            this.setNroCuenta(p_nroCuenta);
            this.setTitular(p_titular); 
            this.setlimiteDescrubierto(500);
            this.setSaldo(0);
    
        }
        public CuentaCorriente(int p_nroCuenta, Persona p_titular, double p_saldo) {
            this.setNroCuenta(p_nroCuenta);
            this.setTitular(p_titular);
            this.setSaldo(p_saldo);
            this.setlimiteDescrubierto(500);
        }
    
        //Accessor's (setter's)
        private void setNroCuenta(int p_nroCuenta) {
            this.nroCuenta = p_nroCuenta;
        }
    
        private void setTitular(Persona p_titular) {
            this.titular = p_titular;
        }
    
        private void setlimiteDescrubierto(double p_limite) {
            this.limiteDescrubierto = p_limite;
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
    
        public double getlimiteDescrubierto() {
            return this.limiteDescrubierto;
        }
        
        //Resto de metodos declarados en el UML.
        private boolean puedeExtraer(double p_importe) {
            if(p_importe < this.getSaldo() && this.getlimiteDescrubierto() > 0) {
                return true;
            }else{
                return false;
            }
        }
    
        private void extraccion(double p_importe) {
            if(puedeExtraer(p_importe)) {
    
                this.setSaldo(this.getSaldo() - p_importe);
                this.setlimiteDescrubierto(this.getlimiteDescrubierto() - 1);
    
            }
        }
    
        public void extraer(double p_importe) {
            if(this.puedeExtraer(p_importe)) {
                this.extraccion(p_importe);
            }else if(this.getSaldo() < p_importe){
                System.out.println("No se pudo extraer por saldo insuficiente");
            }else if(this.getlimiteDescrubierto() <= 0) {
                System.out.println("El importe de extraccion sobrepasa el límite de descubierto!");
            }
        }
    
        public void depositar(double p_importe) {
            this.setSaldo(this.getSaldo() + p_importe);
        }
    
        public void mostrar() {
            System.out.println("\t- Cuenta Corriente -");
            System.out.println("Nro. Cuenta: " + this.getNroCuenta() + " - Saldo: $" + this.getSaldo());
            System.out.println("Titular: " + this.getTitular().nomYApe());
            System.out.println("Descubierto: " + this.getlimiteDescrubierto());
        }
}
