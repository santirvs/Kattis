package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CuckooHashing {

    // Estructura DSU (Disjoint Set Union) para gestionar los componentes conexos del grafo
    static class DSU {
        int[] parent; // Representante de cada conjunto
        int[] vertices; // Cantidad de vértices en el componente conexo
        int[] edges;    // Cantidad de aristas en el componente conexo

        public DSU(int size) {
            parent = new int[size];
            vertices = new int[size];
            edges = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
                vertices[i] = 1; // Cada nodo empieza como su propio componente de 1 vértice
                edges[i] = 0;    // Inicialmente no hay aristas
            }
        }

        // Encontrar el representante con compresión de caminos (Path Compression)
        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        // Intentar agregar una arista entre u y v.
        // Retorna false si la adición crea un componente con más aristas que vértices (E > V).
        public boolean addEdge(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU != rootV) {
                // Si pertenecen a componentes distintos, los unimos
                parent[rootV] = rootU;
                vertices[rootU] += vertices[rootV];
                edges[rootU] += edges[rootV] + 1; // Sumamos las aristas acumuladas más la nueva
            } else {
                // Si ya pertenecen al mismo componente, agregamos un ciclo al componente actual
                edges[rootU]++;
            }

            // Condición de Cuckoo Hashing:
            // Ningún componente puede tener más aristas que vértices (Edges <= Vertices)
            return edges[rootU] <= vertices[rootU];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int numTestCases = Integer.parseInt(line.trim());

        while (numTestCases-- > 0) {
            line = br.readLine();
            // Saltar líneas vacías en la entrada si existiesen
            while (line != null && line.trim().isEmpty()) {
                line = br.readLine();
            }
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken()); // Cantidad de palabras a insertar
            int M = Integer.parseInt(st.nextToken()); // Tamaño de la tabla hash (vértices)

            DSU dsu = new DSU(M);
            boolean possible = true;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int h1 = Integer.parseInt(st.nextToken());
                int h2 = Integer.parseInt(st.nextToken());

                // Si ya falló previamente, seguimos consumiendo la entrada del caso
                if (possible) {
                    if (!dsu.addEdge(h1, h2)) {
                        possible = false;
                    }
                }
            }

            // Impresión del resultado según el criterio de Cuckoo Hashing
            if (possible) {
                System.out.println("successful hashing");
            } else {
                System.out.println("rehash necessary");
            }
        }
    }
}