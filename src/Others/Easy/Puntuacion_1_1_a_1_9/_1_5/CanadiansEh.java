package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la sentencia
// Comprobar si finaliza en "eh?"
// Si es así imprimir "Canadian!"
// Si no, imprimir "Imposter!"

import java.util.Locale;
import java.util.Scanner;


public class CanadiansEh {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        // Leer la sentencia
        String sentencia = sc.nextLine();
        // Comprobar si finaliza en "eh?"
        if (sentencia.endsWith("eh?")) {
            System.out.println("Canadian!");
        } else {
            System.out.println("Imposter!");
        }

        sc.close();
    }
}

