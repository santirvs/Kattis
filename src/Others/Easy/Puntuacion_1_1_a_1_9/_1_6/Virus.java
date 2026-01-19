package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * v1 : Crear la expresión regular que incluya caracteres arbitrarios en el patrón
 *      ABC  ->  .*A.*B.*C.*
 *      Tener cuidado con el punto, que debe tratarse como un literal
 *      AB.C  --> .*A.*B.*\..*C.*
 */


import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Virus {

   public static String buildRegex(String pattern) {
        StringBuilder sb = new StringBuilder();
        sb.append(".*");
        for (char c : pattern.toCharArray()) {
            if (c == '.') {
                sb.append("\\.").append(".*");
            } else {
                sb.append(c).append(".*");
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //leer fichero
        String ficheroBuscado = sc.nextLine();
        String ficheroCandidato = sc.nextLine();

        String regex = buildRegex(ficheroBuscado);
        boolean posible = ficheroCandidato.matches(regex);

        if (posible)
            System.out.println("Ja");
        else
            System.out.println("Nej");

        sc.close();
    }
}

