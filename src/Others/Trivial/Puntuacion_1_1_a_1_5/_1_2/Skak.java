package Others.Trivial.Puntuacion_1_1_a_1_5._1_2;

// Leer la posición de las dos piezas
// Si la torre está en la misma columna o la misma fila --> matar al peón --> 1 movimiento
// Si no, mover la torre a la misma columna y luego matar al peón --> 2 movimientos

import java.util.Scanner;

public class Skak {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        int colTorre = scan.nextInt();
        int filaTorre = scan.nextInt();

        int colPeon = scan.nextInt();
        int filaPeon = scan.nextInt();

        if (colTorre == colPeon || filaTorre == filaPeon) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }

    }
}