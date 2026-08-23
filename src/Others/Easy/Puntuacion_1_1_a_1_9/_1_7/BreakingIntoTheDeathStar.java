package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Leer la entrada y traducir carácter a carácter
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class BreakingIntoTheDeathStar {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        String entrada = sc.nextLine().toLowerCase();

        for (int i=0; i<entrada.length(); i++){
            char car = entrada.charAt(i);
            if (car == '-') {
                System.out.println("");
            } else if (Character.isDigit(entrada.charAt(i))) {
                System.out.print(Integer.toBinaryString(car-'0'));
            } else if (car == 'a' || car == 'e' || car == 'i' || car == 'o' || car == 'u') {
                System.out.print(car);
            } else {
                System.out.print("beepbloop");
            }
        }
        System.out.println();
    }
}

