package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer dos enteros n y m
// Calcular el mínimo de los dos
// Imprimir el doble del mínimo

import java.util.Scanner;

public class Shandy {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //Leer los datos
        int n = scan.nextInt();
        int m = scan.nextInt();
        int min = Math.min(n, m);
        System.out.println(min * 2);

    }
}