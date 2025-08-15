package Cap3._2_BusquedaCompleta._9_SimulacionMatematicaDificiles;
import java.util.*;
import java.math.BigInteger;


/*
Traducción al español del comentario original:

Supongamos que tenemos una fracción a/b y buscamos todos los números k tales que
(a/b) * k sea igual a k pero con su primer dígito movido al final.

Sea k = c_0 * 10^0 + c_1 * 10^1 + ... + c_n * 10^n, es decir, k es un entero de
longitud n+1 (en cadena sería c_n...c_1 c_0). Entonces debe cumplirse:

    (a/b) * k = c_n + (c_0*10^1 + c_1*10^2 + ... + c_[n-1]*10^n)

Reordenando:
    a * k = b * (c_n + 10*(c_0*10^0 + c_1*10^1 + ... + c_[n-1]*10^[n-1]))
          = b * (c_n + 10*k - c_n*10^[n+1])

De ahí:
    k * (a - 10*b) = b * c_n * (1 - 10^[n+1])
    k = b * c_n * (10^[n+1] - 1) / (10*b - a)

Como el primer dígito de k (c_n) nunca es 0, puede ser 1..9, y la longitud n se acota
por la entrada. Para cada (n, c_n) comprobamos si el k resultante es válido.

Nota: En la implementación se generan candidatos con esa fórmula y se valida que
(a/b) * k sea exactamente el número k rotado (mover último dígito al frente).
*/

class Fraction {
    long a, b; // numerador y denominador

    // Construir a partir de un string decimal, ejemplo "12.34"
    public static Fraction constructFromDecimalString(String s) {
        String[] parts = s.split("\\.");
        String integerPart = parts[0];
        String decimalPart = parts[1];
        long num = Long.parseLong(integerPart + decimalPart);
        long den = (long) Math.pow(10, decimalPart.length());
        return new Fraction(num, den);
    }

    public Fraction(long a, long b) {
        long g = gcd(a, b);
        this.a = a / g;
        this.b = b / g;
    }

    private long gcd(long x, long y) {
        return BigInteger.valueOf(x).gcd(BigInteger.valueOf(y)).longValue();
    }
}

class TrickNumbers {
    // Verifica si k es un "trick number" para la fracción f
    public static boolean isTrickNumber(Fraction f, long k) {
        long prod = f.a * k;
        long d = prod / f.b;
        long m = prod % f.b;
        if (m != 0) return false;

        String dStr = Long.toString(d);
        if (dStr.length() < 1) return false;
        String rotated = (d % 10) + dStr.substring(0, dStr.length() - 1);
        long rotatedNum = Long.parseLong(rotated);
        return k == rotatedNum;
    }

    // Genera todos los trick numbers posibles para f
    public static List<Long> generateAllTricks(Fraction f) {
        List<Long> result = new ArrayList<>();
        for (int n = 0; n < 8; n++) {
            for (int last = 1; last <= 9; last++) {
                long numerator = f.b * last * (pow10(n + 1) - 1);
                long denominator = (10 * f.b - f.a);
                if (denominator == 0) break;
                if (numerator % denominator != 0) continue;
                long k = numerator / denominator;
                if (isTrickNumber(f, k)) {
                    result.add(k);
                }
            }
        }
        return result;
    }

    private static long pow10(int exp) {
        long res = 1;
        for (int i = 0; i < exp; i++) res *= 10;
        return res;
    }
}

public class NumberTrick {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String decimalStr = sc.nextLine().trim();
        Fraction f = Fraction.constructFromDecimalString(decimalStr);
        List<Long> numbers = TrickNumbers.generateAllTricks(f);
        if (numbers.isEmpty()) {
            System.out.println("No solution");
        } else {
            for (long num : numbers) {
                System.out.println(num);
            }
        }
    }
}
