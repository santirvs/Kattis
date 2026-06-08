package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// Ejercicio simple de combinatoria
// Todos los conjuntos posibles -> 2^n
// Los que no nos interesan:
//      - conjunto vacio: 1
//      - conjuntos de 1 elemento: n
// Resultado:  2^n - n -1

import java.util.Scanner;

public class CharacterDevelopment {

    public static int combinaciones(int num) {

        if (num<=1) return 0;
        else return (1<<(num)) - num -1 ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numEntrada = sc.nextInt();

        int solucion = combinaciones(numEntrada);

        System.out.println(solucion);

    }
}
