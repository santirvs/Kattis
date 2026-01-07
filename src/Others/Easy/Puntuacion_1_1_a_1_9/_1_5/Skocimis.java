package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer tres numeros (las posiciones de los canguros)
// Un canguro del exterior saltará a la zona de los otros dos
// El canguro a escoger será el que salte al espacio más amplio
// dejando a su vez, el espacio más ámplio posible (saltando al lado del que está en el medio)
// Contar cuantas veces se puede repetir el proceso como máximo


import java.util.Arrays;
import java.util.Scanner;


public class Skocimis {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Vector de posiciones
        int[] posiciones = new int[3];

        //Leer los valores
        for (int i = 0; i < 3; i++) {
            posiciones[i] = sc.nextInt();
        }

        //Empezar el proceso
        int repeticiones = 0;
        boolean fin = false;
        while (!fin) {
            var espacioDerecha = posiciones[2] - posiciones[1];
            var espacioIzquierda = posiciones[1] - posiciones[0];
            if (espacioIzquierda == 1 && espacioDerecha == 1) fin = true;
            else {
                repeticiones++;
                if (espacioIzquierda >= espacioDerecha) {
                    posiciones[2] = posiciones[1];
                    posiciones[1] = posiciones[2]-1;
                } else {
                    posiciones[0] = posiciones[1];
                    posiciones[1] = posiciones[1]+1;
                }

            }
        }

        System.out.println(repeticiones);

    }


}

