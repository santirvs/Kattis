package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer las coordenadas x e y de donde se encuentra la cabra
// Leer las coordenadas x1,y1 y x2,y2 que definen la casa
// Calcular la distancia mínima desde la cabra a la casa
// Imprimir la distancia con 6 decimales

import java.util.Scanner;


public class GoatRope {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer las coordenadas x e y de donde se encuentra la cabra
        double xCabra = sc.nextDouble();
        double yCabra = sc.nextDouble();
        // Leer las coordenadas x1,y1 y x2,y2 que definen la casa
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        // Calcular la distancia mínima desde la cabra a la casa
        // Se calcula "a lo bruto", probando todos los puntos de la casa
        // Se podría optimizar calculando la distancia a los bordes y esquinas
        double distanciaMinima = Double.MAX_VALUE;
        for (double x = x1; x <= x2; x++) {
            for (double y = y1; y <= y2; y++) {
                double distancia = Math.sqrt(Math.pow(x - xCabra, 2) + Math.pow(y - yCabra, 2));
                if (distancia < distanciaMinima) {
                    distanciaMinima = distancia;
                }
            }
        }

        // Imprimir la distancia con 6 decimales
        System.out.printf("%.6f%n", distanciaMinima);

        sc.close();
    }
}

