package Others.Easy.Puntuacion_2_0_a_2_9._2_7;


//BFS para buscar la casilla donde está la D
//Usa una cola con prioridad, buscando el del camino más corto

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RobotTurtles {

    // Movimientos correspondientes a las 4 direcciones:
    // 0: Arriba, 1: Derecha, 2: Abajo, 3: Izquierda (Sentido horario)
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static final char[] dirChars = {'N', 'E', 'S', 'W'}; // Norte, Este, Sur, Oeste

    // Clase para almacenar los estados en la cola del BFS
    static class Estado {
        int r, c;       // Fila y columna de la tortuga
        int dir;        // Dirección actual (0 a 3)
        int iceMask;    // Máscara de bits de los castillos de hielo activos
        String camino;  // Instrucciones acumuladas hasta este punto

        public Estado(int r, int c, int dir, int iceMask, String camino) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.iceMask = iceMask;
            this.camino = camino;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] tablero = new char[8][8];

        int startR = 7, startC = 0; // T siempre empieza abajo a la izquierda
        int iceCount = 0;
        int[][] iceIds = new int[8][8]; // Guardará el ID de bit (0-9) para cada castillo de hielo

        // Inicializar matriz de IDs de hielo con -1
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                iceIds[i][j] = -1;
            }
        }

        // Leer el tablero de 8x8
        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            if (line == null) return;
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = line.charAt(j);
                if (tablero[i][j] == 'I') {
                    iceIds[i][j] = iceCount;
                    iceCount++;
                }
            }
        }

        // Máscara inicial: todos los bits en 1 representan que los hielos están activos
        int inicialIceMask = (1 << iceCount) - 1;

        // Estructura de visitados: [filas][columnas][direcciones][combinaciones_de_hielo]
        // 8 * 8 * 4 * 1024 = 262,144 booleanos (Uso de memoria mínimo)
        boolean[][][][] visitado = new boolean[8][8][4][1 << iceCount];

        Queue<Estado> cola = new LinkedList<Estado>();

        // Estado inicial: Fila 7, Columna 0, Dirección 1 (Derecha), hielos activos, camino vacío
        cola.add(new Estado(startR, startC, 1, inicialIceMask, ""));
        visitado[startR][startC][1][inicialIceMask] = true;

        String solucion = "no solution";

        while (!cola.isEmpty()) {
            Estado actual = cola.poll();

            // Si llegamos al diamante 'D', ¡éxito! Al ser BFS, es la ruta más corta.
            if (tablero[actual.r][actual.c] == 'D') {
                solucion = actual.camino;
                break;
            }

            // --- 1. ACCIÓN: Girar a la Izquierda (L) ---
            int nDirL = (actual.dir + 3) % 4; // Equivalente a (dir - 1) con módulo positivo
            if (!visitado[actual.r][actual.c][nDirL][actual.iceMask]) {
                visitado[actual.r][actual.c][nDirL][actual.iceMask] = true;
                cola.add(new Estado(actual.r, actual.c, nDirL, actual.iceMask, actual.camino + "L"));
            }

            // --- 2. ACCIÓN: Girar a la Derecha (R) ---
            int nDirR = (actual.dir + 1) % 4;
            if (!visitado[actual.r][actual.c][nDirR][actual.iceMask]) {
                visitado[actual.r][actual.c][nDirR][actual.iceMask] = true;
                cola.add(new Estado(actual.r, actual.c, nDirR, actual.iceMask, actual.camino + "R"));
            }

            // --- 3. ACCIÓN: Avanzar (F) ---
            int nR = actual.r + dr[actual.dir];
            int nC = actual.c + dc[actual.dir];

            // Comprobar límites del tablero
            if (nR >= 0 && nR < 8 && nC >= 0 && nC < 8) {
                char celdaObjetivo = tablero[nR][nC];
                boolean sePuedeCaminar = false;

                if (celdaObjetivo == '.' || celdaObjetivo == 'D' || celdaObjetivo == 'T') {
                    sePuedeCaminar = true;
                } else if (celdaObjetivo == 'I') {
                    // Si es hielo, solo se puede pasar si ya fue derretido (bit en 0)
                    int idHielo = iceIds[nR][nC];
                    if ((actual.iceMask & (1 << idHielo)) == 0) {
                        sePuedeCaminar = true;
                    }
                }

                if (sePuedeCaminar && !visitado[nR][nC][actual.dir][actual.iceMask]) {
                    visitado[nR][nC][actual.dir][actual.iceMask] = true;
                    cola.add(new Estado(nR, nC, actual.dir, actual.iceMask, actual.camino + "F"));
                }
            }

            // --- 4. ACCIÓN: Disparar Láser (X) ---
            int fR = actual.r + dr[actual.dir];
            int fC = actual.c + dc[actual.dir];

            if (fR >= 0 && fR < 8 && fC >= 0 && fC < 8) {
                if (tablero[fR][fC] == 'I') {
                    int idHielo = iceIds[fR][fC];
                    // Solo disparamos si el hielo sigue en pie (bit en 1)
                    if ((actual.iceMask & (1 << idHielo)) != 0) {
                        // Apagamos el bit usando una operación XOR
                        int nuevaMask = actual.iceMask ^ (1 << idHielo);

                        if (!visitado[actual.r][actual.c][actual.dir][nuevaMask]) {
                            visitado[actual.r][actual.c][actual.dir][nuevaMask] = true;
                            cola.add(new Estado(actual.r, actual.c, actual.dir, nuevaMask, actual.camino + "X"));
                        }
                    }
                }
            }
        }

        // Salida del resultado
        System.out.println(solucion);
    }
}