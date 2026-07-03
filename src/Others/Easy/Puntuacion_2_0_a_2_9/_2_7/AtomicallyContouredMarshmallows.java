package Others.Easy.Puntuacion_2_0_a_2_9._2_7;


import java.util.Scanner;
import java.util.Arrays;

public class AtomicallyContouredMarshmallows {

    // Clase para representar una carretera (Arista del Grafo)
    static class Road implements Comparable<Road> {
        int u, v, cost;

        public Road(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        // Permite ordenar las carreteras por costo de menor a mayor automáticamente
        @Override
        public int compareTo(Road other) {
            return this.cost - other.cost;
        }
    }

    // Estructura de datos Union-Find (Disjoint Set Union)
    static class DisjointSet {
        int[] parent;

        public DisjointSet(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i; // Al principio cada nodo es su propio padre
            }
        }

        // Encuentra el representante (raíz) del conjunto con Compresión de Caminos
        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            parent[i] = find(parent[i]); // Optimización
            return parent[i];
        }

        // Une dos conjuntos independientes. Retorna true si se unieron,
        // false si ya pertenecían al mismo conjunto.
        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Validar si hay datos de entrada
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int v = sc.nextInt(); // Número de fábricas y distribuidores (nodos)
        int e = sc.nextInt(); // Número de carreteras potenciales (aristas)

        Road[] roads = new Road[e];

        // Leer todas las carreteras potenciales
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int u_v = sc.nextInt();
            int cost = sc.nextInt();
            roads[i] = new Road(u, u_v, cost);
        }

        // 1. Ordenar las carreteras por costo de forma ascendente
        Arrays.sort(roads);

        // 2. Inicializar la estructura Union-Find
        DisjointSet dsu = new DisjointSet(v);

        int totalCost = 0;
        int roadsCount = 0;

        // 3. Aplicar el algoritmo de Kruskal
        for (int i = 0; i < e; i++) {
            Road currentRoad = roads[i];

            // Intentar unir los dos extremos de la carretera
            // Si ya estaban unidos, no hace nada
            if (dsu.union(currentRoad.u, currentRoad.v)) {
                totalCost += currentRoad.cost;
                roadsCount++;

                // Si ya conectamos todos los nodos (V - 1 carreteras), terminamos antes
                if (roadsCount == v - 1) {
                    break;
                }
            }
        }

        // 4. Validar si el grafo quedó completamente conectado
        // Un árbol de expansión válido requiere exactamente V - 1 aristas (para V > 1)
        // Si V es 1, no se necesitan carreteras y el costo es 0
        if (v == 1) {
            System.out.println(0);
        } else if (roadsCount == v - 1) {
            System.out.println(totalCost);
        } else {
            System.out.println(-1);
        }

        sc.close();
    }
}