package Others.Easy.Puntuacion_1_1_a_1_9._1_1;

// Leer el precio de los tres sistemas (Monnei, Fjee, y Dolladollabilljoll) y escoger el de menor precio

import java.util.Scanner;

public class Millifaersla {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int precioMonnei = scan.nextInt();
        int precioFjee = scan.nextInt();
        int precioDolladollabilljoll = scan.nextInt();

        if (precioMonnei <= precioFjee && precioMonnei <= precioDolladollabilljoll) {
            System.out.println("Monnei");
        } else if (precioFjee <= precioMonnei && precioFjee <= precioDolladollabilljoll) {
            System.out.println("Fjee");
        } else {
            System.out.println("Dolladollabilljoll");
        }

    }
}