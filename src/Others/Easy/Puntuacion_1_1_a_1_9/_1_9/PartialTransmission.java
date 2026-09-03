package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Definir un array de booleanos e ir marcando los que ya tenemos
 * En un segundo recorrido, buscar el primero (y único ) que faltará
 */


import java.io.IOException;
import java.util.Scanner;


public class PartialTransmission {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int cantidad = sc.nextInt();
        int minimo = sc.nextInt();

        boolean[] recibidos = new boolean[cantidad];

        for (int i=0; i<cantidad-1; i++) {
            int num = sc.nextInt();
            recibidos[num-minimo] = true;
        }

        boolean encontrado = (recibidos[0] == false);
        int pos = 0;

        while (!encontrado) {
            pos++;
            encontrado = (recibidos[pos] == false);
        }

        System.out.println(pos+minimo);

        sc.close();
    }
}

