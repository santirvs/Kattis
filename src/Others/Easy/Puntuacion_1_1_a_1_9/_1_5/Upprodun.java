package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número de clases
// Leer el número de participantes
// Dividir el número de participantes entre el número de clases
// Calcular el módulo (sobrantes), que habrá que añadir a las primeras clases
// Mostrar el número de participantes por clase mediante *

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;


public class Upprodun {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de clases
        int numClases = sc.nextInt();
        int numConcursantes = sc.nextInt();

        // Calcular participantes por clase
        int participantesBase = numConcursantes / numClases;
        int sobrantes = numConcursantes % numClases;

        // Mostrar participantes por clase con * base + sobrante
        for (int i = 0; i < numClases; i++) {
            int participantesEnEstaClase = participantesBase + (i < sobrantes ? 1 : 0);
            for (int j = 0; j < participantesEnEstaClase; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}

