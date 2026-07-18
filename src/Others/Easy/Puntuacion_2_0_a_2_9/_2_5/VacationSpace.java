package Others.Easy.Puntuacion_2_0_a_2_9._2_5;


/*
  100.000 entradas  --> Usar FastReader

  Leer las posiciones y guardar cada posición en un HashMap<Integer, Integer>  (posición, índice(base 0) )
  A su vez, guardar todas las posiciones en un Array de n posiciones

  Tratar las posiciones 0 y n-1 de forma especial (sólo tienen un vecino!)

  Ordenar el Array, y procesar las ternas de valores para calcular la distancia de una casa con sus vecinas
  Si la distancia es menor que la actual, recuperar el índice.
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class VacationSpace {

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
            return negativo ? -res : res;
        }
    }

    public static void main(String[] args) throws IOException {
        FR_Int sc = new FR_Int();

        int numCasas = sc.nextInt();
        HashMap<Integer, Integer> mapa = new HashMap<>();
        int[] posiciones = new int[numCasas];

        //Leer las posiciones
        for (int i=1; i<= numCasas; i++) {
            int posicion = sc.nextInt();
            mapa.put(posicion, i);
            posiciones[i-1] = posicion;
        }

        //Ordenar el array
        Arrays.sort(posiciones);

        //Buscar la distancia mayor a sus vecinos

        // Buscar la distancia mayor a sus vecinos
        int distanciaMayor = -1; // Inicializamos en -1
        int indiceDistanciaMayor = 1;

        for (int i = 0; i < numCasas; i++) {
            int distanciaMasCercano;

            if (numCasas == 1) {
                distanciaMasCercano = Integer.MAX_VALUE; // Caso especial de una sola casa
            } else if (i == 0) {
                // Primer extremo de la calle ordenada: solo mira a la derecha
                distanciaMasCercano = posiciones[1] - posiciones[0];
            } else if (i == numCasas - 1) {
                // Último extremo de la calle ordenada: solo mira a la izquierda
                distanciaMasCercano = posiciones[i] - posiciones[i - 1];
            } else {
                // Casas intermedias: el mínimo entre izquierda y derecha
                int distanciaAntes = posiciones[i] - posiciones[i - 1];
                int distanciaDespues = posiciones[i + 1] - posiciones[i];
                distanciaMasCercano = Math.min(distanciaAntes, distanciaDespues);
            }

            // AQUÍ recuperamos SIEMPRE el índice correcto desde el mapa
            int indiceOriginal = mapa.get(posiciones[i]);

            if (distanciaMasCercano > distanciaMayor) {
                distanciaMayor = distanciaMasCercano;
                indiceDistanciaMayor = indiceOriginal;
            } else if (distanciaMasCercano == distanciaMayor) {
                // Si hay empate, nos quedamos con el menor índice del input original
                indiceDistanciaMayor = Math.min(indiceOriginal, indiceDistanciaMayor);
            }
        }

        // Mostrar el resultado
        System.out.println(indiceDistanciaMayor);
    }
}
