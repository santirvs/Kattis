package Cap3._3_DivideYVenceras._2_BiseccionBSTAFaciles;

// Estrategia de D&C. Bisección binaria

// Determinar inicialmente si ya ha ganado o bien es imposible que gane
// Una vez descartado el caso directo, se puede aplicar una bisección binaria
// para encontrar el valor entre 0 y 20 segundos (que debe ser el máximo)
// (se podría ajustar más: desde el tiempo mínimo empleado hasta el máximo tiempo empleado, ya que se descartarían ambos)

// v1. WA en Caso #5
// v2. Añadir un margen EPSILON de 1e-9

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ExpeditiousCubing {

    static final double EPS = 1e-9; // Margen de error para evitar problemas de precisión

    public static double mediaTiempos(double[] tiempos) {
        // Ordenar los tiempos, pero copiados en un nuevo array para no modificar el original
        double[] tiemposCopia = Arrays.copyOf(tiempos, tiempos.length);

        Arrays.sort(tiemposCopia);

        double media = (tiemposCopia[1] + tiemposCopia[2] + tiemposCopia[3] ) / 3.0;

        return media;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.UK);  // Se asegura que los números se leen con punto decimal

        // Leer los tiempos de resolución de los cubos (nos dejamos un último tiempo sin usar)
        double[] tiempos = new double[5];
        for (int i = 0; i < 4; i++) {
            tiempos[i] = sc.nextDouble();
        }

        // Leer el tiempo objetivo
        double tiempoMaximo = sc.nextDouble();

        // Casos directos

        // Infinitos --> Ya ha ganado haga el tiempo que haga
        // No es necesario mejorar los tiempos, en el peor de los casos, ya ha ganado
        tiempos[4] = Double.MAX_VALUE; // Asignar un valor muy grande para el último tiempo
        if (mediaTiempos(tiempos) <= tiempoMaximo + EPS) { // Añadir un pequeño margen para evitar problemas de precisión
            System.out.println("infinite");
            return;
        }

        // Imposible --> No puede ganar
        // Ni haciendo 0 segundos en el último cubo alcanzaría el tiempo máximo
        tiempos[4] = 0.0; // Asignar 0 segundos al último tiempo
        if (mediaTiempos(tiempos) > tiempoMaximo + EPS) {
            System.out.println("impossible");
            return;
        }

        // Bisección binaria para encontrar el tiempo mínimo necesario
        double left = 0.0; // Tiempo mínimo posible
        double right = 20.0; // Tiempo máximo posible (ajustable según el problema)
        double result = right; // Inicializar el resultado con el máximo posible
        for (int i = 0; i < 100; i++) { // 100 iteraciones para precisión
            double mid = (left + right) / 2.0;
            tiempos[4] = mid;
            double tiempoTotal = mediaTiempos(tiempos);

            if (tiempoTotal >= tiempoMaximo + 1e-9) { // Añadir un pequeño margen para evitar problemas de precisión
                result = mid; // Guardar el mejor resultado encontrado
                right = mid; // Buscar un tiempo menor
            } else {
                left = mid; // Buscar un tiempo mayor
            }
        }

        // Imprimir el resultado con 6 decimales
        System.out.printf("%.2f\n", result);
        sc.close();

    }
}
