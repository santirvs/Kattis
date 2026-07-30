package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

import java.util.Scanner;

public class FollowThePrize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numVasos = sc.nextInt();
        int premio = sc.nextInt();

        int numIntercambios = sc.nextInt();
        for (int i=0; i<numIntercambios; i++) {
            int vaso1 = sc.nextInt();
            int vaso2 = sc.nextInt();

            if (vaso1 == premio) premio = vaso2;
            else if (vaso2 == premio) premio = vaso1;
        }

        System.out.println(premio);
    }
}
