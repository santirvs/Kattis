package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * "Simple" cálculo y redondeo
 * Se complica con unidades de medida que hay que ajustar
 * Y finalmente el redondeo.
 * Evitar el uso de aritmética flotante
 *
 */

import java.util.Scanner;

public class WorkFromHome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long watios = sc.nextInt();
        long minutos = sc.nextInt();
        long precioCents = sc.nextInt();

        long costeCents = watios * minutos * precioCents;  // El precio en centavos está multiplicado por 60.000 (en minutos en lugar de horas y en watios en lugar de Kw)

        long denominador = 60*1000*100;  //60 minutos * 1000 watios * 100 centavos

        //Redondeo hacia arriba
        long totalDollars = (costeCents + denominador -1 ) / denominador;

        System.out.println(totalDollars);

    }
}
