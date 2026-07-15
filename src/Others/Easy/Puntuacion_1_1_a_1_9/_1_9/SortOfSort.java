package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Tomar el primer elemento, éste siempre forma parte de la lista final.
 * Leer el siguiente elemento,
 *    si es menor que el maximo visto, se descarta
 *    si es igual o mayor, se incluye
 * Ojo, 100.000 entradas --> FastReader
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SortOfSort {

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

        int cantidad = sc.nextInt();

        //Leer y mostrar el primer número
        int maximoVisto = sc.nextInt();
        System.out.print(maximoVisto);

        //Leer el resto de numeros
        cantidad--;
        while (cantidad-- > 0) {
            int numero = sc.nextInt();

            if (numero >= maximoVisto) {
                System.out.print(" " + numero);
                maximoVisto = numero;
            }

        }

        System.out.println();

    }
}