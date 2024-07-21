package Cap1._1_ParaEmpezar._5_Lineales;

import java.util.Locale;
import java.util.Scanner;

public class Thanos {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int numCasos = scan.nextInt();
        while (numCasos > 0) {
            //Aunque poblacion es menor de 10^9, al multiplicar por ratio puede superar 10^9
            //Por lo tanto, debe almacenarse en un long
            long poblacion = scan.nextLong();
            int ratio = scan.nextInt();
            int comida = scan.nextInt();
            int anyos = 0;

            while (poblacion <= comida) {
                poblacion *= ratio;
                anyos++;
            }

            System.out.println(anyos);
            numCasos--;
        }

    }
}