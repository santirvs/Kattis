package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer la cantidad de paradas
// Empezar con un bus con 0 pasajeros
// Para cada parada
//      Restar las personas que bajan
//      Sumar las personas que suben
//      Guardar el máximo de personas
// Finalmente, mostrar el máximo


import java.util.Scanner;

public class BusAssignment {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de paradas
        int numParadas = sc.nextInt();

        int numPasajeros = 0;
        int maxPasajeros = 0;

        //Tratar las paradas
        for (int i = 0; i < numParadas; i++) {
            int numBajan = sc.nextInt();
            int numSuben =  sc.nextInt();
            numPasajeros = numPasajeros - numBajan + numSuben;
            maxPasajeros = Math.max(numPasajeros, maxPasajeros);
        }

        //Mostrar el máximo
        System.out.println(maxPasajeros);

        sc.close();
    }
}

