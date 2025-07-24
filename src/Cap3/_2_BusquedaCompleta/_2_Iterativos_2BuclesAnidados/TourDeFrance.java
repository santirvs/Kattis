package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;

// Ejercicio de fuerza bruta
// Calcular todas las relaciones posibles entre platos y piñones
// Ordenar las relaciones
// Calcular el spread entre 2 relaciones consecutivas y quedarnos con la máxima

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TourDeFrance {

    static class Reader {
        final private int BUFFER_SIZE = 1 << 20;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
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

        public long nextLong() throws IOException {
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

        public double nextDouble() throws IOException {
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

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }


    public static void main(String[] args) throws IOException {
        Reader scan = new Reader(); // Usamos el lector personalizado para mejorar la velocidad de lectura

        //Leer cantidad de platos y piñones
        int numPlatos = scan.nextInt();

        while (numPlatos > 0) {
            int numPinyones = scan.nextInt();

            //Leer platos
            int[] platosArray = new int[numPlatos];
            for (int i = 0; i < numPlatos; i++) {
                platosArray[i] = scan.nextInt();
            }
            //Leer piñones
            int[] pinyonesArray = new int[numPinyones];
            for (int i = 0; i < numPinyones; i++) {
                pinyonesArray[i] = scan.nextInt();
            }
            //Calcular todas las relaciones posibles
            double relaciones[] = new double[numPlatos * numPinyones];
            for (int i = 0; i < numPlatos; i++) {
                for (int j = 0; j < numPinyones; j++) {
                    relaciones[i * numPinyones + j] = ((double) platosArray[i]) / pinyonesArray[j];
                }
            }

            //Ordenar las relaciones
            java.util.Arrays.sort(relaciones);

            //Calcular el spread entre 2 relaciones consecutivas y quedarnos con la máxima
            double maxSpread = 0;
            for (int i = 1; i < relaciones.length; i++) {
                double spread = relaciones[i] / relaciones[i - 1];
                if (spread > maxSpread) {
                    maxSpread = spread;
                }
            }

            //Imprimir el resultado
            System.out.printf("%.2f\n", maxSpread);

            //Leer el número de platos para la siguiente iteración
            numPlatos = scan.nextInt();
        }
    }
}

