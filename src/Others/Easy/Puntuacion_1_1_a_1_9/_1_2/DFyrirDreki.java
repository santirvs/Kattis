package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Calcular el número de soluciones de una ecuación de segundo grado

import java.util.Scanner;

public class DFyrirDreki {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        // Calcular el número de soluciones de una ecuación de segundo grado
        int discriminante = b * b - 4 * a * c;
        if (discriminante > 0) {
            System.out.println(2);
        } else if (discriminante == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}