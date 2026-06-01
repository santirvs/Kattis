package Others.Easy.Puntuacion_3_0_a_3_9._3_4;

import java.util.Scanner;

public class Alloys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextDouble()) {
            double c = scanner.nextDouble();

            // The maximum sum of x + y cannot exceed the budget c,
            // and it cannot exceed 1.0 because x + y + z = 1 and z >= 0.
            double sum = Math.min(c, 1.0);

            // By AM-GM inequality, x * y is maximized when x = y = sum / 2
            double maxHardness = (sum / 2.0) * (sum / 2.0);

            // Print the result
            System.out.println(maxHardness);
        }

        scanner.close();
    }
}