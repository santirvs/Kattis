package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Autotune!  Ajustar a la frecuencia más cercana. Si es equidistante, a la más aguda
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class AmateurishComposersOfMusic {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int numBuenas = sc.nextInt();
            int numMuestras = sc.nextInt();

            List<Integer> buenas = new ArrayList<Integer>();
            for (int i = 0; i < numBuenas; i++) {
                buenas.add(sc.nextInt());
            }

            while (numMuestras-- > 0) {
                int muestra = sc.nextInt();

                int pos = Collections.binarySearch(buenas, muestra);
                if (pos >= 0) {
                    //La nota es buena
                    System.out.println(0);
                } else {
                    //Hay que afinar la nota
                    if (-pos == buenas.size() + 1) {
                        //La nota es más alta que la más alta de las buenas
                        System.out.println(buenas.get(buenas.size() - 1) - muestra);
                    } else if (pos == -1) {
                        //La nota es más baja que la más baja de las buenas
                        System.out.println(buenas.get(0) - muestra);
                    } else {
                        //Está entre dos notas,
                        int notaAlta = buenas.get(-pos-1);
                        int notaBaja = buenas.get(-pos-2);

                        if (muestra - notaBaja < notaAlta - muestra) {
                            System.out.println(notaBaja - muestra);
                        } else {
                            System.out.println(notaAlta - muestra);
                        }
                    }
                }
            }
        }
    }
}

