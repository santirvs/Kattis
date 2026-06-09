package Others.Easy.Puntuacion_2_0_a_2_9._2_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HoneycombWalk {

    // 15 pasos máximos (0 a 14). Matriz de 30x30 es suficiente para no salirnos de los límites.
    private static final int MAX_PASOS = 14;
    private static final int TAMANYO = 30;
    private static final int CENTRO = 15;

    // Tabla DP: dp[pasos][x][y]
    private static final int[][][] dp = new int[MAX_PASOS + 1][TAMANYO][TAMANYO];

    // Los 6 movimientos posibles en coordenadas axiales
    private static final int[] dx = {1, 0, -1, -1, 0, 1};
    private static final int[] dy = {0, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        // Precomputamos todos los caminos posibles antes de leer los casos de prueba
        precompute();

        // Usamos BufferedReader para una lectura rápida de los casos de prueba
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int testCases = Integer.parseInt(line.trim());

        for (int t = 0; t < testCases; t++) {
            line = br.readLine();
            if (line == null) break;
            int n = Integer.parseInt(line.trim());

            // La respuesta es el número de caminos que tras 'n' pasos terminan en el centro
            System.out.println(dp[n][CENTRO][CENTRO]);
        }
    }

    private static void precompute() {
        // Caso base: Con 0 pasos, hay exactamente 1 forma de estar en el origen
        dp[0][CENTRO][CENTRO] = 1;

        // Llenamos la tabla paso a paso, con un máximo de MAX_PASOS (14)
        for (int step = 1; step <= MAX_PASOS; step++) {
            //Busca cuadrática para el array de TAMANYO*TAMANYO.
            // Al ser TAMANYO = 30, su cuadrado es 900: aceptable!
            for (int x = 1; x < TAMANYO - 1; x++) {
                for (int y = 1; y < TAMANYO - 1; y++) {

                    // Si en el paso anterior había caminos para llegar a (x, y)...
                    if (dp[step - 1][x][y] > 0) {

                        // ...distribuimos esos caminos a sus 6 vecinos en el paso actual
                        for (int i = 0; i < 6; i++) {
                            int nx = x + dx[i];
                            int ny = y + dy[i];

                            // Puedo llegar a nx,xy en step pasos de tantas formas diferentes como
                            // puedo llegar todas sus x,y en un paso menos.
                            dp[step][nx][ny] += dp[step - 1][x][y];
                        }
                    }

                }
            }
        }
    }
}