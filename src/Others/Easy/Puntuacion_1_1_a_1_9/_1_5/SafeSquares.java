package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el tablero y tratar las Rs
// Marcar las filas y columnas inseguras
// Contar las casillas seguras, recorriendo las filas y columnas
// que no están marcadas como inseguras a la vez


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class SafeSquares {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Crear arrays para filas y columnas seguras
        boolean[] filasSeguras = new boolean[8];
        Arrays.fill(filasSeguras, true);
        boolean[] columnasSeguras = new boolean[8];
        Arrays.fill(columnasSeguras, true);

        // Leer las filas y marcar las celdas inseguras
        for (int fila=0; fila<8; fila++) {
            String linea = sc.nextLine();
            // Procesar la línea para marcar filas y columnas inseguras
            for (int col=0; col<8; col++) {
                char casilla = linea.charAt(col);
                if (casilla == 'R') {
                    filasSeguras[fila] = false;
                    columnasSeguras[col] = false;
                }
            }
        }

        // Contar las casillas seguras
        int casillasSeguras = 0;
        for (int fila=0; fila<8; fila++) {
            for (int col=0; col<8; col++) {
                if (filasSeguras[fila] && columnasSeguras[col]) {
                    casillasSeguras++;
                }
            }
        }

        // Imprimir el resultado
        System.out.println(casillasSeguras);


        sc.close();
    }
}

