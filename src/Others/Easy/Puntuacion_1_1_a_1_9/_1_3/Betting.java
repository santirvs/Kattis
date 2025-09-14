package Others.Easy.Puntuacion_1_1_a_1_9._1_3;
import java.util.Scanner;

public class Betting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt(); // porcentaje de puntos en opción 1
        sc.close();

        // Convertir a proporción
        double prop1 = p / 100.0;       // fracción en opción 1
        double prop2 = 1.0 - prop1;     // fracción en opción 2

        // El ratio es (1 : x) con x = apuesta_total / apuesta_en_opcion
        // Para opción 1:
        double ratio1 = 1.0 / prop1;
        // Para opción 2:
        double ratio2 = 1.0 / prop2;

        // Imprimir con 10 decimales
        System.out.printf("%.10f%n", ratio1);
        System.out.printf("%.10f%n", ratio2);
    }
}