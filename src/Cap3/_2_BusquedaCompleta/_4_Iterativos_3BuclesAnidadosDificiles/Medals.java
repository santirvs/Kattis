package Cap3._2_BusquedaCompleta._4_Iterativos_3BuclesAnidadosDificiles;

// Fuerza bruta
// La cantidad de países es relativamente pequeña (hasta 50) así que una búsqueda
// completa es factible (2^3 = 8 combinaciones de puntuación por país).
// Leer los países y sus medallas
// Calcular el total de medallas
// Si Canadá no tiene medallas, imprimir que no puede ganar
// Calcular las puntuaciones posibles para Canadá y los demás países
// Comprobar si Canadá tiene la puntuación máxima
// Si Canadá tiene la puntuación máxima, imprimir que gana, de lo contrario, imprimir que no puede ganar

import java.util.*;

public class Medals {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int L = 2;  // Aquí está la clave del problema, el peso de las medallas se divide, por lo que basta con comprobar
        // si se cuenta la medalla (1) o no (0). Esto reduce el número de combinaciones a 2^3 = 8.

        // Leer el número de países
        int numPaises = sc.nextInt();

        // Mientras haya países para procesar
        while (numPaises > 0) {

            // Crear un mapa para almacenar los países y sus medallas
            Map<String, int[]> mapaPaises = new HashMap<>();
            int totalMedallas = 0;

            // Leer los países y sus medallas
            for (int i = 0; i < numPaises; i++) {
                String c = sc.next();
                int numOros = sc.nextInt();
                int numPlatas = sc.nextInt();
                int numBronces = sc.nextInt();
                mapaPaises.put(c, new int[]{numOros, numPlatas, numBronces});
                totalMedallas += numOros + numPlatas + numBronces;
            }

            // Si Canadá no está entre los países, no puede ganar
            if (!mapaPaises.containsKey("Canada")) {
                System.out.println("Canada cannot win.");
                numPaises = sc.nextInt(); // Leer el siguiente número de países
                continue;
            }

            // Genera una matriz de potencias para calcular los pesos de las medallas
            int[] p = new int[L];
            for (int i = 0; i < L; i++) p[i] = (int) Math.pow(totalMedallas, i);

            // Recorrer todas las combinaciones de puntuaciones posibles
            boolean ok = false;
            for (int numOros = 0; numOros < L && !ok; numOros++) {
                for (int numPlatas = 0; numPlatas < L && !ok; numPlatas++) {
                    for (int numBronces = 0; numBronces < L && !ok; numBronces++) {
                        Map<String, Integer> medallero = new HashMap<>();
                        for (Map.Entry<String, int[]> entry : mapaPaises.entrySet()) {
                            String country = entry.getKey();
                            int[] medals = entry.getValue();
                            int score = medals[0] * p[numOros] + medals[1] * p[numPlatas] + medals[2] * p[numBronces];
                            medallero.put(country, score);
                        }
                        // Para cada combinación, comprobar si Canadá tiene la puntuación máxima
                        // Si la tiene, marcar como ok y salir
                        int canadaScore = medallero.get("Canada");
                        int maxScore = Collections.max(medallero.values());
                        if (canadaScore == maxScore) {
                            ok = true;
                        }
                    }
                }
            }

            // Imprimir el resultado
            System.out.println("Canada " + (ok ? "wins!" : "cannot win."));

            numPaises = sc.nextInt(); // Leer el siguiente número de países
        }

        sc.close();
    }
}
