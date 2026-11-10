package Others.Trivial.Puntuacion_1_1_a_1_5._1_2;

import java.util.Scanner;

public class WhatReallyIsICPC {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] linea = scan.nextLine().toUpperCase().split(" ");

        if (linea.length == 4 &&
                linea[0].charAt(0) == 'I' &&
                linea[1].charAt(0) == 'C' &&
                linea[2].charAt(0) == 'P' &&
                linea[3].charAt(0) == 'C' ) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}