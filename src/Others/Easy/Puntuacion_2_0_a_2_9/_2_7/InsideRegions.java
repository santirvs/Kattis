package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InsideRegions {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        switch (num) {
            case 0, 4,6,9 :
                System.out.println(1);
                break;
            case 8:
                System.out.println(2);
                break;
            default:
                System.out.println(0);
        }

    }
}