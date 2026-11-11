package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class IntegerDivision {
    public static void main(String[] args) throws IOException {
        // Usamos BufferedReader y StringTokenizer para una lectura rápida de la entrada estándar,
        // muy útil en problemas de programación competitiva donde el volumen de datos puede ser grande.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        // Arreglo para almacenar los cocientes resultantes de dividir cada elemento entre K.
        // Usamos 'long' para evitar desbordamientos si los números son muy grandes.
        long[] quotients = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long a = Long.parseLong(st.nextToken());

            // En Java, la división entera '/' entre enteros no negativos trunca hacia abajo
            // (descarta la parte fraccionaria), lo cual coincide exactamente con el comportamiento
            // requerido por el problema.
            quotients[i] = a / k;
        }

        // ==========================================
        // PASO 1: Ordenar el arreglo de cocientes
        // ==========================================
        // Al ordenar los cocientes, todos los elementos que producen el mismo valor
        // quedarán ubicados en posiciones consecutivas dentro del arreglo.
        // Complejidad temporal: O(N log N)
        Arrays.sort(quotients);

        // ==========================================
        // PASO 2: Contar bloques consecutivos y calcular pares
        // ==========================================
        long totalPairs = 0;
        long count = 1; // 'count' lleva la frecuencia del cociente actual que estamos evaluando

        for (int i = 1; i < n; i++) {
            if (quotients[i] == quotients[i - 1]) {
                // Si el elemento actual es igual al anterior, forma parte del mismo bloque.
                count++;
            } else {
                // Si el elemento cambia, significa que el bloque anterior ha terminado.
                // Si el bloque tiene más de 1 elemento, calculamos cuántos pares se pueden formar:
                // Fórmula de combinaciones: c * (c - 1) / 2
                if (count > 1) {
                    totalPairs += (count * (count - 1)) / 2;
                }
                // Reiniciamos el contador para el nuevo cociente encontrado.
                count = 1;
            }
        }

        // Importante: Al salir del ciclo 'for', el último bloque procesado queda pendiente
        // de ser sumado al resultado total.
        if (count > 1) {
            totalPairs += (count * (count - 1)) / 2;
        }

        // ==========================================
        // PASO 3: Mostrar el resultado
        // ==========================================
        System.out.println(totalPairs);
    }
}