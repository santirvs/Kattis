package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

import java.util.Scanner;

public class Snowfall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numLecturas = sc.nextInt();
        int totalNieve = 0;

        for (int i=0; i<numLecturas; i++) {
            int tipo = sc.nextInt();
            int cantidad = sc.nextInt();

            if (tipo==0) totalNieve+=cantidad;
            else {
                totalNieve-=cantidad;
                totalNieve = Math.max(totalNieve, 0);  //Nunca podemos tener una altitud negativa!
            }
        }

        System.out.println(totalNieve);
    }
}
