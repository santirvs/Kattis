package Others.Easy.Puntuacion_2_0_a_2_9._2_8;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.TreeMap;

public class Linuhlynun {

    public static void main(String[] args) throws IOException {
        // BufferedReader y StringTokenizer para lectura eficiente de la entrada
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        StringTokenizer tokenizer = new StringTokenizer(line);
        int n = Integer.parseInt(tokenizer.nextToken());

        // TreeMap mantiene las casas ordenadas automáticamente por su número
        Map<Long, Long> housesMap = new TreeMap<Long, Long>();
        long totalPollution = 0;

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(nextNonEmptyLine(reader));
            long x = Long.parseLong(tokenizer.nextToken());
            long p = Long.parseLong(tokenizer.nextToken());

            Long currentP = housesMap.get(x);
            if (currentP == null) {
                housesMap.put(x, p);
            } else {
                housesMap.put(x, currentP + p);
            }

            totalPollution += p;
        }

        // Buscar la mediana ponderada
        long accumulatedPollution = 0;
        for (Map.Entry<Long, Long> entry : housesMap.entrySet()) {
            accumulatedPollution += entry.getValue();

            // Condición: suma acumulada mayor o igual a la mitad de la contaminación total
            // Se usa multiplicación por 2 para evitar problemas de precisión con float/double
            if (accumulatedPollution * 2 >= totalPollution) {
                System.out.println(entry.getKey());
                break;
            }
        }
    }

    private static String nextNonEmptyLine(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = reader.readLine();
        }
        return line;
    }
}