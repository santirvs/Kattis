package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

/*
    Búsqueda de un Árbol de Expansión Mínima (Minimum Spanning Tree - MST).
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;

public class Freckles {

    // Clase para representar las coordenadas de cada peca
    static class Freckle {
        double x, y;

        Freckle(double x, double y) {
            this.x = x;
            this.y = y;
        }

        // Método para calcular la distancia euclidiana hacia otra peca
        double distanceTo(Freckle other) {
            return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
        }
    }

    public static void main(String[] args) throws IOException {
        // Usamos BufferedReader y StringTokenizer para una lectura rápida y compatible
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int numCases = Integer.parseInt(line.trim());

        // El enunciado indica que hay una línea en blanco después del número de casos
        br.readLine();

        for (int c = 0; c < numCases; c++) {
            // Leer el número de pecas
            line = br.readLine();
            while (line != null && line.trim().isEmpty()) {
                line = br.readLine(); // Saltarse líneas en blanco redundantes si las hay
            }
            if (line == null) break;

            int n = Integer.parseInt(line.trim());
            ArrayList<Freckle> freckles = new ArrayList<Freckle>(n);

            // Leer las coordenadas de cada peca
            for (int i = 0; i < n; i++) {
                line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);
                double x = Double.parseDouble(st.nextToken());
                double y = Double.parseDouble(st.nextToken());
                freckles.add(new Freckle(x, y));
            }

            // Algoritmo de Prim para encontrar el MST
            double totalInk = solvePrim(freckles, n);

            // Imprimir el resultado formateado a dos decimales
            // Usamos Locale.US para asegurar que el separador decimal sea un punto '.'
            System.out.printf(Locale.US, "%.2f\n", totalInk);

            // Imprimir una línea en blanco entre casos consecutivos (pero no después del último)
            if (c < numCases - 1) {
                System.out.println();
                br.readLine(); // Consumir la línea en blanco que separa los casos en la entrada
            }
        }
    }

    private static double solvePrim(ArrayList<Freckle> freckles, int n) {
        boolean[] visited = new boolean[n];
        double[] minDist = new double[n];

        // Inicializar las distancias mínimas con un valor infinito
        for (int i = 0; i < n; i++) {
            minDist[i] = Double.MAX_VALUE;
        }

        // Empezamos desde la primera peca (índice 0)
        minDist[0] = 0.0;
        double totalWeight = 0.0;

        for (int step = 0; step < n; step++) {
            // Encontrar la peca no visitada con la distancia mínima acumulada
            int u = -1;
            double min = Double.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && minDist[i] < min) {
                    min = minDist[i];
                    u = i;
                }
            }

            if (u == -1) break; // Por si el grafo no estuviera completamente conectado (no debería pasar)

            // Marcar como visitada y sumar la tinta
            visited[u] = true;
            totalWeight += min;

            // Actualizar las distancias a los vecinos no visitados desde el nodo 'u'
            Freckle current = freckles.get(u);
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    double dist = current.distanceTo(freckles.get(v));
                    if (dist < minDist[v]) {
                        minDist[v] = dist;
                    }
                }
            }
        }

        return totalWeight;
    }
}