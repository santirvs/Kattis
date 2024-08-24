package Cap1._2_ProblemasAdHoc._15_PerderTiempo_Faciles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class AverageSpeed {


     public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

       //Leer la entrada
        double distancia = 0;
        double tiempo = 0;
        double velocidad = 0;
        double tiempoAnterior = 0;
        while (scan.hasNext()) {
            String linea = scan.nextLine();
            String[] partes = linea.split(" ");
            String[] tiempoPartes = partes[0].split(":");
            double tiempoActual = Integer.parseInt(tiempoPartes[0]) * 3600 + Integer.parseInt(tiempoPartes[1]) * 60 + Integer.parseInt(tiempoPartes[2]);
            distancia += (tiempoActual - tiempoAnterior) * velocidad / 3600;
            tiempo += tiempoActual - tiempoAnterior;
            if (partes.length == 2) {
                velocidad = Integer.parseInt(partes[1]);
            } else {
                System.out.print(partes[0] + " ");
                System.out.printf("%.2f km\n", distancia);
            }
            tiempoAnterior = tiempoActual;
        }
    }
}


