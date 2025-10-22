package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer las dos cadenas de entrada
// Separar cada cadena por "|"
// Mostrar las primera parte de cada una de las líneas
// Mostrar la segunda parte de cada una de las líneas

import java.util.Scanner;

public class EkkiDaudiOpnaInni {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer las dos cadenas de entrada
        String cadena1[] = sc.nextLine().split("\\|");
        String cadena2[] = sc.nextLine().split("\\|");

        for (int i = 0; i < cadena1.length; i++) {
            System.out.println(cadena1[i] + cadena2[i]);
        }

        sc.close();
    }
}

