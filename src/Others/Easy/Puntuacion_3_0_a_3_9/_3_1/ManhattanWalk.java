package Others.Easy.Puntuacion_3_0_a_3_9._3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//  Ver ManhattanWalk.md

public class ManhattanWalk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken()); // Filas
        int C = Integer.parseInt(st.nextToken()); // Columnas
        double W = Double.parseDouble(st.nextToken()); // Tiempo máximo del temporizador

        double[][] dp = new double[R][C];

        // Caso base: Destino final
        dp[R - 1][C - 1] = 0.0;

        // Llenar la última fila (solo se puede ir a la derecha)
        for (int j = C - 2; j >= 0; j--) {
            dp[R - 1][j] = dp[R - 1][j + 1] + (W / 4.0);
        }

        // Llenar la última columna (solo se puede ir hacia abajo)
        for (int i = R - 2; i >= 0; i--) {
            dp[i][C - 1] = dp[i + 1][C - 1] + (W / 4.0);
        }

        // Llenar el resto de la cuadrícula de abajo hacia arriba, de derecha a izquierda
        for (int i = R - 2; i >= 0; i--) {
            for (int j = C - 2; j >= 0; j--) {
                double abajo = dp[i + 1][j];
                double derecha = dp[i][j + 1];

                // Identificar cuál es el camino óptimo (min) y cuál el peor (max)
                double minCamino = Math.min(abajo, derecha);
                double maxCamino = Math.max(abajo, derecha);

                double dif = maxCamino - minCamino;
                double costoLadoMalo;

                if (dif >= W) {
                    // Siempre conviene esperar a que cambie la flecha
                    costoLadoMalo = (W / 2.0) + minCamino;
                } else {
                    // Depende del valor de 't' (se usa la fórmula deducida por integración)
                    costoLadoMalo = maxCamino - (dif * dif) / (2.0 * W);
                }

                // 50% de probabilidad para cada estado inicial de la flecha
                dp[i][j] = 0.5 * minCamino + 0.5 * costoLadoMalo;
            }
        }

        // La respuesta es el valor esperado empezando en (0,0)
        System.out.printf("%.10f\n", dp[0][0]);
    }
}