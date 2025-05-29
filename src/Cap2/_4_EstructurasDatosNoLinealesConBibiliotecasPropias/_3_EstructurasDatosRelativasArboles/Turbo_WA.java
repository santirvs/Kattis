package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._3_EstructurasDatosRelativasArboles;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

//  v1.  Parece fácil si se usa un FenwickTree
//       Usar un vector para saber la posición del número
//       Cada vez que se trata un número, eliminarlo del FT


public class Turbo_WA {

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

    static class FenwickTree {
        //Array del acumulador de frecuencias
        private int[] sums;
        //Tamaño
        private int size;

        //Devuelve el 1 menos significativo del número pasado por parámetro
        // Less Significant One
        public int LSOne(int i) {
            return i & -i;
        }

        //Constructor segun el tamaño estimado
        public FenwickTree(int size) {
            this.size = size;
            this.sums = new int[size + 1];
        }

        //Actualización de los nodos del árbol
        public void update(int i, int value) {
            while (i <= size) {
                sums[i] += value;
                i += i & -i;
            }
        }

        //Suma los nodos del árbol
        public int sum(int i) {
            int s = 0;
            while (i > 0) {
                s += sums[i];
                i -= i & -i;
            }
            return s;
        }
    }

    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        Reader sc = new Reader();
        int nums = sc.nextInt(); // Cantidad de números

        //Creamos el árbol de Fenwick de tamaño numBits inicializado a 0
        FenwickTree ft = new FenwickTree(nums);
        int[] posicion = new int[nums + 1];

        //Lectura del vector inicial y actualización del FT
        for (int i=1; i<=nums; i++) {
            int num = sc.nextInt();
            posicion[i] = num;
            ft.update(num, 1);
        }

        //Ordenación de los números de 1 a N
        for (int i=1; i<=nums; i++) {

            int pos;
            int numCambios = 0;
            if (i%2==0) {
                //Pares, se colocan al final
                pos = posicion[nums-(i/2)+1];
                ft.update(pos, -1);
                numCambios = ft.sum(nums-(i/2)+1) - ft.sum(pos);
            }
            else {
                //Impares, se colocan al inicio
                pos = posicion[(i/2)+1];
                ft.update(pos,-1);
                numCambios = ft.sum(pos);
            }
            System.out.println(numCambios);
        }

        sc.close();
    }
}
