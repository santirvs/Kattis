package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer el número de bloques
// Ir probando mientras queden bloques
// Para el 1r piso necesito 1^2
// Para el 2n piso necesito 2^2 bloques más
// Para el 3r piso necesito ....
// Finalizar cuando no tenga suficientes bloques para el siguiente piso

import java.util.Scanner;

public class BuildingPyramids {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer las dos cadenas de entrada
        int numBloques = sc.nextInt();
        int ladoPiso = 1;
        int numPisos = 0;

        //Mientras tenga suficientes bloques para hacer el siguiente piso
        //En cada piso el lado se incrementa en 2
        while (numBloques >= ladoPiso * ladoPiso) {
            //Incrementar número de pisos y decrementar los bloques disponibles
            numPisos++;
            numBloques-=(ladoPiso*ladoPiso);
            ladoPiso+=2;
        }

        System.out.println(numPisos);
        sc.close();
    }
}

