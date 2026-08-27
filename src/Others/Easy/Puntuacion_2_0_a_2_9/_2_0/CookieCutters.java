package Others.Easy.Puntuacion_2_0_a_2_9._2_0;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CookieCutters {
    public static void main(String[] args) throws IOException {
        // BufferedReader y StringTokenizer para una lectura rápida e interactiva de datos
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        int N = Integer.parseInt(line.trim());

        double[] x = new double[N];
        double[] y = new double[N];

        // 1. Lectura de las coordenadas del polígono original
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Double.parseDouble(st.nextToken());
            y[i] = Double.parseDouble(st.nextToken());
        }

        // 2. Lectura del área objetivo (A)
        double targetArea = Double.parseDouble(br.readLine().trim());

        // 3. Cálculo del área del polígono original mediante la Fórmula del Área de Gauss (Shoelace Formula)
        // La fórmula suma (x_i * y_{i+1} - x_{i+1} * y_i) para todos los vértices consecutivos.
        double originalArea2 = 0.0; // Almacena 2 * Área
        for (int i = 0; i < N; i++) {
            int next = (i + 1) % N;
            originalArea2 += (x[i] * y[next] - x[next] * y[i]);
        }
        double originalArea = Math.abs(originalArea2) / 2.0;

        // 4. Factor de escala (s)
        // Dado que el área de una figura 2D varía con el cuadrado del factor de escala (Área = s^2 * Área_original),
        // el factor lineal s se obtiene mediante la raíz cuadrada de la razón entre el área objetivo y la original.
        double s = Math.sqrt(targetArea / originalArea);

        // 5. Aplicar escalado y buscar los valores mínimos en X e Y
        // Al multiplicar las coordenadas por 's', escalamos la figura manteniendo proporciones y ángulos.
        double[] xScaled = new double[N];
        double[] yScaled = new double[N];

        double minX = Double.POSITIVE_INFINITY;
        double minY = Double.POSITIVE_INFINITY;

        for (int i = 0; i < N; i++) {
            xScaled[i] = x[i] * s;
            yScaled[i] = y[i] * s;

            if (xScaled[i] < minX) {
                minX = xScaled[i];
            }
            if (yScaled[i] < minY) {
                minY = yScaled[i];
            }
        }

        // 6. Traslación al primer cuadrante
        // Restando minX y minY a cada punto, desplazamos el polígono de forma que
        // min(X) = 0 y min(Y) = 0. De este modo, la figura queda apoyada exactamente
        // sobre los ejes X e Y sin salir del primer cuadrante (x >= 0, y >= 0).
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            double finalX = xScaled[i] - minX;
            double finalY = yScaled[i] - minY;

            // Formateamos los resultados con precisión decimal
            sb.append(String.format("%.10f %.10f\n", finalX, finalY));
        }

        // Imprimir el resultado final
        System.out.print(sb.toString());
    }
}