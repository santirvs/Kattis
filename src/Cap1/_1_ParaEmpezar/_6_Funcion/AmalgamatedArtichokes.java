package Cap1._1_ParaEmpezar._6_Funcion;

import java.util.Locale;
import java.util.Scanner;

public class AmalgamatedArtichokes {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int p = scan.nextInt();
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();
        int n = scan.nextInt();
        double maxDif = 0;
        double maxVal = p * (Math.sin(a + b) + Math.cos(c + d) + 2);

        for (int k = 2; k <= n; k++) {
            double price = p * (Math.sin(a * k + b) + Math.cos(c * k + d) + 2);
            if (maxVal < price )
                maxVal = price;
            else //if (maxVal - price > maxDif) maxDif = maxVal - price;
                maxDif = Math.max(maxDif, maxVal - price);
        }

        System.out.println(maxDif);

    }
}
