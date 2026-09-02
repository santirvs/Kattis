package Others.Easy.Puntuacion_2_0_a_2_9._2_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ParadoxWithAverages {

    public static void main(String[] args) throws IOException {
        // Uso de Fast I/O mediante CustomReader para procesar archivos de entrada grandes eficientemente
        CustomReader reader = new CustomReader();

        String line = reader.nextToken();
        if (line == null) return;

        int T = Integer.parseInt(line);

        while (T-- > 0) {
            int nCS = reader.nextInt();
            int nEco = reader.nextInt();

            int[] csIQ = new int[nCS];
            long sumCS = 0;
            long sumEco = 0;

            // Lectura de los estudiantes de Ciencias de la Computación (CS)
            for (int i = 0; i < nCS; i++) {
                csIQ[i] = reader.nextInt();
                sumCS += csIQ[i]; // Acumulación usando long para prevenir desbordamiento (overflow)
            }

            // Lectura de los estudiantes de Economía (Eco)
            for (int i = 0; i < nEco; i++) {
                sumEco += reader.nextInt();
            }

            // =========================================================================
            // DEMOSTRACIÓN MATEMÁTICA Y CONDICIÓN
            // =========================================================================
            // Sea A_CS = sumCS / nCS  y  A_Eco = sumEco / nEco los promedios iniciales.
            //
            // Si un estudiante de CS con un IQ de 'x' se traslada a Economía:
            //
            // 1. Para que el promedio de CS AUMENTE:
            //    (sumCS - x) / (nCS - 1) > sumCS / nCS
            //    => nCS * sumCS - nCS * x > nCS * sumCS - sumCS
            //    => -nCS * x > -sumCS
            //    => x < sumCS / nCS  (es decir, x < A_CS)
            //
            // 2. Para que el promedio de Economía AUMENTE:
            //    (sumEco + x) / (nEco + 1) > sumEco / nEco
            //    => nEco * sumEco + nEco * x > nEco * sumEco + sumEco
            //    => nEco * x > sumEco
            //    => x > sumEco / nEco  (es decir, x > A_Eco)
            //
            // Por lo tanto, 'x' debe cumplir estrictamente:
            //    A_Eco < x < A_CS
            //
            // Para evitar imprecisiones de punto flotante (double), expresamos las
            // desigualdades mediante multiplicación entera cruzada:
            //    x * nEco > sumEco   Y   x * nCS < sumCS
            // =========================================================================

            int validStudentsCount = 0;

            for (int i = 0; i < nCS; i++) {
                long x = csIQ[i];

                // Condición 1: El IQ del estudiante es mayor que el promedio de Economía
                boolean strictlyAboveEco = (x * nEco > sumEco);

                // Condición 2: El IQ del estudiante es menor que el promedio de CS
                boolean strictlyBelowCS = (x * nCS < sumCS);

                if (strictlyAboveEco && strictlyBelowCS) {
                    validStudentsCount++;
                }
            }

            System.out.println(validStudentsCount);
        }
    }

    /**
     * Lector rápido personalizado (Fast I/O) para manejar grandes bloques de
     * enteros separados por cualquier tipo de espacio en blanco.
     */
    static class CustomReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public CustomReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String nextToken() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String line = reader.readLine();
                if (line == null) {
                    return null;
                }
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }
    }
}