package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._1_EstucturasDeDatosParaGrafos;
import java.io.*;
import java.util.*;


 // El juego de pruebas público da error!!!
 // Mirar de corregirlo

public class RailroadMap_RTE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            br.readLine(); // Leer y descartar línea vacía
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            List<Map<Integer, List<Integer>>> g = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                g.add(new HashMap<>());
            }
            int[] degree = new int[n + 1];

            for (int i = 0; i < m; i++) {
                String[] edge = br.readLine().split(" ");
                int a = Integer.parseInt(edge[0]);
                int b = Integer.parseInt(edge[1]);
                int w = Integer.parseInt(edge[2]);

                for (int j = 0; j < 2; j++) {
                    g.get(a).putIfAbsent(b, new ArrayList<>());
                    g.get(a).get(b).add(w);
                    degree[a]++;
                    int temp = a;
                    a = b;
                    b = temp;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (degree[i] == 2) q.add(i);
            }

            while (!q.isEmpty()) {
                int i = q.poll();
                if (degree[i] == 2) {
                    List<int[]> edges = new ArrayList<>();
                    for (Map.Entry<Integer, List<Integer>> entry : g.get(i).entrySet()) {
                        int j = entry.getKey();
                        for (int w : entry.getValue()) {
                            edges.add(new int[]{j, w});
                        }
                    }

                    int a = edges.get(0)[0], b = edges.get(0)[1];
                    int c = edges.get(1)[0], d = edges.get(1)[1];

                    degree[a]--;
                    degree[c]--;
                    g.get(i).clear();
                    g.get(a).remove(i);
                    if (a != c) g.get(c).remove(i);

                    degree[a]++;
                    degree[c]++;

                    g.get(a).putIfAbsent(c, new ArrayList<>());
                    g.get(c).putIfAbsent(a, new ArrayList<>());
                    g.get(a).get(c).add(b + d);
                    g.get(c).get(a).add(b + d);

                    if (degree[a] == 2) q.add(a);
                    if (a != c && degree[c] == 2) q.add(c);
                }
            }

            Set<String> E = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                for (Map.Entry<Integer, List<Integer>> entry : g.get(i).entrySet()) {
                    int j = entry.getKey();
                    for (int w : entry.getValue()) {
                        int min = Math.min(i, j);
                        int max = Math.max(i, j);
                        E.add(min + " " + max + " " + w);
                    }
                }
            }

            sb.append(E.size()).append("\n");
            for (String e : E) sb.append(e).append("\n");
            sb.append("\n");
        }

        System.out.print(sb);
    }
}

// Código original en python
// de https://github.com/RussellDash332/kattis/blob/main/src/Railroad%20Map/railroad.py
/*
input = __import__('sys').stdin.readline
for _ in range(int(input())):
    input()
    n, m = map(int, input().split())
    g = [[0, {}] for _ in range(n+1)]
    for _ in range(m):
        a, b, w = map(int, input().split())
        for _ in range(2):
            a, b = b, a
            g[a][0] += 1
            if b not in g[a][1]: g[a][1][b] = []
            g[a][1][b].append(w)
    q = []
    for i in range(1, n+1):
        if g[i][0] == 2: q.append(i)
    for i in q:
        if g[i][0] == 2:
            e = []
            for j in g[i][1]:
                for k in g[i][1][j]: e.append((j, k))
            (a, b), (c, d) = e
            g[a][0] -= 1; g[c][0] -= 1
            g[i] = [0, {}]
            g[a][1].pop(i)
            if a != c: g[c][1].pop(i)
            g[a][0] += 1; g[c][0] += 1
            if c not in g[a][1]: g[a][1][c] = []
            if a not in g[c][1]: g[c][1][a] = []
            g[a][1][c].append(b+d), g[c][1][a].append(b+d)
            if g[a][0] == 2: q.append(a)
            if a != c and g[c][0] == 2: q.append(c)
    E = set()
    for i in range(1, n+1):
        for j in g[i][1]:
            for k in g[i][1][j]: E.add((min(i, j), max(i, j), k))
    print(len(E))
    for e in E: print(*e)
    print()

 */