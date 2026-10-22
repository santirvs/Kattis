package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Contar cuantas veces la pieza es más grande que la anterior
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class TowerConstruction {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numPiezas = sc.nextInt();
        int numTorres = 0;
        int piezaAnterior = 0;

        while (numPiezas-- >0) {
            int nuevaPieza = sc.nextInt();

            if (nuevaPieza > piezaAnterior)
                numTorres++;

            piezaAnterior=nuevaPieza;
        }

        System.out.println(numTorres);


        sc.close();
    }
}

