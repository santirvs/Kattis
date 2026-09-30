package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * La fórmula es SUM ( i*Pi )
 */

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class PasswordHacking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        int numProbabilidades = sc.nextInt();

        double[] probabilidades = new double[numProbabilidades];
        for (int i=0; i<numProbabilidades; i++) {
            sc.next();  // Ignorar la clave
            probabilidades[i] = sc.nextDouble();
        }

        Arrays.sort(probabilidades);

        double intentos =0;
        for (int i=numProbabilidades-1; i>=0; i--) {
            intentos += (numProbabilidades-i) * probabilidades[i];
        }

        System.out.println(intentos);
    }
}