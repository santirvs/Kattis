package Others.Easy.Puntuacion_2_0_a_2_9._2_2;

import java.util.Scanner;

public class Bishops {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int tamanyo = sc.nextInt();

            if (tamanyo <= 2) System.out.println(tamanyo);
            else System.out.println(2*tamanyo - 2);
        }

    }
}
