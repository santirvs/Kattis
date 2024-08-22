package Cap1._2_ProblemasAdHoc._14_FormatoSalida;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Skener {

     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer la entrada
        int filas = scan.nextInt();
        int columnas = scan.nextInt();
        int zoomY = scan.nextInt();
        int zoomX = scan.nextInt();
        scan.nextLine();

        //Imprimir la salida.
        for (int i=0; i<filas; i++) {
            String linea = scan.nextLine();
            char[] caracteres = linea.toCharArray();
            for (int j=0; j<zoomY; j++) {
                for (char c : caracteres) {
                    for (int k=0; k<zoomX; k++) {
                        System.out.print(c);
                    }
                }
                System.out.println();
            }
        }
    }
}


