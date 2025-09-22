package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer el número de problemas
// Para cada problema
//   Leer la calificación
//   Si es impar, contarlo
// Imprimir cuantos impares ha contado

import java.util.Locale;
import java.util.Scanner;

public class CallForProblems {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de casos
        int num = sc.nextInt();

        //Contar los 1s de strNum
        int numImpares = 0;
        for (int i=0; i < num; i++) {
            //Leer la puntuación
            int puntuacion = sc.nextInt();
            if (puntuacion % 2 != 0) {
                numImpares++;
            }
        }

        //Imprimir el resultado
        System.out.println(numImpares);

        sc.close();
    }
}

