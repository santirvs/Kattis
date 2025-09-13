package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer la cantidad de maletas
// Leer el número de la maleta que se quiere comprobar
// Leer cada una de las maletas
// Si es la primera imprimir "fyrst", si es la segunda "naestfyrst", y sinó imprimir pos fyrst.

import java.util.Scanner;

public class Barcelona {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //Leer los datos
        int n = scan.nextInt();
        int maleta = scan.nextInt();
        boolean salir = false;
        for (int i = 1; i <= n && !salir; i++) {
            int numero = scan.nextInt();
            if (numero == maleta) {
                if (i == 1) {
                    System.out.println("fyrst");
                } else if (i == 2) {
                    System.out.println("naestfyrst");
                } else {
                    System.out.println(i + " fyrst");
                }
                salir = true;
            }

        }

    }
}