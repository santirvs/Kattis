package Others.Easy.Puntuacion_2_0_a_2_9._2_6;

/*
    Nos piden la distancia mínima del vértice más alejado a la recta de cualquier lado
    Suponemos que alineamos la moneda a la ranura de ese lado. Entonces el ancho mínimo que necesitamos
    para la ranura es esa distancia.

    Calcular la distancia entre todas las parejas de vértices
    Se puede hacer por fuerza bruta, al haber pocos vértices (máx: 20)
    Nos quedaremos con la distancia menor.

    La fórmula es :
    Distancia de un Punto a una Recta
    Para calcular la distancia perpendicular desde un vértice C(x0, y0) a la recta formada por
    los puntos A(x1, y1) y B(x2, y2), se puede usar la fórmula estándar basada en la ecuación general de la recta
    Ax + By + C = 0, o directamente su forma vectorial:
       Distancia = |(x2 - x1)*(y1 - y0) - (x1 - x0)(y2 - y1)| / sqrt ( (x2 - x1)^2 + (y2 - y1)^2 )
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PlayingTheSlots {

    // Clase auxiliar para representar los puntos/vértices
    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int n = Integer.parseInt(line.trim());
        Point[] vertices = new Point[n];

        // Lectura de los vértices
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            if (line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            vertices[i] = new Point(x, y);
        }

        // Buscaremos el mínimo global de todas las alturas máximas
        double minimoGlobal = Double.MAX_VALUE;

        // Iterar por cada lado del polígono (formado por el vértice i y el i+1)
        for (int i = 0; i < n; i++) {
            Point a = vertices[i];
            Point b = vertices[(i + 1) % n]; // % n para conectar el último con el primero

            double maxDistanciaParaEsteLado = 0.0;

            // Encontrar el vértice más alejado perpendicularmente a la recta AB
            for (int j = 0; j < n; j++) {
                double dist = calcularDistanciaPuntoARecta(vertices[j], a, b);
                if (dist > maxDistanciaParaEsteLado) {
                    maxDistanciaParaEsteLado = dist;
                }
            }

            // El ancho mínimo necesario será el menor de estos máximos
            if (maxDistanciaParaEsteLado < minimoGlobal) {
                minimoGlobal = maxDistanciaParaEsteLado;
            }
        }

        // Imprimir el resultado con la precisión requerida por el problema
        System.out.printf(java.util.Locale.UK, "%.8f\n", minimoGlobal);
    }

    /**
     * Calcula la distancia perpendicular desde un punto C a la recta que pasa por A y B.
     * Utiliza la fórmula del producto cruz (área del paralelogramo) dividida por la base.
     */
    private static double calcularDistanciaPuntoARecta(Point c, Point a, Point b) {
        // Numerador: |(Bx - Ax)(Ay - Cy) - (Ax - Cx)(By - Ay)|
        double numerador = Math.abs((b.x - a.x) * (a.y - c.y) - (a.x - c.x) * (b.y - a.y));

        // Denominador: Longitud del segmento AB (la base)
        double denominador = Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y));

        return numerador / denominador;
    }
}