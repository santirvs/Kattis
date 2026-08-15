package Others.Trivial.Puntuacion_1_1_a_1_5._1_5;

// Pasar a binario y comprobar si tiene un único uno

import java.util.Arrays;
import java.util.Scanner;


public class ThePowerOfTwo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long num = sc.nextLong();
        String binario = Long.toBinaryString(num);

        int num1s = 0;
        for (int pos=0; pos<binario.length() && num1s<=1; pos++) {
            if (binario.charAt(pos) == '1') num1s++;
        }

        if (num1s == 1 ) System.out.println("Yes");
        else System.out.println("No");

        sc.close();
    }
}

