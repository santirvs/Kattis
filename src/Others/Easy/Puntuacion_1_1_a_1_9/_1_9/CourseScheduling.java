package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Guardar la información en un Diccionario <String -> List<String>
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class CourseScheduling {

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
        FR sc = new FR();  //100.000 entradas!!  Fast Reader!

        TreeMap<String, Set<String>> peticiones = new TreeMap<>();

        int numPeticiones = sc.nextInt();

        while (numPeticiones-- > 0) {
            String nombre = sc.next();
            String apellido = sc.next();
            String curso = sc.next();

            if (peticiones.containsKey(curso)) {
                peticiones.get(curso).add(nombre + " " + apellido);
            } else {
                Set<String> lista = new HashSet<>();
                lista.add(nombre + " " + apellido);
                peticiones.put(curso, lista);
            }
        }


        //Recorrer el diccionario de peticiones en orden alfabético
        for (String curso : peticiones.keySet()) {
            System.out.println(curso + " " + peticiones.get(curso).size());
        }


    }
}