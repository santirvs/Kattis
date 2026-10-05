package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Seguir las instrucciones del enunciado sin mirar de entender qué significa
 */


import java.io.IOException;
import java.util.Scanner;


public class FadingWind {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int k = sc.nextInt();
        int v = sc.nextInt();
        int s = sc.nextInt();

        int distancia = 0;

        // While h > 0 repeat the following sequence
        while (h > 0) {

            // Increase v by s.
            v+=s;

            //Then, decrease v by max(1, round_down(v/10)
            v-= Math.max(1, v/10);

            // If v>=k, increase h by one
            if (v>=k) h++;

            // If 0 < v < k, decrease h by one.
            if (v > 0 && v < k ) h--;
            // If h is zero after the decrease, set v to zero
            if (h==0) v=0;

            // If v<=0 set h to zero and v to zero
            if (v<=0) {
                h=0;
                v=0;
            }

            //Your airplane now travels horizontally by v units
            distancia += v;

            //If s>0, decrease it by 1
            if (s>0) s--;

        }

        //Mostrar la distancia recorrida
        System.out.println(distancia);

        sc.close();
    }
}

