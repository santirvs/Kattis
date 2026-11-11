package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// Intercambiar vocales usando dos punteros, uno desde el inicio y otro desde el final

import java.util.Scanner;

public class ReverseTheAlphabet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] cadena = sc.nextLine().toCharArray();

        int izquierda = 0;
        int derecha = cadena.length-1;

        while (izquierda < derecha) {
            while ( izquierda < cadena.length && !esVocal(cadena[izquierda])) {
                izquierda++;
            }
            while ( derecha >= 0 && !esVocal(cadena[derecha])) {
                derecha--;
            }

            if (izquierda < derecha) {
                //Intercambiar vocales
                char aux = cadena[izquierda];
                cadena[izquierda] = cadena[derecha];
                cadena[derecha] = aux;
            }

            izquierda++;
            derecha--;

        }

        System.out.println(cadena);
    }

    private static boolean esVocal(char c) {
        char C = Character.toUpperCase(c);
        return C=='A' || C=='E' || C=='I' || C=='O' || C=='U';
    }
}
