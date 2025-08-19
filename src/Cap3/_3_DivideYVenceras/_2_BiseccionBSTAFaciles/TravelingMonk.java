package Cap3._3_DivideYVenceras._2_BiseccionBSTAFaciles;

// Estrategia de D&C. Bisección binaria

// Versión reducida del problema: Un monje sube a una velocidad Vs y otro baja a una velocidad Vd.
// Es evidente que en algún momento se cruzarán. Eso es justo lo que se pide: ¿en qué momento se cruzan?

// Si se enfoca el problema como una bisección binaria, se pueden establecer los puntos de inicio y de fin
// del recorrido como 0 y el tiempo máximo que se tarda en subir o bajar.
// Para cada instante, se suman las alturas alcanzadas por cada monje y se comparan:
//   ---> Si la suma es mayor que la altura máxima, ya se han cruzado --> reducir el tiempo
//   ---> Si la suma es menor que la altura máxima, aún no se han cruzado --> aumentar el tiempo

import java.util.Scanner;

public class TravelingMonk {

    static int[][] tramosAscenso;
    static int[][] tramosDescenso;

    static int alturaMaxima; // Altura máxima del recorrido, se puede ajustar según el problema

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Leer los tramos de ascenso y descenso
        int numTramosAscenso = scan.nextInt();
        int numTramosDescenso = scan.nextInt();

        // Leer los tramos de ascenso
        tramosAscenso = new int[numTramosAscenso][2];
        int tiempoAscenso = 0; // Variable para almacenar el tiempo total de ascenso
        for (int i = 0; i < numTramosAscenso; i++) {
            tramosAscenso[i][0] = scan.nextInt(); // altura
            tramosAscenso[i][1] = scan.nextInt(); // tiempo
            tiempoAscenso += tramosAscenso[i][1]; // Sumar el tiempo total de ascenso
            alturaMaxima += tramosAscenso[i][0]; // Sumar la altura máxima
        }
        // Leer los tramos de descenso
        tramosDescenso = new int[numTramosDescenso][2];
        int tiempoDescenso = 0; // Variable para almacenar el tiempo total de descenso
        for (int i = 0; i < numTramosDescenso; i++) {
            tramosDescenso[i][0] = scan.nextInt(); // altura
            tramosDescenso[i][1] = scan.nextInt(); // tiempo
            tiempoDescenso += tramosDescenso[i][1]; // Sumar el tiempo total de descenso
            // Aquí no es necesario sumar la altura máxima, ya que es la misma para ambos monjes
        }

        // Calcular el tiempo máximo de ascenso y descenso
        int tiempoMaximo = Math.max(tiempoAscenso, tiempoDescenso);

        // Bisección binaria para encontrar el tiempo en el que se cruzan
        double tiempo = biseccion(0, tiempoMaximo);

        // Imprimir el tiempo en el que se cruzan
        System.out.printf("%.6f\n", tiempo);

    }

    private static double biseccion(double tiempoMinimo, double tiempoMaximo) {
        double epsilon = 1e-6; // Precisión deseada
        while (tiempoMaximo - tiempoMinimo > epsilon) {
            double tiempoMedio = (tiempoMinimo + tiempoMaximo) / 2.0;

            // Calcular la altura alcanzada por el monje que sube
            double alturaAscenso = calcularAltura(tramosAscenso, tiempoMedio);
            // Calcular la altura alcanzada por el monje que baja
            double alturaDescenso = calcularAltura(tramosDescenso, tiempoMedio);

            // Si la suma de las alturas es mayor o igual a la altura máxima, se han cruzado
            if (alturaAscenso + alturaDescenso >= alturaMaxima) {
                tiempoMaximo = tiempoMedio; // Reducir el tiempo
            } else {
                tiempoMinimo = tiempoMedio; // Aumentar el tiempo
            }
        }
        return (tiempoMinimo + tiempoMaximo) / 2.0; // Retornar el tiempo medio
    }

    private static double calcularAltura(int[][] tramos, double tiempoMaximo) {
        double altura = 0.0;
        double tiempoAcumulado = 0.0;

        for (int[] tramo : tramos) {
            int alturaTramo = tramo[0];
            int tiempoTramo = tramo[1];

            if (tiempoAcumulado + tiempoTramo > tiempoMaximo) {
                // Si el tiempoMaximo acumulado más el tiempoMaximo del tramo supera el tiempoMaximo dado,
                // calcular la proporción del tramo que se ha recorrido
                double proporcion = (tiempoMaximo - tiempoAcumulado) / tiempoTramo;
                altura += proporcion * alturaTramo;
                break; // Salir del bucle, ya que hemos alcanzado el tiempoMaximo deseado
            } else {
                altura += alturaTramo; // Sumar la altura completa del tramo
                tiempoAcumulado += tiempoTramo; // Acumular el tiempoMaximo
            }
        }
        return altura; // Retornar la altura alcanzada) {

    }
}
