package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Sumar los valores y restar 1 por cada pareja (longitud total = suma - (n-1))

import java.util.Scanner;

public class JumboJavelin {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numVarillas = scan.nextInt();
        int longitudTotal = -numVarillas+1;  // Así, de entrada, restamos 1 por cada valor leído
        for (int i = 1; i <= numVarillas; i++) {
            longitudTotal += scan.nextInt();
        }

        // Mostrar la longitud total
        System.out.println(longitudTotal);

    }
}