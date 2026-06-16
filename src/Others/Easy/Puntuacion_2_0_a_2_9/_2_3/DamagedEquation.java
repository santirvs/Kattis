package Others.Easy.Puntuacion_2_0_a_2_9._2_3;


/*
    Probar todas las combinaciones de operadores.
    sólo hay 16 combinaciones, así que no es un grave problema
    Deben generarse en orden  *, +, - y /
 */

import java.io.IOException;
import java.util.Scanner;

public class DamagedEquation {

    public static String operador(int num) {
        if (num == 0) return " * ";
        if (num == 1) return " + ";
        if (num == 2) return " - ";
        return (" / ");
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        boolean encontrado = false;

        for (int i=0; i<4;i++) {
            int izquierda = 0;
            if (i==0) izquierda = a * b;
            else if (i==1) izquierda = a + b;
            else if (i==2) izquierda = a - b;
            else if (i==3 && b!=0) izquierda = a / b;
            else continue;
            for (int j=0; j<4; j++) {
                int derecha = 0;
                if (j==0) derecha = c * d;
                else if (j==1) derecha = c + d;
                else if (j==2) derecha = c - d;
                else if (j==3 && d!=0) derecha = c / d;
                else continue;

                if (derecha == izquierda) {
                    System.out.println(a + operador(i) + b + " = " + c + operador(j) + d );
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("problems ahead");
        }


    }
}

