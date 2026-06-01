package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

import java.util.Scanner;

public class NavigationNightmare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        String result = line.replaceAll("B","(ooo)");

        System.out.println(result);
    }
}
