package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el número de casos de prueba
// Para cada caso.
// Leer el ID del caso
// Leer el número de días
// Calcular la suma acumulada de 1 .. numDias  ( n*(n+1) / 2) y sumarle numDias
// Imprimir el resultado

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChanukahChallenge {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer el número de casos
        int numCasos = sc.nextInt();

        //Para cada caso
        for (int i=0; i<numCasos; i++) {
            int ID = sc.nextInt();
            int numDias = sc.nextInt();

            int totalVelas = numDias*(numDias+1)/2 + numDias;

            System.out.println(ID + " " + totalVelas);
        }

        sc.close();
    }
}

