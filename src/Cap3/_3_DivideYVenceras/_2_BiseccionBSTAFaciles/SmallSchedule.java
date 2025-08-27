package Cap3._3_DivideYVenceras._2_BiseccionBSTAFaciles;

// Estrategia de D&C. Bisección binaria

// La mejor manera de abordar este problema es mediante una búsqueda binaria sobre el tiempo mínimo requerido.
// Hay que darse cuenta que la mejor manera de repartir las tareas es siempre llenar cada máquina al máximo posible
// (primero con las tareas largas y luego con las cortas).
// Por lo tanto, para un tiempo máximo dado, se puede simular si es posible completar todas las tareas en ese tiempo.
// Si es posible, se intenta con un tiempo menor; si no, se intenta con un tiempo mayor.

import java.io.*;
import java.util.*;

public class SmallSchedule {

    static int tiempoTareaLarga, numMaquinas, tareasCortasCompradas, tareasLargasCompradas;

    // Verifica si un tiempo máximo dado es suficiente para terminar todas las tareas
    static boolean esPosible(long tiempoMaximo) {
        long cantidadTareasCortas = tareasCortasCompradas, cantidadTareasLargas = tareasLargasCompradas;
        for (int i = 0; i < numMaquinas && (cantidadTareasLargas > 0 || cantidadTareasCortas > 0); i++) {
            long numTareasLargas = Math.min(tiempoMaximo / tiempoTareaLarga, cantidadTareasLargas); // cuántas tareas largas caben en este tiempo
            cantidadTareasLargas -= numTareasLargas;
            long tiempoSobrante = tiempoMaximo - numTareasLargas * tiempoTareaLarga;
            long numTareasCortas = Math.min(tiempoSobrante, cantidadTareasCortas); // llenar con tareas cortas
            cantidadTareasCortas -= numTareasCortas;
        }
        return cantidadTareasLargas == 0 && cantidadTareasCortas == 0; // todas las tareas completadas
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        tiempoTareaLarga = Integer.parseInt(st.nextToken());
        numMaquinas = Integer.parseInt(st.nextToken());
        tareasCortasCompradas = Integer.parseInt(st.nextToken());
        tareasLargasCompradas = Integer.parseInt(st.nextToken());

        long lo = (tareasLargasCompradas > 0 ? tiempoTareaLarga : 0);
        long hi = (long) tiempoTareaLarga * tareasLargasCompradas + tareasCortasCompradas; // límite superior

        // Binary search sobre el tiempo mínimo requerido
        while (lo + 1 < hi) {
            long mid = (lo + hi) / 2;
            if (esPosible(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (esPosible(lo)) hi = lo;

        System.out.println(hi);
    }
}
