package Others.Medium.Puntuacion_2_0_a_2_9._2_8;

// Leer las notas de las dos melodías
// Transformar las notas a un índice 0..11
// Comprobar si cumplen con alguna de las transformaciones

import java.util.Scanner;

public class Dodecaphony {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numNotas = sc.nextInt();

        //Leer las melodias
        int[][] melodias = new int[2][numNotas];
        for (int melodia = 0; melodia < 2; melodia++) {
            for (int nota = 0; nota < numNotas; nota++) {
                    melodias[melodia][nota] = decodificaNota(sc.next());
            }
        }

        //Comprobar melodias

        //Verificar e imprimir resultados
        if (esTransposition(melodias)) System.out.println("Transposition");
        else if (esRetrograde(melodias)) System.out.println("Retrograde");
        else if (esInversion(melodias)) System.out.println("Inversion");
        else System.out.println("Nonsense");
    }

    private static boolean esInversion(int[][] melodias) {
        boolean result = true;
        int longitud = melodias[0].length;

        //La primera nota de ambas melodias debe ser igual
        result = melodias[0][0] == melodias[1][0];

        for (int i=1; i < longitud && result; i++) {
            //La distancia de cada nota respecto a la primera, debe ser igual, pero con signo cambiado
            int distancia1 = (melodias[0][i]+12 - melodias[0][0]) % 12;
            int distancia2 = (melodias[1][0]+12 - melodias[1][i]) % 12;

            result = distancia1 == distancia2;

        }

        return result;

    }

    private static boolean esTransposition(int[][] melodias) {
        boolean result = true;
        int longitud = melodias[0].length;
        //La primera nota marca la distancia que debe existir entre todas ellas
        int distancia = (melodias[0][0] + 12 -melodias[1][0])%12;

        for (int i=1; i < longitud && result ; i++) {
            result = ((melodias[0][i]+12 - melodias[1][i]) % 12) == distancia ;
        }

        return result;
    }

    private static boolean esRetrograde(int[][] melodias) {
        boolean result = true;
        int longitud = melodias[0].length;
        for (int i=0; i<longitud && result; i++) {
            result = melodias[0][i] == melodias[1][longitud-i-1];
        }
        return result;
    }

    private static int decodificaNota(String nota) {
        if (nota.equals("C")) return 0;
        if (nota.equals("C#")) return 1;
        if (nota.equals("D")) return 2;
        if (nota.equals("D#")) return 3;
        if (nota.equals("E")) return 4;
        if (nota.equals("F")) return 5;
        if (nota.equals("F#")) return 6;
        if (nota.equals("G")) return 7;
        if (nota.equals("G#")) return 8;
        if (nota.equals("A")) return 9;
        if (nota.equals("A#")) return 10;
        else return 11;
    }
}