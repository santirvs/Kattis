package Others.Medium.Puntuacion_3_0_a_3_9._3_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

public class RoundedButtons {

    public static void main(String[] args) throws IOException {
        // Fast I/O para procesar eficientemente múltiples casos y coordenadas
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int N = Integer.parseInt(line.trim());

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);

            // Leer parámetros del rectángulo redondeado
            double xLeft = Double.parseDouble(st.nextToken());
            double yTop = Double.parseDouble(st.nextToken());
            double w = Double.parseDouble(st.nextToken());
            double h = Double.parseDouble(st.nextToken());
            double r = Double.parseDouble(st.nextToken());

            // Calcular bordes absolutos del rectángulo contenedor
            double xRight = xLeft + w;
            double yBottom = yTop + h;

            // Leer cantidad de clics de mouse
            int numClicks = Integer.parseInt(st.nextToken());

            // Procesar cada par de coordenadas (x, y)
            for (int j = 0; j < numClicks; j++) {
                double x = Double.parseDouble(st.nextToken());
                double y = Double.parseDouble(st.nextToken());

                if (isInside(x, y, xLeft, yTop, xRight, yBottom, r)) {
                    System.out.println("inside");
                } else {
                    System.out.println("outside");
                }
            }

            // Imprimir una línea en blanco entre casos de prueba para separar resultados
            System.out.println();
        }
    }

    /**
     * Determina si un punto (x, y) está dentro del botón redondeado.
     */
    private static boolean isInside(double x, double y, double xLeft, double yTop, double xRight, double yBottom, double r) {
        // PASO 1: Filtro rápido del rectángulo contenedor
        if (x < xLeft || x > xRight || y < yTop || y > yBottom) {
            return false;
        }

        // Tolerancia infinitesimal para absorber imprecisiones del tipo double
        double EPS = 1e-9;
        double rCc = r * r + EPS; // Radio al cuadrado con tolerancia

        // PASO 2 y 3: Identificar zonas de esquinas y validar con Pitágoras

        // Esquina Superior Izquierda
        if (x < xLeft + r && y < yTop + r) {
            double dx = x - (xLeft + r);
            double dy = y - (yTop + r);
            return (dx * dx + dy * dy) <= rCc;
        }

        // Esquina Superior Derecha
        if (x > xRight - r && y < yTop + r) {
            double dx = x - (xRight - r);
            double dy = y - (yTop + r);
            return (dx * dx + dy * dy) <= rCc;
        }

        // Esquina Inferior Izquierda
        if (x < xLeft + r && y > yBottom - r) {
            double dx = x - (xLeft + r);
            double dy = y - (yBottom - r);
            return (dx * dx + dy * dy) <= rCc;
        }

        // Esquina Inferior Derecha
        if (x > xRight - r && y > yBottom - r) {
            double dx = x - (xRight - r);
            double dy = y - (yBottom - r);
            return (dx * dx + dy * dy) <= rCc;
        }

        // Si pasó el rectángulo general y no cayó en la zona exterior de ninguna esquina,
        // significa que el punto está en la "cruz" central del botón.
        return true;
    }
}