package Others.Easy.Puntuacion_3_0_a_3_9._3_8;


/**
 * Problema con un cifrado
 *   y = (x*A+B) mod 2^64
 *
 *  donde:
 *      A = 230309227 (impar)
 *      B = 68431307
 *      0 <= x <= 10^18
 *
 *  Al ser A impar, tiene inverso módulo 2^64
 *  Y el descifrado es directo:
 *      x = ((y - B) / A) mod 2^64
 *
 *  Además, 2^64 = 1.84 * 10^19
 *  El rango de x debe estar entre 0 y 10^18
 *  Eso garantiza que el valor obtenido módulo 2^64 es el único posible dentro del rango
 *
 *  Como Java no tiene unsigned long, debemos usar BigInteger
 *  Como Java no tiene unsigned long, debemos usar BigInteger
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Leynitolur {

    static final BigInteger A = new BigInteger("230309227");
    static final BigInteger B = new BigInteger("68431307");
    static final BigInteger MOD = BigInteger.ONE.shiftLeft(64); // 2^64
    static final BigInteger MAXX = new BigInteger("1000000000000000000"); // 1e18

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Inverso de A módulo 2^64 (existe porque A es impar)
        BigInteger Ainv = A.modInverse(MOD);

        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            BigInteger y = new BigInteger(line);

            // x = (y - B) * A^{-1} mod 2^64
            BigInteger x = y.subtract(B).mod(MOD);
            x = x.multiply(Ainv).mod(MOD);

            // Validar rango
            if (x.signum() < 0 || x.compareTo(MAXX) > 0) {
                System.out.println(0);
            } else {
                System.out.println(x);
            }
        }
    }
}
