package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

/**
 * Hay que analizar los casos separados por muros (W)
 *   --> Si hay un intervalo donde todos los miembros tienen salud (no hay ningún I), la cura llegará a tiempo
 *   --> Buscar en cada intervalo el tiempo que tardarán en infectarse todos los miembros
 *       --> Será la longitud más larga entre infectados / t (extremos) o entre 2t (intervalos)
 *   --> Si el instante de infección total <= instante de vacunación -->  Salvados
 *   --> Sino --> Infectados
 */


import java.util.Scanner;

public class CheeseTouch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tPropagacion = sc.nextInt();
        int tVacuna = sc.nextInt();

        String poblacion = sc.next();

        //Analizar los casos separados por muros
        String[] muros = poblacion.split("W",-1);
        String solucion = "ALL INFECTED";

        for (int i=0; i<muros.length; i++) {

            // CORRECCIÓN: Ignorar muros vacíos generados por "WW" o bordes con "W"
            if (muros[i].isEmpty()) {
                continue;
            }

            if (muros[i].indexOf('I') == -1) {
                //Hay algún individuo sano que nunca se infectará
                solucion = "CURED";
            }
            else {
                //Buscar cada intervalo de personas sanas entre infectados
                String[] sanos = muros[i].split("I",-1);
                int tiempoInfeccionTotal=0;
                for (int j=0; j<sanos.length; j++) {
                    int numSanos = sanos[j].length();
                    if (j==0 || j==sanos.length-1) {
                        //Velocidad de propagacion es tPropagacion
                        tiempoInfeccionTotal = Math.max(tiempoInfeccionTotal, numSanos * tPropagacion);
                    } else {
                        // Cálculo correcto de los pasos desde ambos lados
                        int pasos = (numSanos + 1) / 2;
                        tiempoInfeccionTotal = Math.max(tiempoInfeccionTotal, pasos * tPropagacion);
                    }
                }
                if (tiempoInfeccionTotal >= tVacuna) {
                    solucion = "CURED";
                }
            }
        }

        System.out.println(solucion);

    }
}
