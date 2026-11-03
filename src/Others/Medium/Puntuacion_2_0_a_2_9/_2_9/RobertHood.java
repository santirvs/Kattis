package Others.Medium.Puntuacion_2_0_a_2_9._2_9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Solución para el problema "Robert Hood" en Java 1.7.
 * Encuentra el diámetro del conjunto de puntos (distancia máxima entre dos flechas)
 * utilizando Convex Hull (Andrew's Monotone Chain) + Rotating Calipers.
 */
public class RobertHood {

    /**
     * Clase estática para representar un punto bidimensional en el plano.
     * Implementa Comparable para permitir la ordenación lexicográfica (primero por X, luego por Y).
     */
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

    /**
     * Producto cruzado 2D de los vectores OA y OB.
     * Sirve para determinar la orientación relativa del giro:
     * > 0 : Giro a la izquierda (antihorario)
     * < 0 : Giro a la derecha (horario)
     * = 0 : Puntos colineales
     */
    private static long crossProduct(Point o, Point a, Point b) {
        return (a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x);
    }

    /**
     * Calcula la distancia al cuadrado entre dos puntos.
     * Se trabaja al cuadrado para mantener precisión entera exacta sin pérdidas por flotantes.
     */
    private static long distSq(Point a, Point b) {
        long dx = a.x - b.x;
        long dy = a.y - b.y;
        return dx * dx + dy * dy;
    }

    /**
     * Construye la Envolvente Convexa (Convex Hull) utilizando el algoritmo Monotone Chain.
     * @param points Arreglo de puntos originales.
     * @return Arreglo con los vértices de la envolvente convexa ordenados en sentido antihorario.
     */
    private static Point[] getConvexHull(Point[] points) {
        int n = points.length;
        if (n <= 1) {
            return points;
        }

        // Ordenamos los puntos lexicográficamente por coordenadas (X, Y)
        Arrays.sort(points);

        Point[] hull = new Point[2 * n];
        int k = 0;

        // 1. Construir el Lower Hull (Cadena inferior)
        for (int i = 0; i < n; i++) {
            while (k >= 2 && crossProduct(hull[k - 2], hull[k - 1], points[i]) <= 0) {
                k--;
            }
            hull[k++] = points[i];
        }

        // 2. Construir el Upper Hull (Cadena superior)
        int t = k + 1;
        for (int i = n - 2; i >= 0; i--) {
            while (k >= t && crossProduct(hull[k - 2], hull[k - 1], points[i]) <= 0) {
                k--;
            }
            hull[k++] = points[i];
        }

        // Se elimina el último punto duplicado
        return Arrays.copyOf(hull, k - 1);
    }

    public static void main(String[] args) throws IOException {
        // Lector rápido para procesar entradas grandes de manera eficiente
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        while (line == null || line.trim().isEmpty()) {
            line = br.readLine();
        }

        StringTokenizer st = new StringTokenizer(line);
        int c = Integer.parseInt(st.nextToken());

        Point[] points = new Point[c];
        for (int i = 0; i < c; i++) {
            line = br.readLine();
            while (line == null || line.trim().isEmpty()) {
                line = br.readLine();
            }
            st = new StringTokenizer(line);
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            points[i] = new Point(x, y);
        }

        // Paso 1: Obtener la Envolvente Convexa
        Point[] hull = getConvexHull(points);
        int h = hull.length;

        // Casos particulares
        if (h == 1) {
            System.out.printf("%.9f%n", 0.0);
            return;
        }
        if (h == 2) {
            double dist = Math.sqrt(distSq(hull[0], hull[1]));
            System.out.printf("%.9f%n", dist);
            return;
        }

        // Paso 2: Rotating Calipers para encontrar el diámetro en tiempo lineal O(H)
        long maxDistSq = 0;
        int j = 1;

        for (int i = 0; i < h; i++) {
            int nextI = (i + 1) % h;

            // Avanzamos el puntero 'j' mientras el triángulo formado por (hull[i], hull[nextI], hull[j])
            // aumente de área frente al siguiente punto 'nextJ'
            while (true) {
                int nextJ = (j + 1) % h;
                long areaCurrent = Math.abs(crossProduct(hull[i], hull[nextI], hull[j]));
                long areaNext = Math.abs(crossProduct(hull[i], hull[nextI], hull[nextJ]));

                if (areaNext > areaCurrent) {
                    j = nextJ;
                } else {
                    break;
                }
            }

            // Comprobar distancias con el vértice antípoda encontrado
            maxDistSq = Math.max(maxDistSq, distSq(hull[i], hull[j]));
            maxDistSq = Math.max(maxDistSq, distSq(hull[nextI], hull[j]));
        }

        // Salida formateada de la distancia euclidiana máxima
        double maxDistance = Math.sqrt(maxDistSq);
        System.out.printf("%.9f%n", maxDistance);
    }
}