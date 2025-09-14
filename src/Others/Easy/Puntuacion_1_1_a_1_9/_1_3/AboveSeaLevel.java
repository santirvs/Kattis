package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer un valor decimal y restarle 0.3

import java.util.Scanner;

public class AboveSeaLevel {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //Leer los datos
        double n = scan.nextDouble();
        System.out.printf("%.1f%n", n - 0.3);

    }
}