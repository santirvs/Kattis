package Cap3._4_Voraz._1_Clasicos;

// Estrategia Voraz. Clásicos.

// Estrategia voraz.

/**
 * Kattis - messages
 *
 * Dada la cadena, determinamos la posición más a la izquierda desde donde podemos cortar
 * (desde el inicio de la cadena) de manera que la parte cortada contenga una palabra.
 * Observa que esta parte cortada terminará con dicha palabra.
 * Luego repetimos el proceso de manera codiciosa.
 *
 * Complejidad:
 * Tiempo: O(longitud de s * número de palabras * longitud máxima de palabra)
 * Memoria: O(longitud de s + número de palabras + longitud máxima de palabra)
 */

import java.util.*;

public class MessagesFromOuterSpace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> words = new ArrayList<>();

        // Leemos el diccionario de palabras
        while (true) {
            String s = sc.nextLine();
            if (s.equals("#")) break;
            words.add(s);
        }

        // Procesamos cada cadena de mensajes
        while (true) {
            StringBuilder sb = new StringBuilder();
            String line;
            // Leemos hasta que aparezca '|'
            while (!sb.toString().endsWith("|")) {
                line = sc.nextLine();
                if (line.equals("#")) return; // fin total
                sb.append(line);
            }

            String s = sb.toString();
            int numPalabras = 0;
            int inicio = 0;

            // Intentamos cortar desde inicio hasta i
            for (int i = 0; i < s.length(); i++) {
                //Comprobamos si la subcadena s[inicio..i] termina con alguna palabra del diccionario
                for (String word : words) {
                    if (s.substring(inicio, i + 1).endsWith(word)) {
                        //Si es así, incrementamos el punto del corte y el contador de palabras
                        numPalabras++;
                        inicio = i + 1;
                        break;
                    }
                }
            }

            // Imprimir el resultado
            System.out.println(numPalabras);
        }
    }
}
