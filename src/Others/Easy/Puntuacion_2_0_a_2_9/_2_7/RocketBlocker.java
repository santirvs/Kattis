package Others.Easy.Puntuacion_2_0_a_2_9._2_7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RocketBlocker {

    static class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        String rToken = sc.next();
        if (rToken == null) {
            out.flush();
            return;
        }

        // r: radio del cohete en centímetros
        double r = Double.parseDouble(rToken);

        // n: número de vértices del polígono convexo (la roca)
        int n = sc.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        // Coordenadas (x_i, y_i) en centímetros desde el centro de la zona de aterrizaje
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();
        }

        // Acumulamos el doble del área con signo (shoelace formula) y el perímetro
        // del polígono convexo en un único recorrido sobre las n aristas.
        double twiceSignedArea = 0.0;
        double perimeter = 0.0;

        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;

            // Producto cruzado 2D para el área del polígono
            twiceSignedArea += x[i] * y[next] - x[next] * y[i];

            // Longitud de la arista i -> next usando Math.hypot para mayor estabilidad numérica
            double dx = x[next] - x[i];
            double dy = y[next] - y[i];
            perimeter += Math.hypot(dx, dy);
        }

        // 1. Área interior del polígono convexo
        double polygonArea = 0.5 * Math.abs(twiceSignedArea);

        // 2. Área de los rectángulos exteriores de ancho r adosados a cada lado:
        //    cada lado de longitud L_i genera un rectángulo de área r * L_i.
        double rectanglesArea = r * perimeter;

        // 3. Área de los sectores circulares en cada vértice:
        //    la suma de los ángulos exteriores de un polígono convexo simple es 2*pi,
        //    por lo que los sectores de radio r equivalen a un círculo completo de área pi * r^2.
        double sectorsArea = Math.PI * r * r;

        // Área total donde si cae el centro del cohete (disco de radio r),
        // el cohete tocará la roca. Como los vértices están al menos a distancia r
        // del borde del cuadrado de 1000x1000 cm, toda esta región queda dentro.
        double dangerArea = polygonArea + rectanglesArea + sectorsArea;

        // El área total de aterrizaje es 1000 cm * 1000 cm = 1,000,000 cm^2
        double totalSiteArea = 1000.0 * 1000.0;
        double probability = dangerArea / totalSiteArea;

        out.printf(java.util.Locale.US, "%.17f%n", probability);
        out.flush();
    }
}