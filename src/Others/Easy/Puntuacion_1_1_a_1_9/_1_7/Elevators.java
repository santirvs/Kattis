package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Aplicar la tabla del enunciado
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class Elevators {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Leer los datos
        String tipo = sc.next();
        int pisos = sc.nextInt();

        //Determinar el número de ascensores
        int ascensores = 0;

        switch (tipo) {
            case "residential" : ascensores = numAscensoresResidencial(pisos); break;
            case "commercial" : ascensores = numAscensoresComercial(pisos); break;
            case "industrial" : ascensores = numAscensoresIndustrial(pisos); break;
        }

        //Imprimir el resultado
        System.out.println(ascensores);

    }

    private static int numAscensoresResidencial(int pisos) {
        int ascensores = 0;

        if (pisos >= 16) ascensores = 4;
        else if (pisos >=11) ascensores = 3;
        else if (pisos >=6) ascensores = 2;
        else if (pisos >=2) ascensores = 1;
        else ascensores = 0;

        return ascensores;
    }

    private static int numAscensoresComercial(int pisos) {
        int ascensores = 0;

        if (pisos >= 15) ascensores = 3;
        else if (pisos >=8) ascensores = 2;
        else if (pisos >=2) ascensores = 1;
        else ascensores = 0;

        return ascensores;
    }

    private static int numAscensoresIndustrial(int pisos) {
        int ascensores = 0;

        if (pisos >= 17) ascensores = 5;
        else if (pisos >=13) ascensores = 4;
        else if (pisos >=9) ascensores = 3;
        else if (pisos >=5) ascensores = 2;
        else if (pisos >=2) ascensores = 1;
        else ascensores = 0;

        return ascensores;
    }
}

