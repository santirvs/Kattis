package Others.Easy.Puntuacion_1_1_a_1_9._1_7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

public class MeltingSnow {

    public static void main(String[] args) throws IOException {
        // Fast I/O usando BufferedReader para lectura rápida de datos
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        if (line == null || line.trim().isEmpty()) {
            return;
        }

        StringTokenizer st = new StringTokenizer(line);
        double S = Double.parseDouble(st.nextToken()); // Nieve que cae cada día (en cm)
        double P = Double.parseDouble(st.nextToken()); // Porcentaje de nieve que se derrite (%)

        /* =========================================================================
         * PLANTEAMIENTO DETALLADO Y DEDUCCIÓN MATEMÁTICA:
         *
         * 1. Momento de Nieve Máxima:
         *    Dado que la nieve cae al PRINCIPIO del día y se derrite al FINAL, el pico
         *    máximo de nieve en el suelo ocurre justo después de caer la nieve fresca.
         *
         * 2. Fracción de Nieve Retenida:
         *    Si se derrite el P%, se conserva el (100 - P)%.
         *    Definimos la razón de retención como: R = 1 - (P / 100.0)
         *
         * 3. Evolución del Pico Diario:
         *    - Día 1 (al inicio): A_1 = S
         *    - Día 2 (al inicio): A_2 = S + S * R
         *    - Día 3 (al inicio): A_3 = S + S * R + S * R^2
         *    - Día n (al inicio): A_n = S * (1 + R + R^2 + ... + R^(n-1))
         *
         * 4. Convergencia del Proceso Infinito (Límite):
         *    Como el proceso continúa para siempre (n -> infinito) y P > 0 (por lo
         *    que R < 1), la serie geométrica infinita converge a:
         *
         *         MaxSnow = S / (1 - R)
         *
         *    Sustituyendo R = 1 - (P / 100.0):
         *
         *         MaxSnow = S / (1 - (1 - P / 100.0))
         *                 = S / (P / 100.0)
         *                 = (100.0 * S) / P
         * =========================================================================
         */

        double maxSnow = (100.0 * S) / P;

        // Imprimir con precisión decimal usando la configuración regional del Reino Unido (Locale.UK)
        // para garantizar el punto decimal (.) en lugar de comas (,) según los estándares del juez.
        System.out.printf(Locale.UK, "%.6f\n", maxSnow);
    }
}