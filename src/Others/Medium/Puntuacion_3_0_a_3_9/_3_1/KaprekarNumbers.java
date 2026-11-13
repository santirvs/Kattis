package Others.Medium.Puntuacion_3_0_a_3_9._3_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;
import java.util.StringTokenizer;

public class KaprekarNumbers {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        StringTokenizer st = null;

        // Leemos la cantidad de casos de prueba
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        int numCasos = Integer.parseInt(line.trim());

        while (numCasos-- > 0) {
            if (st == null || !st.hasMoreElements()) {
                String l = br.readLine();
                if (l == null) break;
                st = new StringTokenizer(l);
            }

            long numero = Long.parseLong(st.nextToken());
            long numero2 = numero * numero;
            String num2 = Long.toString(numero2);

            boolean encontrado = false;

            // i comienza en 0 para contemplar el caso donde la parte izquierda tiene 0 dígitos (vale 0)
            for (int i = 0; i < num2.length() && !encontrado; i++) {
                String left = num2.substring(0, i);
                String right = num2.substring(i);

                // Si la parte izquierda está vacía, su valor numérico es 0
                long numLeft = left.isEmpty() ? 0 : Long.parseLong(left);
                long numRight = Long.parseLong(right);

                // Condición de Kaprekar:
                // 1. La suma de ambas partes debe ser igual al número original.
                // 2. La parte derecha debe ser estrictamente mayor que cero (numRight != 0).
                if (numLeft + numRight == numero && numRight != 0) {
                    encontrado = true;
                }
            }

            if (encontrado) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }

        out.flush();
    }
}