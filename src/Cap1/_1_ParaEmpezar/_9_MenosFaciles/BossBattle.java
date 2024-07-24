package Cap1._1_ParaEmpezar._9_MenosFaciles;

import java.util.Locale;
import java.util.Scanner;

public class BossBattle {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);
       scan.useLocale(Locale.ENGLISH);

       //Leer la cantidad de pilares
        int numPilares = scan.nextInt();

        //Si hay hasta 3 pilares, con una bomba es suficiente
        if (numPilares <= 3) {
            System.out.println(1);
        }
        //Si hay más de 3 pilares, necesitaré tantas bombas como pilares menos 2
        else {
            System.out.println(numPilares-2);
        }
    }
}
