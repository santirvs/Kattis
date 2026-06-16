package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

import java.util.*;

// Pre-calcular la lista de los números primos "base" de 10^9 y guardarlos en un Set
// Leer cada número de la matriz y comprobar si es primo
// Lo será si no es divisible entre ninguno de los primos "base"
// Imprimir 1 o 0 según corresponda
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class ProveYouAreARobot {

    // Lista global para almacenar los números primos hasta la raíz de 10^9 (~31622)
    private static List<Integer> primosBase;

    public static void main(String[] args) throws IOException {
        // Precalculamos los primos necesarios antes de leer la entrada
        precalcularPrimosBase(31622);

        // Fast I/O para procesar la matriz eficientemente
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < R; i++) {
            line = br.readLine();
            if (line != null) {
                st = new StringTokenizer(line);
                for (int j = 0; j < C; j++) {
                    int num = Integer.parseInt(st.nextToken());

                    if (esPrimo(num)) {
                        output.append("1");
                    } else {
                        output.append("0");
                    }
                }
                output.append("\n");
            }
        }

        // Imprimimos toda la matriz de respuesta de golpe
        System.out.print(output.toString());
    }

    /**
     * Criba clásica de Eratóstenes para generar los primos necesarios para el test.
     */
    private static void precalcularPrimosBase(int max) {
        boolean[] esPrimo = new boolean[max + 1];
        Arrays.fill(esPrimo, true);
        if (max >= 0) esPrimo[0] = false;
        if (max >= 1) esPrimo[1] = false;

        for (int p = 2; p * p <= max; p++) {
            if (esPrimo[p]) {
                for (int i = p * p; i <= max; i += p) {
                    esPrimo[i] = false;
                }
            }
        }

        primosBase = new ArrayList<Integer>();
        for (int i = 2; i <= max; i++) {
            if (esPrimo[i]) {
                primosBase.add(i);
            }
        }
    }

    /**
     * Verifica si un número hasta 10^9 es primo usando los primos base precalculados.
     */
    private static boolean esPrimo(int n) {
        if (n <= 1) return false;

        // Probamos división solo con los números primos hasta la raíz de 'n'
        for (int i = 0; i < primosBase.size(); i++) {
            int primo = primosBase.get(i);

            // Si el primo actual al cuadrado supera a n, ya no habrá más divisores posibles
            if (primo * primo > n) {
                break;
            }

            if (n % primo == 0) {
                return false; // Encontramos un divisor, no es primo
            }
        }

        return true; // Pasó todas las pruebas, es primo
    }
}