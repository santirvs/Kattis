package Cap3._3_DivideYVenceras._2_BiseccionBSTAFaciles;

// Estrategia de D&C. Bisección binaria

// El tiempo mínimo requerido es aquel que permite pasar todas las puertas
// Como la velocidad horizontal es constante para cualquier tipo de esquí, podemos buscar cuál es la velocidad vertical máxima
// que permite pasar por todas las puertas.
// Podemos aplicar una búsqueda binaria sobre la velocidad vertical, desde 0 hasta un número máximo
// Para cada velocidad vertical, se calcula si es posible pasar por todas las puertas
// Si es posible, se intenta con una velocidad mayor; si no, se intenta con una velocidad menor.
// Después, buscar el par de esquies más cercano a la velocidad vertical encontrada sin excederla.

// v1. TLE en Caso #7,
// v2. Optimizar Scanner. Usar FastIO ya que hay muchos datos de entrada --> AC

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Slalom2 {

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

        //Scanner scan = new Scanner(System.in);
        Reader scan = new Reader();

        // Leer la distancia horizontal y el número de puertas
        int anchoPuertas = scan.nextInt();
        int velocidadHorizontal = scan.nextInt();
        int numPuertas = scan.nextInt();

        // Leer las posiciones de las puertas
        // Las puertas ya se leen en orden de arriba a abajo
        int[][] posicionesPuertas= new int[numPuertas][2];
        for (int i = 0; i < numPuertas; i++) {
            posicionesPuertas[i][0] = scan.nextInt();
            posicionesPuertas[i][1] = scan.nextInt();
        }

        // Búsqueda binaria para encontrar la velocidad vertical máxima que permite pasar por todas las puertas
        // El rango inicial de posicion horizontal lo marca la puerta 1
        // El rango siguiente de la posicion horizontal lo marca el rango de la puerta anterior más el movimiento vertical posible
        double left = 0; // Mínima velocidad vertical
        double right = 1e6; // Máxima velocidad vertical (un número suficientemente grande)
        double bestVerticalSpeed = 0; // Mejor velocidad vertical encontrada
        for (int iter = 0; iter < 100; iter++) { // 100 iteraciones son suficientes para precisión de enteros
            double hMin = posicionesPuertas[0][0];
            double hMax = posicionesPuertas[0][0] + anchoPuertas;
            double mid = (left + right) / 2.0; // Punto medio de la velocidad vertical a probar
            boolean canPass = true; // Indica si se puede pasar por todas las puertas con la velocidad vertical mid
            for (int i = 1; i < numPuertas; i++) {
                double tiempoEntrePuertas = (posicionesPuertas[i][1]-posicionesPuertas[i-1][1]) / mid; // Tiempo para llegar a la siguiente puerta
                hMin = hMin - tiempoEntrePuertas*velocidadHorizontal; // Actualizar el rango mínimo de la posición horizontal
                hMax = hMax + tiempoEntrePuertas*velocidadHorizontal; // Actualizar el rango máximo de la posición horizontal

                // Verificar si la posición vertical está dentro del rango de la puerta
                if (hMin > posicionesPuertas[i][0]+anchoPuertas || hMax < posicionesPuertas[i][0]) {
                    canPass = false; // No se puede pasar por la puerta i
                    break;
                }

                // Actualizar el rango de la posición horizontal para la siguiente puerta
                hMin = Math.max(hMin, posicionesPuertas[i][0]);
                hMax = Math.min(hMax, posicionesPuertas[i][0] + anchoPuertas);
            }

            if (canPass) {
                bestVerticalSpeed = mid; // Actualizar la mejor velocidad vertical encontrada
                left = mid; // Intentar con una velocidad mayor
            } else {
                right = mid; // Intentar con una velocidad menor
            }
        }

        // Buscar el par de esquíes más cercano a la velocidad vertical encontrada sin excederla
        int numEsquies = scan.nextInt();
        int bestSkiSpeed = 0; // Mejor velocidad de esquí encontrada
        for (int i = 0; i < numEsquies; i++) {
            int skiSpeed = scan.nextInt();
            if (skiSpeed <= bestVerticalSpeed && skiSpeed > bestSkiSpeed) {
                bestSkiSpeed = skiSpeed; // Actualizar la mejor velocidad de esquí encontrada
            }
        }

        // Mostrar la velocidad del par de esquíes más cercano a la velocidad vertical encontrada sin excederla
        if (bestSkiSpeed == 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(bestSkiSpeed);
        }

    }

}

