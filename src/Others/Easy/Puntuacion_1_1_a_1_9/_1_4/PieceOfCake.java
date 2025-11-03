package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el lado del pastel
// Leer la posición del corte horizontal
// Leer la posición del corte vertical
// Calcular el área de la mayor pieza resultante
// Calcular el volumen sabiendo que la altura es 4
// Mostrar el resultado

import java.util.Scanner;

public class PieceOfCake {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el lado del pastel
        int lado = sc.nextInt();

        // Leer la posición del corte horizontal
        int corteHorizontal = sc.nextInt();
        // Leer la posición del corte vertical
        int corteVertical = sc.nextInt();

        // Calcular el área de la mayor pieza resultante
        int maxH = Math.max(corteHorizontal, lado - corteHorizontal);
        // Calcular el volumen sabiendo que la altura es 4
        int maxV = Math.max(corteVertical, lado - corteVertical);

        // Mostrar el resultado
        System.out.println(maxH*maxV*4);


        sc.close();
    }
}

