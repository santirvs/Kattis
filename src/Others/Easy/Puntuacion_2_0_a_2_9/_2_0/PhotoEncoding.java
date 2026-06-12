package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PhotoEncoding {

    public static void main(String[] args) throws IOException {
        // Usamos Fast I/O compatible con Java 1.7 para procesar los datos rápidamente
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int K = Integer.parseInt(line.trim());

        // Mapa para guardar la frecuencia de cada distancia Manhattan
        Map<Integer, Integer> frecuencias = new HashMap<Integer, Integer>();
        int maxDistancia = 0;

        for (int i = 0; i < K; i++) {
            line = br.readLine();
            if (line != null) {
                int dist = Integer.parseInt(line.trim());
                maxDistancia = Math.max(maxDistancia, dist);

                int actual = frecuencias.containsKey(dist) ? frecuencias.get(dist) : 0;
                frecuencias.put(dist, actual + 1);
            }
        }

        // Búsqueda Binaria sobre el tamaño N de la grilla
        // El tamaño mínimo absoluto es 1.
        // El tamaño máximo necesario no superará maxDistancia + 1.
        int low = 1;
        int high = maxDistancia + 1;
        int resultado = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (esValido(mid, frecuencias, maxDistancia)) {
                resultado = mid;      // Guardamos la solución actual
                high = mid - 1;      // Intentamos buscar un N más pequeño
            } else {
                low = mid + 1;       // N es muy chico, necesitamos agrandar la grilla
            }
        }

        System.out.println(resultado);
    }

    /**
     * Verifica si una grilla de tamaño N x N puede contener todos los píxeles requeridos.
     */
    private static boolean esValido(int N, Map<Integer, Integer> frecuencias, int maxDistancia) {
        // Validación 1: El límite físico de la grilla.
        // La distancia máxima en una grilla N x N es (N-1) + (N-1) = 2N - 2.
        if (maxDistancia > 2 * N - 2) {
            return false;
        }

        // Validación 2: Verificar la capacidad de cada diagonal de distancia D
        for (Map.Entry<Integer, Integer> entrada : frecuencias.entrySet()) {
            int D = entrada.getKey();
            int pixelesRequeridos = entrada.getValue();

            // Fórmula de capacidad recortada por los bordes de una grilla N x N
            int capacidadDiagonal = Math.min(D + 1, 2 * N - 1 - D);

            // Si la grilla tiene capacidad negativa o menor a la requerida para esa diagonal
            if (capacidadDiagonal <= 0 || pixelesRequeridos > capacidadDiagonal) {
                return false;
            }
        }

        return true;
    }
}