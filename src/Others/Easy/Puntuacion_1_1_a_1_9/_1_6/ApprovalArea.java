package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

import java.util.Scanner;

public class ApprovalArea {

    public static void main(String[] args) {
        // Inicializamos Scanner para leer la entrada estándar
        Scanner scanner = new Scanner(System.in);

        // Comprobamos que exista una entrada disponible
        if (scanner.hasNextLong()) {
            // Leemos el valor de U (unhappiness / infelicidad actual)
            // Dado que U <= 4 * 10^15, un 'long' de 64 bits es suficiente.
            long U = scanner.nextLong();

            /*
             * PLANTEAMIENTO GEOMÉTRICO:
             * 1. La infelicidad actual está dada por: U = dist(P_actual, P_ideal)^2.
             * 2. El votante aceptará cualquier nueva política cuya infelicidad sea <= U:
             *    dist(P_nueva, P_ideal)^2 <= U  ==>  dist(P_nueva, P_ideal) <= sqrt(U).
             * 3. Esto define un círculo centrado en P_ideal con radio R = sqrt(U).
             * 4. El área de un círculo es: Área = PI * R^2 = PI * (sqrt(U))^2 = PI * U.
             */

            // Calculamos el área multiplicando la constante Math.PI por el valor de U
            double area = Math.PI * U;

            // Imprimimos el resultado. System.out.println dará formato al double
            // con la precisión necesaria para pasar el límite de error relativo.
            System.out.println(area);
        }

        // Cerramos el recurso del scanner
        scanner.close();
    }
}