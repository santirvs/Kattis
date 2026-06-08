package Others.Easy.Puntuacion_2_0_a_2_9._2_3;


/*
    Ejercicio de programación dinámica
    El caso base será 1 (existe una única forma de sumar 0)
    El caso general es la suma de la formas posibles de llegar a otro número
    sin usar la secuencia prohibida
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Compositions {

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
            while (c!= -1 && c<=32) { c=read(); }
            if (c==-1) return -1;
            int res = 0;
            while (c > 32) {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res;
        }
    }


    public static void main(String[] args) throws IOException {
        FR_Int fr = new FR_Int();

        int numCasos = fr.nextInt();

        while (numCasos-- > 0) {

            int id = fr.nextInt();
            int numero = fr.nextInt();
            //Datos de la secuencia prohibida (SP)
            int inicioSP = fr.nextInt();
            int incrementoSP = fr.nextInt();

            int[] dp = new int[numero+1];
            dp[0] = 1;

            for (int i=1; i<=numero; i++) {
                for (int j=1; j<=i; j++) {
                    if (j<=numero && ((j<inicioSP) || (j-inicioSP)%incrementoSP !=0) ) {
                        dp[i] += dp[i-j];
                    }
                }
            }

//            for (int i=0; i<=numero; i++) {
//                System.out.print(i+":"+dp[i]+" ");
//            }
//            System.out.println();

            System.out.println(id + " " + dp[numero]);

        }
    }



}
