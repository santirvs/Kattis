package Others.Easy.Puntuacion_1_1_a_1_9._1_9;
import java.util.Scanner;

public class Ants {
    public static void main(String[] args) {
        // Inicializamos el Scanner para leer desde la entrada estándar (System.in)
        Scanner sc = new Scanner(System.in);

        int numCases = sc.nextInt();

        // Procesamos cada caso de prueba de forma independiente
        for (int c = 0; c < numCases; c++) {
            // L: Longitud de la barra (en cm)
            int length = sc.nextInt();
            // n: Número de hormigas en la barra
            int numAnts = sc.nextInt();

            int earliest = 0; // Guardará el tiempo mínimo global
            int latest = 0;   // Guardará el tiempo máximo global

            // Leemos la posición de cada una de las n hormigas
            for (int i = 0; i < numAnts; i++) {
                int pos = sc.nextInt();

                // 1. Calculamos la distancia de la hormiga al extremo más cercano (su tiempo mínimo personal)
                int distToNearEnd = Math.min(pos, length - pos);

                // 2. Calculamos la distancia de la hormiga al extremo más lejano (su tiempo máximo personal)
                int distToFarEnd = Math.max(pos, length - pos);

                // 3. El tiempo mínimo global es el máximo de todos los tiempos mínimos individuales
                // (todas deben haber caído, por lo que manda la que tarda más bajo su mejor opción)
                earliest = Math.max(earliest, distToNearEnd);

                // 4. El tiempo máximo global es el máximo de todos los tiempos máximos individuales
                latest = Math.max(latest, distToFarEnd);
            }

            // Imprimimos el resultado correspondiente al caso de prueba actual
            System.out.println(earliest + " " + latest);
        }

        sc.close();
    }
}