package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Leer la entrada y traducir carácter a carácter
 */


import java.io.IOException;
import java.io.InputStream;


public class PolynomialMultiplication1 {

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

        int numCasos = sc.nextInt();

        while (numCasos-- >0) {
            int grado1 = sc.nextInt();
            int[]poli1 = new int[grado1+1];
            for (int i=0;i<=grado1;i++) {
                poli1[i] = sc.nextInt();
            }

            int grado2 = sc.nextInt();
            int[]poli2 = new int[grado2+1];
            for (int i=0;i<=grado2;i++) {
                poli2[i] = sc.nextInt();
            }

            //Multiplicar los grados
            int[] result = new int[grado1+grado2+1];
            for (int i=0; i<=grado1;i++) {
                for (int j=0; j<=grado2;j++) {
                    result[i+j] += poli1[i] * poli2[j];
                }
            }

            //Mostrar el resultado
            System.out.println(result.length-1);
            for (int i=0; i<result.length; i++) {
                if (i!=0) System.out.print(" ");
                System.out.print(result[i]);
            }
            System.out.println();


        }

    }

}
