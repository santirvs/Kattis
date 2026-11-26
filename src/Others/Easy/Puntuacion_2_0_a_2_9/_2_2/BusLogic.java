package Others.Easy.Puntuacion_2_0_a_2_9._2_2;

/**
 * Crear un array de paradas accesibles y finalmente contar el número de paradas
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class BusLogic {


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int paradaInicial = sc.nextInt() -1 ;  // Indice de la parada, con base 1, pasar a base 0
        int numLineas = sc.nextInt();
        int numParadas = sc.nextInt();

        boolean[] accesibles = new boolean[numParadas];

        while (numLineas-- >0) {
            String linea = sc.next();

            if (linea.charAt(paradaInicial) != '0') {
                int numParadasLineas = 0;
                for (int i=0; i<numParadas ; i++) {
                    if (i != paradaInicial && linea.charAt(i) == '1' ) accesibles[i] = true;
                }
            }
        }

        //Contar el número de paradas accesibles
        int numParadasAccesibles = 0;
        for (int i=0; i<numParadas; i++) {
            if (accesibles[i]) numParadasAccesibles++;
        }

        System.out.println(numParadasAccesibles);
    }
}
