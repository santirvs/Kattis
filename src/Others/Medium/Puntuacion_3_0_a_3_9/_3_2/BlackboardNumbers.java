package Others.Medium.Puntuacion_3_0_a_3_9._3_2;

/**
 * Comprobar si el número puede interpretarse como decimal, octal, binario o hexadecimal
 * Transformarlo a decimal y comprobar si es primo o no
 * Usar la implementación de Test de Miller-Rabin
 */


import java.util.Scanner;

public class BlackboardNumbers {

    static class PrimeTest {

        // Bases suficientes para que el test sea 100% determinista para cualquier n < 2^64
        private static final long[] BASES = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L};

        /**
         * Verifica si un número es primo utilizando el test de Miller-Rabin determinista.
         * @param n El número a comprobar (hasta 2^64).
         * @return true si es primo, false en caso contrario.
         */
        public static boolean isPrime(long n) {
            if (n < 2) return false;

            // Comprobación rápida para las bases pequeñas
            for (long b : BASES) {
                if (n == b) return true;
                if (n % b == 0) return false;
            }

            // Escribir n - 1 como d * 2^s sacando factores de 2
            long d = n - 1;
            int s = 0;
            while ((d & 1) == 0) {
                d >>= 1;
                s++;
            }

            // Aplicar el test para cada base determinista
            for (long a : BASES) {
                if (n <= a) break;
                if (!millerRabinTest(a, d, n, s)) {
                    return false; // Encontró un testigo compuesto, definitivamente no es primo
                }
            }
            return true;
        }

        /**
         * Realiza una ronda del test de Miller-Rabin para una base 'a'.
         */
        private static boolean millerRabinTest(long a, long d, long n, int s) {
            long x = powerMod(a, d, n);
            if (x == 1 || x == n - 1) return true;

            for (int r = 1; r < s; r++) {
                x = multiplyMod(x, x, n);
                if (x == n - 1) return true;
            }
            return false;
        }

        /**
         * Calcula (base^exp) % mod de forma eficiente usando exponenciación binaria.
         */
        private static long powerMod(long base, long exp, long mod) {
            long res = 1;
            base %= mod;
            while (exp > 0) {
                if ((exp & 1) == 1) {
                    res = multiplyMod(res, base, mod);
                }
                base = multiplyMod(base, base, mod);
                exp >>= 1;
            }
            return res;
        }

        /**
         * Realiza la multiplicación modular segura (a * b) % mod
         * evitando desbordamientos de enteros (overflow) de 64 bits.
         */
        private static long multiplyMod(long a, long b, long mod) {
            // BigInteger previene el desbordamiento de long cuando a * b excede 2^63 - 1
            return java.math.BigInteger.valueOf(a)
                    .multiply(java.math.BigInteger.valueOf(b))
                    .mod(java.math.BigInteger.valueOf(mod))
                    .longValue();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt();

        while (numCasos-- > 0) {
            int numPrimos = 0;
            int numBases = 0;

            String num = scan.next();
            try {
                long binario = Long.parseLong(num, 2);
                numBases++;
                if (PrimeTest.isPrime(binario)) numPrimos++;
                }
            catch (NumberFormatException e) {
                //Ignorar
            }
            try {
                long decimal = Long.parseLong(num, 10);
                numBases++;
                if (PrimeTest.isPrime(decimal)) numPrimos++;
            }
            catch (NumberFormatException e) {
                //Ignorar
            }
            try {
                long octal = Long.parseLong(num, 8);
                numBases++;
                if (PrimeTest.isPrime(octal)) numPrimos++;
            }
            catch (NumberFormatException e) {
                //Ignorar
            }
            try {
                long hexadecimal = Long.parseLong(num, 16);
                numBases++;
                if (PrimeTest.isPrime(hexadecimal)) numPrimos++;
            }
            catch (NumberFormatException e) {
                //Ignorar
            }

            if (numPrimos == 0) {
                numBases = 1;
            } else {
                //Reducir la fracción
                if (numBases % numPrimos == 0) {
                    numBases = numBases / numPrimos;
                    numPrimos = 1;
                }
            }


            System.out.println(numPrimos + "/" + numBases);

        }
        scan.close();
    }
}