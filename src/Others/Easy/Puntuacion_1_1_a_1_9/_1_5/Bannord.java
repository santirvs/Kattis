package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer los caracteres prohibidos
// Para cada palabra,
//  leer la palabra
//  mirar si contiene alguno de los caracteres prohibidos
//  si contiene alguno -> sustituir todos los caracteres por *
//  si no contiene ninguno -> imprimir la palabra

import java.util.Scanner;

public class Bannord {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer los caracteres prohibidos
        String prohibidos = sc.next();

        //Tratar los casos
        boolean primero = true;
        while (sc.hasNext()) {
            String palabra = sc.next();

            for (char c: prohibidos.toCharArray()) {
                if (palabra.contains(""+c)) {
                    palabra = "*".repeat(palabra.length());
                }
            }

            if (primero) primero = false;
            else System.out.print(" ");
            System.out.print(palabra);
        }

        sc.close();
    }
}

