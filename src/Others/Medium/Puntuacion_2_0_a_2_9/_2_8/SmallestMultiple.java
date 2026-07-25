package Others.Medium.Puntuacion_2_0_a_2_9._2_8;

// Encontrar el mínimo común múltiplo de una serie de números.
// Como se puede desbordar, usar el BigInteger y ya puestos, el BigInteger.gcd()

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SmallestMultiple {

    public static BigInteger BI_ZERO = new BigInteger("0");

    public static BigInteger calcularMCM(BigInteger a, BigInteger b) {
        if (a.equals(BigInteger.ZERO) || b.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }
        // (a / MCD(a,b)) * b para evitar multiplicaciones innecesarias
        return a.divide(a.gcd(b)).multiply(b);
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String[] nums = scan.nextLine().split("\\s+");

            BigInteger mcm = new BigInteger(nums[0]);

            for (int i=1; i<nums.length; i++) {
                mcm = calcularMCM(mcm, new BigInteger(nums[i]));
            }

            System.out.println(mcm);

        }

        scan.close();

    }
}