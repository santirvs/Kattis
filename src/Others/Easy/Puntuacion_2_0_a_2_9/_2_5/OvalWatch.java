package Others.Easy.Puntuacion_2_0_a_2_9._2_5;


/*
  Inicialmente cada jugador tiene su personaje asignado 0->0, 1->1, ....
  Cada una de las líneas obliga a intercanviar los personajes de los dos jugadores implicados

  --> Leer todas las líneas, ordenarlas e intercambiar posiciones de los jugadores implicados

  Con un array de enteros donde a[i] es el personaje del jugador i  será suficiente
  Y una lista de Legs para poder cargarlas en memoria y ordenarlas
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class OvalWatch {

    static class FR_Int {
        private InputStream in = System.in;
        private byte[] buffer = new byte[1 << 16];
        private int head = 0;
        private int tail = 0;

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = in.read(buffer, 0, buffer.length);
                if (tail <= 0) return -1;   // Fin de archivo
            }
            return buffer[head++];
        }

        public int nextInt() throws IOException {
            int c = read();
            // Ignorar espacios en blanco o saltos de línea (ASCII <= 32)
            while (c != -1 && c <= 32) {
                c = read();
            }

            if (c == -1) return -1; // EOF
            boolean negativo = false;
            if (c == '-') {
                negativo = true;
                c = read();
            }
            int res = 0;
            // Construir el número mientras el carácter sea visible (> 32)
            while (c > 32) {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res;
        }
    }


    public static class Leg implements Comparable<Leg> {
        int inicio;
        int altura;

        Leg(int inicio, int altura) {
            this.altura = altura;
            this.inicio = inicio;
        }


        @Override
        public int compareTo(Leg o) {
            int result = Integer.compare(o.altura, altura);
            if (result == 0) result = -1;
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        FR_Int sc = new FR_Int();

        //Leer datos
        int numJugadores = sc.nextInt();
        int numLegs = sc.nextInt();

        //Inicializar array de personajes asignados
        int[] personajes = new int[numJugadores];
        for (int i=0; i<numJugadores; i++) {
            personajes[i] = i;
        }

        //Leer los Legs
        Leg[] legs = new Leg[numLegs];
        for (int i=0; i<numLegs; i++) {
            int inicio = sc.nextInt();
            int altura = sc.nextInt();
            legs[i] = new Leg(inicio, altura);
        }

        //ordenar los Legs
        Arrays.sort(legs);

        //Procesar los legs
        for (Leg l : legs) {
            int aux = personajes[l.inicio];
            personajes[l.inicio] = personajes[l.inicio+1];
            personajes[l.inicio+1] = aux;
        }

        //Mostrar el resultado
        for (int i=0; i<personajes.length; i++) {
            if (i!=0) System.out.print(" ");
            System.out.print(personajes[i]);
        }
        System.out.println();

    }
}
