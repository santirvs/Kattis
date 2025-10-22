package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer los 4 lados de un rectángulo
// y aplicar la fórmula de Brahmagupta

import java.util.Scanner;


public class JanitorTroubles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double s1 = sc.nextDouble();
        double s2 = sc.nextDouble();
        double s3 = sc.nextDouble();
        double s4 = sc.nextDouble();
        sc.close();

        double s = (s1 + s2 + s3 + s4) / 2.0;
        double area = Math.sqrt((s - s1) * (s - s2) * (s - s3) * (s - s4));

        System.out.printf("%.10f%n", area);
    }
}

