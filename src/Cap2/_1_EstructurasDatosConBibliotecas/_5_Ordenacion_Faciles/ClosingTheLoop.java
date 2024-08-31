package Cap2._1_EstructurasDatosConBibliotecas._5_Ordenacion_Faciles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class ClosingTheLoop {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numCasos = scan.nextInt();
        int numCaso = 0;
        while (numCaso < numCasos) {
            numCaso++;

            //Lectura de datos
            int numSegmentos = scan.nextInt();

            //Definir las listas de segmentos
            ArrayList<Integer> segmentosR = new ArrayList<>();
            ArrayList<Integer> segmentosB = new ArrayList<>();

            //Lectura de los segmentos
            for (int i = 0; i < numSegmentos; i++) {
                String segmento = scan.next();
                int longitud = Integer.parseInt(segmento.substring(0, segmento.length()-1));
                if (segmento.charAt(segmento.length()-1) == 'R') {
                    segmentosR.add(longitud);
                } else {
                    segmentosB.add(longitud);
                }
            }

            //Ordenar las listas
            Collections.sort(segmentosR, Collections.reverseOrder());
            Collections.sort(segmentosB, Collections.reverseOrder());

            //Calcular la longitud del lazo
            int longitudLazo = 0;
            int numSegmentosLazo = Math.min(segmentosR.size(), segmentosB.size());
            for (int i = 0; i < numSegmentosLazo; i++) {
                longitudLazo += segmentosR.get(i) + segmentosB.get(i) - 2;
            }

            //Mostrar el resultado
            System.out.println("Case #" + (numCaso) + ": " + longitudLazo);

        }

    }
}