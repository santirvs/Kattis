package Others.Trivial.Puntuacion_1_1_a_1_5._1_2;

// Ai = Ai-3 + Ai-1
// Nos dan A3, A4 y A5
// Nos piden A0, A1 y A2

//A3 = A0 + A2  --> ???
//A4 = A1 + A3  --> A1 = A4 - A3 !!!
//A5 = A2 + A4  --> A2 = A5 - A4 !!!
//                  A0 = A3 - A2

import java.util.Scanner;

public class Fibonacho {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a3 = scan.nextInt();
        int a4 = scan.nextInt();
        int a5 = scan.nextInt();

        int a1 = a4-a3;
        int a2 = a5-a4;
        int a0 = a3-a2;

        System.out.println(a0 + " " + a1 + " " + a2);

    }
}