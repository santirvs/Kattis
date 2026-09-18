package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Recorrido de fuerza bruta por tener un tamaño muy pequeño  (2 x 5)
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Ruffians {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();

        while (numCasos-- > 0){

            //Leer el conjunto de cartas
            int[][] conjunto = new int[2][5];
            for (int fila=0; fila<2; fila++) {
                for (int col=0; col<5; col++) {
                    conjunto[fila][col] = sc.nextInt();
                }
            }

            //Analizar el conjunto de cartas
            boolean encontrado = false;

            for (int fila=0; fila<2 && !encontrado; fila++) {
                for (int col=0; col<5 && !encontrado; col++) {

                    for (int fila2=0; fila2<2 && !encontrado; fila2++) {
                        for (int col2 = 0; col2 < 5 && !encontrado; col2++) {

                            if (fila!=fila2 && col!=col2) {
                                if (conjunto[fila][col] == conjunto[fila2][col2])
                                    encontrado = true;
                            }

                        }
                    }
                }
            }

            if (encontrado) System.out.println("YES");
            else System.out.println("NO");

        }


    }
}

