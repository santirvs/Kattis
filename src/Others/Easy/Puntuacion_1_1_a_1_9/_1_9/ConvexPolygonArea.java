package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Aplicar la fórmula de ShoeLace
 *
 *  Area = 1/2 Suma ( Xi * Yi+1  -  Xi+1 * Yi)
 */


import java.io.IOException;
import java.util.Scanner;

public class ConvexPolygonArea {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();

        while (numCasos-- > 0) {

            int numPuntos = sc.nextInt();
            double[] X = new double[numPuntos];
            double[] Y = new double[numPuntos];

            //Lectura de los vertices
            for (int i=0; i<numPuntos; i++) {
                X[i] = sc.nextDouble();
                Y[i] = sc.nextDouble();
            }

            //Calculo del área  (fórmula de Shoelace)
            double area = 0;
            // Sumatorio
            for (int i=0; i<numPuntos; i++) {
                area +=  X[i]*Y[(i+1)%numPuntos] - X[(i+1)%numPuntos]*Y[i];
            }

            // 1/2
            area = area * 0.5;

            //Mostrar el resultado
            System.out.println(area);


        }
    }
}