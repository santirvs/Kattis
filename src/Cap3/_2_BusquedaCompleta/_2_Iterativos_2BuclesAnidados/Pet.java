package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;

// Siempre son 5 concursantes
// Leer 5 veces las líneas de puntución de cada concursante (que serán de 4 números)
// Sumar las puntuaciones y quedarnos con el concursante que más puntos ha obtenido.

import java.util.*;

public class Pet {

    static int NUM_CONCURSANTES = 5;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int maxPuntuacion = 0;
        int ganador = 0;

        for (int concursante=1; concursante <= NUM_CONCURSANTES; concursante++) {
            int puntuacion = 0;
            for (int i = 0; i < NUM_CONCURSANTES-1; i++) {
                puntuacion += scan.nextInt(); // Leer las puntuaciones de cada concursante
            }
            if (puntuacion > maxPuntuacion) {
                maxPuntuacion = puntuacion; // Actualizar la máxima puntuación
                ganador = concursante; // Actualizar el ganador
            }
        }
        // Imprimir el ganador y su puntuación
        System.out.println(ganador + " " + maxPuntuacion);
    }
}