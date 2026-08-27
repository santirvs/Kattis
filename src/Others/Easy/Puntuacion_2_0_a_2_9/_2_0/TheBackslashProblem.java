package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * Escapar el texto deseado tantas veces como se pida
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TheBackslashProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            int numRepeticiones = sc.nextInt();
            sc.nextLine();

            String texto = sc.nextLine();
            for (int i=0; i<numRepeticiones;i++) {
                texto = escaparTexto(texto);
            }

            System.out.println(texto);

        }
    }

    private static String escaparTexto(String texto) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<texto.length(); i++) {
            char car = texto.charAt(i);
            if ( car >= '!' && car <= '*' || car >= '[' && car <= ']') {
                sb.append("\\"+car);
            } else {
                sb.append(car);
            }
        }

        return sb.toString();

    }
}