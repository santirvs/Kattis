package Others.Trivial.Puntuacion_1_1_a_1_5._1_4;

// Leer dos números y restar el segundo del primero

import java.util.Scanner;

public class ReadySetGo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer los dos números
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        //Mostrar la resta
        System.out.println(num1-num2);

        sc.close();
    }
}

