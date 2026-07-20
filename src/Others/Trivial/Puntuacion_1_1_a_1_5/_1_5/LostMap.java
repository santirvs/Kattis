package Others.Trivial.Puntuacion_1_1_a_1_5._1_5;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LostMap {

    static class Arista {
        int u, v;
        int peso;

        Arista(int u, int v, int peso) {
            this.u = u;
            this.v = v;
            this.peso = peso;
        }
    }

    // Estructura DSU (Union-Find) para Kruskal
    static class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) parent[i] = i;
        }

        int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }

        boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int n = Integer.parseInt(line.trim());
        List<Arista> aristas = new ArrayList<Arista>();

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int dist = Integer.parseInt(st.nextToken());
                if (i < j) {
                    aristas.add(new Arista(i, j, dist));
                }
            }
        }

        // Ordenar aristas por peso
        Collections.sort(aristas, new Comparator<Arista>() {
            @Override
            public int compare(Arista a1, Arista a2) {
                return Integer.compare(a1.peso, a2.peso);
            }
        });

        // Kruskal
        DSU dsu = new DSU(n);
        StringBuilder sb = new StringBuilder();
        int aristasAgregadas = 0;

        for (Arista e : aristas) {
            if (dsu.union(e.u, e.v)) {
                sb.append(e.u).append(" ").append(e.v).append("\n");
                aristasAgregadas++;
                if (aristasAgregadas == n - 1) break;
            }
        }

        System.out.print(sb.toString());
    }
}