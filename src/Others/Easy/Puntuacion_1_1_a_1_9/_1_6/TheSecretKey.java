package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * No hay límite de número de dígitos binarios...
 * Aplicar la diagonalización de Cantor
 * --> Cambiar el bit i-ésimo de cada elemento i
 * --> El resultado será diferente en un bit de cualquiera de las entradas
 */

import java.util.Scanner;
import java.util.Scanner;

public class TheSecretKey {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        StringBuilder newKey = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            String key = sc.next();
            // Tomamos el carácter i-ésimo de la i-ésima clave e invertimos su bit
            char c = key.charAt(i);
            newKey.append(c == '0' ? '1' : '0');
        }

        System.out.println(newKey.toString());
    }
}