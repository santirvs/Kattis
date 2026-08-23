package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * El problema busca los primos pares y únicamente existe el 2
 * por lo que el problema se reduce a determinar si el 2 se encuentra dentro del rango
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pallatolur {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long inicioRango = sc.nextInt();
        long finRango = sc.nextInt();

        if (inicioRango<=2 && finRango >=2) {
            System.out.println("1");
            System.out.println("2");
        } else {
            System.out.println(":(");
        }


    }
}