package Others.Easy.Puntuacion_2_0_a_2_9._2_2;

import java.io.IOException;
import java.io.InputStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JustAMinim {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numNotas = sc.nextInt();
        double longitud = 0;

        for (int i=0; i<numNotas; i++) {
            int codigo = sc.nextInt();
            if (codigo == 0) longitud += 2;
            else {
                longitud += ( 1.0 / codigo );
            }
        }

        System.out.println(longitud);

    }
}
