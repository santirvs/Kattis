package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer la palabra
// Determinar si se repite algun caracter
// Si se repite alguno mostrar 0
// Si no se repite ninguno mostrar 1

import java.util.Scanner;

public class MagicTrick {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la palabra
        String palabra = sc.nextLine();

        // Comprobar cada carácter si se repite más adelante
        boolean repetido = false;
        for (int i=0; i<palabra.length() && !repetido; i++) {
            char letra = palabra.charAt(i);
            if (palabra.substring(i+1).contains(letra+"")) {
                repetido = true;
            }
        }

        //Mostrar el resultado
        if (repetido) System.out.println(0);
        else System.out.println(1);

        sc.close();
    }
}

