package Others.Easy.Puntuacion_2_0_a_2_9._2_5;

import java.io.InputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;

public class ImageDecoding {

    public static void main(String[] args) throws IOException {
        // Lector rápido personalizado de bytes
        FastReader sc = new FastReader(System.in);
        // Escritor con búfer para agilizar drásticamente la salida
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int numFilas = sc.nextInt();

        while (numFilas > 0) {
            boolean error = false;
            int maxLength = -1;

            for (int fila = 0; fila < numFilas; fila++) {
                // Leemos el carácter inicial sin procesar strings pesados
                char c = sc.nextChar();
                int columna = 0;

                // Leemos y parseamos los enteros de la línea actual de forma directa
                while (true) {
                    int numRepeticiones = sc.nextInt();

                    // En lugar de imprimir uno a uno, escribimos al búfer del PrintWriter
                    for (int pos = 0; pos < numRepeticiones; pos++) {
                        out.print(c);
                        columna++;
                    }

                    // Alternamos el carácter
                    c = (c == '#') ? '.' : '#';

                    // Si el lector detectó un salto de línea tras el número actual,
                    // significa que terminamos de procesar la fila.
                    if (sc.isEndOfLine()) {
                        break;
                    }
                }
                out.println(); // Agrega el salto de línea al búfer

                if (fila != 0) {
                    error = error || (maxLength != columna);
                }
                maxLength = columna;
            }

            if (error) {
                out.println("Error decoding image");
            }

            // Leemos la cantidad de filas del siguiente caso de prueba
            numFilas = sc.nextInt();

            // Línea de separación si hay más casos
            if (numFilas != 0) {
                out.println();
            }
        }

        // ¡Súper importante! Forzamos la escritura de todo lo acumulado en el búfer
        out.flush();
    }

    /**
     * Clase utilitaria para realizar lecturas de bytes a ultra-velocidad.
     * Evita el overhead de expresiones regulares de Scanner y split().
     */
    static class FastReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024 * 64]; // Búfer de 64KB
        private int head = 0, tail = 0;
        private boolean endOfLine = false;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = stream.read(buf, 0, buf.length);
                if (tail <= 0) return -1;
            }
            return buf[head++];
        }

        public char nextChar() throws IOException {
            int c = read();
            while (c <= 32) {
                c = read();
            }
            return (char) c;
        }

        public int nextInt() throws IOException {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            int res = 0;
            while (c > 32) {
                if (c < '0' || c > '9') {
                    throw new IOException("Input mismatch");
                }
                res = res * 10 + (c - '0');
                c = read();
            }
            // Marcamos si este número estaba al final de la línea actual
            endOfLine = (c == '\n' || c == '\r' || c == -1);
            if (c == '\r') {
                // Manejo de saltos de línea estilo Windows (\r\n)
                int next = read();
                if (next != '\n' && next != -1) {
                    head--; // Devolvemos el byte al búfer si no era parte del salto
                }
            }
            return res;
        }

        public boolean isEndOfLine() {
            return endOfLine;
        }
    }
}