package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número de cruces y desvíos
// Si el número de desvíos es par mostrar "possible", si es impar mostrar "impossible"

import java.util.Scanner;


public class Railroad {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de cruces y desvíos
        sc.nextInt();  // el número de cruces no importa
        int desvios = sc.nextInt();
        // Si el número de desvíos es par mostrar "possible", si es impar mostrar "impossible"
        if (desvios % 2 == 0) {
            System.out.println("possible");
        } else {
            System.out.println("impossible");
        }

        sc.close();
    }
}

