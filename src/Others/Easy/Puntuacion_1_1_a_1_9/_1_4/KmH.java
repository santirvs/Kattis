package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer la cantidad de señales
// Leer cada señal y quedarnos con el valor máximo
// Con cada señal de / calculamos el múltiplo más cercano a 10
// del valor máximo

import java.util.Scanner;

public class KmH {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de señales
        int numSenyales =  sc.nextInt();
        int velocidadMaxima = 0;
        int velocidadActual = 0;

        while (numSenyales-- > 0) {
            String senyal = sc.next();
            if (senyal.equals("/")) {
                if (velocidadMaxima%10 != 0) {
                    velocidadMaxima = velocidadMaxima + (10 - velocidadMaxima % 10);
                }
                velocidadActual = velocidadMaxima;
            } else {
                velocidadActual = Integer.parseInt(senyal);
                velocidadMaxima = Math.max(velocidadMaxima, (velocidadActual+10) - (velocidadActual%10) );
            }
            System.out.println(velocidadActual);

        }

        sc.close();
    }
}

