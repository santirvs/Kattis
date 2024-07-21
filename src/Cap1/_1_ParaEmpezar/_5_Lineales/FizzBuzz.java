package Cap1._1_ParaEmpezar._5_Lineales;

import java.util.Locale;
import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int X = scan.nextInt();
        int Y = scan.nextInt();
        int N = scan.nextInt();

        for (int i = 1; i <= N; i++) {
            if (i % X == 0 && i % Y == 0) {
                System.out.println("FizzBuzz");
            } else if (i % X == 0) {
                System.out.println("Fizz");
            } else if (i % Y == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }



    }
}