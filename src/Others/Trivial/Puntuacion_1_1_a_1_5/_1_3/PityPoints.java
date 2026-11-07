package Others.Trivial.Puntuacion_1_1_a_1_5._1_3;

// Suma los números que se lean

import java.util.Locale;
import java.util.Scanner;

public class PityPoints {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int cantidad = scan.nextInt();
        int suma = 0;
        while (cantidad-- >0) {
            suma += scan.nextInt();
        }

        System.out.println(suma);


    }
}