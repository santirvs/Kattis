package Cap1._1_ParaEmpezar._5_Lineales;

import java.util.Locale;
import java.util.Scanner;

public class Babybites {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int numCasos = scan.nextInt();
        boolean blnFishy = false;

        for (int i=1; i<=numCasos; i++) {
            String num= scan.next();
            if (num.equals("mumble")) {
                continue;
            }
            else {
                int n = Integer.parseInt(num);
                if (n != i)
                    blnFishy = true;
            }

        }
        if (blnFishy)
            System.out.println("something is fishy");
        else
            System.out.println("makes sense");

    }
}