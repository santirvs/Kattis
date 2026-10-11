package Others.Easy.Puntuacion_2_0_a_2_9._2_7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class SpidermansWorkout {

    static int[] pasos;
    static int numPasos;
    static int[][] memo; // memo[paso][altura] almacena la altura máxima mínima requerida desde este estado
    static final int IMPOSSIBLE = 1000000; // Valor que representa un camino inválido o inalcanzable

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int numCasos = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();

        while (numCasos-- > 0) {
            numPasos = Integer.parseInt(br.readLine().trim());
            pasos = new int[numPasos];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sumaTotal = 0;
            for (int i = 0; i < numPasos; i++) {
                pasos[i] = Integer.parseInt(st.nextToken());
                sumaTotal += pasos[i];
            }

            // Inicializamos la tabla de memoización con -1 (no visitado)
            // Filas: número de pasos + 1
            // Columnas: suma total de distancias + 1 (altura máxima teórica posible)
            memo = new int[numPasos + 1][sumaTotal + 1];
            for (int i = 0; i <= numPasos; i++) {
                Arrays.fill(memo[i], -1);
            }

            // Paso 1: Encontrar el pico mínimo necesario empezando desde el paso 0 a la altura 0
            int minPeak = solve(0, 0);

            // Si el resultado es mayor o igual a IMPOSSIBLE, no hay solución legal
            if (minPeak >= IMPOSSIBLE) {
                sb.append("IMPOSSIBLE\n");
            } else {
                // Paso 2: Reconstruir la secuencia exacta de "U" y "D" basada en la memoización
                sb.append(reconstruct(0, 0)).append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    /**
     * Función recursiva con memoización.
     * Devuelve la altura máxima (pico) mínima necesaria para completar con éxito
     * el entrenamiento desde el paso actual y con la altura actual.
     */
    static int solve(int step, int height) {
        // Caso base: Hemos procesado todos los pasos
        if (step == numPasos) {
            // El ejercicio es legal solo si terminamos exactamente a nivel de suelo (altura 0)
            return (height == 0) ? 0 : IMPOSSIBLE;
        }

        // Si ya calculamos este estado, lo devolvemos directamente (evita re-cálculos)
        if (memo[step][height] != -1) {
            return memo[step][height];
        }

        int distancia = pasos[step];
        int minPeak = IMPOSSIBLE;

        // Opción A: Subir (U)
        int nuevaAlturaUp = height + distancia;
        int peakUp = Math.max(nuevaAlturaUp, solve(step + 1, nuevaAlturaUp));
        if (peakUp < minPeak) {
            minPeak = peakUp;
        }

        // Opción B: Bajar (D) - Solo es válido si no caemos por debajo del suelo (< 0)
        int nuevaAlturaDown = height - distancia;
        if (nuevaAlturaDown >= 0) {
            int peakDown = Math.max(nuevaAlturaDown, solve(step + 1, nuevaAlturaDown));
            if (peakDown < minPeak) {
                minPeak = peakDown;
            }
        }

        // Guardamos el resultado en la tabla y lo retornamos
        return memo[step][height] = minPeak;
    }

    /**
     * Reconstruye la cadena de caracteres ("U" y "D") recorriendo los estados óptimos
     * calculados previamente en la matriz `memo`.
     */
    static String reconstruct(int step, int height) {
        if (step == numPasos) {
            return "";
        }

        int distancia = pasos[step];
        int objetivoActual = memo[step][height];

        // Intentamos ver si la opción 'U' fue la que nos dio el óptimo
        int nuevaAlturaUp = height + distancia;
        if (nuevaAlturaUp < memo[0].length) {
            int peakUp = Math.max(nuevaAlturaUp, solve(step + 1, nuevaAlturaUp));
            if (peakUp == objetivoActual) {
                return "U" + reconstruct(step + 1, nuevaAlturaUp);
            }
        }

        // Si no fue 'U', obligatoriamente la opción óptima vino de 'D'
        int nuevaAlturaDown = height - distancia;
        if (nuevaAlturaDown >= 0) {
            return "D" + reconstruct(step + 1, nuevaAlturaDown);
        }

        return "";
    }
}