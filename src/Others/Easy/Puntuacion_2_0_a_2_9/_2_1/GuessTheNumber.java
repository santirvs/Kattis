package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// Aproximar el número por búsqueda binaria

import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numMax = 1000;
        int numMin = 1;
        boolean encontrado = false;

        while (!encontrado) {

            int apuesta = (numMax + numMin) / 2;

            System.out.println(apuesta);
            String resultado = sc.next();
            if (resultado.equals("correct")) {
                encontrado = true;
            } else if (resultado.equals("lower")) {
                numMax = apuesta - 1;
            } else {
                numMin = apuesta + 1;
            }
        }
    }
}
