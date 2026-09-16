package Others.Trivial.Puntuacion_1_1_a_1_5._1_5;

// Leer la frase y decodificar: si encuentro una vocal, saltar dos posiciones

import java.util.Scanner;


public class Kemija {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String frase = sc.nextLine();

        for (int i=0; i<frase.length(); i++) {

            System.out.print(frase.charAt(i));

            char c = Character.toUpperCase(frase.charAt(i));
            if (c=='A' || c == 'E' || c=='I' || c=='O' || c=='U') {
                i+=2;
            }
        }
        System.out.println();


        sc.close();
    }
}

