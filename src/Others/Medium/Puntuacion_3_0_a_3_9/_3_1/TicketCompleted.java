package Others.Medium.Puntuacion_3_0_a_3_9._3_1;
import java.util.*;
import java.io.*;

/*
 * No se trata sólo de combinatoria donde la probabilidad de que salga
 * el ticket que tenemos sería (N * N-1) / 2
 * Ya que ahora el tramo 1-2 junto al tramo 2-3 hacen que el tramo 1-3 también sea válido
 * y la probabilidad aumenta
 * Apoyándonos en un UFDS, obtendremos el tamaño de cada "isla" de ciudades interconectadas
 * Una vez, hecho, queda como un ejercicio de probabilidad.
 */

public class TicketCompleted {

    // Estructura para el Union-Find
    static class DisjointSet {
        int[] parent;
        int[] size;

        public DisjointSet(int n) {
            // Se usa n + 1 por si las ciudades están indexadas de 1 a N
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1; // Inicialmente cada ciudad es su propia isla de tamaño 1
            }
        }

        // Busca la raíz de la componente con compresión de caminos
        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            parent[i] = find(parent[i]);
            return parent[i];
        }

        // Une dos componentes y actualiza el tamaño de la raíz
        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if (rootI != rootJ) {
                // Unimos la componente de J a la de I
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Usamos BufferedReader para una lectura rápida y compatible con Java 1.7
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        String[] tokens = line.trim().split("\\s+");
        int N = Integer.parseInt(tokens[0]);
        int M = Integer.parseInt(tokens[1]);

        DisjointSet dsu = new DisjointSet(N);

        // Leer todas las vías y conectar las ciudades
        for (int i = 0; i < M; i++) {
            line = br.readLine();
            if (line != null) {
                tokens = line.trim().split("\\s+");
                int u = Integer.parseInt(tokens[0]);
                int v = Integer.parseInt(tokens[1]);
                dsu.union(u, v);
            }
        }

        // Calcular los casos favorables (tickets que ya podemos completar)
        // Usamos long para evitar desbordamiento de enteros en la multiplicación
        long casosFavorables = 0;

        // Solo sumamos los tamaños de los nodos que son raíces de sus componentes
        for (int i = 1; i <= N; i++) {
            if (dsu.parent[i] == i) {
                long s = dsu.size[i];
                casosFavorables += (s * (s - 1)) / 2;
            }
        }

        // Calcular el total de tickets posibles en el juego
        long totalTickets = ((long) N * (N - 1)) / 2;

        // Calcular e imprimir la probabilidad con punto decimal
        double probabilidad = (double) casosFavorables / totalTickets;
        System.out.printf(Locale.UK, "%.10f\n", probabilidad);
    }
}