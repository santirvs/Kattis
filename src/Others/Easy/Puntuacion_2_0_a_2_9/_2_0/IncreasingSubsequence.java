package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

// Aplicar LIS

import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class IncreasingSubsequence {

    public static void main(String[] args) {
        // Una solució recursiva genera TLE donat que té molt solapament
        // Farem una solució incremental

        Scanner sc = new Scanner(System.in);

        int longSecuencia = sc.nextInt();

        while (longSecuencia != 0) {
            long[] valores = new long[longSecuencia];
            int[] LIS = new int[longSecuencia];
            int max_LIS_general = 0;

            for (int i = 0; i < longSecuencia; i++) {
                // Llegir el preu
                valores[i] = sc.nextLong();
                int max_LIS = 1;

                // Busquem els valors més baixos anteriors
                for (int j = 0; j < i; j++) {
                    if (valores[j] < valores[i]) {
                        if (LIS[j] >= max_LIS) {
                            max_LIS = LIS[j] + 1;
                        }
                    }
                }

                // Guardem el max_LIS a l'array de max_LIS
                LIS[i] = max_LIS;

                // Guardem el max_LIS general
                if (max_LIS_general < max_LIS) {
                    max_LIS_general = max_LIS;
                }
            }

            Stack<Long> pila = new Stack<>();
            System.out.print(max_LIS_general);
            int index = LIS.length-1;
            while (max_LIS_general > 0) {
                if (LIS[index] == max_LIS_general) {
                    pila.push(valores[index]);
                    max_LIS_general--;
                }
                index--;
            }

            //Vaciar la pila
            while (!pila.empty()) {
                System.out.print(" " + pila.pop());
            }
            System.out.println();

            //Siguiente caso
            longSecuencia = sc.nextInt();
        }
    }
}