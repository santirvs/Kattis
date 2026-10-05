package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Cargar el mapa.
 * Localizar el caballo
 * Hacer un recorrido en anchura, marcando las casillas ya visitadas
 * Finalizar al llegar a la casilla 1,1
 */


import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class KnightJump {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int lado = sc.nextInt();
        sc.nextLine();

        //Definir un array donde guardaremos las posiciones con 3 enteros:
        //  fila, columna, movimientos
        ArrayDeque<Integer> posiciones = new ArrayDeque<Integer>() ;

        //Leer el tablero
        char[][] tablero = new char[lado][lado];
        for (int fila=0; fila<lado; fila++) {
            String linea = sc.nextLine();
            tablero[fila] = linea.toCharArray();
            int columna = linea.indexOf('K');
            if (columna != -1) {
                //Añadir fila, columna, movimientos
                posiciones.push(fila);
                posiciones.push(columna);
                posiciones.push(0);
                tablero[fila][columna] = 'v';
            }
        }

        //Recorrer la lista hasta que no se llegue a la posicion 0,0 o esté vacío
        int numMovimientos = 0;
        int[][] movs = { {2,1}, {2,-1}, {-2,1}, {-2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}};

        while (tablero[0][0]!='v' && !posiciones.isEmpty()) {
            int fila = posiciones.pollFirst();
            int columna = posiciones.pollFirst();
            int movimientos = posiciones.pollFirst();

            //Tratar de acceder a cada una de las posiciones
            for (int i=0; i<movs.length; i++) {
                int ff=fila+movs[i][0];
                int cc=columna+movs[i][1];

                if (ff>=0 && ff<lado && cc>=0 && cc<lado && tablero[ff][cc]=='.') {
                    //Marcar la casilla como visitada
                    tablero[ff][cc] = 'v';

                    posiciones.add(ff);
                    posiciones.add(cc);
                    posiciones.add(movimientos+1);
                    if (ff==0 && cc==0) {
                        numMovimientos = movimientos+1;
                    }
                }
            }
        }

        //Mostrar el resultado
        if (tablero[0][0]=='v') System.out.println(numMovimientos);
        else System.out.println("-1");

        sc.close();
    }
}

