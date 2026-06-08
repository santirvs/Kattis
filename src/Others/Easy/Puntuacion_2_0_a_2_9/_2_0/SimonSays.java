package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * Leer la entrada. Si comienza por "simon says " escribir el resto de la frase
 * en caso contrario, escribir una línea en blanco
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SimonSays {

    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in).useLocale(Locale.UK);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCasos = Integer.parseInt(br.readLine());

        while (numCasos-- > 0) {
            String linea = br.readLine();
            if (linea.startsWith("simon says ")) {
                System.out.println(linea.substring("simon says ".length()));
            }
            else {
                System.out.println();
            }

        }


        //sc.close();
    }
}

