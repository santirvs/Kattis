package Cap3._2_BusquedaCompleta._8_SimulacionMatematicaFaciles;

// Problema sencillo de simulación por búsqueda completa.
// Calcular el tiempo inicial de un vídeo teniendo en cuenta eventos que aceleran la reproducción.
// Cada evento aumenta la velocidad de reproducción en un porcentaje dado.
// La simulación se realiza hacia atrás desde el tiempo total del vídeo hasta el primer evento, teniendo
// en cuenta la velocidad de reproducción en cada momento.


import java.util.Scanner;

public class VideoSpeedUp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Leer los datos
        int numEventos = scan.nextInt(); // Número de eventos
        int porcentaje = scan.nextInt(); // Porcentaje de velocidad de reproducción
        int tiempoTotal = scan.nextInt(); // Tiempo total del vídeo en segundos

        // Leer los tiempos de cada evento
        int[] tiemposEventos = new int[numEventos];
        int velocidadFinal = 100; // Velocidad final del vídeo (inicialmente es 100%)
        for (int i = 0; i < numEventos; i++) {
            tiemposEventos[i] = scan.nextInt(); // Tiempo del evento i
            velocidadFinal += porcentaje;
        }

        // Calcular el tiempo inicial del vídeo
        // Calcular hacia atrás el tiempo total del vídeo entre los eventos
        double tiempoInicial = 0;
        double eventoAnterior = tiempoTotal; // Tiempo del último evento

        for (int i = numEventos-1; i>=0; i--) {
            // Calcular el tiempo de reproducción del evento i
            double tiempoEvento = (eventoAnterior - tiemposEventos[i]) * velocidadFinal / 100.0;
            // Calcular el tiempo de reproducción a velocidad normal
            tiempoInicial += tiempoEvento;

            // DEBUG
            /*System.out.println("Entre el tiempo " + tiemposEventos[i] + " y " + eventoAnterior +
                               ", el tiempo de reproducción es: " + tiempoEvento +
                               " segundos a velocidad " + velocidadFinal + "%");
            System.out.println("Tiempo total acumulado hasta ahora: " + tiempoInicial + " segundos");
            */

            // Actualizar el evento anterior
            eventoAnterior = tiemposEventos[i];

            // Reducir la velocidad final para el siguiente evento
            velocidadFinal -= porcentaje;

        }

        // Añadir el tiempo del primer evento que ya será a velocidad normal
        tiempoInicial += tiemposEventos[0] * velocidadFinal / 100.0;

        // DEBUG
        /*
        System.out.println("Tiempo del primer evento a velocidad normal: " + (tiemposEventos[0] * (velocidadFinal / 100.0))+ " segundos");
        */

        // Mostrar el tiempo inicial del vídeo
        System.out.println(tiempoInicial);

    }

}


