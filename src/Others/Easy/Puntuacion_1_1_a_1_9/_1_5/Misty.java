package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Misty {

    /**
     * Clase que representa un sendero (arista) del grafo.
     * Implementa Comparable para ordenar los senderos por su longitud de forma ascendente.
     */
    static class Trail implements Comparable<Trail> {
        int id;      // Índice original del sendero (1-based, según la entrada)
        int u, v;    // Las dos casas que conecta el sendero
        int weight;  // La longitud (peso) del sendero

        public Trail(int id, int u, int v, int weight) {
            this.id = id;
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Trail other) {
            // Ordenar de menor a mayor longitud
            return Integer.compare(this.weight, other.weight);
        }
    }

    /**
     * Estructura de datos Disjoint Set Union (Union-Find)
     * Permite gestionar componentes conexos y detectar ciclos eficientemente.
     */
    static class DisjointSet {
        private int[] parent;
        private int[] rank;

        public DisjointSet(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            // Inicialmente, cada casa es su propio padre (componente independiente)
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        /**
         * Encuentra el representante (raíz) del conjunto al que pertenece el elemento i,
         * aplicando compresión de caminos (path compression) para optimizar búsquedas futuras.
         */
        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        /**
         * Une los conjuntos de los elementos i y j si pertenecen a componentes distintos.
         * Utiliza unión por rango (union by rank) para mantener el árbol plano.
         *
         * @return true si se unieron con éxito (no formaban ciclo); false si ya estaban conectados.
         */
        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if (rootI != rootJ) {
                // Adjuntar el árbol de menor rango bajo la raíz del árbol de mayor rango
                if (rank[rootI] < rank[rootJ]) {
                    parent[rootI] = rootJ;
                } else if (rank[rootI] > rank[rootJ]) {
                    parent[rootJ] = rootI;
                } else {
                    parent[rootJ] = rootI;
                    rank[rootI]++;
                }
                return true;
            }
            return false; // Ya están conectados, añadir este sendero crearía un ciclo
        }
    }

    public static void main(String[] args) throws IOException {
        // Usamos BufferedReader para lectura rápida de la entrada estándar
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken()); // Número de casas (nodos)
        int m = Integer.parseInt(st.nextToken()); // Número de senderos (aristas)

        List<Trail> trails = new ArrayList<Trail>();

        // Leer la información de los M senderos
        for (int i = 1; i <= m; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // Guardamos el sendero junto con su ID original (índice 1-based)
            trails.add(new Trail(i, u, v, w));
        }

        // Paso 1: Ordenar todos los senderos de menor a mayor según su longitud (Algoritmo Voraz / Greedy)
        Collections.sort(trails);

        // Paso 2: Inicializar el Union-Find para las N casas
        DisjointSet ds = new DisjointSet(n);
        List<Integer> selectedTrails = new ArrayList<Integer>();
        int edgesCount = 0;

        // Paso 3: Recorrer los senderos ordenados
        for (Trail trail : trails) {
            // Intentar conectar las dos casas del sendero actual
            if (ds.union(trail.u, trail.v)) {
                // Si la unión fue exitosa, no se forma ciclo; seleccionamos este sendero
                selectedTrails.add(trail.id);
                edgesCount++;

                // Un árbol de expansión válido para N nodos contiene exactamente N - 1 aristas
                if (edgesCount == n - 1) {
                    break;
                }
            }
        }

        // Paso 4: Construir la salida requerida
        StringBuilder sb = new StringBuilder();
        sb.append(selectedTrails.size()).append("\n");
        for (int trailId : selectedTrails) {
            sb.append(trailId).append("\n");
        }

        // Imprimir todos los resultados de una sola vez
        System.out.print(sb.toString());
    }
}