package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

// Contar la frecuencia de aparicion de las letras en la palabra
// Se podrá formar una palíndroma si hay como máximo una frecuencia impar

import java.util.Scanner;

public class Dralinpome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Definir el array de conteo de frecuencias
        int[] freq = new int['z'-'a'+1];

        // Leer la palabra
        String palabra = sc.nextLine();

        //Contar la frecuencia de aparición de cada letra
        for (int i=0; i<palabra.length(); i++) {
            freq[palabra.charAt(i)-'a']++;
        }

        //Contar cuantas frecuencias impares hay
        int numImpares = 0;
        for (int i=0; i<freq.length; i++) {
            numImpares += freq[i]%2;
        }

        //Si tengo 0 o 1 frecuencias impares podré formar el palíndromo
        if (numImpares <= 1) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}

