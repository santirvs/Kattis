package Others.Hard.Puntuacion_7_0_a_7_9._7_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class ArtAppreciation {

    // Precisión matemática para comparaciones de punto flotante
    private static final double EPS = 1e-11;

    // Representación de un punto en 2D
    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // Representa una línea dirigida (o un semiplano a su izquierda)
    static class HalfPlane {
        Point p1, p2;
        double angle; // Ángulo polar para ordenamiento

        HalfPlane(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
            this.angle = Math.atan2(p2.y - p1.y, p2.x - p1.x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int N = Integer.parseInt(line.trim());
        Point[] pts = new Point[N];

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            pts[i] = new Point(x, y);
        }

        // 1. Asegurar orientación antihoraria (CCW) utilizando la fórmula de la zapatilla (Shoelace)
        double polyArea = 0;
        for (int i = 0; i < N; i++) {
            Point curr = pts[i];
            Point next = pts[(i + 1) % N];
            polyArea += (curr.x * next.y - next.x * curr.y);
        }

        // Si el área es negativa, los vértices están en orden horario (CW); invertimos el arreglo
        if (polyArea < 0) {
            List<Point> list = Arrays.asList(pts);
            Collections.reverse(list);
            pts = list.toArray(new Point[0]);
        }

        // 2. Crear las aristas como semiplanos (el interior queda a la izquierda)
        List<HalfPlane> planes = new ArrayList<HalfPlane>();
        for (int i = 0; i < N; i++) {
            planes.add(new HalfPlane(pts[i], pts[(i + 1) % N]));
        }

        // Agregar una caja contenedora (Bounding Box) gigante para limitar los semiplanos abiertos
        // El tamaño de la caja (-1e9 a 1e9) es ideal dada la restricción de las coordenadas (+- 10^6)
        double INF = 1e9;
        Point b1 = new Point(-INF, -INF);
        Point b2 = new Point(INF, -INF);
        Point b3 = new Point(INF, INF);
        Point b4 = new Point(-INF, INF);
        planes.add(new HalfPlane(b1, b2));
        planes.add(new HalfPlane(b2, b3));
        planes.add(new HalfPlane(b3, b4));
        planes.add(new HalfPlane(b4, b1));

        // 3. Ejecutar algoritmo de Intersección de Semiplanos
        List<Point> kernel = intersectHalfPlanes(planes);

        // 4. Calcular el área del polígono del Kernel obtenido
        double kernelArea = 0;
        if (kernel.size() >= 3) {
            for (int i = 0; i < kernel.size(); i++) {
                Point curr = kernel.get(i);
                Point next = kernel.get((i + 1) % kernel.size());
                kernelArea += (curr.x * next.y - next.x * curr.y);
            }
            kernelArea = Math.abs(kernelArea) / 2.0;
        }

        // Salida formateada con la precisión requerida de 10 dígitos decimales
        System.out.printf(Locale.UK, "%.10f\n", kernelArea);
    }

    // Producto cruz de dos vectores (B - A) y (C - A)
    private static double cross(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    // Comprueba si la intersección de las líneas h1 y h2 queda a la derecha del semiplano h
    private static boolean isRight(HalfPlane h, HalfPlane h1, HalfPlane h2) {
        Point p = getIntersection(h1, h2);
        if (p == null) return true;
        return cross(h.p1, h.p2, p) < -EPS;
    }

    // Calcula el punto de intersección entre dos rectas definidas por sus semiplanos
    private static Point getIntersection(HalfPlane h1, HalfPlane h2) {
        double a1 = h1.p2.y - h1.p1.y;
        double b1 = h1.p1.x - h1.p2.x;
        double c1 = a1 * h1.p1.x + b1 * h1.p1.y;

        double a2 = h2.p2.y - h2.p1.y;
        double b2 = h2.p1.x - h2.p2.x;
        double c2 = a2 * h2.p1.x + b2 * h2.p1.y;

        double det = a1 * b2 - a2 * b1;
        if (Math.abs(det) < EPS) return null; // Líneas paralelas

        double x = (b2 * c1 - b1 * c2) / det;
        double y = (a1 * c2 - a2 * c1) / det;
        return new Point(x, y);
    }

    // Algoritmo de intersección de semiplanos O(N log N)
    private static List<Point> intersectHalfPlanes(List<HalfPlane> planes) {
        // Ordenamos los semiplanos por ángulo polar de su vector director
        Collections.sort(planes, new Comparator<HalfPlane>() {
            @Override
            public int compare(HalfPlane h1, HalfPlane h2) {
                if (Math.abs(h1.angle - h2.angle) > EPS) {
                    return Double.compare(h1.angle, h2.angle);
                }
                // Si son paralelos en la misma dirección, el que esté más a la izquierda va primero
                return Double.compare(cross(h1.p1, h1.p2, h2.p1), 0);
            }
        });

        // Filtrar planos colineales y paralelos redundantes (conservamos el de más a la izquierda)
        List<HalfPlane> uniquePlanes = new ArrayList<HalfPlane>();
        for (int i = 0; i < planes.size(); i++) {
            if (i > 0 && Math.abs(planes.get(i).angle - planes.get(i - 1).angle) < EPS) {
                continue;
            }
            uniquePlanes.add(planes.get(i));
        }

        int n = uniquePlanes.size();
        HalfPlane[] deque = new HalfPlane[n + 5];
        int head = 0, tail = 0;

        // Añadir el primer semiplano
        deque[tail++] = uniquePlanes.get(0);

        for (int i = 1; i < n; i++) {
            HalfPlane curr = uniquePlanes.get(i);
            // Si la intersección de los dos últimos en la cola queda a la derecha del actual, se saca de la cola
            while (tail - head >= 2 && isRight(curr, deque[tail - 1], deque[tail - 2])) {
                tail--;
            }
            // Mismo chequeo por la cabeza de la cola
            while (tail - head >= 2 && isRight(curr, deque[head], deque[head + 1])) {
                head++;
            }
            deque[tail++] = curr;
        }

        // Cerrar el polígono de manera circular para descartar los extremos redundantes
        while (tail - head >= 2 && isRight(deque[head], deque[tail - 1], deque[tail - 2])) {
            tail--;
        }
        while (tail - head >= 2 && isRight(deque[tail - 1], deque[head], deque[head + 1])) {
            head++;
        }

        List<Point> kernelVertices = new ArrayList<Point>();
        // Si sobrevivieron menos de 3 semiplanos delimitando el espacio, el núcleo es vacío
        if (tail - head < 3) {
            return kernelVertices;
        }

        // Generar los vértices resultantes de intersectar los semiplanos adyacentes en el deque
        for (int i = head; i < tail - 1; i++) {
            Point p = getIntersection(deque[i], deque[i + 1]);
            if (p != null) kernelVertices.add(p);
        }
        Point pLast = getIntersection(deque[tail - 1], deque[head]);
        if (pLast != null) kernelVertices.add(pLast);

        return kernelVertices;
    }
}
