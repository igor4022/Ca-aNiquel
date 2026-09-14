public class Saldo {
    protected double saldo = 100;
    protected double aposta;
    
    public void getSaldo(double saldo, double aposta) {
        saldo = this.saldo;
        aposta = this.aposta;
    }

    public double mostrarSaldo() {
        return saldo;
    }
}