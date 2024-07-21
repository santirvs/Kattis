package Others;

import java.util.Scanner;

public class AlienNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numCaso = 1;
        int numCasos = scan.nextInt();

        while (numCasos > 0) {
            String numero = scan.next();
            String alfabeto1 = scan.next();
            String alfabeto2 = scan.next();

            int base1 = alfabeto1.length();
            int base2 = alfabeto2.length();

            int decimal = 0;
            for (int i = 0; i < numero.length(); i++) {
                decimal = decimal * base1 + alfabeto1.indexOf(numero.charAt(i));
            }

            StringBuilder sb = new StringBuilder();
            while (decimal > 0) {
                sb.insert(0, alfabeto2.charAt(decimal % base2));
                decimal /= base2;
            }

            numero = sb.toString();
            if (numero.isEmpty()) {
                numero = alfabeto2.charAt(0) + "";
            }

            System.out.println("Case #" + numCaso + ": " + numero);
            numCaso++;
            numCasos--;
        }

    }
}