package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el número de jueces total y el número de veredictos
// Leer y acumular los veredictos
// Estimar el mínimo y el máximo de puntos pendientes (JT-NV * 3 y -3)
// Calcular la media para el máximo y mínimo

import java.util.Scanner;

public class RatingProblems {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer número de jueces y número de veredictos emitidos
        int numJueces = sc.nextInt();
        int numVeredictos = sc.nextInt();

        // Leer y acumular las puntuaciones
        int puntosTotales = 0;
        for (int i = 1; i <= numVeredictos; i++) {
            puntosTotales += sc.nextInt();
        }

        // Estimar las puntuaciones máximas y mínimas
        int estimacionMinima = puntosTotales - 3*(numJueces-numVeredictos);
        int estimacionMaxima = puntosTotales + 3*(numJueces-numVeredictos);

        // Imprimir la media de cada estimacion, con 4 decimales
        System.out.printf("%.4f %.4f\n",estimacionMinima/(float)numJueces, estimacionMaxima/(float)numJueces);

        sc.close();
    }
}

