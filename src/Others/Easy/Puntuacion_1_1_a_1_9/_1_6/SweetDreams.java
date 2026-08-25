package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Calcular si alguno de los puntos se encuentra a una distancia igual o inferior a 8
 * de la posición inicial de la cama
 */


import java.io.IOException;
import java.util.Scanner;


public class SweetDreams {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int posXCama = sc.nextInt();
        int posYCama = sc.nextInt();

        int numMonstruos = sc.nextInt();
        boolean seguro = true;

        while (numMonstruos-- >0 && seguro) {

            int posXMonstruo = sc.nextInt();
            int posYMonstruo = sc.nextInt();

            int distX = posXCama-posXMonstruo;
            int distY = posYCama-posYMonstruo;

            seguro = (distX*distX) + (distY*distY) > 64;  //64=8*8 para evitar hacer raíces cuadradas

        }

        if (seguro) System.out.println("YES");
        else System.out.println("NO");


        sc.close();
    }
}

