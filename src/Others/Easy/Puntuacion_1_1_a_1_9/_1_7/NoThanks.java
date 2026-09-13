package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Leer los números
 * Ordenarlos
 * Sumarlos excepto si el anterior ya existe
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NoThanks {
    public static void main(String[] args) throws IOException {
        // Usamos BufferedReader para una lectura eficiente de la entrada estándar
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        if (line == null || line.trim().isEmpty()) {
            return;
        }

        StringTokenizer st = new StringTokenizer(line);
        int numCartas = Integer.parseInt(st.nextToken()); // Número de cartas
        int[] cartas = new int[numCartas];

        //Segunda línea
        line = br.readLine();
        st = new StringTokenizer(line);

        //Leer las cartas
        for (int i=0; i<numCartas;i++) {
            cartas[i] =Integer.parseInt(st.nextToken());
        }

        //Ordenar las cartas
        Arrays.sort(cartas);

        //Sumar siempre que el anterior número no exista
        long suma = cartas[0];
        int anterior = cartas[0];
        for (int i=1; i<numCartas; i++) {
            if (cartas[i]-1 != anterior) {
                suma += cartas[i];
            }
            anterior = cartas[i];
        }

        //Mostrar el resultado
        System.out.println(suma);
    }
}