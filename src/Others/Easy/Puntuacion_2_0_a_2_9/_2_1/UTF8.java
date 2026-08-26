package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

/**
 * Seguir las reglas del enunciado para determinar si es o no es un UTF8 valido
 */

import java.util.Scanner;

public class UTF8 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int numBytes = sc.nextInt();

        boolean valido = true;
        int[] tipos = new int[4];

        while (numBytes > 0 && valido) {
            numBytes--;
            String valor = sc.next();

            if (valor.charAt(0) == '0') {
                // Es type 1
                tipos[0]++;
            } else if (valor.substring(0, 3).equals("110")) {
                //Podria ser type2
                valido = comprobarType(2);
                tipos[1]++;
                numBytes--;
            } else if (valor.substring(0, 4).equals("1110")) {
                //Podria ser type3
                valido = comprobarType(3);
                tipos[2]++;
                numBytes-=2;
            } else if (valor.substring(0, 5).equals("11110")) {
                //Podria ser type4
                valido = comprobarType(4);
                tipos[3]++;
                numBytes-=3;
            } else
                valido = false;
        }

        if (valido) {
            for (int i=0; i<4; i++) {
                System.out.println(tipos[i]);
            }
        } else {
            System.out.println("invalid");
        }

    }

    private static boolean comprobarType(int numBytes) {
        boolean valido = true;

        for (int i=1; i<numBytes && valido; i++) {
            valido = sc.hasNext();
            if (valido) {
                String valor = sc.next();
                valido = valor.substring(0, 2).equals("10");
            }
        }
        return valido;
    }
}
