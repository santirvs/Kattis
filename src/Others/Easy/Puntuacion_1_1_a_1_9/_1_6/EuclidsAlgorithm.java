package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

import java.util.Scanner;

public class EuclidsAlgorithm {

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long numA = sc.nextLong();
        long numB = sc.nextLong();

        long divisor = gcd(numA, numB);

        System.out.println(divisor);

    }
}
