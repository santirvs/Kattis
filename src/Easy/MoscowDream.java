package Easy;

import java.util.Locale;
import java.util.Scanner;

public class MoscowDream {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        float result = 0.0f;
        for (int i=1; i<=n; i++) {
            float y = scan.nextFloat();
            float q = scan.nextFloat();
            result += y*q;
        }
        System.out.printf("%.3f",result);
    }
}