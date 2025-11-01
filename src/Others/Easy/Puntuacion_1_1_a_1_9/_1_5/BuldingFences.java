package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número de plantas
// Leer las coordenadas de cada planta
// Guardarnos la X mínima, máxima, Y mínima y máxima
// Calcular el perímetro del rectángulo que las contiene a todas
// Como 2 * (maximo -minimo)+2 para X y para la Y
// Imprimir el perímetro

import java.util.Scanner;

public class BuldingFences {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de plantas
        int numPlantas = sc.nextInt();
        int xMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE;
        // Leer las coordenadas de cada planta
        for (int i = 0; i < numPlantas; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            xMin = Math.min(xMin, x);
            xMax = Math.max(xMax, x);
            yMin = Math.min(yMin, y);
            yMax = Math.max(yMax, y);
        }

        // Calcular el perímetro del rectángulo que las contiene a todas
        int perimetro = 2 * ((xMax - xMin)+2) + 2*((yMax - yMin)+2);

        // Imprimir el perímetro
        System.out.println(perimetro);

        sc.close();
    }
}

