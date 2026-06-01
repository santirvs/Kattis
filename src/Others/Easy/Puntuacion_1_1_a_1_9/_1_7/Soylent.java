package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * v1 : Leer la cantidad de calorias necesarias y dividir entre 400
 *      Si el módulo no es exacto, incrementar en 1
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class Soylent {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer los datos
        int casos = sc.nextInt();

        while (casos-- > 0) {
            int numCalorias = sc.nextInt();
            int numBotellas = numCalorias/400;
            if (numCalorias%400 != 0) {
                numBotellas++;
            }
            System.out.println(numBotellas);
        }

        sc.close();
    }
}

