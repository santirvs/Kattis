package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Leer dos ángulos y calcular la distancia mínima
 */


import java.io.IOException;
import java.util.Scanner;


public class SteamColumn {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int dist1 = Math.abs(num1-num2);
        if (dist1>180) {
            if (num1 < num2) num1+=360;
            else num2+=360;
            dist1 = Math.abs(num1-num2);
        }

        System.out.println(dist1);

        sc.close();
    }
}

