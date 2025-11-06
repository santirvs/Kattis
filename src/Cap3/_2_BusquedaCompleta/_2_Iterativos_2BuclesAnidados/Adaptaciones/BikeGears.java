package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados.Adaptaciones;

// Hacer todas las combinaciones de platos y piñones
// Calcular la relación plato/piñón
// Ordenar por relación plato/piñón, en caso de empate, por plato
// Mostrar el resultado.
// Como máximo 50 platos y 50 piñones, por lo que no parece que pueda haber TLE

// v1. Ok, excepto el Caso #9 WA
// v2. Sospecho de la división, así que haré la comparación de plato/piñón multiplicando
//     por el piñón de la otra relación y el plato de la otra relación
//     en lugar de plato/piñón. Al multiplicar, evito la división y los problemas de precisión,
//     pero debo usar long para evitar overflow.  --> AC!

import java.util.Arrays;
import java.util.Scanner;

public class BikeGears {

    public static class Relacion implements Comparable<Relacion> {
        long  pinyon; // Num de piñón
        long  plato; // Num de plato

        public Relacion(long plato, long pinyon) {
            this.pinyon  = pinyon;
            this.plato = plato;
        }

        @Override
        public int compareTo(Relacion o) {
            return this.plato*o.pinyon != o.plato*this.pinyon ? Long.compare(this.plato*o.pinyon, o.plato*this.pinyon) : Long.compare(this.plato, o.plato);
        }

        //@Override
        public int compareTo_(Relacion o) {
            return this.plato/this.pinyon > o.plato / o.pinyon ? 1 : -1;
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numPlatos = scan.nextInt(); // Número de platos
        int numPinyones = scan.nextInt(); // Número de piñones

        Relacion[] relaciones = new Relacion[numPlatos * numPinyones]; // Array para almacenar las relaciones plato/piñón y el plato
        long[] platos = new long[numPlatos]; // Array para almacenar los platos
        long[] pinyones = new long[numPinyones]; // Array para almacenar los piñones

        // Leer los platos y piñones
        for (int i = 0; i < numPlatos; i++) {
            platos[i] = scan.nextLong(); // Leer los platos
        }
        for (int i = 0; i < numPinyones; i++) {
            pinyones[i] = scan.nextLong(); // Leer los piñones
        }


        for (int i = 0; i < numPlatos; i++) {
            for (int j = 0; j < numPinyones; j++) {
                relaciones[i * numPinyones + j] = new Relacion(platos[i], pinyones[j]);
            }
        }

        // Ordenar las relaciones por relación plato/piñón, en caso de empate, por plato
        Arrays.sort(relaciones);

        // Imprimir las relaciones ordenadas
        for (Relacion r : relaciones) {
            System.out.println("(" + r.plato + "," + r.pinyon + ")"); // + " " + String.format("%.10f", ((float)r.plato) / r.pinyon));
        }
    }
}