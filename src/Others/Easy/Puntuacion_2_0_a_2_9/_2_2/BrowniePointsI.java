package Others.Easy.Puntuacion_2_0_a_2_9._2_2;

/**
 * Por las dimensiones del plano (-10^6 <--> 10^6) hay que descartar el uso de una matriz
 * El punto de corte viene en el punto central de la lista de brownies.  podemos determinar los brownies
 * Una vez que lo tengamos, podemos determinar si el brownie es de Stan o de Ollie.
 * Si un brownie es cruzado por la línea vertical u horizontal --> no es de nadie
 * Si el brownie tiene ambas coordenadas positivas o ambas negativas --> es de Stan
 * Si no es de Ollie
 * <p>
 * Para saber de quien son los brownies anteriores a saber el punto de corte, será necesario guardarlo en
 * un array y procesarlos posteriormente
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public class BrowniePointsI {


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
                // Fin de archivo
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

            if (negativo) return -res;
            else return res;
        }
    }


    public static void main(String[] args) throws IOException {

        FR_Int sc = new FR_Int();
        //Scanner sc = new Scanner(System.in);

        int numBrownies = sc.nextInt();
        while (numBrownies > 0) {
            int cantStan = 0;
            int cantOllie = 0;
            int refX = 0;
            int refY = 0;
            int[] anteriores = new int[numBrownies];


            for (int i = 0; i < numBrownies; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                if ((numBrownies / 2) == i) {
                    //Hemos alcanzado el punto central!
                    refX = x;
                    refY = y;
                } else if ((numBrownies / 2) > i) {
                    //Aún no sabemos los puntos de corte
                    anteriores[2 * i] = x;
                    anteriores[2 * i + 1] = y;
                } else {
                    //Ya sí sabemos los puntos de corte

                    if (x == refX || y == refY) {
                        //El brownie no es para nadie
                    } else if ((x > refX && y > refY) || (x < refX && y < refY)) {
                        //Primer o tercer cuadrante: para Stan
                        cantStan++;
                    } else cantOllie++;
                }

            }

            //Procesar los anteriores
            for (int i = 0; i < numBrownies / 2; i++) {
                int x = anteriores[2 * i];
                int y = anteriores[2 * i + 1];

                if (x == refX || y == refY) {
                    //El brownie no es para nadie
                } else if ((x > refX && y > refY) || (x < refX && y < refY)) {
                    //Primer o tercer cuadrante: para Stan
                    cantStan++;
                } else cantOllie++;
            }


            System.out.println(cantStan + " " + cantOllie);

            //Siguiente caso
            numBrownies = sc.nextInt();
        }
    }
}
