package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// Ojo con la suma total de los lanzamientos (2^21 requiere BigInteger)  XXX No!!! Se pide la suma de cada caso por separado
// Ojo con las entradas: 10^6 * 10^5  --> FastReader

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Darts {

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

    static FR sc;

    public static void main(String[] args) {

        sc = new FR();

        int numCasos = sc.nextInt();
        //BigInteger puntosTotal = BigInteger.ZERO;

        while (numCasos-- > 0) {
            int puntuacion = puntosTirada();
            System.out.println(puntuacion);

            //puntosTotal = puntosTotal.add(new BigInteger(""+puntuacion));
        }

        //System.out.println(puntosTotal);

    }

    private static int puntosTirada() {
        int numLanzamientos = sc.nextInt();
        int totalPuntos = 0;

        while (numLanzamientos-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int puntos = 0;

            double distanciaRadio = Math.sqrt( x*x + y*y );
            if (distanciaRadio <= 20) puntos = 10;
            else if (distanciaRadio <= 40) puntos = 9;
            else if (distanciaRadio <= 60) puntos = 8;
            else if (distanciaRadio <= 80) puntos = 7;
            else if (distanciaRadio <= 100) puntos = 6;
            else if (distanciaRadio <= 120) puntos = 5;
            else if (distanciaRadio <= 140) puntos = 4;
            else if (distanciaRadio <= 160) puntos = 3;
            else if (distanciaRadio <= 180) puntos = 2;
            else if (distanciaRadio <= 200) puntos = 1;

            //System.out.println("La distancia es " + distanciaRadio + " y da " + puntos + " puntos");
            totalPuntos+=puntos;
        }

        return totalPuntos;
    }
}
