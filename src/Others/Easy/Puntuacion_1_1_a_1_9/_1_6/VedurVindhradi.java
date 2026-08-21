package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Concatenar ifs para clasificar el viento según su fuerz
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class VedurVindhradi {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        double fuerza = sc.nextDouble();

        if (fuerza >= 32.7) System.out.println("Farvidri");
        else if (fuerza >= 28.5) System.out.println("Ofsavedur");
        else if (fuerza >= 24.5) System.out.println("Rok");
        else if (fuerza >= 20.8) System.out.println("Stormur");
        else if (fuerza >= 17.2) System.out.println("Hvassvidri");
        else if (fuerza >= 13.9) System.out.println("Allhvass vindur");
        else if (fuerza >= 10.8) System.out.println("Stinningskaldi");
        else if (fuerza >= 8.0) System.out.println("Kaldi");
        else if (fuerza >= 5.5) System.out.println("Stinningsgola");
        else if (fuerza >= 3.4) System.out.println("Gola");
        else if (fuerza >= 1.6) System.out.println("Kul");
        else if (fuerza >= 0.3) System.out.println("Andvari");
        else  System.out.println("Logn");

        sc.close();
    }
}

