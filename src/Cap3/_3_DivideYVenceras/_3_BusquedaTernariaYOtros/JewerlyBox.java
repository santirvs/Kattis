package Cap3._3_DivideYVenceras._3_BusquedaTernariaYOtros;

// Estrategia de D&C. Búsqueda ternaria y otros

/*
 * Búsqueda ternaria básica
 *
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class JewerlyBox {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        while (cases-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double d1 = Double.parseDouble(st.nextToken());
            double d2 = Double.parseDouble(st.nextToken());

            // Aseguramos que d1 <= d2
            if (d1 > d2) {
                double temp = d1;
                d1 = d2;
                d2 = temp;
            }

            double lo = 0.0;
            double hi = d1 / 2.0;

            // Búsqueda ternaria para maximizar el volumen
            while (hi - lo > 1e-7) {
                double mid1 = (hi - lo) * (1.0 / 3.0) + lo;
                double mid2 = (hi - lo) * (2.0 / 3.0) + lo;

                double ans1 = mid1 * (d1 - 2 * mid1) * (d2 - 2 * mid1);
                double ans2 = mid2 * (d1 - 2 * mid2) * (d2 - 2 * mid2);

                if (ans1 > ans2) {
                    hi = mid2;
                } else {
                    lo = mid1;
                }
            }

            // Imprimir con 9 decimales
            System.out.printf("%.9f%n", lo * (d1 - 2 * lo) * (d2 - 2 * lo));
        }
    }
}
