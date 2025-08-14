package Cap3._2_BusquedaCompleta._9_SimulacionMatematicaDificiles;

import java.io .*;
import java.util .*;

// Búsqueda completa
// Buscar la constante de Lipschitz de una función dada por puntos
// CLAVE:: La constante de Lipschitz es el máximo valor de |dy/dx| entre puntos consecutivos

public class LipschitzConstant {

    static class Point implements Comparable<Point> {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            if (this.x != other.x) {
                return Double.compare(this.x, other.x);
            }
            return Double.compare(this.y, other.y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Leer el número de puntos
        int numPuntos = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>(numPuntos);

        // Leer los puntos
        for (int i = 0; i < numPuntos; i++) {
            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            points.add(new Point(a, b));
        }

        // Ordenar los puntos por coordenadas x y luego por y
        Collections.sort(points);

        // Calcular la constante de Lipschitz
        // La constante de Lipschitz es el máximo valor de |dy/dx| entre puntos consecutivos

        double res = Double.NEGATIVE_INFINITY;
        for (int i = 1; i < numPuntos; i++) {
            double dy = points.get(i).y - points.get(i - 1).y;
            double dx = points.get(i).x - points.get(i - 1).x;
            res = Math.max(res, Math.abs(dy / dx));
        }

        System.out.printf("%.5f\n", res);
    }
}



