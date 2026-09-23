package Others.Easy.Puntuacion_1_1_a_1_9._1_5;


/*
    Ir acumulando goombas y comprobando si tengo los necesarios
    para salir de cada habitación.
    Dado que pueden haber hasta 100.000 entradas, usar FastReader
 */

import java.io.IOException;
import java.io.InputStream;

public class GoombaStacks {

    static class FR_Int {
        private InputStream in = System.in;
        private byte[] buffer = new byte[1 << 16];
        private int head = 0;
        private int tail = 0;

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = in.read(buffer, 0, buffer.length);
                if (tail <= 0) return -1;   // Fin de archivo
            }
            return buffer[head++];
        }

        public int nextInt() throws IOException {
            int c = read();
            // Ignorar espacios en blanco o saltos de línea (ASCII <= 32)
            while (c != -1 && c <= 32) {
                c = read();
            }

            if (c == -1) return -1; // EOF
            boolean negativo = false;
            if (c == '-') {
                negativo = true;
                c = read();
            }
            int res = 0;
            // Construir el número mientras el carácter sea visible (> 32)
            while (c > 32) {
                res = res * 10 + (c - '0');
                c = read();
            }
            return negativo ? -res : res;
        }
    }

    public static void main(String[] args) throws IOException {
        FR_Int sc = new FR_Int();

        int numHabitaciones = sc.nextInt();
        boolean posible = true;
        int cantidad = 0;

        while (numHabitaciones-- > 0) {
            int numGoomba = sc.nextInt();
            int necesarios = sc.nextInt();

            cantidad += numGoomba;
            if (necesarios > cantidad)
                posible = false;
        }

        if (posible) System.out.println("possible");
        else System.out.println("impossible");
    }
}
