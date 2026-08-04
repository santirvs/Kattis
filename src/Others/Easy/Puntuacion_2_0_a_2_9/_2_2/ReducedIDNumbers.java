package Others.Easy.Puntuacion_2_0_a_2_9._2_2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ReducedIDNumbers {

    public static void main(String[] args) throws IOException {
        // Usamos BufferedReader para una lectura rápida de la entrada
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        if (line == null || line.trim().isEmpty()) {
            return;
        }

        // 1. Lectura de N (número de estudiantes en el grupo)
        int g = Integer.parseInt(line.trim());
        int[] sins = new int[g];

        // 2. Almacenamiento de los SINs
        for (int i = 0; i < g; i++) {
            sins[i] = Integer.parseInt(br.readLine().trim());
        }

        // 3. Planteamiento y Búsqueda del módulo m:
        // Cota inferior: Para alojar 'g' elementos distintos sin colisión,
        // necesitamos como mínimo m >= g.
        int m = g;

        while (true) {
            if (esModuloValido(m, sins)) {
                // Como probamos desde m = g hacia arriba,
                // el primer m válido es garantizado como el mínimo.
                System.out.println(m);
                break;
            }
            m++;
        }
    }

    /**
     * Verifica si un valor 'm' produce residuos únicos para todos los SINs.
     */
    private static boolean esModuloValido(int m, int[] sins) {
        // Arreglo booleano para marcar residuos ya vistos.
        // En Java 1.7 los valores por defecto de boolean[] son 'false'.
        boolean[] visto = new boolean[m];

        for (int i = 0; i < sins.length; i++) {
            int residuo = sins[i] % m;

            // Si el residuo ya apareció previamente para otro SIN, hay colisión.
            if (visto[residuo]) {
                return false;
            }

            visto[residuo] = true;
        }

        // Si procesamos todos los SINs sin colisiones, m es válido.
        return true;
    }
}