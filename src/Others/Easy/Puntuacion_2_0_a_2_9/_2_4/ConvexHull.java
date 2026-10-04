package Others.Easy.Puntuacion_2_0_a_2_9._2_4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ConvexHull {

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            if (this.x != other.x) {
                return Long.compare(this.x, other.x);
            }
            return Long.compare(this.y, other.y);
        }
    }

    public static long crossProduct(Point o, Point a, Point b) {
        return (a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x);
    }

    public static List<Point> convexHull(List<Point> points) {
        if (points.size() <= 1) {
            return points;
        }

        // 1. Ordenar primero para poder eliminar duplicados en O(N)
        Collections.sort(points);

        List<Point> uniquePoints = new ArrayList<Point>();
        uniquePoints.add(points.get(0));
        for (int i = 1; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i - 1);
            if (p1.x != p2.x || p1.y != p2.y) {
                uniquePoints.add(p1);
            }
        }

        if (uniquePoints.size() <= 2) {
            return uniquePoints;
        }

        int n = uniquePoints.size();
        List<Point> hull = new ArrayList<Point>();

        // 2. Construir Lower Hull
        for (int i = 0; i < n; i++) {
            while (hull.size() >= 2 && crossProduct(hull.get(hull.size() - 2), hull.get(hull.size() - 1), uniquePoints.get(i)) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(uniquePoints.get(i));
        }

        // 3. Construir Upper Hull
        for (int i = n - 2, t = hull.size() + 1; i >= 0; i--) {
            while (hull.size() >= t && crossProduct(hull.get(hull.size() - 2), hull.get(hull.size() - 1), uniquePoints.get(i)) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(uniquePoints.get(i));
        }

        // Remover el punto duplicado de cierre
        if (hull.size() > 1) {
            hull.remove(hull.size() - 1);
        }

        return hull;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        StringTokenizer st = null;

        while (true) {
            String line = br.readLine();
            while (line != null && line.trim().isEmpty()) {
                line = br.readLine();
            }
            if (line == null) {
                break;
            }

            st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) {
                continue;
            }

            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            List<Point> points = new ArrayList<Point>(n);
            for (int i = 0; i < n; i++) {
                line = br.readLine();
                while (line == null || line.trim().isEmpty()) {
                    line = br.readLine();
                }
                st = new StringTokenizer(line);
                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());
                points.add(new Point(x, y));
            }

            List<Point> hull = convexHull(points);

            out.println(hull.size());
            for (Point p : hull) {
                out.print(p.x);
                out.print(' ');
                out.println(p.y);
            }
        }
        out.flush();
    }
}