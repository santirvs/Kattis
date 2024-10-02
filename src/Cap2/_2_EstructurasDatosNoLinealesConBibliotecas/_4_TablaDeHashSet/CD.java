package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._4_TablaDeHashSet;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

// Usar un HashSet para verificar si ya contiene el CD

// Caso 2: TLE  --> Pruebo con FastIO  -> AC (1.00s)
//

public class CD {

    static class FastIO {
        BufferedReader in;
        PrintWriter out;

        FastIO() {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        int nextInt() throws Exception {
            return Integer.parseInt(in.readLine());
        }

        String nextLine() throws Exception {
            return in.readLine();
        }

        String next() throws Exception {
            StringBuilder s = new StringBuilder();
            while (true) {
                int c = in.read();
                if (Character.isWhitespace(c) || c == -1) {
                    break;
                }
                s.append((char) c);
            }
            return s.toString();
        }

        void print(String s) {
            out.print(s);
            out.flush();
        }

        void print(int i) {
            this.print("" + i);
        }

        void println(String s) {
            out.println(s);
            out.flush();
        }

        void println(int i) {
            this.println("" + i);
        }
    }

    public static void main(String[] args) throws Exception {
        FastIO scan = new FastIO();

        String[] linea = scan.nextLine().split(" ");
        int numCDsJack = Integer.parseInt(linea[0]);
        int numCDsJill = Integer.parseInt(linea[1]);

        while (numCDsJack!=0 || numCDsJill !=0) {

            HashSet<Integer> listaCDs = new HashSet<Integer>();

            for (int i = 0; i < numCDsJack + numCDsJill; i++) {
                int cd = scan.nextInt();
                listaCDs.add(cd);
            }

            System.out.println((numCDsJack + numCDsJill) - listaCDs.size());

            linea = scan.nextLine().split(" ");
            numCDsJack = Integer.parseInt(linea[0]);
            numCDsJill = Integer.parseInt(linea[1]);
        }

    }
}
