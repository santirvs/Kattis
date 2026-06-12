package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Si el numero de botellas a abrir es igual o superior al número de botellas que
 * tenemos --> impossible
 * En caso contrario, abrir la 1 con la 2, abrir la 2 con la 3, abrir la 3 con la 4, ...
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class BottleOpening {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer los datos
        int numBotellasDisponibles = sc.nextInt();
        int numBotellasParaAbrir = sc.nextInt();

        if (numBotellasParaAbrir >= numBotellasDisponibles)
            System.out.println("impossible");
        else {
            for (int i=1; i<=numBotellasParaAbrir; i++) {
                System.out.println("open " + i + " using " + (i+1));
            }
        }

        sc.close();
    }
}

