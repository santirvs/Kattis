package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer las dos cadenas
// Si la primera es igual o más larga que la segunda -> go
// Sino -> no

import java.util.Scanner;

public class Aaah {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer las cadenas
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        //Mostrar el resultado
        if (str1.length()>=str2.length()) {
            System.out.println("go");
        }
        else System.out.println("no");

        sc.close();
    }
}

