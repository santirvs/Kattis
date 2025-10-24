package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el tamaño de la matriz
// Leer la matriz
// Buscar entre 1 y la longitud-1 un 0 rodeado de O
// contar cuantas veces se encuentran
// Salida
// 0 -> Oh no!
// 1 -> fila columna
// >1 -> Oh no! X locations

import java.util.Scanner;


public class OoohISee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer el número de frases
        int filas =  sc.nextInt();
        int columnas = sc.nextInt();
        sc.nextLine();

        // Leer el mapa
        char[][] mapa =  new char[filas][columnas];
        for (int i = 0; i < filas; i++) {
            mapa[i] = sc.nextLine().toCharArray();
        }

        int numTesorosEncontrados = 0;
        int filaEncontrado = 0;
        int columnaEncontrado = 0;

        // Buscar en el mapa
        for (int fila=1; fila < filas-1; fila++) {
            for (int columna=1; columna < columnas-1; columna++) {
                if (mapa[fila][columna] == '0') {
                    if (mapa[fila-1][columna-1] == 'O' &&
                        mapa[fila-1][columna] == 'O' &&
                        mapa[fila-1][columna+1] == 'O' &&
                        mapa[fila][columna-1] == 'O' &&
                        mapa[fila][columna+1] == 'O' &&
                        mapa[fila+1][columna-1] == 'O' &&
                        mapa[fila+1][columna] == 'O' &&
                        mapa[fila+1][columna+1] == 'O') {

                        numTesorosEncontrados++;
                        filaEncontrado = fila+1;
                        columnaEncontrado = columna+1;

                    }
                }
            }
        }

        //Mostrar resultado
        if (numTesorosEncontrados == 0) {
            System.out.println("Oh no!");
        } else if (numTesorosEncontrados == 1) {
            System.out.println(filaEncontrado + " " + columnaEncontrado);
        } else {
            System.out.println("Oh no! " + numTesorosEncontrados + " locations");
        }


        sc.close();
    }
}

