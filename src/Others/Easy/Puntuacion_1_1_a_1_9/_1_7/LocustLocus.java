package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Para cada par, buscar el mcm y sumarlo al año
 * Quedarnos con el menor año de reaparicion
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LocustLocus {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numParejas = sc.nextInt();
        int minimo = Integer.MAX_VALUE;

        for (int i=0; i<numParejas; i++) {
            int anyo = sc.nextInt();
            int periodo1 = sc.nextInt();
            int periodo2 = sc.nextInt();

            //Calcular el próximo año en común (mcm)
            int comun = calcularMCM(periodo1, periodo2);
            //Añadir al año actual
            int proximoAnyo = anyo + comun;

            minimo = Math.min(minimo, proximoAnyo);
        }

        //Mostrar el resultado
        System.out.println(minimo);

    }

    public static int calcularMCD(int a, int b) {
        // Trabajamos con valores absolutos para soportar números negativos
        a = Math.abs(a);   b = Math.abs(b);

        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

    public static int calcularMCM(int a, int b) {
        if (a == 0 || b == 0) {
            return 0; // El MCM de 0 con cualquier número es 0 por convención
        }
        // Dividimos primero por el MCD para evitar desbordamientos (overflow)
        // si los números multiplicados son muy grandes.
        return Math.abs((a / calcularMCD(a, b)) * b);
    }

}