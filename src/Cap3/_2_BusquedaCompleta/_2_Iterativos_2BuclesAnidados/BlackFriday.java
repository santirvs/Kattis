package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;

// Las caras del dado (y las soluciones) son del 1 al 6
// La solución es el jugador que más puntos ha obtenido de manera única, por lo tanto, si hay empate, no hay ganador
// Para cada una de las caras del dado, podemos tener 3 posibilidades:
// 1.- Un concursante ha obtenido esa puntuación  (guardar el número del concursante)
// 2.- Varios concursantes han obtenido esa puntuación  (marcar la puntuación como no válida. Ej: -1)
// 3.- Ningún concursante ha obtenido esa puntuación  (no hacer nada)

import java.util.Scanner;

public class BlackFriday {

    static int resultados[] = {0,0,0,0,0,0}; // Array para almacenar los resultados de cada concursante (de 1 a 6)

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numJugadores = scan.nextInt(); // Número de jugadores
        for (int i = 0; i < numJugadores; i++) {
            int puntuacion = scan.nextInt(); // Puntuación del jugador
            if (resultados[puntuacion - 1] == 0) {
                resultados[puntuacion - 1] = i + 1; // Guardamos el número del concursante (i+1 porque los concursantes empiezan en 1)
            } else {
                resultados[puntuacion - 1] = -1; // Marcamos la puntuación como no válida
            }
        }

        // Buscar el ganador
        int ganador = -1;
        for (int i = 5; i>=0 && ganador == -1; i--) { // Empezamos desde la puntuación más alta (6) hasta la más baja (1), mientras no se haya encontrado un ganador
            if (resultados[i] > 0) { // Si sólo hay un concursante con esa puntuación
                ganador = resultados[i]; // Guardamos el ganador
            }
        }

        // Imprimir el ganador
        if (ganador == -1) {
            System.out.println("none");
        } else {
            System.out.println(ganador); // Imprimimos el número del concursante ganador
        }

    }
}