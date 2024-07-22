package Cap1._1_ParaEmpezar._6_Funcion;

import java.util.Locale;
import java.util.Scanner;

public class Digits {

   public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        String num = scan.nextLine();
        while (!num.equals("END")) {
            int index = 0;
            if (num.equals("1")) {
                index = 1;
            }
            else {
                int numDigits = String.valueOf(num.length()).length();
                int numDigitsAnterior = num.length();
                index = 2;
                while (numDigitsAnterior != numDigits) {
                    numDigitsAnterior = numDigits;
                    num = String.valueOf(numDigits);
                    numDigits = num.length();
                    index++;
                }
            }
            System.out.println(index);
            num = scan.nextLine();
        }

    }
}
