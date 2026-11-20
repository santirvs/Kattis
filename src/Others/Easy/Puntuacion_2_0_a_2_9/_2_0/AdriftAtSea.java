package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class AdriftAtSea {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> brujula = new ArrayList<String>(Arrays.asList("N", "NE", "E", "SE", "S", "SW", "W", "NW"));
        int[]              grados = new int[]                        {   0,   45,  90,  135, 180,  225, 270,  315};

        String direccionInicial = sc.nextLine();
        String direccionFinal = sc.nextLine();

        if (direccionInicial.equals(direccionFinal)) {
            System.out.println("Keep going straight");
        }
        else {
            int gradosInicial = grados[brujula.indexOf(direccionInicial)];
            int gradosFinal = grados[brujula.indexOf(direccionFinal)];

            int clockwise = (gradosFinal - gradosInicial + 360) % 360;        // starboard
            int counterClockwise = (gradosInicial - gradosFinal + 360) % 360; // port

            if (clockwise == 180) {
                System.out.println("U-turn");
            } else if (clockwise < counterClockwise) {
                System.out.println("Turn " + clockwise + " degrees starboard");
            } else {
                System.out.println("Turn " + counterClockwise + " degrees port");
            }


        }

    }
}

