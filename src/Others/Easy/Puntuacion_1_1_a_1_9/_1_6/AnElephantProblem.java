package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class AnElephantProblem {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int pesoCacahuete = sc.nextInt();
        int restos = sc.nextInt();

        int numCacahuetes = restos / pesoCacahuete;
        if (restos % pesoCacahuete != 0) numCacahuetes++;

        System.out.println(numCacahuetes);
    }
}

