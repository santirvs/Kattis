package Others.Easy.Puntuacion_2_0_a_2_9._2_3;


/*
    Atención al factorial de un número muy grande!
    El error debe ser menor de 10^-12, por lo que podemos dejar de calcular


 */

import java.io.IOException;
import java.io.InputStream;

public class EulersNumber {


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
