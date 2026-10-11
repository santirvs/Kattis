package Others.Trivial.Puntuacion_1_1_a_1_5._1_3;

// Un mapa con las cafeterías en las posiciones (0,1) y (1,0)
// cumple con los requerimientos
// Dibujar la matriz hasta el tamaño requerido

import java.util.Scanner;

public class EspressoMachiatto {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //Leer los datos
        int numCasos = scan.nextInt();

        while (numCasos-- > 0) {
            int tamanyo = scan.nextInt();

            for (int fila=0; fila<tamanyo; fila++) {
                for (int columna=0; columna<tamanyo;columna++) {
                    if ((fila==0 && columna==1) || (fila==1 && columna==0)) {
                        System.out.print("C");
                    }
                    else {
                        System.out.print(".");
                    }
                }
                System.out.println();
            }
        }

    }
}