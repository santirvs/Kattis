package Others.Easy.Puntuacion_2_0_a_2_9._2_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class AlienSunset {

    // Clase auxiliar para almacenar los datos de cada asentamiento
    static class Settlement {
        long b; // Duración del día solar (período de rotación)
        long r; // Hora de salida del sol (sunrise)
        long s; // Hora de puesta de sol (sunset)

        public Settlement(long b, long r, long s) {
            this.b = b;
            this.r = r;
            this.s = s;
        }

        // Método para verificar si este asentamiento está en oscuridad en el tiempo t
        public boolean isDark(long t) {
            long localTime = t % b;

            // El problema indica:
            // "At sunrise and sunset, a settlement is in darkness."
            // "At times strictly in between sunrise and sunset, a settlement is in daylight."

            if (r < s) {
                // Caso normal: la luz diurna ocurre estrictamente entre r y s (r < localTime < s)
                // Hay oscuridad si el tiempo local está fuera de ese intervalo cerrado [r, s]
                return localTime <= r || localTime >= s;
            } else {
                // Caso donde el período de luz cruza el cambio de ciclo (r > s)
                // La luz ocurre si localTime > r O localTime < s
                // Hay oscuridad si está entre s y r inclusive (s <= localTime <= r)
                return localTime >= s && localTime <= r;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        int n = Integer.parseInt(line.trim());

        Settlement[] settlements = new Settlement[n];
        long maxB = 0;

        for (int i = 0; i < n; i++) {
            while (st == null || !st.hasMoreTokens()) {
                String l = br.readLine();
                if (l == null) break;
                st = new StringTokenizer(l);
            }
            if (!st.hasMoreTokens()) break;

            long b = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            long s = Long.parseLong(st.nextToken());

            settlements[i] = new Settlement(b, r, s);

            // Encontramos el período de rotación máximo para calcular el límite de búsqueda
            if (b > maxB) {
                maxB = b;
            }
        }

        // Límite de tiempo: 1825 días medidos por el planeta con el mayor período de rotación
        long maxLimit = 1825 * maxB;
        long result = -1;

        // Simulamos hora por hora desde t = 0 hasta maxLimit
        for (long t = 0; t <= maxLimit; t++) {
            boolean allDark = true;

            // Verificamos si todos los asentamientos están en oscuridad en el tiempo t
            for (int i = 0; i < n; i++) {
                if (!settlements[i].isDark(t)) {
                    allDark = false;
                    break; // Si al menos uno está en luz, este tiempo no sirve
                }
            }

            if (allDark) {
                result = t;
                break; // Encontramos el primer momento en que todos están en oscuridad
            }
        }

        // Imprimir el resultado requerido
        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("impossible");
        }
    }
}