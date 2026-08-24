package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Geometría Euclidiana (Geometría normal):
 *   El área de un círculo de radio R se calcula con la fórmula clásica: = Pi * R^2
 *
 * Geometría del Taxi (Taxicab geometry):
 *   La distancia entre el centro (0,0) y un punto (x,y) viene dada por |x| + |y| = R
 *   Esto significa que un "círculo" en geometría del taxi es en realidad un cuadrado rotado a 45° (un rombo)
 *   centrado en el origen. Las esquinas de este cuadrado se encuentran en los puntos (R,0), (0,R), (-R,0) y (0,-R).
 *   La longitud de las diagonales de este cuadrado es 2R.
 *   Por tanto, el área en geometría del taxi es simplemente: A = 2 * R^2
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Herman {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double r = Double.parseDouble(br.readLine().trim());

        // Área en geometría euclidiana
        double euclidianArea = Math.PI * r * r;

        // Área en geometría del taxi (Minkowski)
        double taxicabArea = 2.0 * r * r;

        System.out.printf("%.6f%n", euclidianArea);
        System.out.printf("%.6f%n", taxicabArea);
    }
}