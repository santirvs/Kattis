package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

/**
 * Cada servidor necesita uno de los tres componentes
 * Contar los componentes por separado.
 * El contador mínimo será el que indicará el número de servidores
 * completos que podemos montar
 */

import java.util.Scanner;

public class Vefpjonatjon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();

        int[] componentes = new int[3];

        while (numCasos-- > 0) {
            for (int i=0; i<3; i++) {
                if (sc.next().equals("J")) componentes[i]++;
            }
        }

        int montados = Math.min(Math.min(componentes[0],componentes[1]),componentes[2]);

        System.out.println(montados);

    }
}
