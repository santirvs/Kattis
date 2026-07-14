package Others.Medium.Puntuacion_3_0_a_3_9._3_5;

/**
 * Dado que los límites del problema son muy pequeños podemos usar fuerza bruta
 * Calcular todas las combinaciones posibles y quedarnos con la mayor nota mínima
 * Para agilizarlo, usaremos máscaras de bits
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ExamManipulation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // Guardamos las respuestas de los estudiantes como enteros (bitmasks)
        int[] estudiantes = new int[N];
        for (int i = 0; i < N; i++) {
            String respuestas = br.readLine().trim();
            int mask = 0;
            for (int j = 0; j < K; j++) {
                if (respuestas.charAt(j) == 'T') {
                    mask |= (1 << j); // Encendemos el bit si es True
                }
            }
            estudiantes[i] = mask;
        }

        int mejorPuntuacionBaja = 0;
        int totalCombinaciones = 1 << K; // Equivalente a 2^K

        // Probamos todas las 2^K combinaciones de la hoja de respuestas del examen
        for (int examKey = 0; examKey < totalCombinaciones; examKey++) {
            int actualPuntuacionBaja = Integer.MAX_VALUE;

            // Evaluamos a cada estudiante con la clave de examen actual
            for (int i = 0; i < N; i++) {
                int respuestasEstudiante = estudiantes[i];

                // XOR nos da un '1' en las posiciones donde difieren. 
                // Al aplicar el operador NOT (~), los '1' serán las coincidencias (respuestas correctas).
                int matchesMask = ~(respuestasEstudiante ^ examKey);

                // Como un entero tiene 32 bits en Java, nos quedamos solo con los últimos K bits
                matchesMask &= (1 << K) - 1;

                // Contamos cuántos bits están encendidos (puntos ganados por el estudiante)
                int score = Integer.bitCount(matchesMask);

                // Buscamos el peor puntaje de la clase para esta configuración de examen
                if (score < actualPuntuacionBaja) {
                    actualPuntuacionBaja = score;
                }
            }

            // Queremos que el peor puntaje sea lo más alto posible (Maximin)
            if (actualPuntuacionBaja > mejorPuntuacionBaja) {
                mejorPuntuacionBaja = actualPuntuacionBaja;
            }
        }

        // Imprimimos el mejor peor resultado posible
        System.out.println(mejorPuntuacionBaja);
    }
}