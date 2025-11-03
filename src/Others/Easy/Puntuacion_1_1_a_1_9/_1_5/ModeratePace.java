package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el numero de dias a entrenar
// Leer las distancias para el primer corredor
// Leer las distancias para el segundo corredor
// Leer las distancias para el tercer corredor
// Para cada dia, mostrar la mediana

import java.util.Scanner;


public class ModeratePace {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el numero de dias a entrenar
        int numDias = sc.nextInt();

        int[][] distancias = new int[3][numDias];
        //Para cada corredor
        for (int corredor =0; corredor <3; corredor++) {
            // Leer las distancias
            for (int distancia=0; distancia<numDias; distancia++) {
                distancias[corredor][distancia]=sc.nextInt();
            }
        }
        // Para cada dia, mostrar la mediana
        for (int dia=0; dia < numDias; dia++) {
            if (dia!=0) System.out.print(" ");
            if (distancias[0][dia] >= distancias[1][dia] && distancias[0][dia] <= distancias[2][dia] ||
                    distancias[0][dia] <= distancias[1][dia] && distancias[0][dia] >= distancias[2][dia] ) {
                System.out.print(distancias[0][dia]);
            } else if (distancias[1][dia] >= distancias[0][dia] && distancias[1][dia] <= distancias[2][dia] ||
                    distancias[1][dia] <= distancias[0][dia] && distancias[1][dia] >= distancias[2][dia]) {
                System.out.print(distancias[1][dia]);
            } else {
                System.out.print(distancias[2][dia]);
            }
        }
        System.out.println("");

        sc.close();
    }
}

