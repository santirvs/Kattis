package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer la entrada y contrar los caracteres [a-zA-Z] (letras mayúsculas y minúsculas)

import java.util.Scanner;

public class FjoldiBokstafa {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        String a = scan.nextLine();
        //Contar las letras
        int count = 0;
        for (char c : a.toCharArray()) {
            if (Character.isLetter(c)) {
                count++;
            }
        }
        //Mostrar el resultado
        System.out.println(count);

    }
}