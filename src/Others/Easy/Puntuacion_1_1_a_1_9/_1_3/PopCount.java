package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer el string
// Contar cuantos 1 contiene el string
// Imprimir el conteo

import java.util.Scanner;

public class PopCount {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        String input = scan.nextLine();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1') {
                count++;
            }
        }
        System.out.println(count);

    }
}