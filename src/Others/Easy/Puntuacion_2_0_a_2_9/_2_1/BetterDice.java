package Others.Easy.Puntuacion_2_0_a_2_9._2_1;


import java.util.Arrays;
import java.util.Scanner;

public class BetterDice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCaras = sc.nextInt();

        //Leer los dados
        int[] dado1 = new int[numCaras];
        int[] dado2 = new int[numCaras];

        for (int i=0; i<numCaras;i++) {
            dado1[i] = sc.nextInt();
        }
        for (int i=0; i<numCaras;i++) {
            dado2[i] = sc.nextInt();
        }
        Arrays.sort(dado1);
        Arrays.sort(dado2);

        //Contar cuantas tiradas de dado1 ganarían al dado2
        int numGanadas1 = 0;
        for (int i=0; i<numCaras; i++) {
            int pos = Arrays.binarySearch(dado2, dado1[i]);
            if (pos >= 0) {
                numGanadas1 += pos;
            } else {
                numGanadas1 += -pos;
            }
        }

        //Contar cuantas tiradas de dado2 ganarían al dado1
        int numGanadas2 = 0;
        for (int i=0; i<numCaras; i++) {
            int pos = Arrays.binarySearch(dado1, dado2[i]);
            if (pos >= 0) {
                numGanadas2 += pos;
            } else {
                numGanadas2 += -pos;
            }
        }


        //Mostrar el resultado
        if (numGanadas1 == numGanadas2) {
            System.out.println("tie");
        } else if (numGanadas1 > numGanadas2) {
            System.out.println("first");
        } else {
            System.out.println("second");
        }
    }
}
