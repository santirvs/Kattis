package Others.Easy.Puntuacion_2_0_a_2_9._2_8;

import java.util.Scanner;

public class Alphabet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la cadena de entrada mientras haya datos (buena práctica para jueces en línea)
        String s = scanner.next();
        System.out.println(getMinInsertions(s));

        scanner.close();
    }

    public static int getMinInsertions(String s) {
        // dp[i] almacenará la longitud de la subsecuencia alfabética más larga
        // que termina en la i-ésima letra del alfabeto (0 = 'a', 1 = 'b', ..., 25 = 'z')
        int[] dp = new int[26];

        // Recorremos cada carácter de la cadena de entrada
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int charIdx = c - 'a'; // Convertir el carácter a un índice de 0 a 25

            // Buscamos la mejor subsecuencia previa válida.
            // Para que mantenga el orden alfabético, la letra anterior en nuestra
            // subsecuencia debe ser estrictamente menor en el alfabeto (índices de 0 a charIdx - 1).
            int maxPrev = 0;
            for (int j = 0; j < charIdx; j++) {
                if (dp[j] > maxPrev) {
                    maxPrev = dp[j];
                }
            }

            // Actualizamos el estado para la letra actual:
            // Es el máximo entre lo que ya teníamos para esta letra o extender la mejor secuencia previa.
            dp[charIdx] = Math.max(dp[charIdx], maxPrev + 1);
        }

        // Encontramos la subsecuencia alfabética más larga (LIS) en el array dp
        int maxLen = 0;
        for (int i = 0; i < 26; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
            }
        }

        // El resultado es el total de letras del alfabeto (26) menos las que ya tenemos en orden
        return 26 - maxLen;
    }
}