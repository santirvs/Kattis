package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

/**
 * Contar cuantos casos cumplen las dos condiciones
 * - no ser múltiplo de 8
 * - tener una duración superior a 10000 o inferior a 1
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class SuspiciousActivity {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        int numCasos = sc.nextInt();
        int contador = 0;

        while (numCasos-- > 0) {
            int id = sc.nextInt();
            int duracion = sc.nextInt();

            if (id%8 != 0 && (duracion > 10000 || duracion < 1)) {
                contador++;
            }
        }

        System.out.println(contador);
    }
}

