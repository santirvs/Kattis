package Others.Trivial.Puntuacion_1_1_a_1_5._1_2;

// Comprobar si las letras son iguales comparando desde ambos extremos
// y llegando al centro

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String palabra = scan.nextLine();


        int izquierda = 0;
        int derecha = palabra.length()-1;
        boolean esPalindromo = true;

        while (esPalindromo && izquierda < derecha) {
            if (palabra.charAt(izquierda) == palabra.charAt(derecha)) {
                izquierda++;
                derecha--;
            } else esPalindromo = false;
        }


        if (esPalindromo)
            System.out.println("Palindrome!");
        else
            System.out.println("Nothing special about this string :(");

    }
}