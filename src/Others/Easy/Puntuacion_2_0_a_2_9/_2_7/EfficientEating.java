package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

/**
 * El problema se reduce a calcular el tiempo que tardará cada cola y quedarnos con la menor
 * Lo que tardará cada cola es el tiempo acumulado en despachar a cada uno de los miembros de la cola
 * teniendo en cuenta que algunos de ellos abandonarán la cola.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EfficientEating {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numColas = Integer.parseInt(br.readLine().trim());

        int minTiempoCola = Integer.MAX_VALUE;
        int mejorCola = 0;

        for (int cola=0; cola < numColas; cola++){

            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int numPersonasEnCola = Integer.parseInt(st.nextToken());
            int totalTiempo = 0;   //10^5 personas * 20seg cada persona, caben en un int

            // Calcular el tiempo de cada cola
            for (int persona=0; persona < numPersonasEnCola; persona++) {
                int tiempoProceso = Integer.parseInt(st.nextToken());
                int tiempoEspera = Integer.parseInt(st.nextToken());

                if (tiempoEspera==0 || tiempoEspera >= totalTiempo) {
                    //La persona no abandona la cola
                    totalTiempo+=tiempoProceso;
                }
            }

            //Guardarnos la mejor cola
            if (totalTiempo < minTiempoCola) {
                minTiempoCola = totalTiempo;
                mejorCola = cola;
            }

        }

        //Mostrar el resultado
        System.out.println(mejorCola);
    }
}