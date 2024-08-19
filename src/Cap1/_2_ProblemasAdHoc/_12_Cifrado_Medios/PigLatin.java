package Cap1._2_ProblemasAdHoc._12_Cifrado_Medios;

import java.util.Locale;
import java.util.Scanner;

public class PigLatin {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer los datos
        while (scan.hasNext()) {
            String mensaje = scan.nextLine();
            String[] palabras = mensaje.split(" ");
            for (int i = 0; i < palabras.length; i++) {
                if (i>0) System.out.print(" ");
                String palabra = palabras[i];
                if (palabra.matches("[aeiouyYAEIOU].*")) {
                    System.out.print(palabra + "yay");
                } else {
                    int j = 0;
                    while (j < palabra.length() && !palabra.substring(j, j + 1).matches("[aeiouyYAEIOU]")) {
                        j++;
                    }
                    System.out.print(palabra.substring(j) + palabra.substring(0, j) + "ay");
                }
            }
            System.out.println();
        }


    }
}


