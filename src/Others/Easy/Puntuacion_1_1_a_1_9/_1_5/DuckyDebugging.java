package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

import java.util.Scanner;

public class DuckyDebugging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        while (!line.equals("I quacked the code!")) {
            if (line.charAt(line.length()-1) == '.') {
                System.out.println("*Nod*");
            } else {
                System.out.println("Quack!");
            }

            line = sc.nextLine();
        }
    }
}
