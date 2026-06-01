package Others.Easy.Puntuacion_3_0_a_3_9._3_5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinecraftSpeedrunning {

    // Clase para representar un portal
    static class Portal {
        int id;
        long coordNether;
        long coordOverworld;
        long costoReparacion;

        public Portal(int id, long coordNether, long costoReparacion) {
            this.id = id;
            this.coordNether = coordNether;
            this.coordOverworld = coordNether * 8;
            this.costoReparacion = costoReparacion;
        }
    }

    // Clase para las aristas del grafo
    static class Arista {
        int destino;
        long peso;

        public Arista(int destino, long peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    // Nodo para la Cola de Prioridad de Dijkstra
    static class NodoDijkstra implements Comparable<NodoDijkstra> {
        int vertice;
        long distancia;

        public NodoDijkstra(int vertice, long distancia) {
            this.vertice = vertice;
            this.distancia = distancia;
        }

        @Override
        public int compareTo(NodoDijkstra o) {
            return Long.compare(this.distancia, o.distancia);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        long T = Long.parseLong(st.nextToken());

        ArrayList<Portal> portales = new ArrayList<Portal>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long coordNether = Long.parseLong(st.nextToken());
            long costo = Long.parseLong(st.nextToken());
            portales.add(new Portal(i, coordNether, costo));
        }

        // 1. ORDENAR LOS PORTALES por su coordenada en el Nether
        // Esto es vital para conectar solo vecinos contiguos en O(N)
        Collections.sort(portales, new Comparator<Portal>() {
            @Override
            public int compare(Portal p1, Portal p2) {
                return Long.compare(p1.coordNether, p2.coordNether);
            }
        });

        // 2. ASIGNACIÓN DE VÉRTICES EN EL GRAFO
        // Nodo 0: Origen (OW 0)
        // Nodo 1: Destino (OW T)
        // Para el portal con índice 'i' en la lista ordenada:
        //   Lado Overworld (OW_i) = 2 + 2*i
        //   Lado Nether (NE_i)    = 2 + 2*i + 1
        int numVertices = 2 + 2 * N;
        ArrayList<Arista>[] grafo = new ArrayList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            grafo[i] = new ArrayList<Arista>();
        }

        // 3. CONSTRUCCIÓN DE ARISTAS

        // Conexión directa: Origen -> Destino por el Overworld
        grafo[0].add(new Arista(1, Math.abs(T)));
        grafo[1].add(new Arista(0, Math.abs(T)));

        for (int i = 0; i < N; i++) {
            Portal pActual = portales.get(i);
            int vOW = 2 + 2 * i;
            int vNE = 2 + 2 * i + 1;

            // Conexión interna del propio Portal (OW <-> NE usando el costo de reparación)
            grafo[vOW].add(new Arista(vNE, pActual.costoReparacion));
            grafo[vNE].add(new Arista(vOW, pActual.costoReparacion));

            // Conexiones desde el Origen (0) y hacia el Destino (1) en el Overworld
            grafo[0].add(new Arista(vOW, Math.abs(pActual.coordOverworld)));
            grafo[vOW].add(new Arista(1, Math.abs(pActual.coordOverworld - T)));

            // Conexiones lineales con el portal anterior (si existe)
            if (i > 0) {
                Portal pAnterior = portales.get(i - 1);
                int vOWAnterior = 2 + 2 * (i - 1);
                int vNEAnterior = 2 + 2 * (i - 1) + 1;

                // Caminar en Overworld entre portales contiguos
                long distOW = Math.abs(pActual.coordOverworld - pAnterior.coordOverworld);
                grafo[vOW].add(new Arista(vOWAnterior, distOW));
                grafo[vOWAnterior].add(new Arista(vOW, distOW));

                // Caminar en Nether entre portales contiguos
                long distNE = Math.abs(pActual.coordNether - pAnterior.coordNether);
                grafo[vNE].add(new Arista(vNEAnterior, distNE));
                grafo[vNEAnterior].add(new Arista(vNE, distNE));
            }
        }

        // 4. ALGORITMO DE DIJKSTRA
        long[] distancias = new long[numVertices];
        Arrays.fill(distancias, Long.MAX_VALUE);
        distancias[0] = 0;

        PriorityQueue<NodoDijkstra> pq = new PriorityQueue<NodoDijkstra>();
        pq.add(new NodoDijkstra(0, 0));

        while (!pq.isEmpty()) {
            NodoDijkstra actual = pq.poll();
            int u = actual.vertice;

            // Si ya encontramos un camino más corto hacia 'u', ignoramos este estado
            if (actual.distancia > distancias[u]) continue;

            // Si ya llegamos al Destino, podemos terminar antes
            if (u == 1) break;

            for (Arista arista : grafo[u]) {
                int v = arista.destino;
                long nuevoCosto = distancias[u] + arista.peso;

                if (nuevoCosto < distancias[v]) {
                    distancias[v] = nuevoCosto;
                    pq.add(new NodoDijkstra(v, nuevoCosto));
                }
            }
        }

        // El nodo 1 almacena la distancia mínima hacia el Stronghold
        System.out.println(distancias[1]);
    }
}