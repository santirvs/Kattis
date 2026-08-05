package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * CO = CC * tan(a)  CC es 50cm
 */


import java.io.IOException;
import java.util.Scanner;


public class PaintingTheRoof {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        double co = 50 * Math.tan(Math.toRadians(a));

        System.out.printf("%.1f\n", co);

        sc.close();
    }
}

