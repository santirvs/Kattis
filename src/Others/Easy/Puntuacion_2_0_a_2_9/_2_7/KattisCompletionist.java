package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

/*
    Leer la puntuación de los problemas, ordenarlos e ir sumando puntos hasta alcanzar
    la cantidad de puntos necesaria diaria.
    Ojo a la suma de double!!!  (el 3r caso de prueba)
    Como solo tienen un decimal, lo multiplicamos por 10 y lo tratamos como un integer
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class KattisCompletionist {


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

        //Leer los datos
        int numProblemas = sc.nextInt();
        int puntosDia = (int) (sc.nextDouble() * 10);

        //Leer los puntos
        int[] puntosProblemas = new int[numProblemas];
        for (int i=0; i<numProblemas; i++) {
            puntosProblemas[i] = (int) (sc.nextDouble()*10);
        }
        //Ordenar de menor a mayor
        Arrays.sort(puntosProblemas);

        //Contar los días necesarios para acabar con todos los problemas
        int numDias = 0;
        int totalPuntos = 0;
        for (int i=0; i<numProblemas; i++) {
            totalPuntos += puntosProblemas[i];
            if (totalPuntos >= puntosDia) {
                numDias++;
                totalPuntos=0;
            }
        }
        if (totalPuntos>0) numDias++;

        System.out.println(numDias);


    }
}