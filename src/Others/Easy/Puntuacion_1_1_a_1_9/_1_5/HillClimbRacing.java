package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la longitud de un mapa y la aceleración del vehiculo
// Leer la secuencia de pendientes del mapa
// Calcular si cada tramo de subida es superior a la aceleración del vehículo
// Si es así, mostrar "BUG REPORT", si no "POSSIBLE"
// Los tramos de bajada o llanos no afectan al resultado


import java.util.Scanner;


public class HillClimbRacing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer longitud del mapa y aceleración del vehículo
        int mapLength = sc.nextInt();
        int vehicleAcceleration = sc.nextInt();

        boolean possible = true;
        // Leer secuencia de pendientes del mapa
        // Leer la primera pendiente
        int previousSlope = sc.nextInt();
        for (int i = 0; i < mapLength && possible; i++) {
            int slope = sc.nextInt();
            // Comprobar si el tramo es de subida y si supera la aceleración del vehículo
            if (slope > previousSlope && (slope - previousSlope) > vehicleAcceleration) {
                possible = false;
            }
            previousSlope = slope;
        }
        // Mostrar resultado
        if (possible) {
            System.out.println("POSSIBLE");
        } else {
            System.out.println("BUG REPORT");
        }
    }
}

