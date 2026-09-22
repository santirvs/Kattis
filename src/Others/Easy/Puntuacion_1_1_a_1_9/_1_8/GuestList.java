package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

/**
 * Usar un HashSet para gestionar la lista
 * Como pueden haber hasta 200.000 entradas, usar un FastReader
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;


public class GuestList {

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

        FR sc = new FR();

        int numEntradas = sc.nextInt();
        HashSet<String> invitados = new HashSet<>();

        while (numEntradas-- > 0) {
            String[] linea = sc.nextLine().split(" ");

            String comando = linea[0];
            String nombre = linea[1];

            if (comando.equals("+")) {
                invitados.add(nombre);
            } else if (comando.equals("-")) {
                invitados.remove(nombre);
            } else {
                if (invitados.contains(nombre)) System.out.println("Jebb");
                else System.out.println("Neibb");
            }



        }

    }
}

