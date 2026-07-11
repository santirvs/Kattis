package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AllDifferentDirections {

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine().trim());
            if (n == 0) break;

            Point[] dest = new Point[n];
            double sumX = 0.0;
            double sumY = 0.0;

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);

                double x = Double.parseDouble(st.nextToken());
                double y = Double.parseDouble(st.nextToken());

                double angle = 0.0;

                while (st.hasMoreTokens()) {
                    String cmd = st.nextToken();

                    if (cmd.equals("start")) {
                        angle = Double.parseDouble(st.nextToken());
                    } else if (cmd.equals("turn")) {
                        angle += Double.parseDouble(st.nextToken());
                    } else if (cmd.equals("walk")) {
                        double d = Double.parseDouble(st.nextToken());
                        double rad = Math.toRadians(angle);
                        x += d * Math.cos(rad);
                        y += d * Math.sin(rad);
                    }
                }

                dest[i] = new Point(x, y);
                sumX += x;
                sumY += y;
            }

            double avgX = sumX / n;
            double avgY = sumY / n;

            double maxDist = 0.0;

            for (int i = 0; i < n; i++) {
                double dx = dest[i].x - avgX;
                double dy = dest[i].y - avgY;
                double dist = Math.sqrt(dx * dx + dy * dy);
                if (dist > maxDist)
                    maxDist = dist;
            }

            System.out.printf("%.10f %.10f %.10f%n", avgX, avgY, maxDist);
        }
    }
}