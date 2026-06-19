package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

// Ir apuntando la longitud de cada línea
// Sumar la distancia cuadrática respecto a la mayor

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;


public class RaggedRight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] longitudes = new int[100];
        int numLineas = 0;
        int maxLong = 0;

        while (sc.hasNext()) {
            String linea = sc.nextLine();
            longitudes[numLineas] = linea.length();

            maxLong = Math.max(maxLong, longitudes[numLineas]);
            numLineas++;
        }

        //Suma las distancias
        int suma = 0;

        //La última línea queda exenta de penalización!
        for (int i=0; i<numLineas-1; i++) {
            int distancia = (maxLong - longitudes[i]);
            suma += (distancia * distancia);
            //System.out.println("Linea " + i + " long: " + longitudes[i] + " dist: " + distancia + " suma: " + suma);
        }

        //Muestra el resultado
        System.out.println(suma);

        sc.close();
    }
}

