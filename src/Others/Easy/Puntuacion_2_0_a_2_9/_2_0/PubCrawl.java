package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * Para cada bar, calcular su tiempo de espera en la cola (personas+1)*tiempo
 * Si mejora el tiempo actual, actualizar.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class PubCrawl {
    static class FR {
        BufferedReader br;
        StringTokenizer st;

        public FR() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null; // Manejo de EOF
                    st = new StringTokenizer(line);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        float nextFloat() {
            return Float.parseFloat(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st != null && st.hasMoreElements()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numBares = sc.nextInt();
        String mejorBar = "";
        int mejorTiempo = -1;

        while (numBares-- > 0) {
            String nombreBar = sc.next();
            int numPersonas = sc.nextInt();
            int tiempo = sc.nextInt();
            int totalTiempo = (numPersonas+1)*tiempo;

            //Si supera el tiempo de espera, actualizar el mejor
            if (totalTiempo > mejorTiempo) {
                mejorBar = nombreBar;
                mejorTiempo = totalTiempo;
            }

        }

        //Mostrar el resultado
        System.out.println(mejorBar + " " + mejorTiempo);

    }
}

