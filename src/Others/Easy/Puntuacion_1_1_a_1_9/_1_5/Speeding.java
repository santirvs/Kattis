package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número de mediciones
// Tomar los datos de la primera medición (el número siempre es igual o mayor que 2)
// Para el resto de mediciones
// Leer los datos de la medicion
// Calcular la velocidad del tramo
// Quedarme con la mayor velocidad
// Al final, imprimir la mayor velocidad

import java.util.Scanner;


public class Speeding {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de mediciones
        int mediciones = sc.nextInt();
        // Tomar los datos de la primera medición (el número siempre es igual o mayor que 2)
        int tiempoAnterior = sc.nextInt();
        int distanciaAnterior = sc.nextInt();
        int maxVelocidad = 0;
        // Para el resto de mediciones
        for (int i=1; i<mediciones; i++) {
            // Leer los datos de la medicion
            int tiempoActual = sc.nextInt();
            int distanciaActual = sc.nextInt();

            // Calcular la velocidad del tramo:   distancia / tiempo
            int velocidad = (distanciaActual-distanciaAnterior) / (tiempoActual-tiempoAnterior);

            // Quedarme con la mayor velocidad
            maxVelocidad = Math.max(maxVelocidad, velocidad);

            //Actualizar la medición anterior
            tiempoAnterior = tiempoActual;
            distanciaAnterior = distanciaActual;
        }
        // Al final, imprimir la mayor velocidad
        System.out.println(maxVelocidad);

        sc.close();
    }
}

