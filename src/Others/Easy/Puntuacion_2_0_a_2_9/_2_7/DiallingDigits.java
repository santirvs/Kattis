package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;

public class DiallingDigits {

    // Arreglo estático que funciona como mapeo del teclado telefónico.
    // Como las letras van de 'a' (índice 0) a 'z' (índice 25), podemos obtener
    // el dígito correspondiente restando el carácter 'a'.
    private static final char[] KEYPAD = {
            '2', '2', '2', // a, b, c -> 2
            '3', '3', '3', // d, e, f -> 3
            '4', '4', '4', // g, h, i -> 4
            '5', '5', '5', // j, k, l -> 5
            '6', '6', '6', // m, n, o -> 6
            '7', '7', '7', '7', // p, q, r, s -> 7
            '8', '8', '8', // t, u, v -> 8
            '9', '9', '9', '9'  // w, x, y, z -> 9
    };

    public static void main(String[] args) throws IOException {
        // Usamos BufferedReader y StringTokenizer para optimizar la lectura de datos de entrada masivos
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        if (line == null || line.trim().isEmpty()) {
            return;
        }

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken()); // Número de palabras
        int m = Integer.parseInt(st.nextToken()); // Número de números de teléfono a consultar

        // Estructura de datos clave: Un Mapa donde la clave es el número traducido (ej. "2272")
        // y el valor es una lista con las palabras originales asociadas.
        HashMap<String, ArrayList<String>> phoneToWords = new HashMap<String, ArrayList<String>>();

        // -------------------------------------------------------------------------
        // PASO 1: Procesar las N palabras del diccionario
        // -------------------------------------------------------------------------
        for (int i = 0; i < n; i++) {
            String word = br.readLine().trim();

            // Traducimos la palabra a su secuencia numérica del teléfono
            String translatedNumber = wordToNumber(word);

            // Obtenemos la lista asociada a ese número numérico
            ArrayList<String> wordList = phoneToWords.get(translatedNumber);

            // Si el número no existe todavía en el mapa, inicializamos la lista
            if (wordList == null) {
                wordList = new ArrayList<String>();
                phoneToWords.put(translatedNumber, wordList);
            }

            // Añadimos la palabra. Como la entrada ya viene ordenada alfabéticamente,
            // las palabras se insertarán en orden automáticamente.
            wordList.add(word);
        }

        // -------------------------------------------------------------------------
        // PASO 2: Procesar las M consultas de números de teléfono
        // -------------------------------------------------------------------------
        StringBuilder sb = new StringBuilder(); // Para acumular la salida y mejorar el rendimiento

        for (int i = 0; i < m; i++) {
            String phone = br.readLine().trim();

            // Buscamos directamente en el HashMap en tiempo O(1) promedio
            ArrayList<String> matches = phoneToWords.get(phone);

            if (matches == null || matches.isEmpty()) {
                // Si no hay coincidencias, imprimimos 0
                sb.append("0\n");
            } else {
                // Si hay coincidencias, imprimimos la cantidad de palabras
                sb.append(matches.size());

                // Y luego iteramos sobre las palabras (que ya están ordenadas alfabéticamente)
                for (int j = 0; j < matches.size(); j++) {
                    sb.append(" ").append(matches.get(j));
                }
                sb.append("\n");
            }
        }

        // Imprimir todo el resultado acumulado en consola de una sola vez
        System.out.print(sb.toString());
    }

    /**
     * Método auxiliar para convertir una palabra en su equivalente numérico telefónico.
     *
     * @param word La palabra en minúsculas (a-z).
     * @return El número de teléfono correspondiente como String.
     */
    private static String wordToNumber(String word) {
        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // Calculamos la posición en el arreglo KEYPAD restando el valor ASCII de 'a'
            int index = c - 'a';
            numberBuilder.append(KEYPAD[index]);
        }
        return numberBuilder.toString();
    }
}