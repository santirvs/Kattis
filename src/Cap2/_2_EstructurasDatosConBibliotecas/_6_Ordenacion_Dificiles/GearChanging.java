package Cap2._2_EstructurasDatosConBibliotecas._6_Ordenacion_Dificiles;

import java.util.*;

public class GearChanging {

    /**
     * El enunciado deja de comentar cosas importantes, como que la ratio se calcula
     * como el número de dientes del plato (pedal) dividido por el número de dientes del piñón (rueda).
     * La cadencia es el número de vueltas por minuto y es el inverso del ratio.
     * Los cambios de marcha válidos son absolutamente todas las combinaciones posibles
     * de platos y piñones. Se puede pasar del plato N al plato N+2 y del piñón M al piñón M+2 en el mismo cambio.
     *
     * De esta forma, el planteamiento es buscar la relación de todas las combinaciones posibles entre platos y piñones
     * Se ordena la lista de combinaciones y se comprueba que la relación entre cada combinación y la siguiente
     * no supere la tolerancia.
     */


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Datos del problema
        int numPlatos = scan.nextInt();
        int numPiñones = scan.nextInt();
        double tolerancia = (scan.nextFloat() / 100.0)+1.0;

        //Leer los platos
        int[] platos = new int[numPlatos];
        for (int i = 0; i < numPlatos; i++) {
            platos[i] = scan.nextInt();
        }

        //Leer los piñones
        int[] piñones = new int[numPiñones];
        for (int i = 0; i < numPiñones; i++) {
            piñones[i] = scan.nextInt();
        }

        //Calculamos la cadencia de todas las combinaciones posibles
        double[] cadencias = new double[numPlatos*numPiñones];
        for (int i = 0; i < numPlatos; i++) {
            for (int j = 0; j < numPiñones; j++) {
                double ratio = (double)platos[i] / piñones[j];
                cadencias[i*numPiñones+j] = 1/ratio;
            }
        }

        //Ordenamos las cadencias
        Arrays.sort(cadencias);

        //Calculamos la diferencia entre la cadencia de cada combinación y la siguiente
        boolean valido = true;
        for (int i = 0; i < cadencias.length-1 && valido; i++) {
            if (cadencias[i+1]/cadencias[i]>tolerancia) {
                valido = false;
                break;
            }
        }

        if (valido) {
            System.out.println("Ride on!");
        } else {
            System.out.println("Time to change gears!");
        }
    }
}