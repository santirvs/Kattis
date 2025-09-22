package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer el numero de entrada
// Si el número es igual o superior a 13, sumarle 1
// Mostrar el resultado

import java.util.Scanner;

public class ThirteenFloors {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el piso real
        int num = sc.nextInt();

        //Comprobar si el piso es igual o superior al 13
        if (num >= 13) num++;

        //Mostrar el resultado
        System.out.println(num);

        sc.close();
    }
}

