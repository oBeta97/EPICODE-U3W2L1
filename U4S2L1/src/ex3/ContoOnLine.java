package ex3;

import ex3.exceptions.BancaException;

public class ContoOnLine extends ContoCorrente {
    private double maxPrelievo;

    public ContoOnLine(String titolare, double saldo, double maxP) {
        super(titolare, saldo);
        this.maxPrelievo = maxP;
    }

    public void stampaSaldo() {
        System.out.println("Titolare: " + titolare + " - Saldo: " + saldo + " - Num movimenti: " + nMovimenti
                + " - Massimo movimenti: " + maxMovimenti + " - Massimo prelievo possibile: " + maxPrelievo);
    }

    @Override
    public void preleva(double x) throws BancaException {
        if (x >= maxPrelievo) throw new BancaException("il prelievo non è disponibile");

        super.preleva(x);
    }

    @Override
    public String toString() {
        return "ContoOnLine{" +
                "\n\tmaxPrelievo=" + maxPrelievo +
                "\n}";
    }
}
