package Cap1._1_ParaEmpezar._5_Lineales;

import java.util.Locale;
import java.util.Scanner;

public class Statistics {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int numCaso = 0;

        while (scan.hasNext()) {
            numCaso++;

            int nums = scan.nextInt();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i=0; i<nums; i++) {
                int num = scan.nextInt();
                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            int range = max - min;
            System.out.println("Case " + numCaso + ": " + min + " " + max + " " + range);

        }



    }
}