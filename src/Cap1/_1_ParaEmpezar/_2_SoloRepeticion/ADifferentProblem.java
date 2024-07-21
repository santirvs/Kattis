package Cap1._1_ParaEmpezar._2_SoloRepeticion;

import java.util.Locale;
import java.util.Scanner;

public class ADifferentProblem {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        while (scan.hasNext()) {
            long n1 = scan.nextLong();
            long n2 = scan.nextLong();

            System.out.println(Math.abs(n1 - n2));
        }
    }
}