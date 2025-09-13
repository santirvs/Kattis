package Others.Easy.Puntuacion_1_1_a_1_9._1_2;

// Leer el número como cadena y luego intercambiar los dígitos
// Imprimir el nuevo número

import java.util.Scanner;

public class DigitSwap {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        String num = scan.nextLine();
        String swapped = "" + num.charAt(1) + num.charAt(0);
        System.out.println(swapped);

    }
}