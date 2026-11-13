package Others.Easy.Puntuacion_2_0_a_2_9._2_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;

public class DiscDistrict {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        String line = br.readLine();
        if (line != null && !line.trim().isEmpty()) {
            long r = Long.parseLong(line.trim());
            long r2 = r * r;

            // Buscamos el menor incremento d >= 1 tal que r^2 + d sea la suma de dos cuadrados (x^2 + y^2)
            // Estadísticamente, d es casi siempre 1 o un número muy pequeño, por lo que el bucle es O(1).
            for (long d = 1; ; d++) {
                long N = r2 + d;
                long startX = (long) Math.sqrt(N / 2);
                long limitX = (long) Math.sqrt(N);

                // Exploramos x desde el punto medio hacia arriba para encontrar la combinación válida
                for (long x = startX; x <= limitX; x++) {
                    long rem = N - x * x;
                    long y = (long) Math.round(Math.sqrt(rem));

                    if (y * y == rem && x >= 1 && y >= 1) {
                        out.println(x + " " + y);
                        out.flush();
                        return;
                    }
                }
            }
        }

        out.flush();
    }
}