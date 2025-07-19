package Cap2._2_EstructurasDatosConBibliotecas._4_ArraysBidimensionales_Dificiles;

import java.util.Locale;
import java.util.Scanner;

public class FallingApples {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int alto = scan.nextInt();
        int ancho = scan.nextInt();
        scan.nextLine();

        //Definir la matriz
        char[][] matriz = new char[alto][ancho];

        //Leer el tablero
        for (int i = 0; i < alto; i++) {
            matriz[i] = scan.nextLine().toCharArray();
        }

        //Procesar la matriz
        //Analizar columna por columna, empezando por la fila 0
        //Contar el número de manzanas que hay en cada columna.
        //A medida que me encuentre una manzana, la cambio por un .
        //Si me encuentro un obstáculo, a partir de él hacia arriba voy poniendo
        // las manzanas que he contado y continuo el proceso desde la fila siguiente.
        //Al llegar a la última fila, coloco las manzanas contadas.
        for (int j = 0; j < ancho; j++) {
            int manzanas = 0;
            for (int i = 0; i < alto; i++) {
                //Manzana
                if (matriz[i][j] == 'a') {
                    manzanas++;
                    matriz[i][j] = '.';
                } else if (matriz[i][j] == '#') {
                    //Obstáculo. Coloco las manzanas contadas
                    for (int k = i - 1; k >= i-manzanas; k--) {
                        matriz[k][j] = 'a';
                    }
                    manzanas = 0;
                }
            }
            //He llegado al final. Coloco las manzanas contadas
            for (int k = alto - 1; k >= alto - manzanas; k--) {
                matriz[k][j] = 'a';
            }
        }

        //Imprimir la matriz
        for (int i = 0; i < alto; i++) {
            System.out.println(matriz[i]);
        }

    }
}