package Others.Trivial.Puntuacion_1_1_a_1_5._1_2;

// Leer el número y compararlo con 1984

import java.util.Scanner;

public class Literally1984 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer los datos
        int valor = sc.nextInt();

        if (valor == 1984) System.out.println("Literally 1984");
        else System.out.println("Not 1984... yet");
    }
}