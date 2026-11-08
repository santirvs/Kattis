package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

import java.util.Scanner;

public class DecodingTrump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String vocales = "AEIOU";
        String consonantes = "BCDFGHJKLMNPQRSTVWXYZ";

        String mensaje = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        for (int i=0;i<mensaje.length(); i++) {
            char caracter = mensaje.charAt(i);

            if (Character.isUpperCase(caracter)) {
                if (caracter == 'A' || caracter == 'E' || caracter == 'I' || caracter == 'O' || caracter == 'U' ) {
                    int pos = vocales.indexOf(caracter);
                    pos = (5 + pos - 2 ) % 5;
                    caracter = vocales.charAt(pos);
                } else {
                    int pos = consonantes.indexOf(caracter);
                    pos = (consonantes.length() + pos - 5) % consonantes.length();
                    caracter = consonantes.charAt(pos);
                }
            }
            sb.append(caracter);
        }

        System.out.println(sb.toString());


    }
}
