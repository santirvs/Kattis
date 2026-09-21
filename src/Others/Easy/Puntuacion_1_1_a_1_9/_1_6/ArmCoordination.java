package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * El cuadrado más pequeño donde cabrá un círculo de radio N
 * será aquel que tenga un lado de 2*N
 * Por simplicidad, lo situaremos en las coordenadas 0,0 a 2*N,2*N
 * y lo desplazamos a las coordenadas de círculo
 */

import java.util.Scanner;
public class ArmCoordination {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Leer las coordenadas del centro del círculo (x e y)
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        // 2. Leer el radio del círculo
        int radio = scanner.nextInt();

        // 3. Imprimir las 4 esquinas del cuadrado delimitador (en orden alrededor del cuadrado)
        // Inferior izquierda
        System.out.println((x - radio) + " " + (y - radio));
        // Superior izquierda
        System.out.println((x - radio) + " " + (y + radio));
        // Superior derecha
        System.out.println((x + radio) + " " + (y + radio));
        // Inferior derecha
        System.out.println((x + radio) + " " + (y - radio));

        scanner.close();
    }
}