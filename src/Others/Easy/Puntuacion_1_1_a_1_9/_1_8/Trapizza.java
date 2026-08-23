package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

/**
 * Calcular las superficies de una pizza (redonda) y la otra (trapezoidal)
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class Trapizza {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        double diametro = sc.nextInt();
        double radio = diametro/2;
        double superficieMahjong = radio * radio * Math.PI;

        double lado1 = sc.nextInt();
        double lado2 = sc.nextInt();
        double altura = sc.nextInt();

        double superficieTrapizza = (lado1+lado2)/2*altura;

        if (superficieMahjong > superficieTrapizza)
            System.out.println("Mahjong!");
        else if (superficieMahjong < superficieTrapizza)
            System.out.println("Trapizza!");
        else
            System.out.println("Jafn storar!");

    }
}

