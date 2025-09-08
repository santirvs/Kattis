package Others.Easy.Puntuacion_1_1_a_1_9;

// Leer los números, guardarlos en un array y luego imprimirlos en orden inverso

import java.util.Scanner;
import java.util.Stack;

public class Ofugsnuid {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int cantidadNumeros = scan.nextInt();

        //Definir la lista y leer los números
        int[] lista = new int[cantidadNumeros];
        for (int i = 0; i < cantidadNumeros; i++) {
            lista[i] = scan.nextInt();
        }

        //Imprimir en orden inverso
        for (int i = cantidadNumeros - 1; i >= 0; i--) {
            System.out.println(lista[i]);
        }

    }
}