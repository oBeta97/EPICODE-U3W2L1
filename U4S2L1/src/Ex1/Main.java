package Ex1;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++){
            Random r =new Random();
            numbers[i] = r.nextInt(10) + 1;
        }

        printArray(numbers);

        Scanner s = new Scanner(System.in);


        int index;
        while(true) {
            System.out.println("quale indice dell'array vuoi modificare?");
            try {
                index = Integer.parseInt(s.nextLine());
                if (index > numbers.length-1) {
                    System.out.println("indice troppo alto");
                    continue;
                }
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("valore non valido");
            }

        }

        System.out.println("valore selezionato:");
        System.out.println(numbers[index]);

        System.out.println(" ");
        while (true){
            System.out.println("Vuoi modificarne il valore? (y/n)");
            String yn = s.nextLine();
            if (!Objects.equals(yn, "y") && !yn.equals("n")){
                System.out.println("valore non valido!");
                continue;
            }

            if (yn.equals("n")) break;

            int newVal;
            while(true){
                System.out.println("Indica il nuovo valore");

                try {
                    newVal = Integer.parseInt(s.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("valore non valido");
                }

            }
            numbers[index] = newVal;
        }

        System.out.println(" ");
        System.out.println("Nuovi valori del array:");
        printArray(numbers);



    }

    private static void printArray(int[] arr){

        String res = "";

        for (int number : arr)
            res += number + " ";

        System.out.println(res);
    }
}