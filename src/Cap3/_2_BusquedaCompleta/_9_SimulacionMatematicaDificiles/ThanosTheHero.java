package Cap3._2_BusquedaCompleta._9_SimulacionMatematicaDificiles;

// Buscar por fuerza bruta
// El límite lo marca el último planeta.
// A partir de ahí, debemos eliminar toda la población que exceda del planeta siguiente y tomar la población restante como nueva referencia.
// Si alguna población pasa a ser negativa, se considerará imposible y se imprimirá "1"

// v1. WA en Caso#11
// v2. cambio de planteamiento -> AC



import java.io.*;
import java.util.*;

public class ThanosTheHero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Leer la cantidad de mundos y sus poblaciones
        int n = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().trim().split("\\s+");

        List<Integer> poblacion = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            poblacion.add(Integer.parseInt(parts[i]));
        }

        // Invertimos el array para ir desde el último mundo al primero
        Collections.reverse(poblacion);

        int maxVal = poblacion.get(0) - 1;
        long eliminados = 0;
        boolean impossible = false;

        // Ir desde el segundo mundo hasta el último
        // y comparar con el máximo permitido
        for (int mundo = 1; mundo < n; mundo++) {
            // Si la población del mundo actual es mayor o igual que el máximo permitido
            // debemos eliminar la diferencia y ajustar el máximo permitido
            if (poblacion.get(mundo) >= maxVal) {
                eliminados += poblacion.get(mundo) - maxVal;
                poblacion.set(mundo, maxVal);
                maxVal--;
            } else {
                // sino, actualizamos el máximo permitido
                maxVal = poblacion.get(mundo) - 1;
            }

            if (maxVal < 0) {
                // Si el máximo permitido es negativo, es imposible
                impossible = true;
                break;
            }
        }

        if (impossible) {
            System.out.println(1);
        } else {
            System.out.println(eliminados);
        }
    }
}


