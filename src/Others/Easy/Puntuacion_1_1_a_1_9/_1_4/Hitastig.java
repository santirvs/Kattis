package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer cada dato (en tipo Long)
// Comparar con máximo y mínimo hasta el momento
// Mostrar los resultados

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hitastig {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        int numLecturas = sc.nextInt();
        while (numLecturas-- > 0) {
            long valor = sc.nextLong();
            max = Math.max(max, valor);
            min = Math.min(min, valor);
        }

        System.out.println(max + " " + min);


        sc.close();
    }
}

