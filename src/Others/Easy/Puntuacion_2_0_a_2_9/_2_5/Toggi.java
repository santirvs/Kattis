package Others.Easy.Puntuacion_2_0_a_2_9._2_5;


/*
  Hacer una búsqueda binaria entre 1 y MAX_LONG
 */

import java.util.Locale;
import java.util.Scanner;

public class Toggi {

    public static double calcular(long n) {

        return n * Math.log10(n)/1000000.0;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double C = sc.nextInt();

        long lo = 0; long hi = Long.MAX_VALUE;  // Establecer márgenes
        while (lo + 1 < hi) {
            long mid = (lo + hi) / 2;
            if (calcular(mid) > C)  hi = mid;
            else  lo = mid + 1;
        }
        if (calcular(lo) > C) lo--;  //Ajustar para valor mínimo

        System.out.println(lo);
    }
}
