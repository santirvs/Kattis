package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer las cantidades y sumar los positivos y negativos por separado
// Comparar las sumas y mostrar el resultado:
// Si hay más negativos, imprimir "Nekad"
// Si hay más positivos, imprimir "Usch, vinst"
// Si son iguales, imprimir "Lagom"

import java.util.Scanner;

public class ProgrammeringsolympiadensBudget {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int n = scan.nextInt();
        int positiveSum = 0;
        int negativeSum = 0;
        for (int i = 0; i < n; i++) {
            scan.next(); // Leer y descartar la descripción
            int a = scan.nextInt();
            if (a > 0) {
                positiveSum += a;
            } else {
                negativeSum -= a;
            }
        }

        //Comparar las sumas y mostrar el resultado
        if (negativeSum > positiveSum) {
            System.out.println("Nekad");
        } else if (positiveSum > negativeSum) {
            System.out.println("Usch, vinst");
        } else {
            System.out.println("Lagom");
        }


    }
}