package Cap3._2_BusquedaCompleta._3_Iterativos_3BuclesAnidadosFaciles;

// Es un puzzle de tamaño 4x4
// Recorrer la matriz y comprobar si la letra esperada se encuentra en la posición esperada
// Si no es así, buscar la letra en la matriz y obtener su distancia a la posición esperada
// Acumular las distancias de todas las letras y devolver el resultado


import java.io.IOException;
import java.util.Scanner;

public class NPuzzle {

     public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        //Tablero
         char[][] tablero = new char[4][4];

        //Leer el tablero
        for (int i = 0; i < 4; i++) {
            String linea = scan.nextLine();
            tablero[i] = linea.toCharArray();
        }

        //Inicializar la distancia total
        int distanciaTotal = 0;

        //Recorrer el tablero
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                char letraEsperada = (char) ('A' + (i * 4) + j); // Calcular la letra esperada en función de la posición
                if (tablero[i][j] != letraEsperada) { // Si la letra no está en la posición esperada
                    // Buscar la letra en el tablero
                    boolean letraEncontrada = false;
                    for (int k = 0; k < 4 && !letraEncontrada; k++) {
                        for (int l = 0; l < 4 && !letraEncontrada; l++) {
                            if (tablero[k][l] == letraEsperada) { // Si encontramos la letra
                                // Calcular la distancia Manhattan
                                int distancia = Math.abs(i - k) + Math.abs(j - l);
                                distanciaTotal += distancia;
                                letraEncontrada = true; // Salir del bucle una vez encontrada la letra
                            }
                        }
                    }
                }
            }
        }
        // Imprimir la distancia total
        System.out.println(distanciaTotal);
    }
}

