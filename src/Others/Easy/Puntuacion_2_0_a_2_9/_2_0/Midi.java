package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * Leer todas las partes
 * Procesarlas del final al principio
 * Deletrearlas del final al principio
 *
 */

import java.io.IOException;
import java.util.Scanner;


public class Midi {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numFragmentos = sc.nextInt();
        String[] partes = new String[numFragmentos];
        StringBuilder sb = new StringBuilder();

        //Leer las partes y añadirles al string builder
        for (int i=0; i<numFragmentos; i++) {
            sb.append(sc.next());
        }

        //Mostrar el resultado, dandole la vuelta
        System.out.println(sb.reverse().toString());



    }
}

