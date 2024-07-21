package Cap1._1_ParaEmpezar._5_Lineales;

import java.util.Locale;
import java.util.Scanner;

public class StandOnZanzibar {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int numCasos = scan.nextInt();
        while (numCasos > 0) {
            int numTortugasAnterior = scan.nextInt();
            int numTortugasImportadas = 0;
            int numTortugas = scan.nextInt();

            while (numTortugas > 0) {
                if (numTortugas > 2 * numTortugasAnterior) {
                    numTortugasImportadas += numTortugas - 2 * numTortugasAnterior;
                }
                numTortugasAnterior = numTortugas;
                numTortugas = scan.nextInt();
            }

            System.out.println(numTortugasImportadas);

            numCasos--;
        }

    }
}