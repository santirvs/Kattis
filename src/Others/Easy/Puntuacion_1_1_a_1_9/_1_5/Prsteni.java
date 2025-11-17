package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Problema de reduccion de fracciones
// Leer la cantidad de casos
// Leer el primer caso (denominador)
// Leer el resto de casos (numerador)
// Mostrar la fracción reducida
// Calcular el mcd de ambos números y dividirlos

import java.util.Scanner;


public class Prsteni {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de casos
        int numCasos = sc.nextInt();

        // Leer el primer caso (denominador)
        int denominador = sc.nextInt();

        // Leer el resto de casos (numerador)
        for (int i=2; i<= numCasos; i++) {
            int numerador = sc.nextInt();
            // Calcular el mcd de ambos números y dividirlos
            int mcd = mcd(numerador,denominador);

            // Mostrar la fracción reducida
            System.out.println( denominador/mcd + "/" + numerador/mcd);
        }

        sc.close();
    }


    public static int mcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return mcd(b, a % b);
    }
}

