package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Duplicar impresoras hasta tener las necesarias y entonces imprimirlas todas
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class a3DPrintedStatues {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer los datos
        int numFiguras = sc.nextInt();
        int numImpresoras = 1;
        int numDias = 1;  // El día necesario para imprimir todas las piezas

        while (numImpresoras < numFiguras ) {
            numDias++;
            numImpresoras *= 2;
        }

        System.out.println(numDias);

    }
}

