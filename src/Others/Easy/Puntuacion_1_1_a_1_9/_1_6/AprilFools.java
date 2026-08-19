package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Descifrado Cesar
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class AprilFools {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();

        while (numCasos-- > 0) {
            int desplazamiento = sc.nextInt();
            sc.nextLine();
            String mensaje = sc.nextLine();

            for (int i=0; i<mensaje.length(); i++) {
                char caracter = mensaje.charAt(i);
                if (caracter >= 'A' && caracter <= 'Z') {
                    caracter -= desplazamiento;
                    if (caracter < 'A') caracter += 26;
                }
                System.out.print(caracter);
            }
            System.out.println();


        }

        sc.close();
    }
}

