package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Buscar el máximo y el mínimo de una serie de números
// Nos van a subvencionar con un máximo de la mitad del precio del billete más caro
// Y no van a subvencionarnos más del precio real del billete más barato
// El resto lo pagamos nosotros.
// Hay que mostrar cuanto pagamos nosotros

import java.util.Scanner;

public class AirfareGrants {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //Leer los datos
        int n = scan.nextInt();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int price = scan.nextInt();
            min = Math.min(min, price);
            max = Math.max(max, price);
        }
        //Calcular el resultado
        int grant = Math.min(min, max / 2);
        int toPay = min - grant;
        //Mostrar el resultado
        System.out.println(toPay);

    }
}