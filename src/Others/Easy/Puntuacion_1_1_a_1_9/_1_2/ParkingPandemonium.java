package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer el primer y tercer valor y multiplicarlos

import java.util.Scanner;

public class ParkingPandemonium {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int tiempoVuelta = scan.nextInt();
        scan.nextInt();
        int numVueltas = scan.nextInt();

        // Mostrar la longitud total
        System.out.println(tiempoVuelta*numVueltas);

    }
}