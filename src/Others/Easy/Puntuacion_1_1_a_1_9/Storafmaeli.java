package Others.Easy.Puntuacion_1_1_a_1_9;

// Detectar si el número és múltiplo de 10 e imprimir "Neibb" si no lo es o "Jebb" si sí que lo es

import java.util.Scanner;

public class Storafmaeli {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        if (num % 10 == 0) {
            System.out.println("Jebb");
        } else {
            System.out.println("Neibb");
        }

    }
}