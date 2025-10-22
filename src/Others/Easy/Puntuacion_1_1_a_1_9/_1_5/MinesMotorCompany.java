package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

//

import java.util.Scanner;

public class MinesMotorCompany {

    // Leer el número de estaciones a visitar
    // Leer la estación de inicio
    // Para el resto de estaciones,
    //  - Leer la distancia a la siguiente estación
    //  - Calcular la distancia de Manhattan entre la estación actual y la siguiente
    //  - Acumular la distancia total
    // Al final, mostrar la distancia total
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de estaciones
        int n = sc.nextInt();
        // Leer la estación de inicio
        String estacionActual = sc.next();
        int distanciaTotal = 0;
        // Recorrer las estaciones restantes
        for (int i = 1; i < n; i++) {
            String estacionSiguiente = sc.next();
            // Calcular la distancia de Manhattan
            int distancia = Math.abs(estacionActual.charAt(0) - estacionSiguiente.charAt(0)) +
                            Math.abs(estacionActual.charAt(1) - estacionSiguiente.charAt(1));
            distanciaTotal += distancia;
            estacionActual = estacionSiguiente;
        }
        // Mostrar la distancia total
        System.out.println(distanciaTotal);

        sc.close();
    }
}

