package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Frikada de definición de números ...
 * el siguiente a x es x U { x }
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Neumann {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        if (line == null || line.trim().isEmpty()) {
            return;
        }

        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());

        // Arreglo para almacenar la representación en cadena de cada número de 0 a N
        String[] s = new String[n + 1];
        s[0] = "{}";

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (int j = 0; j < i; j++) {
                if (j > 0) {
                    sb.append(",");
                }
                sb.append(s[j]);
            }
            sb.append("}");
            s[i] = sb.toString();
        }

        System.out.println(s[n]);
    }
}