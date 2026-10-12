package Others.Medium.Puntuacion_5_0_a_5_9._5_0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InverseFactorial {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s == null) return;
        s = s.trim();

        // Casos base pequeños donde la longitud de los dígitos puede superponerse
        // 1! = 1 (1 dígito)
        // 2! = 2 (1 dígito) -> Ojo: ¡1! y 2! tienen ambos 1 dígito ("1" y "2")
        // 6! = 720 (3 dígitos), 3! = 6 (1 dígito), 4! = 24 (2 dígitos), 5! = 120 (3 dígitos)
        int length = s.length();
        if (length == 1) {
            int val = Integer.parseInt(s);
            if (val == 1 || val == 2) {
                System.out.println(val);
            } else if (val == 6) {
                System.out.println(3);
            }
            return;
        } else if (length == 2) {
            // 4! = 24 (2 dígitos)
            System.out.println(4);
            return;
        }

        // Para factoriales con 3 o más dígitos, el método de logaritmos es totalmente preciso y único.
        // La cantidad de dígitos de un número X es floor(log10(X)) + 1.
        // Para n!, log10(n!) = log10(1) + log10(2) + ... + log10(n).
        double logSum = 0.0;
        int n = 1;

        while (true) {
            logSum += Math.log10(n);

            // Calculamos el número de dígitos que tendría n! con la suma acumulada de logaritmos
            // floor(logSum) + 1 nos da la cantidad exacta de dígitos
            int currentDigits = (int) Math.floor(logSum) + 1;

            // Si la cantidad de dígitos calculados coincide con la longitud de la cadena de entrada,
            // hemos encontrado el valor exacto de n.
            if (currentDigits == length) {
                System.out.println(n);
                break;
            }

            n++;
        }
    }
}