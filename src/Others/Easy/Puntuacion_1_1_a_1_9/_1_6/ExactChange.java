package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Dividir entre la denominación de cada billete, desde el más alto al más bajo
 */


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class ExactChange {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int cantidad = sc.nextInt();
        int[] denominacion = { 1, 5, 15, 30, 150};
        int[] billetes = new int[5];

        for (int i=4; i>=0; i--) {
            billetes[i] = cantidad / denominacion[i];
            cantidad = cantidad % denominacion[i];
        }

        //Imprimir el resultado
        for (int i=0; i<5;i++) {
            if (i!=0) System.out.print(" ");
            System.out.print(billetes[i]);
        }
        System.out.println();

        sc.close();
    }
}

