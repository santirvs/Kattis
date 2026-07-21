package Others.Easy.Puntuacion_2_0_a_2_9._2_2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class JibJob {

    static class Crane {
        long x, y;
        long h;

        Crane(long x, long y, long h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        int n = Integer.parseInt(line.trim());
        Crane[] cranes = new Crane[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long h = Long.parseLong(st.nextToken());
            cranes[i] = new Crane(x, y, h);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            long maxR = cranes[i].h;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                // Solo nos importa si la torre j mide igual o más que la grúa i
                if (cranes[j].h >= cranes[i].h) {
                    long dx = cranes[i].x - cranes[j].x;
                    long dy = cranes[i].y - cranes[j].y;
                    long dist2 = dx * dx + dy * dy;

                    // Distancia exacta
                    double dist = Math.sqrt(dist2);

                    // Permitimos tocar: r <= floor(dist)
                    long allowedR = (long) Math.floor(dist);

                    if (allowedR < maxR) {
                        maxR = allowedR;
                    }
                }
            }

            sb.append(maxR).append("\n");
        }

        System.out.print(sb.toString());
    }
}