package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

// Sumar volumenes y buscar mediante raiz cúbica el lado del cubo que podría contenerlo

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LotsOfLiquid {

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


    public static void main(String[] args) {

        FR sc = new FR();

        // Leer el numero de cubos
        int numCubos = sc.nextInt();
        double volumenTotal = 0;

        for (int i=0; i<numCubos; i++) {
            double lado = sc.nextDouble();
            volumenTotal += lado * lado * lado;
        }

        //Buscar el lado del cubo que pueda contener el volumen total
        System.out.println(Math.pow(volumenTotal, 1.0/3.0));

    }
}

