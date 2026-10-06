package Others.Easy.Puntuacion_2_0_a_2_9._2_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AssigningWorkstations {

    // Clase auxiliar para almacenar la información de cada investigador
    static class Researcher {
        int arrival;  // Tiempo de llegada (a_i)
        int stay;     // Duración de la sesión (s_i)

        public Researcher(int arrival, int stay) {
            this.arrival = arrival;
            this.stay = stay;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) {
            return;
        }

        int n = sc.nextInt(); // Número de investigadores
        int m = sc.nextInt(); // Tiempo de inactividad antes de auto-bloquearse

        Researcher[] researchers = new Researcher[n];
        for (int i = 0; i < n; i++) {
            int arrival = sc.nextInt();
            int stay = sc.nextInt();
            researchers[i] = new Researcher(arrival, stay);
        }

        // 1. Ordenar los investigadores por tiempo de llegada ascendente
        Arrays.sort(researchers, new Comparator<Researcher>() {
            @Override
            public int compare(Researcher r1, Researcher r2) {
                return Integer.compare(r1.arrival, r2.arrival);
            }
        });

        // 2. PriorityQueue (Min-Heap) para almacenar los tiempos en que las estaciones quedan libres
        PriorityQueue<Integer> availableStations = new PriorityQueue<Integer>();

        int savedUnlocks = 0; // Contador de desbloqueos ahorrados

        // 3. Procesar cada investigador en orden cronológico de llegada
        for (int i = 0; i < n; i++) {
            Researcher curr = researchers[i];

            // A. Eliminar estaciones que ya se hayan bloqueado automáticamente
            // Una estación se bloquea si: (tiempo_liberacion + m) < tiempo_llegada_actual
            while (!availableStations.isEmpty() && availableStations.peek() + m < curr.arrival) {
                availableStations.poll();
            }

            // B. Comprobar si existe alguna estación desocupada y aún unlocked
            // Requisito: tiempo_liberacion <= tiempo_llegada_actual
            if (!availableStations.isEmpty() && availableStations.peek() <= curr.arrival) {
                // Reutilizamos la estación disponible más antigua
                availableStations.poll();
                savedUnlocks++; // Penelope se ahorra un desbloqueo
            }

            // C. Registrar el nuevo tiempo de liberación para la estación asignada
            availableStations.add(curr.arrival + curr.stay);
        }

        // 4. Imprimir el resultado final
        System.out.println(savedUnlocks);

        sc.close();
    }
}