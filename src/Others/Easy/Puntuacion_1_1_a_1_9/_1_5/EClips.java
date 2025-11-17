package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Mientras hayan palabras en la entrada
// Leer la palabra
// Comprobar si contiene la e
// Si la tiene, imprimirla a la salida

import java.util.Scanner;

public class EClips {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean primera = true;
        while (sc.hasNext()) {
            String palabra = sc.next();
            if (palabra.contains("e")) {
                if (primera) primera=false;
                else System.out.print(" ");
                System.out.print(palabra);
            }
        }
        if (primera)
            System.out.println("oh noes");

        sc.close();
    }
}

