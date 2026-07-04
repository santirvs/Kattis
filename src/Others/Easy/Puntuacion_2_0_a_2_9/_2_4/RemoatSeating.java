package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

import java.util.Scanner;

// Problema de combinatoria (permutaciones) y reducción de fracciones

import java.math.BigInteger;

public class RemoatSeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        int[] teams = new int[n];
        int totalPeople = 0;
        for (int i = 0; i < n; i++) {
            teams[i] = sc.nextInt();
            totalPeople += teams[i];
        }

        // Inicializamos el numerador y el denominador en 1
        BigInteger numerador = BigInteger.ONE;
        BigInteger denominador = BigInteger.ONE;

        // 1. Multiplicar N! en el numerador
        for (int i = 2; i <= n; i++) {
            numerador = numerador.multiply(BigInteger.valueOf(i));
        }

        // 2. Multiplicar el factorial de cada equipo (S_i!) en el numerador
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= teams[i]; j++) {
                numerador = numerador.multiply(BigInteger.valueOf(j));
            }
        }

        // 3. Multiplicar P! (totalPeople!) en el denominador
        for (int i = 2; i <= totalPeople; i++) {
            denominador = denominador.multiply(BigInteger.valueOf(i));
        }

        // 4. Reducir la fracción utilizando el Máximo Común Divisor (GCD)
        BigInteger mcd = numerador.gcd(denominador);
        numerador = numerador.divide(mcd);
        denominador = denominador.divide(mcd);

        // Imprimir el resultado en formato "numerador/denominador"
        System.out.println(numerador + "/" + denominador);

        sc.close();
    }
}