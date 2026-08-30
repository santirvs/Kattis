package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * El rango inferior viene delimitado por el máximo de la temperatura mínima
 * El rango superior viene delimitado por el mínimo de la temperatura máxima
 * Si min > max --> bad news
 * sino, imprimir max-min+1 y min
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class Sauna {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        int numAmigos = sc.nextInt();
        int inferior = Integer.MIN_VALUE;
        int superior = Integer.MAX_VALUE;

        for (int i=0; i<numAmigos; i++) {
            int tempMin = sc.nextInt();
            int tempMax = sc.nextInt();

            inferior = Math.max(tempMin, inferior);
            superior = Math.min(tempMax, superior);
        }

        if (inferior > superior) System.out.println("bad news");
        else System.out.println(superior-inferior+1 + " " + inferior);

        sc.close();
    }
}

