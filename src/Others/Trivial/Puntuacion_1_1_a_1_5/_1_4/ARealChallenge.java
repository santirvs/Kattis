package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

// Hacer la raiz de la superficie (eso me dará el lado)
// El resultado es 4 * lado

import java.util.Scanner;

public class ARealChallenge {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long area = sc.nextLong();

        System.out.println( 4 * Math.sqrt(area));
    }
}

