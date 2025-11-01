package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número
// Descomponer en dígitos y calcular el producto de sus dígitos que no sean 0
// Repetir el proceso hasta que el número tenga un solo dígito
// Imprimir el resultado

import java.util.Scanner;

public class DigitProduct {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número
        int numero = sc.nextInt();

        // Repetir hasta que el número tenga un solo dígito
        while (numero >= 10) {
            int producto = 1;
            // Descomponer en dígitos y calcular el producto de sus dígitos que no sean 0
            while (numero > 0) {
                int digito = numero % 10;
                if (digito != 0) {
                    producto *= digito;
                }
                numero /= 10;
            }
            numero = producto;
        }

        // Imprimir el resultado
        System.out.println(numero);


        sc.close();
    }
}

