package Others.Easy.Puntuacion_2_0_a_2_9._2_5;


/*
    Leer los jugadores y ponerlos en una lista enlazada
    Leer los juguetes y sus tiempos
    Asignar el primer juguete al jugador 1 y calcular quien se elimina  (numPases % longitudLista)
    - sacarlo de la lista
    - asignar el siguiente juguete al siguiente jugador
    hasta que sólo que quede un jugador
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HotPotatoeEasierVersion {


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

        FR scan = new FR();

        int numJugadores = scan.nextInt();
        int numJuguetes = scan.nextInt();

        //Leer los jugadores
        LinkedList<String> jugadores = new LinkedList<>();
        for (int i=0; i<numJugadores; i++) {
            jugadores.addLast(scan.next());
        }

        //Leer los juguetes
        int[] juguetes = new int[numJuguetes];
        for (int i=0; i<numJuguetes; i++) {
            juguetes[i] = scan.nextInt();
        }

        //Empieza el juego!
        int jugadorActual = 0;
        int jugueteActual = 0;
        while (jugadores.size() > 1) {
            int valorJuguete = juguetes[jugueteActual];
            jugadorActual = (jugadorActual + valorJuguete) % jugadores.size() ;
            jugadores.remove(jugadorActual);
            jugadorActual = jugadorActual % jugadores.size();
            jugueteActual = (jugueteActual +1) % numJuguetes;
        }

        //Mostrar el último jugador que quede en la lista
        System.out.println(jugadores.get(0));

    }
}
