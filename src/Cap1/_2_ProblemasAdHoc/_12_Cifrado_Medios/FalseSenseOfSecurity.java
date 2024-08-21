package Cap1._2_ProblemasAdHoc._12_Cifrado_Medios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class FalseSenseOfSecurity {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Tabla de conversion código Morse
        String underscore = "..--";
        String comma = ".-.-";
        String period = "---.";
        String question = "----";
        ArrayList<String> morse = new ArrayList<>(Arrays.asList(
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--..", underscore, comma, period, question));
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_,.?";

        //Leer los datos
        while (scan.hasNext()) {
            String mensaje = scan.nextLine();

            //Convertir a código Morse
            String morseCode = "";
            String longitudes = "";
            for (int i = 0; i < mensaje.length(); i++) {
                char letra = mensaje.charAt(i);
                int pos = alfabeto.indexOf(letra);
                morseCode += morse.get(pos);
                longitudes = longitudes + morse.get(pos).length();
            }

            //Invertir la cadena de longitudes
            StringBuilder longitudesInvertidas = new StringBuilder(longitudes).reverse();

            //Decodificar el mensaje en base a la cadena de longitudes invertida
            int pos = 0;
            for (int i = 0; i < longitudesInvertidas.length(); i++) {
                int longitud = Integer.parseInt(longitudesInvertidas.substring(i, i + 1));
                String charMorse = morseCode.substring(pos, pos + longitud);
                int posMorse = morse.indexOf(charMorse);
                System.out.print(alfabeto.charAt(posMorse));
                pos += longitud;
            }
            System.out.println();

        }

    }
}


