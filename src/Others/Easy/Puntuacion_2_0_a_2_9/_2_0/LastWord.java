package Others.Easy.Puntuacion_2_0_a_2_9._2_0;


import java.util.Scanner;
import java.util.Stack;

public class LastWord {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        String entrada = sc.nextLine();

        int inicio = 0;
        int fin = entrada.length()-1;

        int numOperaciones = sc.nextInt();

        while (numOperaciones-- > 0) {
            int iniPalabra = sc.nextInt();
            int finPalabra = sc.nextInt();

            inicio += iniPalabra;
            fin = inicio + finPalabra;

        }

        System.out.println(entrada.substring(inicio, fin));

    }
}