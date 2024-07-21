package Cap1._1_ParaEmpezar._5_Lineales;

import java.util.Locale;
import java.util.Scanner;

public class StarArrangements {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int numStars = scan.nextInt();
        System.out.println(numStars + ":");
        for (int i = 2; i < numStars; i++) {
            //El número de estrellas es divisible por (i + i-1), entonces se imprime i,i-1
            //o bien el módulo de numStars entre (i + i-1) es igual a i, entonces también se imprime i,i-1
            if (numStars % (i + i - 1) == 0 || numStars % (i + i - 1) == i) {
                System.out.println(i + "," + (i - 1));
            }
            // El número de estrellas es divisible por i, entonces se imprime i,i
            if (numStars % i == 0) {
                System.out.println(i + "," + i);
            }
        }

    }
}