package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

//Crear una matriz de NxM inicializada con _
//Ir imprimiendo cada una de las pegatinas sobre la matriz

import java.util.Arrays;
import java.util.Scanner;

public class LaptopStickers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tableroAncho = sc.nextInt();
        int tableroAlto = sc.nextInt();
        int numPegatinas = sc.nextInt();

        //Crear el tablero
        char[][] tablero = new char[tableroAlto][tableroAncho];
        for (int y=0; y<tableroAlto; y++) {
            Arrays.fill(tablero[y], '_');
        }

        //Leer las pegatinas
        for (int i=0; i<numPegatinas; i++) {
            int ancho = sc.nextInt();
            int alto = sc.nextInt();
            int posX = sc.nextInt();
            int posY = sc.nextInt();

            //Enganchar la pegatina al tablero
            for (int y=posY; y < tableroAlto && y < posY+alto; y++) {
                for (int x=posX; x < tableroAncho && x < posX+ancho; x++) {
                    tablero[y][x] = (char)('a'+i);
                }
            }
        }

        //Mostrar el tablero
        for (int y=0; y<tableroAlto; y++) {
            System.out.println(tablero[y]);
        }
    }
}