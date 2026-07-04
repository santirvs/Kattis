package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Calcular la media de granos por mazorca y aplicar la fórmula
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class Cornhusker {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Calcular el número de granos por mazorca
        int totalGranos = 0;
        for (int i=0; i<5;i++) {
            int perimetro = sc.nextInt();
            int largo = sc.nextInt();

            totalGranos += perimetro * largo;
        }

        //Calcular la media
        int mediaGranos = totalGranos / 5;

        //Calcular el resultado
        int numMazorcas = sc.nextInt();
        int factor = sc.nextInt();

        int resultado = numMazorcas * mediaGranos / factor ;

        System.out.println(resultado);

    }
}

