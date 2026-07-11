package Others.Medium.Puntuacion_3_0_a_3_9._3_3;

import java.io.*;

public class FindTheGraph {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int query(int... vertices) throws Exception {
        out.print("?");
        out.print(" ");
        out.print(vertices.length);
        for (int v : vertices) {
            out.print(" ");
            out.print(v);
        }
        out.println();
        out.flush();

        int ans = Integer.parseInt(br.readLine());
        if (ans == -1) System.exit(0);
        return ans;
    }

    public static void main(String[] args) throws Exception {

        String line = br.readLine();
        if (line == null) return;

        int n = Integer.parseInt(line);

        int[] single = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            single[i] = query(i);
        }

        int[][] ans = new int[n][n];

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {

                int pair = query(i, j);

                int edge = (single[i] + single[j] - pair) / 2;

                ans[i - 1][j - 1] = edge;
                ans[j - 1][i - 1] = edge;
            }
        }

        out.println("!");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) out.print(" ");
                out.print(ans[i][j]);
            }
            out.println();
        }
        out.flush();
    }
}