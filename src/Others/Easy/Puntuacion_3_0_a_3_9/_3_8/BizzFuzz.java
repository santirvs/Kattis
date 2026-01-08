package Others.Easy.Puntuacion_3_0_a_3_9._3_8;

// Divisible por ambos es lo mismo que divisible por el mínimo común múltiplo
// Entonces el problema se reduce a contar los múltiplos del mcm en el intervalo [A,B]
// La fórmula es  contador = floor(B/mcm) - floor(A-1/mcm)
// Hay un detalle importante: son números de hasta 10^18 que al multiplicarse exceden el rango de un long
// Es necesario usar BigInteger

import java.math.BigInteger;
import java.util.Scanner;

public class BizzFuzz {
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);

        //Leer los datos
        long A = scan.nextLong();
        long B = scan.nextLong();
        long C = scan.nextLong();
        long D = scan.nextLong();

        // gcd usando BigInteger
        BigInteger bigC = BigInteger.valueOf(C);
        BigInteger bigD = BigInteger.valueOf(D);
        BigInteger g = bigC.gcd(bigD);

        // lcm = C / gcd * D
        BigInteger lcm = bigC.divide(g).multiply(bigD);

        BigInteger bigA = BigInteger.valueOf(A);
        BigInteger bigB = BigInteger.valueOf(B);

        //  count(x) = floor(x / lcm)
        BigInteger countB = bigB.divide(lcm);
        BigInteger countAminus1 = bigA.subtract(BigInteger.ONE).max(BigInteger.ZERO).divide(lcm);

        BigInteger answer = countB.subtract(countAminus1);

        System.out.println(answer.toString());
    }
}
