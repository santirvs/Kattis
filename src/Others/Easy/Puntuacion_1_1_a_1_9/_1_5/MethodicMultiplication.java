package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer ambos números
// Contar la cantidad de S que tiene
// Multiplicarlas
// Escribir el resultado

import java.util.Scanner;

public class MethodicMultiplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Leer el primer número
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();

        //Contar la cantidad de S en cada número
        //Cada S conlleva su correspondiente par de paréntesis
        //-1 para quitar el 0 que es el número inicial
        int num1S = (num1.length()-1)/3;
        int num2S = (num2.length()-1)/3;

        //Calcular el resultado y escribirlo
        int resultado = num1S * num2S;

        for (int i=0; i<resultado;i++) {
            System.out.print("S(");
        }
        System.out.print("0");
        for (int i=0; i<resultado;i++) {
            System.out.print(")");
        }

        sc.close();
    }
}

