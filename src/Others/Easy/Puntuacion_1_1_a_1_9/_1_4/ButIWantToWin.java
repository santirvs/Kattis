package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el número de candidatos
// Cargar los votos para cada candidato
// Sumar los votos
// Ordenar los votos
// Mientras el primero o segundo no tengan más votos de la mitad
// Eliminar el que menos votos tenga (ojo que puede ser más de uno)
// Añadirlos al segundo clasificado


import java.util.Arrays;
import java.util.Scanner;

public class ButIWantToWin {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Leer el número de candidatos
        int numCandidatos = sc.nextInt();
        int[] votaciones = new int[numCandidatos];
        int totalVotos = 0;
        // Cargar los votos para cada candidato
        for (int i=0; i<numCandidatos; i++) {
            // Sumar los votos
            int votos = sc.nextInt();
            totalVotos += votos;
            votaciones[i] = votos;
        }

            // Ordenar los votos
        Arrays.sort(votaciones);  // orden ascendente
            // Mientras el primero o segundo no tengan más votos de la mitad
        int numVotosGanador = totalVotos/2 + 1 ;
        int posicion = 0;
        int numRondas = 0;
        while (votaciones[numCandidatos-1] < numVotosGanador && votaciones[numCandidatos-2] < numVotosGanador && posicion != numCandidatos-2) {
            // Eliminar el que menos votos tenga (ojo que puede ser más de uno)
            // Añadirlos al segundo clasificado
            int votosATraspasar = votaciones[posicion];
            while (votaciones[posicion] == votosATraspasar) {
                votaciones[numCandidatos - 2] += votosATraspasar;
                posicion++;
            }
            numRondas++;
        }

        //Mostrar el resultado
        if (votaciones[numCandidatos-2] >= numVotosGanador) {
            System.out.println(numRondas);
        } else {
            System.out.println("IMPOSSIBLE TO WIN");
        }

        sc.close();
    }
}

