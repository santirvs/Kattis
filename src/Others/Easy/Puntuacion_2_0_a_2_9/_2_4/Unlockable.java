package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class Unlockable {

    /**
     * Estructura de datos para representar una clave (p, q).
     * Sobrescribimos equals() y hashCode() para que el HashSet
     * pueda identificar y eliminar claves duplicadas correctamente.
     */
    static class KeyPair {
        long p;
        int q;

        KeyPair(long p, int q) {
            this.p = p;
            this.q = q;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            KeyPair keyPair = (KeyPair) o;
            return p == keyPair.p && q == keyPair.q;
        }

        @Override
        public int hashCode() {
            // Genera un código hash único combinando los bits de p y q
            int result = (int) (p ^ (p >>> 32));
            result = 31 * result + q;
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        // Lectura rápida con BufferedReader para manejar eficientemente grandes entradas (N = 200,000)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line == null || line.trim().isEmpty()) return;

        // Lectura de los valores N (número de candados) y M (entero común)
        StringTokenizer tokenizer = new StringTokenizer(line);
        int N = Integer.parseInt(tokenizer.nextToken());
        long M = Long.parseLong(tokenizer.nextToken());

        // Conjunto Hash para almacenar únicamente pares de claves (p, q) únicos
        Set<KeyPair> validKeys = new HashSet<>();

        line = reader.readLine();
        if (line != null) {
            tokenizer = new StringTokenizer(line);

            // Procesamos cada uno de los N candados
            for (int i = 0; i < N; i++) {
                long ai = Long.parseLong(tokenizer.nextToken());

                // Caso límite: si M = 1, la ecuación p * 1^q = ai implica p = ai.
                // Para evitar un bucle infinito de potencias de 1, añadimos directamente (ai, 1).
                if (M == 1) {
                    validKeys.add(new KeyPair(ai, 1));
                    continue;
                }

                // Inicializamos M_pow_q con M^1 (para q = 1)
                long M_pow_q = M;
                int q = 1;

                // Incrementamos q mientras M^q no supere el valor del candado a_i
                while (M_pow_q <= ai) {

                    // Condición principal: a_i debe ser exactamente divisible entre M^q
                    if (ai % M_pow_q == 0) {
                        long p = ai / M_pow_q;
                        validKeys.add(new KeyPair(p, q));
                    }

                    // Prevención de overflow (desbordamiento de tipo long) antes de calcular M^(q + 1):
                    // Si M_pow_q > ai / M, la siguiente multiplicación superaría ai.
                    if (M_pow_q > ai / M) break;

                    M_pow_q *= M;
                    q++;
                }
            }
        }

        // Imprimimos la cantidad total de parejas únicas de claves que abren al menos un candado
        System.out.println(validKeys.size());
    }
}