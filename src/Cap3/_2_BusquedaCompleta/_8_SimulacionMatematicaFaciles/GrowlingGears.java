package Cap3._2_BusquedaCompleta._8_SimulacionMatematicaFaciles;

// El máximo de la función es el 0 de la derivada
// La derivada de la función es T'(R) = -2aR + b
// Por lo tanto, el máximo se alcanza cuando R = b/(2a)
// Tmax = -a*(b/(2a))^2 + b * (b/(2a)) + c
// Simular para cada una de las marchas y quedarnos con el máximo
import java.util.Scanner;

public class GrowlingGears {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Leer el número de casos de prueba
        int numCasos = scan.nextInt();
        for (int i = 0; i < numCasos; i++) {
            // Leer los datos del caso de prueba
            int numMarchas = scan.nextInt();
            // Leer los datos de cada marcha
            double maxR = Double.MIN_VALUE; // Para almacenar el máximo de R
            int numMarcha = 0; // Para almacenar el número de marcha que da el máximo
            for (int j = 0; j < numMarchas; j++) {
                int a = scan.nextInt();
                int b = scan.nextInt();
                int c = scan.nextInt();

                // Calcular el máximo de la función T(R) = -aR^2 + bR + c
                double T = Tmax(a,b,c);
                if (T > maxR) {
                    maxR = T; // Actualizar el máximo si encontramos uno mayor
                    numMarcha = j+1;
                }

            }

            // Imprimir el número de marcha que da el máximo
            System.out.println(numMarcha);
        }

    }

    private static double Tmax(double a, double b, double c) {
        // Tmax = -a*(b/(2a))^2 + b * (b/(2a)) + c
        double X = (double) b / (2 * a); // Calcular el valor de R que maximiza T(R)
        // Tmax = -a*X^2 + b * X + c
        double T = -a * X * X + b * X + c; // Calcular el máximo de la función T(R)
        return T; // Devolver el máximo
    }


}


