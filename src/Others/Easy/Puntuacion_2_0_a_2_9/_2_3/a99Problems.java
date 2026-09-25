package Others.Easy.Puntuacion_2_0_a_2_9._2_3;

import java.util.Scanner;

/**
 * Obtener la centena del precio y sumar 99 o restar 1
 * Escoger el valor más cercano al precio original y que no sea negativo
 */


public class a99Problems {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int numero = sc.nextInt();

        int numOfertaAlto = numero / 100 * 100 + 99;
        int numOfertaBajo = numero / 100 * 100 - 1 ;

        int distanciaAlto = numOfertaAlto - numero;
        int distanciaBajo = numero - numOfertaBajo;

        if (distanciaAlto <= distanciaBajo || numOfertaBajo < 0) {
            System.out.println(numOfertaAlto);
        } else {
            System.out.println(numOfertaBajo);
        }

    }
}
