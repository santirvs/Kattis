package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class StardustCurry {
    public static void main(String[] args) throws IOException {
        // BufferedReader y StringTokenizer para optimizar la lectura de datos
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = null;

        // Leer el número de casos de prueba (T)
        String line = reader.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        // Procesar cada caso de prueba
        while (t-- > 0) {
            // Leer N (número de descansos) y P (número total de flexiones)
            line = reader.readLine();
            while (line != null && line.trim().isEmpty()) {
                line = reader.readLine(); // Saltar líneas vacías si las hay
            }
            if (line == null) break;

            tokenizer = new StringTokenizer(line);
            int n = Integer.parseInt(tokenizer.nextToken());

            // Usamos 'long' para P para evitar desbordamiento al elevar al cuadrado
            long p = Long.parseLong(tokenizer.nextToken());

            // Acumular la suma total de las duraciones de los descansos (sumT)
            long sumT = 0;

            // Leer las N duraciones de los descansos
            line = reader.readLine();
            tokenizer = new StringTokenizer(line);

            for (int i = 0; i < n; i++) {
                // Si la línea actual se queda sin tokens, leemos la siguiente
                while (!tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
                long t_i = Long.parseLong(tokenizer.nextToken());
                sumT += t_i; // Acumular el tiempo total sum(T_i)
            }

            /*
             * Aplicamos la fórmula deducida:
             * Estrés Mínimo = (P^2) / (Suma de T_i)
             *
             * Realizamos la conversión explícita a double para obtener
             * la división flotante precisa.
             */
            double minStress = (double) (p * p) / (double) sumT;

            // Imprimir el resultado con 10 decimales de precisión
            System.out.printf("%.10f%n", minStress);
        }
    }
}