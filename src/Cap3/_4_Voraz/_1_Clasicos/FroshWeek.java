package Cap3._4_Voraz._1_Clasicos;

// Estrategia Voraz. Clásicos.

/*
 Problema típico de emparejamiento bipartito
 Aplicar una estragegia voraz para asignar cada tarea a un intervalo.
 Se ordenan las tareas por su duración decreciente.
 Se ordenan los intervalos por su duración decreciente.
 Se asigna cada tarea al primer intervalo que la pueda cubrir.
 Si no hay ningún intervalo que pueda cubrir la tarea, se descarta.
 El número de tareas asignadas es el resultado.
 Si hay varias tareas con la misma duración, se pueden asignar en cualquier orden.
 Si hay varios intervalos con la misma duración, se pueden usar en cualquier orden.
 El algoritmo es O(n log n) por la ordenación.
*/

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class FroshWeek {

    public static void main(String[] args) throws IOException {
        // Con 200.000 entradas, es necesario un scanner rápido
        FastScanner sc = new FastScanner();

        // Leer el número de tareas y el número de intervalos
        int numTareas = sc.nextInt();
        int numIntervalos = sc.nextInt();
        int[] tareas = new int[numTareas];
        int[] intervalos = new int[numIntervalos];
        for (int i = 0; i < numTareas; i++) {
            tareas[i] = sc.nextInt();
        }
        for (int i = 0; i < numIntervalos; i++) {
            intervalos[i] = sc.nextInt();
        }
        // Ordenar las tareas y los intervalos por duración decreciente
        Arrays.sort(tareas);
        Arrays.sort(intervalos);

        // Asignar las tareas a los intervalos
        // El recorrido se hace en orden decreciente para simular una ordenación decreciente
        // Si una tarea no cabe en un intervalo, ningún intervalo menor podrá asumirla. Se descarta la tarea
        int tareasAsignadas = 0;
        int j = numTareas - 1; // Puntero para las tareas
        for (int i = numIntervalos - 1; i >= 0; i--) {
            int duracionIntervalo = intervalos[i];
            // Avanzar el puntero de tareas hasta encontrar una que encaje en el intervalo
            while (j >= 0 && tareas[j] > duracionIntervalo) {
                j--;
            }
            if (j >= 0) {
                // Se ha encontrado una tarea que se ajusta al intervalo
                tareasAsignadas++;
                j--; // Usar esta tarea y pasar a la siguiente
            } else {
                // No hay tareas que puedan ajustarse a este intervalo o a intervalos menores
                break;
            }
        }

        // Imprimir el número de tareas asignadas
        System.out.println(tareasAsignadas);
    }

    // Scanner rápido
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = readByte()) != -1 && c <= ' ');
            if (c == -1) return null;
            do {
                sb.append((char)c);
            } while ((c = readByte()) != -1 && c > ' ');
            return sb.toString();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
