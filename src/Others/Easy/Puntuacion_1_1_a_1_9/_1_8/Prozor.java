package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

import java.util.Scanner;

public class Prozor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int filas = sc.nextInt();
        int columnas = sc.nextInt();
        int tamanyo = sc.nextInt();

        char[][] matriz = new char[filas][columnas];

        for (int f = 0; f < filas; f++) {
            matriz[f] = sc.next().toCharArray();
        }

        int maxMoscas = -1;
        int filaRaquetaMax = 0;
        int columnaRaquetaMax = 0;

        // Esquina superior izquierda (r, c) válida para que quepa toda la raqueta de lado 'tamanyo'
        for (int r = 0; r <= filas - tamanyo; r++) {
            for (int c = 0; c <= columnas - tamanyo; c++) {
                int numMoscas = 0;

                // Contar moscas estrictamente en el interior de la raqueta
                for (int f = r + 1; f < r + tamanyo - 1; f++) {
                    for (int colInner = c + 1; colInner < c + tamanyo - 1; colInner++) {
                        if (matriz[f][colInner] == '*') {
                            numMoscas++;
                        }
                    }
                }

                if (numMoscas > maxMoscas) {
                    maxMoscas = numMoscas;
                    filaRaquetaMax = r;
                    columnaRaquetaMax = c;
                }
            }
        }

        int filaFinRaquetaMax = filaRaquetaMax + tamanyo - 1;
        int columnaFinRaquetaMax = columnaRaquetaMax + tamanyo - 1;

        System.out.println(maxMoscas);

        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                boolean esFilaBorde = (f == filaRaquetaMax || f == filaFinRaquetaMax);
                boolean esColBorde = (c == columnaRaquetaMax || c == columnaFinRaquetaMax);
                boolean dentroFilas = (f >= filaRaquetaMax && f <= filaFinRaquetaMax);
                boolean dentroCols = (c >= columnaRaquetaMax && c <= columnaFinRaquetaMax);

                if (esFilaBorde && esColBorde) {
                    System.out.print("+");
                } else if (esFilaBorde && dentroCols) {
                    System.out.print("-");
                } else if (esColBorde && dentroFilas) {
                    System.out.print("|");
                } else {
                    System.out.print(matriz[f][c]);
                }
            }
            System.out.println();
        }
    }
}