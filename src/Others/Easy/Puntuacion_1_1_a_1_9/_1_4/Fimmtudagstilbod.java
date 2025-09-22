package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer el año
// Si es menor o igual a 2020, imprimir 1000
// Si es mayor a 2020, imprimir 1000 + (año-2020)*100

import java.util.Scanner;

public class Fimmtudagstilbod {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el año
        int any = sc.nextInt();

        //Imprimir el resultado
        if (any <= 2020) {
            System.out.println(1000);
        }
        else {
            System.out.println(1000 + (any-2020)*100);
        }

        sc.close();
    }
}

