package Others.Easy.Puntuacion_2_0_a_2_9._2_2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Watchdog {

    // Clase auxiliar para almacenar las coordenadas (x, y) de las trampillas
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // Leemos el número de casos de prueba
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            while (st == null || !st.hasMoreTokens()) {
                String l = br.readLine();
                if (l == null) break;
                st = new StringTokenizer(l);
            }
            if (!st.hasMoreTokens()) break;

            int s = Integer.parseInt(st.nextToken()); // Tamaño del tejado (s x s)
            int h = Integer.parseInt(st.nextToken()); // Número de trampillas

            Point[] hatches = new Point[h];
            boolean[][] isHatch = new boolean[s + 1][s + 1]; // Para búsqueda rápida O(1) de trampillas

            for (int i = 0; i < h; i++) {
                while (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                int hx = Integer.parseInt(st.nextToken());
                int hy = Integer.parseInt(st.nextToken());
                hatches[i] = new Point(hx, hy);
                isHatch[hx][hy] = true;
            }

            int bestX = -1;
            int bestY = -1;
            boolean found = false;

            // 1. Explorar todos los puntos de anclaje (X, Y) posibles con coordenadas enteras
            // El problema indica que las coordenadas van desde 0 hasta s.
            // Para satisfacer la condición de "menor X y luego menor Y", recorremos X e Y de menor a mayor.
            for (int x = 0; x <= s; x++) {
                for (int y = 0; y <= s; y++) {

                    // 2. Restricción: Un leash no se puede anclar donde hay una trampilla
                    if (isHatch[x][y]) {
                        continue;
                    }

                    // 3. Calcular la distancia máxima al cuadrado necesaria para alcanzar todas las trampillas
                    long maxDistSq = 0;
                    for (int i = 0; i < h; i++) {
                        long dx = x - hatches[i].x;
                        long dy = y - hatches[i].y;
                        long distSq = dx * dx + dy * dy;
                        if (distSq > maxDistSq) {
                            maxDistSq = distSq;
                        }
                    }

                    // 4. Validar que la correa de longitud L (donde L^2 = maxDistSq)
                    // no se extienda más allá del borde del tejado (0 a s).
                    // Esto significa que el punto (x, y) debe estar a una distancia de
                    // al menos L de los cuatro bordes: x >= L, s-x >= L, y >= L, s-y >= L.
                    // Elevando al cuadrado: x^2 >= maxDistSq, (s-x)^2 >= maxDistSq, etc.
                    boolean valid = true;

                    if ((long) x * x < maxDistSq) valid = false;
                    else if ((long) (s - x) * (s - x) < maxDistSq) valid = false;
                    else if ((long) y * y < maxDistSq) valid = false;
                    else if ((long) (s - y) * (s - y) < maxDistSq) valid = false;

                    // 5. Selección de la solución óptima
                    // Como recorremos X de 0 a s y Y de 0 a s en orden ascendente,
                    // el primer punto válido que encontremos será automáticamente el que tenga
                    // la menor X (y menor Y en caso de empate con el mismo bucle exterior).
                    if (valid) {
                        bestX = x;
                        bestY = y;
                        found = true;
                        break; // Encontramos la mejor solución para este caso de prueba
                    }
                }
                if (found) {
                    break;
                }
            }

            // 6. Imprimir el resultado requerido
            if (found) {
                System.out.println(bestX + " " + bestY);
            } else {
                System.out.println("poodle");
            }
        }
    }
}