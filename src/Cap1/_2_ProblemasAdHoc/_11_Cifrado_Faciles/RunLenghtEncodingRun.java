package Cap1._2_ProblemasAdHoc._11_Cifrado_Faciles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class RunLenghtEncodingRun {

    public static void decode(String mensaje) {
        for (int i = 0; i < mensaje.length(); i += 2) {
            int veces = mensaje.charAt(i+1)-'0';
            for (int j = 0; j < veces; j++) {
                System.out.print(mensaje.charAt(i));
            }
        }
        System.out.println("");
    }

    public static void encode(String mensaje) {
        for (int i=0; i < mensaje.length(); i++) {
            int cont = 1;
            while (i+1 < mensaje.length() && mensaje.charAt(i) == mensaje.charAt(i+1)) {
                cont++;
                i++;
            }
            System.out.print(mensaje.charAt(i) + "" + cont);
        }
        System.out.println();
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Leer los datos del caso
        String accion = scan.next();
        String mensaje = scan.next();

        if (accion.equals("D"))
            decode(mensaje);
        else
            encode(mensaje);

    }
}


