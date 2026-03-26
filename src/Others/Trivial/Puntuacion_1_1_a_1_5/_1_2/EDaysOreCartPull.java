package Others.Trivial.Puntuacion_1_1_a_1_5._1_2;

// Leer el primer número (ignorar los otros dos) y multiplicar por 2 (ida y vuelta)

import java.util.Scanner;

public class EDaysOreCartPull {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int distancia = scan.nextInt();

        // Mostrar la longitud total
        System.out.println(distancia*2);

    }
}