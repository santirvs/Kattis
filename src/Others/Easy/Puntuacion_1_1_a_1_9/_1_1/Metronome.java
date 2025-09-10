package Others.Easy.Puntuacion_1_1_a_1_9._1_1;

// Leer el número y dividir entre 4
// Presentar el resultado con 2 decimales

import java.util.Scanner;

public class Metronome {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        System.out.printf("%.2f\n",a/4.0);

    }
}