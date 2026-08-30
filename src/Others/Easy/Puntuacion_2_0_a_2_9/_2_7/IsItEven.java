package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

/*
    Contar cuantas veces se puede dividir entre dos cada uno de los números
    Si el conteo es igual o superior a K, imprimir 1
    sino imprimir 0

 */

import java.io.IOException;
import java.util.Scanner;

public class IsItEven {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numeros = sc.nextInt();
        int k = sc.nextInt();

        int contador = 0;
        for (int num=0; num<numeros; num++) {
            int valor = sc.nextInt();
            while (valor >0 && valor%2==0) {
                contador++;
                valor = valor / 2;
            }
        }

        if (contador >= k) System.out.println(1);
        else System.out.println(0);

    }
}