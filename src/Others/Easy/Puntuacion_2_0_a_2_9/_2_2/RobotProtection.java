package Others.Easy.Puntuacion_2_0_a_2_9._2_2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class RobotProtection {

    /**
     * Clase auxiliar para representar un punto (baliza) en el plano cartesiano.
     * Implementa Comparable para permitir el ordenamiento lexicográfico.
     */
    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            // Ordenar primero por la coordenada X, y en caso de empate, por la Y.
            if (this.x != other.x) {
                return Long.compare(this.x, other.x);
            }
            return Long.compare(this.y, other.y);
        }
    }

    /**
     * Calcula el producto cruzado de los vectores OA y OB.
     *
     * @return
     *   - Un valor positivo si el giro es en sentido antihorario.
     *   - Un valor negativo si el giro es en sentido horario.
     *   - Cero si los puntos son colineales.
     */
    public static long crossProduct(Point o, Point a, Point b) {
        return (a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x);
    }

    /**
     * Calcula el Cierre Convexo (Convex Hull) utilizando el algoritmo de Andrew (Monotone Chain).
     * Complejidad: O(n log n) debido al ordenamiento inicial.
     */
    public static List<Point> convexHull(List<Point> points) {
        int n = points.size();
        if (n <= 1) {
            return points;
        }

        // 1. Ordenar los puntos lexicográficamente
        Collections.sort(points);

        List<Point> hull = new ArrayList<Point>();

        // 2. Construir la mitad inferior del cierre convexo (Lower Hull)
        for (int i = 0; i < n; i++) {
            while (hull.size() >= 2 && crossProduct(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points.get(i)) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(points.get(i));
        }

        // 3. Construir la mitad superior del cierre convexo (Upper Hull)
        for (int i = n - 2, t = hull.size() + 1; i >= 0; i--) {
            while (hull.size() >= t && crossProduct(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points.get(i)) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(points.get(i));
        }

        // El último punto de la lista está duplicado (cierra el ciclo con el primero), se elimina
        if (hull.size() > 1) {
            hull.remove(hull.size() - 1);
        }

        return hull;
    }

    /**
     * Calcula el área de un polígono simple utilizando la Fórmula de Gauss (Shoelace Formula).
     */
    public static double polygonArea(List<Point> polygon) {
        int n = polygon.size();
        double area = 0.0;

        for (int i = 0; i < n; i++) {
            Point p1 = polygon.get(i);
            Point p2 = polygon.get((i + 1) % n); // Siguiente vértice (con vuelta al inicio)
            area += (p1.x * p2.y) - (p2.x * p1.y);
        }

        return Math.abs(area) / 2.0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while (true) {
            String line = br.readLine();
            if (line == null || line.trim().isEmpty()) {
                continue;
            }
            st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) {
                continue;
            }

            int n = Integer.parseInt(st.nextToken());
            // Condición de parada del problema
            if (n == 0) {
                break;
            }

            List<Point> points = new ArrayList<Point>();
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

            // Paso 1: Encontrar el perímetro exterior accesible (Convex Hull)
            List<Point> hull = convexHull(points);

            // Paso 2: Calcular el área encerrada por dicho perímetro
            double area = polygonArea(hull);

            // Imprimir el resultado formateado a un decimal (según el formato de salida esperado)
            System.out.printf("%.1f\n", area);
        }
    }
}
