package Others.Easy.Puntuacion_2_0_a_2_9._2_6;

import java.util.Scanner;

public class CodeGuessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int alice1 = sc.nextInt();
        int alice2 = sc.nextInt();

        int minAlice = Math.min(alice1, alice2);
        int maxAlice = Math.max(alice1, alice2);

        String patron = sc.next();

        if (patron.equals("AABB")) {
            if (maxAlice==7) System.out.println("8 9");
            else System.out.println("-1");
        } else if (patron.equals("ABAB")) {
            if (maxAlice==8 && minAlice == 6) System.out.println("7 9");
            else System.out.println("-1");
        } else if (patron.equals("ABBA")) {
            if (maxAlice - minAlice == 3) System.out.println((minAlice+1) + " " + (minAlice+2));
            else System.out.println("-1");
        } else if (patron.equals("BBAA")) {
            if (minAlice == 3) System.out.println("1 2");
            else System.out.println("-1");
        } else if (patron.equals("BABA")) {
            if (maxAlice == 4 && minAlice==2) System.out.println("1 3");
            else System.out.println("-1");
        } else if (patron.equals("BAAB")) {
            if (maxAlice == 8 && minAlice==2) System.out.println("1 9");
            else System.out.println("-1");
        }

        sc.close();
    }
}
