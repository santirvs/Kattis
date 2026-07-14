package Others.Medium.Puntuacion_3_0_a_3_9._3_0;


/*
    Apoyarnos en un HashMap<Precio, Cantidad> para gestionar la cantidad de platos con el mismo precio
    Para agilizar las operaciones, usaremos siempre el precio base de los platos, manteniendo
    una suma total de platos y un acumulador de inflación
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class Inflation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        String line = br.readLine();
        if (line == null) return;
        int N = Integer.parseInt(line.trim());

        long totalSum = 0;
        long globalInflation = 0;
        Map<Long, Long> priceCounts = new HashMap<Long, Long>();

        line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for (int i = 0; i < N; i++) {
            long price = Long.parseLong(st.nextToken());
            totalSum += price;

            // Frecuencia inicial (con inflación = 0, precio_base = precio_inicial)
            Long count = priceCounts.get(price);
            if (count == null) {
                priceCounts.put(price, 1L);
            } else {
                priceCounts.put(price, count + 1);
            }
        }

        line = br.readLine();
        int Q = Integer.parseInt(line.trim());

        for (int q = 0; q < Q; q++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            String type = st.nextToken();

            if (type.equals("INFLATION")) {
                long x = Long.parseLong(st.nextToken());
                globalInflation += x;
                totalSum += (x * N);

            } else if (type.equals("SET")) {
                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());

                if (x != y) {
                    long baseX = x - globalInflation;
                    long baseY = y - globalInflation;

                    Long countX = priceCounts.get(baseX);
                    // Si existen platos con el precio actual x
                    if (countX != null && countX > 0) {
                        // 1. Actualizar la suma total global
                        totalSum += countX * (y - x);

                        // 2. Transferir platos de baseX a baseY
                        priceCounts.remove(baseX);

                        Long countY = priceCounts.get(baseY);
                        if (countY == null) {
                            priceCounts.put(baseY, countX);
                        } else {
                            priceCounts.put(baseY, countY + countX);
                        }
                    }
                }
            }
            // Imprimimos la suma acumulada del día utilizando PrintWriter (mucho más rápido que System.out.println)
            out.println(totalSum);
        }
        out.flush();
    }
}