package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._3_EstructurasDatosRelativasArboles;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import java.util.*;

//  v1.  TLE  --> Faig servir el reader


public class MovieCollection {

    static class Reader {
        final private int BUFFER_SIZE = 1 << 20;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    // Estructura BIT (Fenwick Tree) emmagatzemada com a ArrayList
    static ArrayList<Integer> st = new ArrayList<>();

    // Calcula el "Least Significant Bit" d'un número
    static int LSB(int i) {
        return i & -i;
    }

    // Suma prefixada fins a la posició i (inclusiva)
    static int sum(int i) {
        int res = 0;
        while (i > 0) {
            res += st.get(i);
            i -= LSB(i); // Ens movem cap enrere pel BIT
        }
        return res;
    }

    // Afegeix valor v a la posició i del BIT
    static void add(int i, int v) {
        while (i < st.size()) {
            st.set(i, st.get(i) + v); // Suma v a la posició actual
            i += LSB(i);              // Ens movem cap endavant pel BIT
        }
    }

    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        Reader sc = new Reader();
        int numCasos = sc.nextInt(); // Nombre de casos de prova

        while (numCasos-- > 0) {
            int numElements = sc.nextInt(); // Nombre d'elements inicials a la pila
            int numConsultes = sc.nextInt(); // Nombre de consultes (accions de moure al front)

            // Inicialitzem el BIT amb m + r + 1 posicions (més un extra per seguretat)
            st = new ArrayList<>(Collections.nCopies(numElements + numConsultes + 2, 0));
            int[] T = new int[numElements]; // Array per guardar les posicions actuals dels elements

            // Inicialitzem el BIT amb els m elements
            for (int i = 0; i < numElements; ++i) {
                T[i] = i + numConsultes + 1; // Assignem a cada element una posició al final
                add(T[i], 1);     // L’afegim al BIT
            }

            // Processem les r consultes
            for (int i = 0; i < numConsultes; ++i) {
                int k = sc.nextInt() - 1; // Llegim l’element a moure (0-based)

                // Mostrem quants elements hi ha davant seu (sumatori fins a la seva posició - 1)
                System.out.print((sum(T[k]) - 1) + " ");

                // L’eliminem de la seva posició actual
                add(T[k], -1);

                // El movem al front, a una nova posició que decreix amb cada pas
                T[k] = numConsultes - i;

                // L’afegim a la nova posició
                add(T[k], 1);
            }

            // Salt de línia després de cada cas de prova
            System.out.println();
        }

        sc.close();
    }
}
