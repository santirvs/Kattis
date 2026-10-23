package Others.Trivial.Puntuacion_1_1_a_1_5._1_2;

// Leer los dos números y sumarlos
import java.util.Scanner;

public class Fairytale {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numCasos = scan.nextInt();

        while (numCasos-- >0) {
            boolean[] cuerdas = new boolean[4];

            int numNotas = scan.nextInt();

            while (numNotas-- > 0) {

                int nota = scan.nextInt();
                if (nota <= 10) cuerdas[0] = true;
                else if (nota <=20 ) cuerdas[1] = true;
                else if (nota <= 30) cuerdas[2] = true;
                else cuerdas[3] = true;
            }

            int numCuerdas = 0;
            for (int i=0;i<4;i++) {
                if (cuerdas[i]) numCuerdas++;
            }

            System.out.println(numCuerdas);


        }


    }
}