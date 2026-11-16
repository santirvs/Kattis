package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Suma de 1^3 n veces para conseguir el número n
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class JacobiNumbers {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer los datos
        int numero = sc.nextInt();

        System.out.println(numero);

        for (int i=0; i<numero; i++) {
            if (i!=0) System.out.print(" ");
            System.out.print("1");
        }
        System.out.println();

    }
}

