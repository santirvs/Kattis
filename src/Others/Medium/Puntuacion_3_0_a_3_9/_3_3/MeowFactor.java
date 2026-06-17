package Others.Medium.Puntuacion_3_0_a_3_9._3_3;

// Como el número de entrada es 2^63 aprox(10^18), el número de salida será como máximo 10^2
// Por lo tanto, podemos buscar por fuerza bruta desde 100 hasta 1 elevando el número a la potencia de 9
// El primer número que sea divisible será el resultado buscado

import java.util.Scanner;

public class MeowFactor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLong()) {
            sc.close();
            return;
        }

        long num = sc.nextLong();

        // 128 es el límite real porque 128^9 = 2^63, que es el límite de un long con signo.
        // Si el problema tiene un caso donde la respuesta sea mayor a 100, empezar en 100 daba WA.
        for (int i = 128; i > 0; i--) {
            long potencia = 1;
            boolean overflow = false;

            for (int j = 0; j < 9; j++) {
                // Comprobamos si multiplicar de nuevo causará un desbordamiento del long.
                // Si 'potencia' supera num/i, la multiplicación se va a salir de rango.
                if (potencia > num / i) {
                    overflow = true;
                    break;
                }
                potencia *= i;
            }

            // Si la potencia es perfectamente válida y además divide exacto a num
            if (!overflow && num % potencia == 0) {
                System.out.println(i);
                break;
            }
        }
        sc.close();
    }
}