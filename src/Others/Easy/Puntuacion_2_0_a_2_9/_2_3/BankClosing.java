package Others.Easy.Puntuacion_2_0_a_2_9._2_3;


/*
    Apoyarnos en una cola con prioridad para atender las solicitudes
 */

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class BankClosing {

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

    static class Persona implements Comparable<Persona> {
        int instante;
        int colaOriginal;

        Persona(int instante, int colaOriginal) {
            this.colaOriginal = colaOriginal;
            this.instante = instante;
        }


        @Override
        public int compareTo(Persona o) {
            int result = Integer.compare(this.instante,o.instante);
            if (result == 0) return -1;
            else return result;
        }
    }


    public static void main(String[] args) throws IOException {
        //Como pueden haber hasta 100.000 lecturas y escrituras, usar un FR / PrintWriter
        FR fr = new FR();
        //PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));


        int numClientes = fr.nextInt();
        int numCues = fr.nextInt();
        PriorityQueue<Persona> pq = new PriorityQueue<>();

        //Càrrega inicial de la cua
        for (int i = 0; i < numCues; i++) {
            pq.add(new Persona(fr.nextInt(), i+1  ) );
        }

        int ultimaCola = 0;
        if (pq.isEmpty()) out.println("DONE");
        else {
            ultimaCola = pq.poll().colaOriginal;
            out.println(ultimaCola);
        }

        int numCuesBuidades=0;

        for (int i=numCues; i<=numClientes && numCuesBuidades<numCues; ) {


            //Leer el valor
            String valor = fr.next();
            if (!valor.equals("DONE")) {
                pq.add(new Persona(Integer.parseInt(valor), ultimaCola  ) );
                i++;
            } else {
                numCuesBuidades++;
                //Hay que salir?
                if (numCuesBuidades == numCues) {
                    out.println("DONE");
                    break;
                }
            }

            //Mostrar el siguiente cliente a pasar a la cola única
            ultimaCola = pq.poll().colaOriginal;
            out.println(ultimaCola);
        }

    }
}
