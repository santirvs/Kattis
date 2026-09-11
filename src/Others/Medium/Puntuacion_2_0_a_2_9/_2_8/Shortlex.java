package Others.Medium.Puntuacion_2_0_a_2_9._2_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Shortlex {
    public static void main(String[] args) throws IOException {
        // Uso de BufferedReader para una lectura rápida de los casos de prueba
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        if (line == null || line.trim().isEmpty()) {
            return;
        }

        int T = Integer.parseInt(line.trim()); // Número de casos de prueba

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            line = br.readLine();
            while (line != null && line.trim().isEmpty()) {
                line = br.readLine();
            }
            if (line == null) {
                break;
            }

            // Lectura del índice N (hasta 10^18, por lo que usamos long)
            long N = Long.parseLong(line.trim());

            // --- PLANTEAMIENTO Y REGLA DIRECTA ---
            // 1. Sumamos 1 a N.
            // 2. Convertimos (N + 1) a su representación binaria en String.
            // 3. Eliminamos el primer caracter (el bit más significativo '1').
            //
            // Ejemplo para N = 10:
            //   N + 1 = 11
            //   11 en binario es "1011"
            //   Eliminando el primer '1' obtenemos "011"

            long val = N + 1;
            String binary = Long.toBinaryString(val);

            // Obtenemos la subcadena desde el índice 1 (omite el primer bit)
            String result = binary.substring(1);

            sb.append(result).append("\n");
        }

        // Imprimimos los resultados
        System.out.print(sb.toString());
    }
}