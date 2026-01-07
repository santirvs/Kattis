package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número de palabras
// Leer las palabras y comprobar si son "she", "he", "her", "him"
// contarlas y escribir la cantidad

import java.util.Locale;
import java.util.Scanner;


public class CultureShock {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer la cantidad de palabras
        int numPalabras = sc.nextInt();

        int numShocks = 0;
        while (numPalabras-- > 0) {
            String palabra = sc.next();
            if (palabra.equals("she") || palabra.equals("he") ||
                palabra.equals("her") || palabra.equals("him")) {
                numShocks++;
            }
        }

        System.out.println(numShocks);

        sc.close();
    }
}

