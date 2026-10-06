package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// Enfrontar els digits i passar-los a un StringBuilder
// La longitud màxima és de 10 dígits, el rendiment no és problema
// Finalment imprimir l'String. Si està buit --> YODA

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Yoda {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //Leer los dos números
        int numA = sc.nextInt();
        int numB = sc.nextInt();

        StringBuilder sA = new StringBuilder();
        StringBuilder sB = new StringBuilder();

        while (numA!=0 && numB!=0) {
            int digitA = numA % 10;
            numA = numA/10;
            int digitB = numB % 10;
            numB = numB/10;

            if (digitA >= digitB) {
                sA.insert(0, digitA);
            }
            if (digitA <= digitB) {
                sB.insert(0,digitB);
            }
        }

        if (numA != 0) {
            sA.insert(0, numA);
        }

        if (numB !=0) {
            sB.insert(0, numB);
        }

        if (sA.toString().isEmpty()) {
            System.out.println("YODA");
        } else {
            System.out.println(Integer.parseInt(sA.toString()));
        }

        if (sB.toString().isEmpty()) {
            System.out.println("YODA");
        } else {
            System.out.println(Integer.parseInt(sB.toString()));
        }

    }
}
