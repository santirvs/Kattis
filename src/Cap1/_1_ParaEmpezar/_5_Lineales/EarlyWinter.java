package Cap1._1_ParaEmpezar._5_Lineales;

import java.util.Locale;
import java.util.Scanner;

public class EarlyWinter {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int numCasos = scan.nextInt();
        int dm = scan.nextInt();

        for (int i=0; i<numCasos; i++) {
            int k = scan.nextInt();
            if (k <= dm) {
                System.out.println("It hadn't snowed this early in " + i + " years!");
                return;
            }
        }
        System.out.println("It had never snowed this early!");

    }
}