package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer la cantidad de casos
// Leer las 3 longitudes
// Imprimir "Ordered" si estan ordenadas de forma creciente o decreciente
// Imprimir "Unordered" en caso contrario

import java.util.Scanner;

public class GnomeSequencing {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer el número de casos
        int numCasos = sc.nextInt();

        //Imprimir el título
        System.out.println("Gnomes:");

        //Procesar cada caso
        for (int caso=0; caso<numCasos; caso++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int num3  = sc.nextInt();

            if (num1 > num2 && num2 > num3 ||
                num1 < num2 && num2 < num3) {
                System.out.println("Ordered");
            }
            else System.out.println("Unordered");

        }


        sc.close();
    }
}

