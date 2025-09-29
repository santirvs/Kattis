package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer la cantidad de veces que se pulsa el botón
// Leer los tiempos en que se pulsa el botón
// Inicialmente el cronómetro está en 0 y parado
// Cada vez que se pulsa el botón, si el cronómetro está parado, se pone en marcha
// Si el cronómetro está en marcha, se para y se acumula el tiempo transcurrido
// Al final, si el cronómetro está en marcha, se imprime "still running"
// Si el cronómetro está parado, se imprime el tiempo acumulado

import java.util.Scanner;

public class Stopwatch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de veces que se pulsa el botón
        int n = sc.nextInt();
        boolean enMarcha = false;
        int tiempoAcumulado = 0;
        int ultimoInicio = 0;

        // Leer los tiempos en que se pulsa el botón
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if (enMarcha) {
                // Si el cronómetro está en marcha, se para y se acumula el tiempo transcurrido
                tiempoAcumulado += t - ultimoInicio;
                enMarcha = false;
            } else {
                // Si el cronómetro está parado, se pone en marcha
                ultimoInicio = t;
                enMarcha = true;
            }
        }

        // Al final, si el cronómetro está en marcha, se imprime "still running"
        if (enMarcha) {
            System.out.println("still running");
        } else {
            // Si el cronómetro está parado, se imprime el tiempo acumulado
            System.out.println(tiempoAcumulado);
        }


        sc.close();
    }
}

