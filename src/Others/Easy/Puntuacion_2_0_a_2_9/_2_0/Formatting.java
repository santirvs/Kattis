package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

// Leer un número decimal y formatear la salida de forma que tenga:
//  12 posiciones de ancho
//  2 decimales
//  alineado a la derecha

import java.util.Locale;
import java.util.Scanner;

public class Formatting {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in).useLocale(Locale.UK);

        double num = scan.nextDouble();

        System.out.printf("%12.2f\n",num);

    }
}