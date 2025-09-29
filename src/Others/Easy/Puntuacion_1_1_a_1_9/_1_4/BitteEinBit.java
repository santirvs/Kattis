package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer la entrada
// Mostrar el primer caracter de la entrada

import java.util.Scanner;

public class BitteEinBit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la entrada
        String entrada = sc.nextLine();
        // Mostrar el primer caracter de la entrada
        System.out.println(entrada.charAt(0));

        sc.close();
    }
}

