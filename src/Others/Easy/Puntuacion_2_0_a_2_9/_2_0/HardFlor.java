package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * Aplicar la fórmula de Shoelace
 *
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class HardFlor {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();

            if (line == null || line.trim().isEmpty()) {
                return;
            }

            int n = Integer.parseInt(line.trim());

            // Leemos todos los pares de la siguiente línea
            StringTokenizer st = new StringTokenizer(br.readLine());

            // Arreglos para almacenar las coordenadas x e y de los vértices
            long[] x = new long[n + 1];
            long[] y = new long[n + 1];

            x[0] = 0;
            y[0] = 0;

            long currX = 0;
            long currY = 0;

            for (int i = 0; i < n; i++) {
                String paso = st.nextToken();
                char direccion = paso.charAt(0);
                long distancia = Long.parseLong(paso.substring(1));

                switch (direccion) {
                    case 'N':
                        currY += distancia;
                        break;
                    case 'S':
                        currY -= distancia;
                        break;
                    case 'E':
                        currX += distancia;
                        break;
                    case 'W':
                        currX -= distancia;
                        break;
                }

                x[i + 1] = currX;
                y[i + 1] = currY;
            }

            // Aplicación de la Fórmula de la Lazada (Shoelace Formula)
            long suma = 0;
            for (int i = 0; i < n; i++) {
                suma += (x[i] * y[i + 1]) - (x[i + 1] * y[i]);
            }

            long area = Math.abs(suma) / 2;

            System.out.println("THE AREA IS " + area);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}