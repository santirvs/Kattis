package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * Usar un TreeMap<String, X> para gestionar cada ruta
 * X debe tener un contador de frecuencias de puntos de anclaje
 * que se implementará con un Map<Int, Int>
 *
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class ClimbingFall {


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


    public static class Ruta {
        String nombre;
        HashMap<Integer, Integer> caidas = new HashMap<Integer, Integer>();

        Ruta (String nombre) {
            this.nombre = nombre;
        }

        public int maxCaidas() {
            int max = 0;
            int puntoMax = Integer.MAX_VALUE;
            for (Integer k : caidas.keySet()) {
                if (max < caidas.get(k)) {
                    puntoMax = k;
                    max = caidas.get(k);
                } else if (max == caidas.get(k)) {
                    puntoMax = Math.min(puntoMax, k);
                }
            }
            return puntoMax;
        }
    }



    public static void main(String[] args) throws IOException {
        FR sc = new FR();

        int numRutas = sc.nextInt();
        TreeMap<String, Ruta> apuntes = new TreeMap<>();

        for (int i=0; i<numRutas; i++) {
            String nomRuta = sc.next();
            int numPunto = sc.nextInt();
            Ruta r;

            //Gestionar si la ruta ya está en el diccionario, sinó se añade
            if (apuntes.containsKey(nomRuta)) {
                r=apuntes.get(nomRuta);
            } else {
                r = new Ruta(nomRuta);
                apuntes.put(nomRuta, r);
            }

            //Gestionar el contador de frecuencias de la ruta
            if (r.caidas.containsKey(numPunto)) {
               r.caidas.put( numPunto, r.caidas.get(numPunto)+1 );
            } else {
                r.caidas.put( numPunto, 1);
            }
        }

        //Recorrer todas las rutas
        for (String k :  apuntes.keySet()) {
            //Imprimir clave
            System.out.print(k + " ");
            //Recuperar Ruta asociada a la clave
            Ruta r = apuntes.get(k);
            //Mostrar el primer valor
            System.out.println(r.maxCaidas());
        }



    }
}

