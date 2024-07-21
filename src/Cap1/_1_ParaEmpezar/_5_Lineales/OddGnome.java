package Cap1._1_ParaEmpezar._5_Lineales;

import java.util.Locale;
import java.util.Scanner;

public class OddGnome {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        int numCasos = scan.nextInt();

        for (int i=0; i<numCasos; i++) {
            int numGnomos = scan.nextInt();
            int gnomoPenultimo = scan.nextInt();
            int gnomoUltimo = scan.nextInt();
            int gnomoRey = 0;

            for (int j=3; j<=numGnomos; j++) {
                int gnomoActual = scan.nextInt();

                //Caso normal: todos en orden
                if (gnomoPenultimo < gnomoUltimo && gnomoUltimo < gnomoActual) {
                    // No hacemos nada
                }
                else if (gnomoPenultimo < gnomoActual) {
                    //El rey es el último
                    gnomoRey = j-1;
                }

                gnomoPenultimo = gnomoUltimo;
                gnomoUltimo = gnomoActual;
            }

            System.out.println(gnomoRey);
        }

    }
}