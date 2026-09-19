package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

import java.util.Scanner;

public class CoffeeCupCombo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt(); // Ignorar el número de clases
        String cafes = scan.next();

        int numCafes = 0;
        int clasesAtendidas = 0;

        for (int i = 0; i < num; i++) {
            if (cafes.charAt(i) == '1') {
                numCafes = 2;
                clasesAtendidas++;
            } else {
                if (numCafes > 0) {
                    numCafes--;
                    clasesAtendidas++;
                }
            }
        }

        System.out.println(clasesAtendidas);
    }
}
