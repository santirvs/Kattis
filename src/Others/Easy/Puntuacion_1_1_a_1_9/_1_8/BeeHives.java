package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

/**
 * 10 casos, 100 elementos -> 100*100*10 = 10^5 (admite fuerza bruta)
 *
 * Leer la posición de todos los paneles.
 * Para cada panel, buscar algún otro panel que esté demasiado cerca.
 * Si se encuentra demasiado cerca de otro, se marcan los dos.
 */


import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;


public class BeeHives {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        double distanciaMinima = sc.nextDouble();
        int numPaneles = sc.nextInt();

        while (distanciaMinima != 0 && numPaneles !=0) {

            //Lectura de las posiciones de los paneles
            double[] panelX = new double[numPaneles];
            double[] panelY = new double[numPaneles];
            boolean[] agria = new boolean[numPaneles];

            for (int i=0; i<numPaneles;i++) {
                panelX[i] = sc.nextDouble();
                panelY[i] = sc.nextDouble();
            }

            //Análisis de cada panel
            for (int i=0 ; i<numPaneles ; i++) {
                for (int j=0; j < numPaneles ; j++) {
                    if (i!=j) {
                        double distancia = Math.sqrt(Math.pow((panelX[i] - panelX[j]), 2) + Math.pow(panelY[i] - panelY[j], 2));
                        if (distancia < distanciaMinima) {
                            agria[i] = true;
                            agria[j] = true;
                        }
                    }
                }
            }

            //Contar los casos
            int numAgrias = 0;
            int numDulces = 0;
            for (int i=0; i < numPaneles; i++) {
                if (agria[i]) numAgrias++;
                else numDulces++;
            }

            //Mostrar resultado
            System.out.println(numAgrias + " sour, " + numDulces + " sweet");


            //Siguiente caso
            distanciaMinima = sc.nextDouble();
            numPaneles = sc.nextInt();
        }

        sc.close();
    }
}

