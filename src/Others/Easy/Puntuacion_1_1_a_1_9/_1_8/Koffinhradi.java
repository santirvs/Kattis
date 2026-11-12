package Others.Easy.Puntuacion_1_1_a_1_9._1_8;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;

public class Koffinhradi {

    /**
     * Clase que representa una tarea de estudio o proyecto.
     * Implementa Comparable para ordenar las tareas de menor a mayor según su fecha límite (deadline).
     */
    static class Task implements Comparable<Task> {
        long duration; // Duración inicial en horas (sin cafeína)
        long deadline; // Plazo límite en horas desde el inicio

        public Task(long duration, long deadline) {
            this.duration = duration;
            this.deadline = deadline;
        }

        @Override
        public int compareTo(Task other) {
            // Regla de Jackson / EDF: Ordenamos las tareas prioritariamente por su deadline ascendente.
            if (this.deadline < other.deadline) {
                return -1;
            } else if (this.deadline > other.deadline) {
                return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        // Utilizamos BufferedReader para una lectura rápida y eficiente de la entrada estándar.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int n = Integer.parseInt(line.trim());
        Task[] tasks = new Task[n];

        // Lectura de los datos de cada tarea
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            long duration = Long.parseLong(st.nextToken());
            long deadline = Long.parseLong(st.nextToken());
            tasks[i] = new Task(duration, deadline);
        }

        // Paso 1: Ordenar las tareas usando el criterio Earliest Deadline First (EDF)
        Arrays.sort(tasks);

        // Paso 2: Configurar un Max-Heap (Cola de Prioridad de Máximos) para las duraciones.
        // En Java, PriorityQueue por defecto es un Min-Heap, por lo que usamos Collections.reverseOrder()
        // para asegurarnos de extraer siempre la tarea con mayor duración primero.
        PriorityQueue<Long> maxHeap = new PriorityQueue<Long>(11, Collections.reverseOrder());

        long currentTime = 0;       // Tiempo total acumulado de ejecución
        long beveragesCount = 0;    // Contador total de bebidas con cafeína utilizadas

        // Paso 3: Simulación iterativa de la asignación de tiempo y consumo de cafeína
        for (int i = 0; i < n; i++) {
            long t = tasks[i].duration;
            long d = tasks[i].deadline;

            // Añadimos la duración de la tarea actual al tiempo total y al Max-Heap
            currentTime += t;
            maxHeap.add(t);

            // Paso 4: Evaluación perezosa (Lazy Greedy)
            // Si el tiempo acumulado supera la fecha límite de la tarea actual, significa que
            // nos hemos pasado del plazo y necesitamos "gastar" cafeína.
            while (currentTime > d) {
                // Seleccionamos la tarea con mayor duración procesada hasta el momento,
                // ya que reducirla a la mitad es lo que nos da el mayor ahorro absoluto de horas.
                long maxDuration = maxHeap.poll();

                // Aplicamos la bebida: reduce a la mitad redondeando hacia abajo (división entera)
                long reducedDuration = maxDuration / 2;

                // Actualizamos el reloj restando las horas que nos hemos ahorrado
                currentTime -= (maxDuration - reducedDuration);

                // Volvemos a insertar la duración reducida en el Max-Heap
                // (por si acaso esa misma tarea necesita otra bebida más adelante)
                maxHeap.add(reducedDuration);

                // Incrementamos el contador de bebidas utilizadas
                beveragesCount++;
            }
        }

        // Imprimir el resultado final con la cantidad mínima de bebidas necesarias
        System.out.println(beveragesCount);
    }
}