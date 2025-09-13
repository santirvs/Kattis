package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer la cantidad de numeros a sumar
// Leer los numeros y sumarlos
// Imprimir la suma

import java.util.Scanner;

public class N_Sum {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int n = scan.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += scan.nextInt();
        }
        System.out.println(sum);

    }
}