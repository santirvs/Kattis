package Others.Trivial.Puntuacion_1_1_a_1_5._1_3;

// Leer el tamaño del equipo
// Leer la gente que ha conocido cada uno de los 3 ermitaños
// Ordenarlos de menor a mayor
// Mirar si el menor de ellos más el tamaño del equipo sigue siendo menor que el segundo

import java.util.Arrays;
import java.util.Scanner;

public class IsolationIntrusion {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Leer los datos
        int equipo = sc.nextInt();
        int[] ermitanos = new int[3];
        for (int i=0; i<3; i++) {
            ermitanos[i] = sc.nextInt();
        }

        Arrays.sort(ermitanos);

        if (ermitanos[0] + equipo < ermitanos[1]) {
            System.out.println(ermitanos[0] + equipo);
        } else {
            System.out.println("impossible");
        }

    }
}