package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer la cantidad de ingredientes de la bebida 1 y la bebida 2
// Leer los ingredientes de cada bebida (volumen y alcohol), multiplicarlos los valores e irlos acumulando
// Comparar el valor acumulado de ambas bebidas
// Imprimir "same" si son iguales o "different" si son diferentes

import java.util.Scanner;

public class EqualShots {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Leer la cantidad de ingredientes de la bebida 1 y la bebida 2
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();

        // Leer los ingredientes de cada bebida (volumen y alcohol), multiplicarlos los valores e irlos acumulando
        int total1 = 0;
        for (int i = 0; i < n1; i++) {
            int volume = scan.nextInt();
            int alcohol = scan.nextInt();
            total1 += volume * alcohol;
        }
        int total2 = 0;
        for (int i = 0; i < n2; i++) {
            int volume = scan.nextInt();
            int alcohol = scan.nextInt();
            total2 += volume * alcohol;
        }

        // Comparar el valor acumulado de ambas bebidas
        if (total1 == total2) {
            // Imprimir "same" si son iguales
            System.out.println("same");
        } else {
            // o "different" si son diferentes
            System.out.println("different");
        }


    }
}