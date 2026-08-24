package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class SkyIslands {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // Inicializar lista de adyacencia (1-based index)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Recorrido DFS para contar nodos alcanzables
        boolean[] visited = new boolean[n + 1];
        int count = dfs(1, adj, visited);

        if (count == n) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static int dfs(int u, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        int reached = 1;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                reached += dfs(v, adj, visited);
            }
        }
        return reached;
    }
}
