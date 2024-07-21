package Cap1._1_ParaEmpezar._4_CasosDePruebaMultiplesYSeleccion;

import java.util.Locale;
import java.util.Scanner;

public class NumberFun {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int numCasos = scan.nextInt();

        while (numCasos > 0) {
            float num1 = scan.nextFloat();
            float num2 = scan.nextFloat();
            float result = scan.nextFloat();

            if (num1+num2 == result || num1*num2 == result || num1-num2 == result || num2-num1 == result || num1/num2 == result || num2/num1 == result)
                System.out.println("Possible");
            else
                System.out.println("Impossible");

            numCasos--;
        }




    }
}