package Others.Easy.Puntuacion_2_0_a_2_9._2_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class TreeHouses {

    // Clase para representar una coordenada (Casa del árbol)
    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // Clase para representar una arista (Posible cable)
    static class Edge {
        int u, v;
        double weight;

        Edge(int u, int v, double weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    // Estructura Disjoint Set Union (DSU) para manejar las conexiones
    static class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]); // Compresión de caminos
        }

        boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                return true; // Se realizó una nueva unión
            }
            return false; // Ya estaban conectados
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        // 1. Leer las coordenadas de las casas
        Point[] points = new Point[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            points[i] = new Point(x, y);
        }

        // Inicializar DSU
        DSU dsu = new DSU(n);

        // 2. Unir la "Tierra Firme" (las primeras 'e' casas tienen costo 0 entre sí)
        for (int i = 2; i <= e; i++) {
            dsu.union(1, i);
        }

        // 3. Unir los cables ya existentes (costo 0)
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            dsu.union(u, v);
        }

        // 4. Generar todas las aristas potenciales con sus distancias geométricas
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                // Optimización opcional: Si ambos ya pertenecen a la tierra firme original,
                // ya están unidos con costo 0, no hace falta calcular su distancia.
                if (i <= e && j <= e) continue;

                double dx = points[i].x - points[j].x;
                double dy = points[i].y - points[j].y;
                double dist = Math.sqrt(dx * dx + dy * dy);
                edges.add(new Edge(i, j, dist));
            }
        }

        // 5. Ordenar las aristas por peso de menor a mayor (Utilizando Comparator anónimo compatible con Java 1.7)
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return Double.compare(e1.weight, e2.weight);
            }
        });

        // 6. Algoritmo de Kruskal para obtener el costo mínimo
        double totalNewCableLength = 0.0;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            // Si no están en el mismo componente, se añade el cable
            if (dsu.union(edge.u, edge.v)) {
                totalNewCableLength += edge.weight;
            }
        }

        // Imprimir el resultado con el formato de decimales requerido
        System.out.printf("%.6f\n", totalNewCableLength);
    }
}