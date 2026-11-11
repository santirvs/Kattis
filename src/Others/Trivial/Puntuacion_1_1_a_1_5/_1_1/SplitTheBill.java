package Others.Trivial.Puntuacion_1_1_a_1_5._1_1;

import java.util.Scanner;

public class SplitTheBill {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numAmigos = scan.nextInt();
        int numPlatos = scan.nextInt();

        int sumaTotal = 0;

        while (numPlatos-- > 0) {
            sumaTotal += scan.nextInt();
        }

        if (sumaTotal % numAmigos == 0) System.out.println(1);
        else System.out.println(0);

    }
}