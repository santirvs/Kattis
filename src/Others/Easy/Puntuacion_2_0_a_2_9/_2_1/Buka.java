package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// Descartar el uso de longs y BigInteger (hasta 100 digitos!!!)
// Al ser potencias de 10, pueden sumarse y multiplicarse fácilment
// La suma es poner un 1 en la posición longitud_menor de la que tenga longitud menor
// La multiplicacion es añadir tantos 0s al primero como longitud-1 tenga el segundo

import java.util.Scanner;

public class Buka {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num1 = sc.nextLine();
        String operando = sc.nextLine();
        String num2 = sc.nextLine();

        int long_num1 = num1.length();
        int long_num2 = num2.length();

        if (operando.equals("+")) {
            if (long_num1==long_num2) {
                System.out.println("2" + num1.substring(1));
            } else {
                if (long_num1>long_num2) {
                    System.out.println(num1.substring(0, long_num1-long_num2) + num2);
                } else {
                    System.out.println(num2.substring(0, long_num2-long_num1) + num1);
                }
            }
        }
        else {
            System.out.println(num1 + num2.substring(1));
        }

    }
}
