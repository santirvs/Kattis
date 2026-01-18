package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

// Ir apuntando los puntos y su valor correspondiente en un HashMap<String, Boolean>

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;


public class Roknet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Definir el mapa de valores
        HashMap<String, Boolean> mapa = new HashMap<>();

        //Leer la cantidad de puertas lógicas
        int numPuertas = sc.nextInt();
        sc.nextLine();
        while (numPuertas-- > 0) {
            //Leer cada una de las entradas
            String[] puerta = sc.nextLine().split(" ");

            //Parsear la puerta
            if (puerta[0].equals("INNTAK")) {
                String punto = puerta[1];
                boolean valor = puerta[2].equals("SATT");
                mapa.put(punto, valor);
            } else if (puerta[0].equals("UTTAK")) {
                String punto = puerta[1];
                boolean valor = mapa.get(punto);
                System.out.println(punto + " " + (valor?"SATT":"OSATT"));
            } else if (puerta[0].equals("OG")) {
                String punto1 = puerta[1];
                String punto2 = puerta[2];
                String punto3 = puerta[3];
                boolean valorP1 = mapa.get(punto1);
                boolean valorP2 = mapa.get(punto2);
                mapa.put(punto3, valorP1 && valorP2);
            }  else if (puerta[0].equals("EDA")) {
                String punto1 = puerta[1];
                String punto2 = puerta[2];
                String punto3 = puerta[3];
                boolean valorP1 = mapa.get(punto1);
                boolean valorP2 = mapa.get(punto2);
                mapa.put(punto3, valorP1 || valorP2);
            } else if (puerta[0].equals("EKKI")) {
                String punto1 = puerta[1];
                String punto2 = puerta[2];
                boolean valorP1 = mapa.get(punto1);
                mapa.put(punto2, !valorP1);
            }
        }
        sc.close();
    }
}

