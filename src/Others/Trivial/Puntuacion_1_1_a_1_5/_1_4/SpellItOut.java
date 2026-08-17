package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

// Si el número se encuentra entre 0 y 19 --> directo
// sino: escribir la decena, guion, unidad

import java.util.Scanner;

public class SpellItOut {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] numeros = { "zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen" };
        String[] decenas = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        int num = sc.nextInt();

        if (num <= 19) {
            System.out.println(numeros[num]);
            }
        else {
            int unidad = num % 10;
            int decena = num / 10;

            System.out.print(decenas[decena]);
            if (unidad != 0) {
                System.out.print("-" + numeros[unidad]);
            }
            System.out.println();
        }

        sc.close();
    }
}

