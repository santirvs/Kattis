package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * Leer todas las tareas y seleccionar siempre con la que acabe antes sin que se solape con las que ya tenemos
 * Usar lista ordenada por el tiempo de finalizacion
 *
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class SpeedRun {

    public static class Task implements Comparable<Task> {
        int inicio;
        int fin;

        Task (int inicio, int fin) {
            this.inicio = inicio;
            this.fin = fin;
        }

        @Override
        public int compareTo( Task o) {
            return this.fin - o.fin;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numTasksNecesarias = sc.nextInt();
        int numTasksPosibles = sc.nextInt();

        List<Task> lista = new ArrayList<>();

        //Leer las tareas
        for (int i=0; i<numTasksPosibles; i++) {
            lista.add( new Task(sc.nextInt(), sc.nextInt()));
        }

        //Ordenar la lista de tareas
        Collections.sort(lista);

        //Recorrer la lista, y contar las tareas que no se solapan
        int numTareasPosibles = 0;
        int inicioDisponibilidad = 0;

        for (Task t : lista) {
            if (t.inicio >= inicioDisponibilidad) {
                numTareasPosibles++;
                inicioDisponibilidad = t.fin;
            }
        }

        //Mostrar resultado
        if (numTareasPosibles >= numTasksNecesarias) System.out.println("YES");
        else System.out.println("NO");

    }
}

