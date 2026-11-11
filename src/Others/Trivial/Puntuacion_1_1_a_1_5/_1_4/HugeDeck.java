package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

import java.util.Scanner;

public class HugeDeck {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número
        int numCartas = sc.nextInt();

        if (numCartas % 52 == 0) System.out.println(numCartas/52);
        else System.out.println(numCartas/52 + 1);

        sc.close();
    }
}

