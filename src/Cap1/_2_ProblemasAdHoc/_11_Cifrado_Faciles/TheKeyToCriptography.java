package Cap1._2_ProblemasAdHoc._11_Cifrado_Faciles;

import java.util.Locale;
import java.util.Scanner;

public class TheKeyToCriptography {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de los datos del caso
        String encripted  = scan.nextLine();
        String key = scan.nextLine();
        String resultado = "";

        for (int i = 0; i < encripted.length(); i++) {
            char caracterDesencriptado = (char) ('A' + ((encripted.charAt(i) - 'A') - (key.charAt(i) - 'A') + 26) % 26);
            resultado += caracterDesencriptado;
            key += caracterDesencriptado;
        }

        //Mostrar el resultado
        System.out.println(resultado);

    }
}


