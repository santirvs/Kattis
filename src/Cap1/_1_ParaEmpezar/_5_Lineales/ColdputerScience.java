package Cap1._1_ParaEmpezar._5_Lineales;

import java.util.Locale;
import java.util.Scanner;

public class ColdputerScience {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int numCasos = scan.nextInt();
        int numDiasBajoCero = 0;

        for (int i=0; i<numCasos; i++) {
            int temp = scan.nextInt();
            if (temp < 0) {
                numDiasBajoCero++;
            }

        }
        System.out.println(numDiasBajoCero);

    }
}