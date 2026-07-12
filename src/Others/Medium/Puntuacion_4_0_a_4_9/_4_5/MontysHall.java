package Others.Medium.Puntuacion_4_0_a_4_9._4_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MontysHall {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                StringTokenizer st = new StringTokenizer(line);
                if (!st.hasMoreTokens()) continue;

                double d = Double.parseDouble(st.nextToken());
                double s = Double.parseDouble(st.nextToken());
                double e = Double.parseDouble(st.nextToken());

                double resultado;

                // Condición para ver si nos alcanzan las elecciones para el grupo nuevo
                if (s >= (d - s - e)) {
                    // Caso 1: Fórmula corregida y ultra simplificada
                    resultado = (s + e) / d;
                } else {
                    // Caso 2: Esta fórmula sí estaba perfecta
                    resultado = (s * (d - s)) / (d * (d - s - e));
                }

                System.out.printf("%.6f\n", resultado);
            }
        } catch (Exception ex) {
            System.exit(0);
        }
    }


}