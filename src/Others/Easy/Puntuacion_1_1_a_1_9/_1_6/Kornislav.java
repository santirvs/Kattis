package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Leer los lados, ordenarlos y tomar el menor de los dos más pequeños
 * y el menor de los dos más grandes
 */


import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class Kornislav {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer los datos
        int[] lados = new int[4];
        for (int i=0; i<4; i++) {
            lados[i] = sc.nextInt();
        }

        //Ordenar los lados
        Arrays.sort(lados);

        //Tomar el menor de cada pareja
        int base = lados[0];
        int altura = lados[2];

        //Mostrar el area resultante
        System.out.println(base*altura);

        sc.close();
    }
}

