package Others.Easy.Puntuacion_2_0_a_2_9._2_5;


/*
Cortar alternativamente en horizontal y vertical
El resultado (será num_hor + 1) * (num_vert + 1)

Al ser num = 10^9  el resultado puede llegar a ser 10^18 --> long
 */

import java.util.Locale;
import java.util.Scanner;

public class Crne {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long numCortes = sc.nextLong();

        long numVert = numCortes /2;
        long numHoriz = numCortes - numVert;

        System.out.println((numVert+1)*(numHoriz+1));


    }
}
