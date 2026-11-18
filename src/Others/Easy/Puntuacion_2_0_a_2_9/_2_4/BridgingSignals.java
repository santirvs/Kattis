package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class BridgingSignals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        if (line == null || line.trim().isEmpty()) {
            return;
        }

        // Leemos el número total de puertos
        int n = Integer.parseInt(line.trim());
        int[] signals = new int[n];

        // Leemos la secuencia de mapeo de puertos
        for (int i = 0; i < n; i++) {
            signals[i] = Integer.parseInt(reader.readLine().trim());
        }

        // Arreglo auxiliar 'tails' para implementar LIS en O(n log n).
        // tails[i] almacenará el valor final más pequeño de todas las subsecuencias
        // crecientes de longitud (i + 1) encontradas hasta el momento.
        int[] tails = new int[n];
        int length = 0; // Longitud de la subsecuencia creciente más larga (LIS) actual

        for (int i = 0; i < n; i++) {
            int x = signals[i];

            // Realizamos una búsqueda binaria en el arreglo 'tails' dentro del rango [0, length).
            // Arrays.binarySearch busca el elemento 'x' en el subarreglo especificado.
            int idx = Arrays.binarySearch(tails, 0, length, x);

            // Si el valor exacto no se encuentra, binarySearch devuelve:
            // (-(punto de inserción) - 1).
            // Despejamos el índice de inserción real: idx = -idx - 1
            if (idx < 0) {
                idx = -idx - 1;
            }

            // Actualizamos o insertamos el valor en la posición correspondiente
            tails[idx] = x;

            // Si el elemento fue insertado al final del rango actual de 'tails',
            // significa que hemos encontrado una subsecuencia estrictamente mayor,
            // por lo tanto, incrementamos la longitud máxima.
            if (idx == length) {
                length++;
            }
        }

        // La longitud final corresponde al número máximo de señales que no se cruzan
        System.out.println(length);
    }
}