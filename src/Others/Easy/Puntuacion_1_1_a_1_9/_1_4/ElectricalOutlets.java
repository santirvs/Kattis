package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el número de casos de prueba
// Para cada caso, leer el número de regletas
// Inicialmente hay una salida
// Leer cada regleta y restar 1 a cada regleta (donde se enchufa) y sumar el número de salidas
// Imprimir el total de salidas

import java.util.Scanner;

public class ElectricalOutlets {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de casos de prueba
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            // Para cada caso, leer el número de regletas
            int n = sc.nextInt();
            int salidas = 1; // Inicialmente hay una salida
            // Leer cada regleta y restar 1 a cada regleta (donde se enchufa) y sumar el número de salidas
            for (int j = 0; j < n; j++) {
                int r = sc.nextInt();
                salidas += r - 1;
            }
            // Imprimir el total de salidas
            System.out.println(salidas);
        }
        sc.close();
    }
}

