package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Kleptography {
    public static void main(String[] args) throws IOException {
        // Usamos BufferedReader para una lectura eficiente de la entrada estándar
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        if (line == null || line.trim().isEmpty()) {
            return;
        }

        StringTokenizer st = new StringTokenizer(line);
        int L = Integer.parseInt(st.nextToken()); // Longitud de la llave inicial / sufijo conocido
        int m = Integer.parseInt(st.nextToken()); // Longitud total del texto plano

        // Leemos la última parte del texto plano (los últimos L caracteres)
        String lastPlain = br.readLine().trim();
        // Leemos el texto cifrado completo
        String cipher = br.readLine().trim();

        // Arreglo para reconstruir el texto plano de tamaño 'm'
        char[] plaintext = new char[m];

        // PASO 1: Colocar los L caracteres conocidos al final del arreglo de texto plano.
        // Como 'lastPlain' contiene los últimos L caracteres, van desde la posición (m - L) hasta (m - 1).
        for (int i = 0; i < L; i++) {
            plaintext[m - L + i] = lastPlain.charAt(i);
        }

        // PASO 2: Descifrar hacia atrás (desde el penúltimo bloque hasta el principio).
        // Fórmula original de cifrado Autokey: C_i = (P_i + K_i) % 26
        // Donde K_i (la llave en la posición i) es igual a P_{i - L} (el texto plano desplazado L posiciones).
        // Por lo tanto: C_i = (P_i + P_{i - L}) % 26
        // Despejando para encontrar el carácter anterior P_{i - L}:
        // P_{i - L} = (C_i - P_i + 26) % 26

        for (int i = m - 1; i >= L; i--) {
            int cVal = cipher.charAt(i) - 'a';       // Valor numérico del carácter cifrado C_i (0-25)
            int pVal = plaintext[i] - 'a';           // Valor numérico del texto plano P_i que ya conocemos (0-25)

            // Calculamos el valor numérico del carácter anterior de la llave/texto plano (P_{i - L})
            int prevPVal = (cVal - pVal + 26) % 26;

            // Asignamos el carácter resultante a su posición correspondiente en el texto plano
            plaintext[i - L] = (char) ('a' + prevPVal);
        }

        // PASO 3: Imprimir el resultado final reconstruido
        System.out.println(new String(plaintext));
    }
}