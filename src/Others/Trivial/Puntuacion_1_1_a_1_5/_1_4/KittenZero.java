package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

// Calcular la fórmula con decimales y redondear al entero más cercano
//   1 + n + (n * n) + (n * n * n)

import java.util.Locale;
import java.util.Scanner;

public class KittenZero {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        // Leer la tasa de propagación R0
        double r0 = sc.nextDouble();
        double cantidadContagios = 1;

        //Primer contagio
        cantidadContagios += r0;

        //Segundo contagio
        cantidadContagios += r0 * r0;

        //Tercer contagio
        cantidadContagios += r0*r0*r0;


        System.out.println(toNearest(cantidadContagios));
    }

    private static int toNearest(double r0) {
        int result = (int) r0;

        if (r0 - result > 0.5) result++;

        return result;
    }
}

