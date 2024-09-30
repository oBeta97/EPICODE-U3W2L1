package ex3;

import ex3.exceptions.BancaException;

public class ContoCorrente {
    protected String titolare;
    protected int nMovimenti;
    protected final int maxMovimenti = 50;
    protected double saldo;

    public ContoCorrente(String titolare, double saldo) {
        this.titolare = titolare;
        this.saldo = saldo;
        this.nMovimenti = 0;
    }

    public void preleva(double x) throws BancaException {
        if (nMovimenti < maxMovimenti) saldo = saldo - x;
        else saldo = saldo - x - 0.50;

        if (saldo < 0) throw new BancaException("Il conto è in rosso!");

        nMovimenti++;
    }

    public double restituisciSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "ContoCorrente{" +
                "\n\ttitolare='" + titolare + '\'' +
                "\n\tnMovimenti=" + nMovimenti +
                "\n\tmaxMovimenti=" + maxMovimenti +
                "\n\tsaldo=" + saldo +
                "\n}";
    }
}