package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * Leer los números en una lista
 * Verificar que hayan al menos 3
 * Ordenarlos
 * Hacer la suma ignorando los 3 primeros
 *
 */

import java.io.IOException;
import java.util.*;


public class Scores {

     public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        List<Double> lista = new ArrayList<>();

        while (sc.hasNext()) {
            lista.add(sc.nextDouble());
        }

        //Comprobar si hay al menos 3 elementos
         if (lista.size() < 3) {
             System.out.println("At least 3 scores needed!");
         } else {
             double suma = 0;
             Collections.sort(lista);
             for (int i=3; i<lista.size(); i++) {
                 suma += lista.get(i);
             }

             System.out.println("Sum of scores (3 lowest removed): " + suma);
         }

    }
}

