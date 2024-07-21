package Cap1._1_ParaEmpezar._4_CasosDePruebaMultiplesYSeleccion;

import java.util.Locale;
import java.util.Scanner;

public class Oddities {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int numCasos = scan.nextInt();

        while (numCasos > 0) {
            int num = scan.nextInt();

            if (num%2 ==0 )
                System.out.println(num + " is even");
            else
                System.out.println(num + " is odd");

            numCasos--;
        }


    }
}