package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número
// incrementar en 1
// bucle buscando un cuadrado que no contega el 6

import java.util.Arrays;
import java.util.Scanner;


public class HexaphobicSquare {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cantidad de clases
        int numero = sc.nextInt();
        boolean contieneEl6;
        do {
            numero++;
            long cuadrado = numero *numero;
            contieneEl6 = ("" + cuadrado).contains("6");
        } while (contieneEl6);

        System.out.println(numero);


        sc.close();
    }
}

