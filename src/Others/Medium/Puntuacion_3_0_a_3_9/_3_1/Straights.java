package Others.Medium.Puntuacion_3_0_a_3_9._3_1;

/*
    Leer los números, ordenarlos e irlos eliminando a medida que vamos detectando "straights" (números consecutivos)
    Pero hay que tener cuidado con los repetidos!!!
    Como solo hay 1000, hacer un mapa de frecuencias y contar las diferencias entre dos números consecutivos
    con un TreeMap nos podemos centrar sólo en los números existentes y además los tenemos ordenados

 */

import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class Straights {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        if (!scan.hasNextInt()) {
            scan.close();
            return;
        }

        int numCartas = scan.nextInt();

        // Usamos un TreeMap para contar las frecuencias.
        // La ventaja es que mantiene las llaves (los números de las cartas) ordenadas de menor a mayor.
        TreeMap<Integer, Integer> frecuencias = new TreeMap<Integer, Integer>();

        for (int i = 0; i < numCartas; i++) {
            int carta = scan.nextInt();
            if (frecuencias.containsKey(carta)) {
                frecuencias.put(carta, frecuencias.get(carta) + 1);
            } else {
                frecuencias.put(carta, 1);
            }
        }

        int totalTurnos = 0;
        int acumuladoAnterior = 0;
        int cartaAnterior = -1;

        // Recorremos las cartas ordenadas por su valor numérico
        for (Map.Entry<Integer, Integer> entry : frecuencias.entrySet()) {
            int cartaActual = entry.getKey();
            int cantidadActual = entry.getValue();

            // Si hay un hueco (ej. de la carta 3 pasamos a la 5),
            // todas las escaleras anteriores se tuvieron que cerrar.
            if (cartaAnterior != -1 && cartaActual != cartaAnterior + 1) {
                acumuladoAnterior = 0;
            }

            // Si el número actual aparece más veces que el anterior,
            // significa que nos vemos obligados a iniciar nuevas escaleras.
            if (cantidadActual > acumuladoAnterior) {
                totalTurnos += (cantidadActual - acumuladoAnterior);
            }

            // Actualizamos las variables para la siguiente iteración
            acumuladoAnterior = cantidadActual;
            cartaAnterior = cartaActual;
        }

        // Mostrar el resultado mínimo de turnos
        System.out.println(totalTurnos);

        scan.close();
    }
}