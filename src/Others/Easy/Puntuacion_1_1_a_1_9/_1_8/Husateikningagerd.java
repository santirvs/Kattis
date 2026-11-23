package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

import java.util.Scanner;

public class Husateikningagerd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h1 = sc.nextInt();
        int w1 = sc.nextInt();
        int h2 = sc.nextInt();
        int w2 = sc.nextInt();


        for (int f=0; f < h1; f++) {
            for (int c=0; c<w1; c++) {
                if (f >= h2 || c >=w2) System.out.print("+");
                else System.out.print("-");
          }
            System.out.println();
        }


    }
}
