package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Las dimensiones son de 50x50, así que admitirá fuerza bruta
 */


import java.io.IOException;
import java.util.Scanner;


public class RestaurantOpening {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int filas = sc.nextInt();
        int columnas = sc.nextInt();

        int[][] personas = new int[filas][columnas];

        //Leer las personas en cada ubicación
        for (int f =0; f<filas; f++) {
            for (int c=0; c<columnas; c++) {
                personas[f][c]=sc.nextInt();
            }
        }

        //Calcular el coste de cada ubicación
        int minDistancia = Integer.MAX_VALUE;
        for (int f1 =0; f1<filas; f1++) {
            for (int c1=0; c1<columnas; c1++) {

                int distancia = 0;
                //Sumar las distancias a esta ubicación
                for (int f2 =0; f2<filas; f2++) {
                    for (int c2 = 0; c2 < columnas; c2++) {

                        distancia += personas[f2][c2] * (Math.abs(f1-f2) + Math.abs(c1-c2));
                    }
                }

                minDistancia = Math.min(minDistancia, distancia);

            }
        }

        //Mostrar el resultado
        System.out.println(minDistancia);

        sc.close();
    }
}

