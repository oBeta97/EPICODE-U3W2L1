package Ex2;

import Ex2.Exeptions.LiterEqualsToZeroExeption;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner s = new Scanner(System.in);

        double km;
        while(true) {
            System.out.println("inserisci i km percorsi");
            try {
                km = Double.parseDouble(s.nextLine());
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("valore non valido");
            }

        }

        double lt;
        double kmlt;
        while(true) {
            while (true){
                System.out.println("inserisci i lt consumati");
                try {
                    lt = Double.parseDouble(s.nextLine());
                    if (lt == 0) throw new LiterEqualsToZeroExeption();
                    break;
                }
                catch (NumberFormatException e) {
                    System.out.println("il valore deve essere un numero!");
                }
                catch (LiterEqualsToZeroExeption e){
                    System.out.println(e.getMessage());
                }
            }

            try {
                kmlt = km / lt;
                break;
            }
            catch (ArithmeticException e){
                System.out.println("i litri non possono essere 0!");
            }
        }




        System.out.println("Km/l: " + kmlt);


    }
}