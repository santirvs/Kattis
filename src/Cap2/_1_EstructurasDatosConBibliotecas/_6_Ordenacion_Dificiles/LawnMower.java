package Cap2._1_EstructurasDatosConBibliotecas._6_Ordenacion_Dificiles;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class LawnMower {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int pasesX = scan.nextInt();
        int pasesY = scan.nextInt();
        double ancho = scan.nextDouble();

        while (pasesX !=0 && pasesY!=0 && ancho!=0.0) {
            //Lectura de los pases X
            double[] pases = new double[pasesX];
            for (int i = 0; i < pasesX; i++) {
                pases[i] = scan.nextDouble();
            }
            Arrays.sort(pases);
            //Comprobamos si ha pasado por todas las franjas
            //El punto mínimo debe ser <=0 y el máximo >=75 sin dejar huecos
            boolean ok = true;
            double min = 75;
            double max = 0;

            for (int i = 0; i < pasesX; i++) {
                min = Math.min(min, pases[i] - ancho / 2);
                if (i != 0) {
                    if (pases[i] - pases[i - 1] > ancho) {
                        ok = false;
                        break;
                    }
                }
                max = Math.max(max, pases[i] + ancho / 2);
            }
            if (min > 0 || max < 75)
                ok = false;


            //Lectura de los pases Y
            double[] pasesYs = new double[pasesY];
            for (int i=0; i<pasesY; i++) {
                pasesYs[i] = scan.nextDouble();
            }
            Arrays.sort(pasesYs);
            //Comprobamos si ha pasado por todas las franjas
            //El punto mínimo debe ser <=0 y el máximo >=100 sin dejar huecos
            double minY = 100;
            double maxY = 0;
            for (int i=0; i<pasesY; i++) {
                minY = Math.min(minY, pasesYs[i]-ancho/2);
                if (i!=0) {
                    if (pasesYs[i]-pasesYs[i-1]>ancho) {
                        ok = false;
                        break;
                    }
                }
                maxY = Math.max(maxY, pasesYs[i]+ancho/2);
            }
            if (minY > 0 || maxY < 100)
                ok = false;

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            //Siguiente caso
            pasesX = scan.nextInt();
            pasesY = scan.nextInt();
            ancho = scan.nextDouble();
        }
    }


}