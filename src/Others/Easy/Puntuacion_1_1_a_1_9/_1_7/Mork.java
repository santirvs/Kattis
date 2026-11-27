package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Podremos apostar sólo si empatan 0 goles ambos equipos o 2 goles y 2 equipos
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Mork {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //Leer los datos
        int numGoles = sc.nextInt();
        int numEquiposMarcan = sc.nextInt();

        if (numGoles == 0 || (numGoles==2 && numEquiposMarcan==2)) System.out.println("Jebb");
        else System.out.println("Neibb");
    }
}

