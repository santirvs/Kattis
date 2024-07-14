package Easy;

import java.util.Locale;
import java.util.Scanner;

public class StuckInATimeLoop {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int n = scan.nextInt();
        for (int i=1; i<=n; i++) {
            System.out.println(i + " Abracadabra");
        }
    }
}