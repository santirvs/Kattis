package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class HailstoneSequence {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        long num = scan.nextLong();
        int longSecuencia = 1;

        while (num != 1) {
            if (num%2 == 0) num = num/2;
            else num = 3*num +1;
            longSecuencia++;
        }

        System.out.println(longSecuencia);

    }
}