package Others.Easy.Puntuacion_2_0_a_2_9._2_2;

/**
 * Tener un primer HashSet de frases únicas
 * Si ya existe, se elimina de ese HashSet y se pasa a una de frases repetidas
 * Añadimos una frase única si no existe ni en el primer ni el segundo
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class KorokPhrases {


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

        int cantidad = sc.nextInt();
        //sc.nextLine();

        HashSet<String> unicas = new HashSet<>();
        HashSet<String> repetidas = new HashSet<>();

        for (int i=0; i<cantidad; i++) {
            String s = sc.nextLine();

            if (unicas.contains(s) || repetidas.contains(s)) {
                //ignorar
            } else if (unicas.contains(s)) {
                unicas.remove(s);
                repetidas.add(s);
            } else {
                unicas.add(s);
            }

        }

        //Muestra la cantidad de frases únicas
        System.out.println(unicas.size());

    }
}
