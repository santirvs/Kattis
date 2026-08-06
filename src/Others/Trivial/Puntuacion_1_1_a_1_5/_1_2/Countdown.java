package Others.Trivial.Puntuacion_1_1_a_1_5._1_2;

// Hacer la cuenta atrás desde un número leído por teclado

import java.util.Scanner;

public class Countdown {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        for (int i=num; i>0; i--) {
            System.out.println(i);
        }

    }
}