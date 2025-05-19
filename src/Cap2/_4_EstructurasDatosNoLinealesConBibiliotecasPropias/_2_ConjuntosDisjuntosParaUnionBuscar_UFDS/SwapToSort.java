package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._2_ConjuntosDisjuntosParaUnionBuscar_UFDS;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * El programa usa un algoritmo de unión-búsqueda para determinar si es posible
 * ordenar un arreglo de enteros mediante una serie de intercambios.
 *
 * El programa comienza leyendo dos enteros n y k, donde n es el tamaño del arreglo
 * y k es el número de intercambios permitidos.
 * Luego, inicializa un arreglo P de tamaño n con -1, lo que indica que cada elemento es su propio padre.
 *
 * A continuación, procesa los k intercambios leídos desde la entrada estándar.
 * Para cada intercambio, encuentra las raíces de los dos elementos que se van a intercambiar
 * y une sus componentes si no están ya en la misma.
 *
 * Finalmente, verifica si la primera mitad del arreglo está conectada a la segunda mitad
 * comparando las raíces del primer y último elemento.
 * Si están conectados, imprime "Yes", de lo contrario imprime "No".
 *
 */

// v1. Case#15 TLE --> Cambiar a FastIO -> AC

public class SwapToSort {
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

    static int[] P;

    // Metodo para unir dos conjuntos disjuntos
    static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra != rb) {
            P[rb] = ra;
        }
    }
    // Metodo para encontrar la raíz de un elemento
    static int find(int n) {
        if (P[n] == -1) return n;
        return P[n] = find(P[n]);
    }

    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        // Leer el número de elementos y el número de operaciones
        int n = sc.nextInt();
        int k = sc.nextInt();

        // Crear el UFDS con el número de elementos, inicializados a -1
        P = new int[n];
        for (int i = 0; i < n; i++) {
            P[i] = -1;
        }

        // Procesar los intercambios
        // Leer los pares de elementos a intercambiar
        // y unir sus componentes en el conjunto disjunto
        // usando la función find para encontrar las raíces
        // y la función union para unir los conjuntos
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            union (a,b);
        }

        // Verificar si la primera mitad del arreglo está conectada a la segunda mitad
        // comparando las raíces del primer y último elemento
        // Si están conectados, imprime "Yes", de lo contrario imprime "No"
        boolean f = true;
        int a = 0, b = n - 1;
        while (a < b) {
            if (find(a) != find(b)) {
                f = false;
                break;
            }
            a++;
            b--;
        }

        System.out.println(f ? "Yes" : "No");
    }
}
