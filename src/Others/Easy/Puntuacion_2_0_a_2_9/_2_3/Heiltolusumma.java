package Others.Easy.Puntuacion_2_0_a_2_9._2_3;

import java.util.Scanner;

public class Heiltolusumma {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Usamos long para evitar desbordamientos con N grandes
        long n = sc.nextLong();
        long suma = 0;

        if (n >= 1) {
            // Fórmula clásica de Gauss para números positivos
            suma = n * (n + 1) / 2;
        } else {
            // Fórmula para cuando N es 0 o negativo (cuenta regresiva desde 1 hasta N)
            suma = (2 - n) * (1 + n) / 2;
        }

        System.out.println(suma);

        sc.close();
    }
}