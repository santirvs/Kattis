package Others.Easy.Puntuacion_3_0_a_3_9._3_5;


// Ver GoodCoalition.md

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

public class GoodCoalition {

    public static void main(String[] args) throws IOException {
        // Aseguramos el formato de punto flotante con '.' en lugar de ','
        Locale.setDefault(Locale.US);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        if (line == null) return;

        // Usamos StringTokenizer global para leer tokens continuamente,
        // simulando exactamente el comportamiento de "cin >>" en C++
        StringTokenizer st = new StringTokenizer(line);

        // Si la primera línea está vacía, seguimos buscando el primer token
        while (!st.hasMoreTokens()) {
            line = br.readLine();
            if (line == null) return;
            st = new StringTokenizer(line);
        }

        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            while (!st.hasMoreTokens()) {
                line = br.readLine();
                st = new StringTokenizer(line);
            }
            int n = Integer.parseInt(st.nextToken());

            int[] p = new int[n];
            int[] s = new int[n];

            for (int i = 0; i < n; i++) {
                while (!st.hasMoreTokens()) {
                    line = br.readLine();
                    st = new StringTokenizer(line);
                }
                s[i] = Integer.parseInt(st.nextToken());
                p[i] = Integer.parseInt(st.nextToken());
            }

            // double sol[151]; memset(sol,0,sizeof(sol));
            // En Java, los arreglos de tipo primitivo double ya nacen inicializados en 0.0
            double[] sol = new double[151];
            sol[0] = 1.0;

            for (int i = 0; i < n; i++) {
                for (int ss = 150; ss >= s[i]; ss--) {
                    double posible = (p[i] / 100.0) * sol[ss - s[i]];
                    if (posible > sol[ss]) {
                        sol[ss] = posible;
                    }
                }
            }

            double best = 0.0;
            for (int ss = 76; ss < 151; ss++) {
                if (sol[ss] > best) {
                    best = sol[ss];
                }
            }

            best *= 100.0;

            // Usamos %.6f que equivale al %.6lf de C++ para cumplir con la precisión de 10^-6
            System.out.printf("%.6f\n", best);
        }
    }
}