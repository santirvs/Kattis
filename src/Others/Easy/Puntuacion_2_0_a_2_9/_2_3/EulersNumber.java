package Others.Easy.Puntuacion_2_0_a_2_9._2_3;


/*
    Atención al factorial de un número muy grande!
    El error debe ser menor de 10^-12, por lo que podemos dejar de calcular el inverso del factorial
    cuando éste alcance por ejemplo 10^15


 */

import java.util.Scanner;

public class EulersNumber {

    public static long factorial(int i) {
        if (i==0 || i==1) return 1;
        else return (i * factorial(i-1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean noMoreFactorial = false;

        int num = sc.nextInt();
        double resultado = 0;
        for (int i=0; i<=num && !noMoreFactorial; i++) {
            long f = factorial(i);
            double inverso = 1.0/f;
            if (inverso < 0.0000000000000001) {
                noMoreFactorial = true;
            }
            else {
                resultado += inverso;
            }
        }

        System.out.println(resultado);



        }
    }

