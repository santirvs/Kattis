package Others.Medium.Puntuacion_3_0_a_3_9._3_1;

/*
    Leer los nombres en una línea
    Transformar a una matriz de Sqrt(longitud) * Sqrt(longitud) de enteros
    con la longitud de cada uno de los nombres
    Al finalizar, hacer un recorrido de la matriz de números buscando una cruz con
    numeros iguales.
 */

import java.util.Scanner;

public class ScrewySchoolSystems {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt();
        scan.nextLine();
        while (numCasos-- > 0) {

            String[] nombres = scan.nextLine().split(" ");
            int tamano = (int) Math.sqrt((double)nombres.length);
            int[][] matriz = new int[tamano][tamano];

            //Construir la matriz de longitudes
            for (int i=0; i<tamano; i++) {
                for (int j=0; j<tamano; j++) {
                    matriz[i][j] = nombres[i*tamano + j].length() ;
                }
            }

            //Recorrer la matriz buscando una cruz
            //           W, E, S, N
            int[] dx = {-1, 1, 0, 0};
            int[] dy = { 0, 0, 1,-1};
            String nombre = "Name Not Found";
            boolean encontrado = false;
            for (int i=0; i<tamano && !encontrado; i++) {
                for (int j=0; j<tamano && !encontrado; j++) {
                    boolean iguales = true;
                    for (int k=0; k < 4 && !encontrado; k++) {
                        if (i+dy[k] >= 0 && i+dy[k]<tamano && j+dx[k] >=0 && j+dx[k] < tamano) {
                            iguales = iguales && matriz[i][j] == matriz[i+dy[k]][j+dx[k]];
                        }
                    }

                    if (iguales) {
                        nombre = nombres[i*tamano + j];
                        encontrado = true;
                    }
                }
            }

            System.out.println(nombre);

        }

        scan.close();
    }
}