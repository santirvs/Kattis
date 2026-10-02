package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Exam {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 1. Leer K: el número de respuestas correctas de tu amigo.
        String lineK = reader.readLine();
        int K = Integer.parseInt(lineK.trim());

        // 2. Leer tus respuestas (cadena mia)
        String mia = reader.readLine().trim();

        // 3. Leer las respuestas de tu amigo (cadena amigo)
        String amigo = reader.readLine().trim();

        int n = mia.length();
        int same = 0; // Coincidencias: posiciones donde tú y tu amigo respondieron igual
        int diff = 0; // Diferencias: posiciones donde tú y tu amigo respondieron distinto

        // 4. Clasificar cada posición del examen
        // Planteamiento: Dividimos las preguntas en dos conjuntos disjuntos:
        // - Coincidencias ('same'): Si tu amigo acierta aquí, tú también aciertas.
        // - Diferencias ('diff'): Si tu amigo acierta aquí, tú fallas (y viceversa).
        for (int i = 0; i < n; i++) {
            if (mia.charAt(i) == amigo.charAt(i)) {
                same++;
            } else {
                diff++;
            }
        }

        // 5. Determinar el número mínimo posible de aciertos que tu amigo tuvo en las diferencias (c_diff).
        // Restricciones a cumplir:
        // A) c_diff no puede ser menor que 0.
        // B) c_diff no puede ser menor que (K - same), ya que los aciertos restantes de tu amigo
        //    deben ubicarse obligatoriamente dentro del bloque de coincidencias (y 'same' tiene un límite superior).
        int c_diff_min = Math.max(0, K - same);

        // 6. Maximizar tu puntaje.
        // Fórmula derivada: Tu puntaje = K + diff - 2 * c_diff
        // Para maximizar tu puntaje, debemos minimizar c_diff eligiendo su valor mínimo posible (c_diff_min).
        int maxScore = K + diff - (2 * c_diff_min);

        // 7. Imprimir el resultado final
        System.out.println(maxScore);
    }
}