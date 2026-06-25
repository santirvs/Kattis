package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// Buscar la última vocal de una palabra y añadirle "ntry"

import java.util.Scanner;

public class BrexitingAndBrentering {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nombre = sc.nextLine();

        int posicionUltimaVocal = posUltimaVocal(nombre);

        System.out.println(nombre.substring(0,posicionUltimaVocal+1) + "ntry");
    }

    private static int posUltimaVocal(String nombre) {
        boolean trobat= false;
        int posicion = 0;
        for (int i=nombre.length()-1; i>=0 && !trobat; i--) {
            char c = nombre.toLowerCase().charAt(i);

            if (esVocal(c))  {
                trobat = true;
                posicion=i;
            }
        }

        return posicion;
    }

    private static boolean esVocal(char c) {
        boolean vocal = false;

        if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') vocal = true;

        return vocal;
    }
}
