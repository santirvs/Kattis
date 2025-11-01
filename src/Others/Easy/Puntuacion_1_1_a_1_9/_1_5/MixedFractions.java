package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer numerador y denominador
// Mientras no sean ambos cero,
//    Calcular la parte entera como numerador / denominador
//    Calcular el nuevo numerador como numerador % denominador
//    Imprimir la parte entera, el numerador y el denominador

import java.util.Scanner;


public class MixedFractions {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer numerador y denominador
        int numerador = sc.nextInt();
        int denominador = sc.nextInt();
        // Mientras no sean ambos cero,
        while (numerador != 0 || denominador != 0) {
            // Calcular la parte entera como numerador / denominador
            int parteEntera = numerador / denominador;
            // Calcular el nuevo numerador como numerador % denominador
            int nuevoNumerador = numerador % denominador;
            // Imprimir la parte entera, el numerador y el denominador
            System.out.println(parteEntera + " " + nuevoNumerador + " / " + denominador);
            // Leer el siguiente numerador y denominador
            numerador = sc.nextInt();
            denominador = sc.nextInt();
        }

        sc.close();
    }
}

