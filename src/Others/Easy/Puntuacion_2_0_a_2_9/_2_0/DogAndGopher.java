package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * Buscar el primer agujero que está a la mitad o menos de distancia del topo que
 * del perro.
 * Aplicar el teorema de pitágoras para calcular la distancia a cada punto.
 *
 */

import java.io.IOException;
import java.util.Scanner;


public class DogAndGopher {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //Leer las coordenadas del topo
        double topoX = sc.nextDouble();
        double topoY = sc.nextDouble();

        //Leer las coordenadas del perro
        double perroX = sc.nextDouble();
        double perroY = sc.nextDouble();
        boolean escapa = false;

        while (sc.hasNext()) {
            double agujeroX = sc.nextDouble();
            double agujeroY = sc.nextDouble();

            double distanciaTopo = Math.sqrt( Math.pow(agujeroX-topoX,2) +  Math.pow(agujeroY-topoY,2) );
            double distanciaPerro = Math.sqrt( Math.pow(agujeroX-perroX,2) +  Math.pow(agujeroY-perroY,2) );

            if (distanciaPerro >= 2*distanciaTopo) {
                System.out.println("The gopher can escape through the hole at ("+ agujeroX + "," + agujeroY + ").");
                escapa = true;
            }
        }

        if (!escapa) {
            System.out.println("The gopher cannot escape.");
        }

    }
}

