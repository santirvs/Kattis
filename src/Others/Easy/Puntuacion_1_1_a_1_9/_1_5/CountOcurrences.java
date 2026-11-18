package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

import java.util.Scanner;

public class CountOcurrences {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();
        char c = scan.nextLine().charAt(0);

        for (int i=0; i<s.length(); i++) {
            if (c == s.charAt(i)) System.out.println(i);
        }
    }
}
