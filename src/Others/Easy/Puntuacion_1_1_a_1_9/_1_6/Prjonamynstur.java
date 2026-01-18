package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * v1 : Leer el número de filas y columnas de una matriz
 *      Analizar caracter a caracter el coste de cada elemento.
 *      Acumular los costes
 *      Mostrar el coste total
 *      RTE en casos 16 y 28
 *
 * v2 : Se ha quitado el Reader ya que en la primera línea había 2 enteros y se saltaba una línea de datos
 *      Se ha usado el Scanner
 *      AC!
 */


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class Prjonamynstur {

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

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);
        //Reader sc = new Reader();

        //Leer los datos
        int numFilas = sc.nextInt();
        int numColumnas = sc.nextInt();  // Se podría ignorar el número de columnas
        sc.nextLine();

        //Leer las filas y analizar cada carácter
        int costeTotal = 0;
        while (numFilas-- > 0) {
            String linea = sc.nextLine();
            for (int i=0; i<numColumnas; i++) {
                switch (linea.charAt(i)) {
                    case '.' : costeTotal+=20; break;
                    case 'O' : costeTotal+=10; break;
                    case '\\': costeTotal+=25; break;
                    case '/': costeTotal+=25; break;
                    case 'A': costeTotal+=35; break;
                    case '^': costeTotal+=5; break;
                    case 'v': costeTotal+=22; break;
                }
            }
        }

        //Mostrar el resultado
        System.out.println(costeTotal);


        sc.close();
    }
}

