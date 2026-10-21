package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class ButtonBashing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        if (!st.hasMoreTokens()) return;
        int numTestCases = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < numTestCases; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            int[] buttons = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                buttons[i] = Integer.parseInt(st.nextToken());
            }

            int[] dist = new int[3601];
            Arrays.fill(dist, -1);

            Queue<Integer> queue = new LinkedList<>();
            dist[0] = 0;
            queue.add(0);

            // BFS para encontrar el número mínimo de pulsaciones para cada tiempo
            while (!queue.isEmpty()) {
                int curr = queue.poll();

                for (int b : buttons) {
                    int nxt = curr + b;
                    if (nxt < 0) nxt = 0;
                    if (nxt > 3600) nxt = 3600;

                    if (dist[nxt] == -1) {
                        dist[nxt] = dist[curr] + 1;
                        queue.add(nxt);
                    }
                }
            }

            int bestT = -1;

            // Encontrar el menor T >= target alcanzable
            for (int T = target; T <= 3600; T++) {
                if (dist[T] != -1) {
                    bestT = T;
                    break;
                }
            }

            int presses = dist[bestT];
            int extraSeconds = bestT - target;
            sb.append(presses).append(" ").append(extraSeconds).append("\n");
        }

        System.out.print(sb);
    }
}