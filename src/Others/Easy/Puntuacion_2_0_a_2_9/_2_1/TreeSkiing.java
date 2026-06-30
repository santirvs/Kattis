package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// El problema se puede reducir a buscar la cantidad de caminos diferentes
// en una rejilla de tamaño A x B desde la casilla superior izquierda a la
// casilla inferior derecha.
// Los tamaños vienen definidos por la cantidad de Ns (filas) y Ws (columnas)
// del recorrido inicial.
// Las direcciones posibles son únicamente 2  (derecha y abajo)

import java.util.Scanner;

public class TreeSkiing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTramos = sc.nextInt();

        int numNs = 1;
        int numWs = 1;

        for (int i=0; i<numTramos; i++) {
            String direccion = sc.next();

            if (direccion.equals("N")) numNs++;
            else numWs++;
        }

        //Calcular el número de tramos posibles
        //Propagar las opciones a partir de una matriz de tamaño Ns x Ws
        int[][] matriz = new int[numNs][numWs];

        matriz[0][0]=1;

        for (int fila=0; fila<numNs;fila++) {
            for (int columna=0; columna <numWs; columna++) {
                //Desde cada casilla (fila,columna) podemos llegar a la derecha o abajo
                //con la misma cantidad de combinaciones con la que hemos llegado
                if (fila+1 <numNs) matriz[fila+1][columna]+=matriz[fila][columna];
                if (columna+1 < numWs) matriz[fila][columna+1] +=matriz[fila][columna];
            }
        }

        //El resultado es la cantidad de formas diferentes de llegar a la última casilla -1
        System.out.println(matriz[numNs-1][numWs-1]-1);

    }
}
