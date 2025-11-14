package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el número de intervalos
// Leer la cantidad mínima de usuarios
// Definir un int[] de tamaño intervalos
// Leer cada uno de los intervalos (ini, fin)
// Incrementar el rango (ini, fin)
// Contar la cantidad de tramos donde hay al menos los usuarios buscados

import java.util.Scanner;

public class Intervals {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de intervalos
        int numIntervalos = sc.nextInt();
        // Leer la cantidad mínima de usuarios
        int numUsuarios = sc.nextInt();
        // Definir un int[] de tamaño 25 (0..24 horas)
        int[] intervalos = new int[25];
        // Leer cada uno de los intervalos (ini, fin)
        for (int i = 0; i < numIntervalos; i++) {
            // Incrementar el rango (ini, fin)
            int ini = sc.nextInt();
            int fin = sc.nextInt();
            for (int j = ini; j < fin; j++) {
                intervalos[j]++;
            }
        }


        // Contar la cantidad de tramos donde hay al menos los usuarios buscados
        int contador = 0;
        for (int i = 0; i < 25; i++) {
            if (intervalos[i] >= numUsuarios) contador++;
        }

        //Mostrar el contador
        System.out.println(contador);
    }
}

