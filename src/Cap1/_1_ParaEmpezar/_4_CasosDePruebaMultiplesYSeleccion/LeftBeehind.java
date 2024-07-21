package Cap1._1_ParaEmpezar._4_CasosDePruebaMultiplesYSeleccion;

import java.util.Locale;
import java.util.Scanner;

public class LeftBeehind {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int numDulce = scan.nextInt();
        int numAgria = scan.nextInt();

        while (numDulce != 0 || numAgria != 0) {
            if (numDulce + numAgria == 13)
                System.out.println("Never speak again.");
            else if (numDulce == numAgria)
                System.out.println("Undecided.");
            else if (numDulce > numAgria)
                System.out.println("To the convention.");
            else
                System.out.println("Left beehind.");

            numDulce = scan.nextInt();
            numAgria = scan.nextInt();
        }




    }
}