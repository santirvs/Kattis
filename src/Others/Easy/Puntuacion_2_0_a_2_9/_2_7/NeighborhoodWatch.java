package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

/*
    Calcular el total de caminos y restar los inseguros
    Los inseguros son todos aquellos caminos que se realicen entre dos puntos de vigilancia
 */

import java.io.IOException;
import java.io.InputStream;

public class NeighborhoodWatch {

    static class FR_Int {
        private InputStream in = System.in;
        private byte[] buffer = new byte[1 << 16];
        private int head = 0;
        private int tail = 0;

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = in.read(buffer, 0, buffer.length);
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }

        public int nextInt() throws IOException {
            int c = read();
            while (c != -1 && c <= 32) {
                c = read();
            }
            if (c == -1) return -1;
            boolean negativo = false;
            if (c == '-') {
                negativo = true;
                c = read();
            }
            int res = 0;
            while (c > 32) {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res;
        }
    }

    public static void main(String[] args) throws IOException {
        FR_Int sc = new FR_Int();

        // N y M pueden leerse como int porque caben perfectamente (hasta 200,000)
        long numCasas = sc.nextInt();
        int numVigilantes = sc.nextInt();

        // 1. Calcular el total de caminos usando aritmética 'long' para evitar desbordamiento
        long totalCaminos = numCasas * (numCasas + 1) / 2;

        // 2. Restar los caminos inseguros
        long ultimoVigilante = 0; // Usar base 0 simplifica mucho la matemática de intervalos

        for (int i = 0; i < numVigilantes; i++) {
            long posicionVigilante = sc.nextInt();

            // Cantidad de casas vacías entre el último vigilante y el actual
            long casasInseguras = posicionVigilante - ultimoVigilante - 1;

            if (casasInseguras > 0) {
                long combinacionesInseguras = casasInseguras * (casasInseguras + 1) / 2;
                totalCaminos -= combinacionesInseguras;
            }

            ultimoVigilante = posicionVigilante;
        }

        // 3. Último tramo: desde el último vigilante registrado hasta el final de la calle (N)
        long casasInsegurasFinal = numCasas - ultimoVigilante;
        if (casasInsegurasFinal > 0) {
            long combinacionesInsegurasFinal = casasInsegurasFinal * (casasInsegurasFinal + 1) / 2;
            totalCaminos -= combinacionesInsegurasFinal;
        }

        // Mostrar el resultado definitivo
        System.out.println(totalCaminos);
    }
}