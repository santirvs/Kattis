package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Leer los tres números y comprobar los dos intervalos entre ellos
 */


import java.io.IOException;
import java.util.Scanner;

public class TestDrive {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int pos1 = sc.nextInt();
        int pos2 = sc.nextInt();
        int pos3 = sc.nextInt();

        int intervalo1 = pos2 - pos1;
        int intervalo2 = pos3 - pos2;

        if (intervalo1 > 0 && intervalo2 <0 || intervalo1 < 0 && intervalo2 > 0) System.out.println("turned");
        else if (intervalo1 == intervalo2) System.out.println("cruised");
        else if (Math.abs(intervalo1) > Math.abs(intervalo2)) System.out.println("braked");
        else System.out.println("accelerated");

        sc.close();
    }
}