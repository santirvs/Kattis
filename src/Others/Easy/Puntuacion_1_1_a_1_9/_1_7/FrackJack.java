package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;


public class FrackJack {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int throwAlice = sc.nextInt();
        int throwBertil = sc.nextInt();

        if (throwAlice > 21 && throwBertil > 21 || throwAlice == throwBertil) System.out.println("Jack");
        else if (throwAlice <= 21 && throwBertil > 21) System.out.println("Alice");
        else if (throwAlice > 21 && throwBertil <= 21) System.out.println("Bertil");
        else if (throwAlice > throwBertil) System.out.println("Alice");
        else System.out.println("Bertil");


    }
}

