package Others.Easy.Puntuacion_2_0_a_2_9._2_3;


/*
    Apoyarnos en un HashSet<Int> para determinar si el recibo ya se ha procesado
    30.000 entradas -> Usar FastReader
 */


import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;

public class RevisionControl {

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
        //Como pueden haber hasta 30.000 lecturas y escrituras, usar un FR / PrintWriter
        FR_Int sc = new FR_Int();

        int numRecibos = sc.nextInt();

        //Inicializar variables
        HashSet<Integer> set = new HashSet<>();

        //Leer el primer recibo (siempre se va a registrar)
        set.add(sc.nextInt());
        System.out.print("1");
        numRecibos--;

        //Leer el resto de recibos
        while (numRecibos--> 0) {

            int recibo = sc.nextInt();

            if (set.contains(recibo)) {
                System.out.print(" 0");
            } else {
                System.out.print(" 1");
                set.add(recibo);
            }
        }

        System.out.println();

    }

}

