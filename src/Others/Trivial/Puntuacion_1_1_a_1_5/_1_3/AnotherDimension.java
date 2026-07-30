package Others.Trivial.Puntuacion_1_1_a_1_5._1_3;

// Dado el diámetro, calcular el volumen de la semiesfera

import java.util.Locale;
import java.util.Scanner;

public class AnotherDimension {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in).useLocale(Locale.UK);
        //Leer los datos
        double diametro = scan.nextDouble();
        double radio = diametro / 2;

        double area = 4.0 / 3.0 * Math.PI * radio * radio * radio * 0.5;

        System.out.println(area);


    }
}