package Others.Easy.Puntuacion_2_0_a_2_9._2_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Multigram {
    public static void main(String[] args) throws Exception {
        // Usamos BufferedReader para una lectura veloz de la entrada
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        if (word == null) return;
        word = word.trim();

        int n = word.length();
        char[] chars = word.toCharArray();

        // El bloque raíz debe aparecer al menos 2 veces (raiz + anagrama)
        // Por lo tanto, la longitud máxima de la raíz es n / 2
        int maxL = n / 2;

        String shortestRoot = "-1";

        // Evaluamos longitudes L en orden ascendente para hallar la más corta
        for (int L = 1; L <= maxL; L++) {
            // Regla matemática 1: L debe ser divisor exacto de la longitud total
            if (n % L != 0) {
                continue;
            }

            // Paso A: Contar frecuencias del bloque patrón (la primera palabra de tamaño L)
            int[] patternCounts = new int[26];
            for (int i = 0; i < L; i++) {
                patternCounts[chars[i] - 'a']++;
            }

            // Paso B: Validar el resto de los bloques de tamaño L
            boolean isValidMultigram = true;

            // Empezamos desde el índice L (el segundo bloque) y saltamos de L en L
            for (int blockStart = L; blockStart < n; blockStart += L) {
                int[] currentCounts = new int[26];

                // Contar frecuencias del bloque actual
                for (int i = 0; i < L; i++) {
                    currentCounts[chars[blockStart + i] - 'a']++;
                }

                // Comparar el bloque actual con el bloque patrón
                if (!isAnagram(patternCounts, currentCounts)) {
                    isValidMultigram = false;
                    break; // Rompemos el bucle de bloques si uno falla
                }
            }

            // Si todos los bloques pasaron la prueba, encontramos la raíz más corta
            if (isValidMultigram) {
                shortestRoot = word.substring(0, L);
                break; // Rompemos el bucle principal porque buscamos la menor longitud
            }
        }

        // Imprimir el resultado obtenido
        System.out.println(shortestRoot);
    }

    /**
     * Compara si dos arreglos de frecuencias de tamaño 26 son idénticos.
     */
    private static boolean isAnagram(int[] pattern, int[] current) {
        for (int i = 0; i < 26; i++) {
            if (pattern[i] != current[i]) {
                return false;
            }
        }
        return true;
    }
}