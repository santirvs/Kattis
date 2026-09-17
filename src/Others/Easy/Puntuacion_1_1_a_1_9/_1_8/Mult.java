package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

import java.util.Scanner;

public class Mult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nums = sc.nextInt();
        int numInicial = sc.nextInt();


        for (int i=1; i<nums; i++) {
            int numero = sc.nextInt();
            if (numero % numInicial == 0) {
                System.out.println(numero);
                if (sc.hasNextInt()) {
                    numInicial = sc.nextInt();
                    i++;
                    }
            }
        }


    }
}
