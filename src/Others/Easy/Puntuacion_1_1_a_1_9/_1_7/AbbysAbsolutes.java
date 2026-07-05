package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Calcular la diferencia entre la cantidad pedida y la estimación de Abby.
 * Comprar 1 o N según sea el más cercano
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class AbbysAbsolutes {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer los datos
        int umbral = sc.nextInt();
        int viajes = sc.nextInt();
        boolean primero = true;

        while (viajes-- > 0) {
            if (primero) primero=false;
            else System.out.print(" ");

            int cantidad = sc.nextInt();

            if (cantidad - 1 <= umbral - cantidad) System.out.print("1");
            else System.out.print(umbral);
        }
        System.out.println();

    }
}

