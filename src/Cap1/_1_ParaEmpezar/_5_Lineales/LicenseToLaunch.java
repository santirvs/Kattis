package Cap1._1_ParaEmpezar._5_Lineales;

import java.util.Locale;
import java.util.Scanner;

public class LicenseToLaunch {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int numDias = scan.nextInt();
        int menorBasura = Integer.MAX_VALUE;
        int diaMenorBasura = 0;

        for (int i = 0; i < numDias; i++) {
            int basura = scan.nextInt();
            if (basura < menorBasura) {
                menorBasura = basura;
                diaMenorBasura = i;
            }

        }

        System.out.println(diaMenorBasura);

    }
}