package Cap1._1_ParaEmpezar._4_CasosDePruebaMultiplesYSeleccion;

import java.util.Locale;
import java.util.Scanner;

public class HelpAPhDCandidateOut {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int numCasos = scan.nextInt();

        while (numCasos > 0) {
            String caso = scan.next();

            if (caso.equals("P=NP"))
                System.out.println("skipped");
            else {
                String[] numeros = caso.split("\\+");
                System.out.println(Integer.parseInt(numeros[0]) + Integer.parseInt(numeros[1]));
            }

            numCasos--;
        }


    }
}