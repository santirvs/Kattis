package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer los dos números N y K
// Dividir N / K
// Si N % K no es cero, sumar uno
// Mostrar el resultado

import java.util.Locale;
import java.util.Scanner;


public class CatToys {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        // Leer los dos números N y K
        int numJuguetesTotal = sc.nextInt();
        int numJuguetesDia = sc.nextInt();
        // Dividir N / K
        int resultado = numJuguetesTotal / numJuguetesDia;
        // Si N % K no es cero, sumar uno
        if (numJuguetesTotal % numJuguetesDia != 0) {
            resultado++;
        }
        // Mostrar el resultado
        System.out.println(resultado);

        sc.close();
    }
}

