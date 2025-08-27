package Cap3._3_DivideYVenceras._2_BiseccionBSTAFaciles;

// Estrategia de D&C. Bisección binaria

// Buscar la constante de error del velocímetro, de forma que el tiempo empleado en recorrer cada tramo
// sumen el tiempo total del trayecto.
// Se puede hacer una búsqueda binaria sobre la constante de error, desde -1000 hasta un número máximo de 1000 (el rango de lectura del velocímetro).
// Para cada constante de error, se calcula el tiempo total del trayecto.
// Si el tiempo total es menor que el tiempo real, se intenta con una constante mayor; si no, se intenta con una constante menor.
// Después, buscar la constante de error más cercana al resultado encontrado sin excederlo.

// v1. WA en Caso #8
// v2. Ajuste del rango de búsqueda: -minVelocidad a 1e7 --> AC
//     El límite inferior es -minVelocidad, ya que si la constante es menor, alguna velocidad real sería negativa o cero
//     Pero el límite superior puede ser muy grande, ya que no hay un límite en la velocidad real.
//     Aunque si la lectura del velocímetro es entre -1000 y 1000 y el límite inferior real es 0, el límite superior real debería ser 1000.
//     Sin embargo, hay que poner un límite superior muy grande (10^7) para recibir el AC.

import java.util.Scanner;

public class Speed {

    public static final double EPS = 1e-9;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Lectura del número de tramos y tiempo total
        int numTramos = scan.nextInt();
        int tiempoTotal = scan.nextInt();

        //Lectura de los tramos  (distancia y velocidad leída en el velocímetro)
        int[][] tramos = new int[numTramos][2];
        int minVelocidad = Integer.MAX_VALUE;
        for (int i = 0; i < numTramos; i++) {
            tramos[i][0] = scan.nextInt();
            tramos[i][1] = scan.nextInt();
            minVelocidad = Math.min(minVelocidad, tramos[i][1]);
        }

        //Búsqueda binaria de la constante de error
        //El límite inferior es -minVelocidad, ya que si la constante es menor, alguna velocidad real sería negativa o cero
        double low = -minVelocidad, high = 1e7; // 1e7
        while (high - low > EPS) {
            double mid = (low + high) / 2;
            double tiempoCalculado = calcularTiempo(tramos, mid, tiempoTotal);
            if (tiempoCalculado + EPS > tiempoTotal) {
                // Tarda demasiado, la velocidad es demasiado baja --> aumentar la velocidad
                low = mid;
            } else {
                // Tarda poco, la velocidad es demasiado alta --> disminuir la velocidad
                high = mid;
            }
        }

        //Salida del resultado
        System.out.printf("%.9f\n", low);

    }

    private static double calcularTiempo(int[][] tramos, double constante, int tiempoTotal) {
        double tiempo = 0;
        for (int[] tramo : tramos) {
            double velocidadReal = tramo[1] + constante;
            // Optimización: si la velocidad de algún tramo es negativa o cero, el tiempo es infinito
            // Optimización2: si el tiempo acumulado ya supera el tiempo total, no es necesario seguir calculando
            if (velocidadReal <= 0 || (tiempo + EPS) > tiempoTotal) {
                return Double.MAX_VALUE; // Velocidad no válida
            }
            //Acumular el tiempo del tramo
            tiempo += (double) tramo[0] / velocidadReal;
        }
        return tiempo;
    }

}

