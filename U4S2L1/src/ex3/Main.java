package ex3;

import ex3.exceptions.BancaException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("inserisci il tuo nome:");
        String utente = s.nextLine();


        double saldo;
        while(true) {
            System.out.println("inserisci la liquidità che possiedi:");
            try {
                saldo = Double.parseDouble(s.nextLine());
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("valore non valido");
            }
        }

        double maxTrans;
        while(true) {
            System.out.println("quale limite di soldi vuoi prelevare:");
            try {
                maxTrans = Double.parseDouble(s.nextLine());
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("valore non valido");
            }
        }

        ContoCorrente cc = new ContoCorrente(utente, saldo);
        ContoOnLine col = new ContoOnLine(utente, saldo, maxTrans);

        System.out.println(" ");

        int tipoConto;
        while(true) {
            System.out.println("Vuoi giocare sul conto corrente (1) o sul conto online(2)?");
            try {
                tipoConto = Integer.parseInt(s.nextLine());
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("valore non valido");
            }
        }

        while (true){
            String willContinue = "n";

            if(tipoConto == 1 || tipoConto == 2){
                while(true){
                    System.out.println("Vuoi prelevare?(y/n)");
                    String p =  s.nextLine();

                    if (!p.equals("y") && !p.equals("n")) continue;
                    if (p.equals("n")) break;

                    double prelievo;
                    while(true) {
                        System.out.println("Quanto vuoi prelevare? (0 exit)");
                        try {
                            prelievo = Double.parseDouble(s.nextLine());
                            break;
                        }
                        catch (NumberFormatException e) {
                            System.out.println("valore non valido");
                        }
                    }
                    if (prelievo == 0) break;

                    try {
                        if (tipoConto == 1)
                            cc.preleva(prelievo);

                        if (tipoConto == 2)
                            col.preleva(prelievo);

                    } catch (BancaException e){
                        System.out.println(e.getMessage());
                        break;
                    }

                    while(true) {
                        System.out.println("Vuoi continuare? (y/n)");
                        willContinue = s.nextLine();

                        if (!p.equals("y") && !p.equals("n")) {
                            System.out.println("valore non valido");
                            continue;
                        };

                        break;
                    }

                }
            } else {
                System.out.println("Valore non valido");
            }

            System.out.println(cc);
            System.out.println(col);

            if (willContinue.equals("n")) break;
        }


    }
}
