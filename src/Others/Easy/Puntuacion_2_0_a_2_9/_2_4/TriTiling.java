package Others.Easy.Puntuacion_2_0_a_2_9._2_4;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TriTiling {
    public static void main(String[] args) throws Exception {
        // Usamos BufferedReader para una lectura rápida y eficiente de la entrada
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // El tamaño máximo común para este problema es N = 30
        int maxN = 30;
        int[] dp = new int[maxN + 1];

        // --- CASOS BASE ---
        dp[0] = 1; // Un tablero vacío tiene exactamente 1 forma de ser llenado (no poner nada)
        // Los índices impares permanecen en 0 porque es imposible llenarlos
        if (maxN >= 2) {
            dp[2] = 3; // El caso inicial de 3x2 del enunciado tiene 3 combinaciones
        }

        // --- LLENADO DE LA TABLA DP (Solo índices pares) ---
        for (int i = 4; i <= maxN; i += 2) {
            dp[i] = 4 * dp[i - 2] - dp[i - 4];
        }

        // --- PROCESAMIENTO DE CASOS DE PRUEBA ---
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            int n = Integer.parseInt(line);

            // Condición de parada del problema
            if (n == -1) {
                break;
            }

            // Si N es impar o está fuera de rango, el resultado es 0.
            // De lo contrario, devolvemos el valor precalculado.
            if (n < 0 || n > maxN || n % 2 != 0) {
                System.out.println(0);
            } else {
                System.out.println(dp[n]);
            }
        }
    }
}