package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número de casos
// Para cada caso, leer un número entero
// Determinar si el número es impar, cuadrado perfecto o nada de eso
// Imprimir "O" si es impar, "S" si es cuadrado perfecto, "OS" si es ambos, o "EMPTY" si no es ninguno


import java.util.Locale;
import java.util.Scanner;


public class WhichNumberKindIsIt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        // Leer el número de casos
        int numCasos = sc.nextInt();

        // Para cada caso, leer un número entero
        for (int i = 0; i < numCasos; i++) {
            int numero = sc.nextInt();
            boolean esImpar = (numero % 2 != 0);
            boolean esCuadradoPerfecto = (Math.sqrt(numero) % 1 == 0);

            // Imprimir "O" si es impar, "S" si es cuadrado perfecto, "OS" si es ambos, o "EMPTY" si no es ninguno
            if (esImpar && esCuadradoPerfecto) {
                System.out.println("OS");
            } else if (esImpar) {
                System.out.println("O");
            } else if (esCuadradoPerfecto) {
                System.out.println("S");
            } else {
                System.out.println("EMPTY");
            }
        }

        sc.close();
    }
}

