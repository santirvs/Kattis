package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la cantidad de casos de prueba
// Para cada caso
//   Leer el instante y el estado del LED
//   Si el instante es menor que el actual y el estado es 0, actualizar el instante menor
// Mostrar el instante menor o -1 si nunca se encontró el LED apagado

import java.util.Locale;
import java.util.Scanner;


public class TestingLEDs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de casos de prueba
        int numCasos = sc.nextInt();
        // Para cada caso
        long instanteMenor = Long.MAX_VALUE;
        boolean apagado = false;
        while (numCasos-- > 0) {
            //   Leer el instante y el estado del LED
            long instante = sc.nextLong();
            int estado = sc.nextInt();
            //   Si el instante es menor que el actual y el estado es 0, actualizar el instante menor
            if (estado == 0 && instante < instanteMenor) {
                instanteMenor = instante;
                apagado = true;
            }
        }
        // Mostrar el instante menor o -1 si nunca se encontró el LED apagado
        if (!apagado)
            System.out.println(-1);
        else
            System.out.println(instanteMenor);


        sc.close();
    }
}

