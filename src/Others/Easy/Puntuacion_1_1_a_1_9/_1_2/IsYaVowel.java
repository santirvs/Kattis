package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer la cadena de entrada
// Contar las vocales en la cadena, y contando la 'y' como vocal
// Imprimir ambos conteos de vocales

import java.util.Scanner;

public class IsYaVowel {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        String input = scan.nextLine().toLowerCase();
        int vowelCount = 0;
        int vowelYCount = 0;
        for (char c : input.toCharArray()) {
            //Curiosa forma de comprobar si un caracter es una vocal
            if ("aeiou".indexOf(c) != -1) {
                vowelCount++;
            }
            if (c == 'y') {
                vowelYCount++;
            }
        }
        // Imprimir el conteo de vocales
        System.out.println(vowelCount + " " + (vowelCount + vowelYCount));

    }
}