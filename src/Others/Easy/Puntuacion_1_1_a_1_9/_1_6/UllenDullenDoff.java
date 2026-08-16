package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * pito-pito-colorito...  13 palabras
 */


import java.io.IOException;
import java.util.Scanner;


public class UllenDullenDoff {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numNenes = sc.nextInt();
        String[] nombres = new String[numNenes+1];

        for (int i=1; i<=numNenes; i++) {
            nombres[i] = sc.next();
        }
        nombres[0] = nombres[numNenes];

        //A quien le toca?
        if (numNenes >= 13)
            System.out.println(nombres[13]);
        else {
            System.out.println(nombres[13%numNenes]);
        }
        sc.close();
    }
}

