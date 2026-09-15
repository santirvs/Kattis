package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

// Leer todos los valores, ordenarlos y sumar los dos menores

import java.util.Arrays;
import java.util.Scanner;

public class FindingForks {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numDatos = sc.nextInt();

        int[] datos = new int[numDatos];

        for (int i=0; i<numDatos; i++) {
            datos[i] = sc.nextInt();
        }

        Arrays.sort(datos);

        System.out.println(datos[0] + datos[1]);


        sc.close();
    }
}

