package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer la palabra
// Comprobar una por una si tiene las letras UAPC
// Si no la tiene, mostrarla a la salida en el mismo orden

import java.util.Scanner;

public class Vandalism {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer la palabra
        String palabra = sc.nextLine();

        //Comprobar cada una de las letras
        for (int i=0; i<=3; i++) {
            char letra = "UAPC".charAt(i);
            if (!palabra.contains(letra+"")) {
                System.out.print(letra);
            }
        }
        System.out.println();

        sc.close();
    }
}

