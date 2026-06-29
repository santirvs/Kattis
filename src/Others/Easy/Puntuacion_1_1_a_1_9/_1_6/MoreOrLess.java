package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Poco que comentar...
 * Leer los dos números y mientras sean diferentes, compararlos entre ellos
 * Si A > B  imprimir More y en caso contrario imprimir Less
 */


import java.io.IOException;
import java.util.Scanner;


public class MoreOrLess {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numA = sc.nextInt();
        int numB = sc.nextInt();

        while (numA != numB) {

            if (numA > numB) System.out.println("More");
            else System.out.println("Less");

            numA = sc.nextInt();
            numB = sc.nextInt();
        }


        sc.close();
    }
}

