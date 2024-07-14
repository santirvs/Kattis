package Easy;

import java.util.Scanner;
import java.util.Locale;

public class RoamingRomans {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        double n = scan.nextDouble();
        double result = n * 1000 * 5280 / 4854;

        System.out.println(Math.round(result));
    }
}