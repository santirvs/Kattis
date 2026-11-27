package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Comparar un marcador con el siguiente.
 * Tanto local como visitante deben ser igual o superior al anterior
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class JumbledScoreboards {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        int numImagenes = sc.nextInt();
        int local = 0;
        int visitante = 0;
        boolean correcto = true;

        for (int i=0; i<numImagenes && correcto; i++) {
            int fotoLocal = sc.nextInt();
            int fotoVisitante = sc.nextInt();

            if (fotoLocal < local || fotoVisitante < visitante) correcto = false;

            local = fotoLocal;
            visitante = fotoVisitante;
        }

        if (correcto) System.out.println("yes");
        else System.out.println("no");



    }
}

