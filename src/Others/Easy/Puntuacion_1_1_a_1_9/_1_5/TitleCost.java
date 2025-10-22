package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el titulo de la pelicula y el importe máximo a pagar
// El resultado es el min entre el número de caracteres del título y el importe máximo a pagar


import java.util.Locale;
import java.util.Scanner;


public class TitleCost {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        String title = sc.next();
        double maxAmount = sc.nextDouble();

        double cost = Math.min(title.length(), maxAmount);
        System.out.println(cost);

        sc.close();
    }
}

