package Others.Trivial.Puntuacion_1_1_a_1_5._1_3;

// Leer una cadena
// Invertir cada carácter mayúscula <--> minuscula


import java.util.Scanner;

public class InverseCase {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Leer una cadena
        String input = scan.nextLine();

        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c))
                    c= Character.toLowerCase(c);
                else if (Character.isLowerCase(c))
                    c= Character.toUpperCase(c);
            }

            System.out.print(c);

        }

        System.out.println();

    }
}