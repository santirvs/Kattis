package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer la cantidad de problemas y la cantidad de equipos
// Leer el nombre de los problemas y almacenarlos en un array
// Leer las puntuaciones de cada problema para cada equipo y acumularlas en un array
// Buscar el problema con mayor puntuación acumulada
// Mostrar el nombre del problema con mayor puntuación acumulada

import java.util.Scanner;

public class LettastaVerkefnid {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de problemas y la cantidad de equipos
        int numProblemas = sc.nextInt();
        int numEquipos = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea
        String[] nombresProblemas = new String[numProblemas];
        int[] puntuacionesAcumuladas = new int[numProblemas];
        // Leer el nombre de los problemas
        for (int i = 0; i < numProblemas; i++) {
            nombresProblemas[i] = sc.next();
        }
        // Leer las puntuaciones de cada problema para cada equipo
        for (int i = 0; i < numEquipos; i++) {
            for (int j = 0; j < numProblemas; j++) {
                int puntuacion = sc.nextInt();
                puntuacionesAcumuladas[j] += puntuacion;
            }
        }

        // Buscar el problema con mayor puntuación acumulada
        int maxPuntuacion = -1;
        int indiceMax = -1;
        for (int i = 0; i < numProblemas; i++) {
            if (puntuacionesAcumuladas[i] > maxPuntuacion) {
                maxPuntuacion = puntuacionesAcumuladas[i];
                indiceMax = i;
            }
        }

        // Mostrar el nombre del problema con mayor puntuación acumulada
        System.out.println(nombresProblemas[indiceMax]);

        sc.close();
    }
}

