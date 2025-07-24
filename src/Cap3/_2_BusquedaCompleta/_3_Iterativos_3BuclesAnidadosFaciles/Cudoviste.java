package Cap3._2_BusquedaCompleta._3_Iterativos_3BuclesAnidadosFaciles;

// Recorrer la matriz y para cada posición posible del monster truck
// calcular si puede aparcar o no y cuantos coches debe aplastar.
// Clasificar el aparcamiento según el número de coches aplastados (entre 0 y 4) y acumular.
// Finalmente, imprimir el número de aparcamientos de cada tipo.


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Cudoviste {

     public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int numFilas = scan.nextInt();
        int numColumnas = scan.nextInt();
        scan.nextLine();

        char[][] mapa = new char[numFilas][numColumnas];
        int[] aparcamientos = new int[5]; // 0 a 4 coches aplastados

        // Leer el mapa
        for (int i = 0; i < numFilas; i++) {
            mapa[i] = scan.nextLine().toCharArray();
        }

        // Recorrer el mapa
        for (int i = 0; i < numFilas-1; i++) {
            for (int j = 0; j < numColumnas-1; j++) {
                if (mapa[i][j] != '#') { // Si no es un edificio
                    int cochesAplastados = 0;
                    boolean hayEdificio = false;

                    // Comprobar las posiciones (actual, derecha, abajo y diagonal abajo-derecha)
                    // Comprobar la casilla actual (ya sabemos que no es un edificio)
                    if (mapa[i][j] == 'X') cochesAplastados++;
                    // Comprobar la casilla de la derecha
                    if (mapa[i][j + 1] == 'X') cochesAplastados++; // Derecha
                    if (mapa[i][j + 1] == '#') hayEdificio = true;
                    // Comprobar la casilla de abajo
                    if (mapa[i + 1][j] == 'X') cochesAplastados++; // Abajo
                    if (mapa[i + 1][j] == '#') hayEdificio = true;
                    // Comprobar la casilla diagonal abajo-derecha
                    if (mapa[i + 1][j + 1] == 'X') cochesAplastados++; // Diagonal abajo-derecha
                    if (mapa[i + 1][j + 1] == '#') hayEdificio = true;

                    if (!hayEdificio) {
                        // Si no hay edificios, se puede aparcar
                        aparcamientos[cochesAplastados]++;
                    }
                }
            }
        }

        // Imprimir el resultado
        for (int i = 0; i < aparcamientos.length; i++) {
            System.out.println(aparcamientos[i]);
        }

    }
}

