package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

/**
 * Mutiplicar por 60 el acumulado
 * Leer número, sumar al acumulado
 * Hasta que se acaben los números
 *
 * Leer la línea completa y separar por ","
 * Recorrer el array
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BabylonianNumbers {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();
        sc.nextLine();

        while (numCasos-- > 0) {
            String lin = sc.nextLine() + ",1";   // le añadimos un dígito extra para que el split funcione como esperamos
            String[] linea = lin.split(",");

            long resultado = 0;
            for (int i=0; i<linea.length-1;i++) {
                resultado *=60;
                if (linea[i].length()!=0) {
                    int num = Integer.parseInt(linea[i]);
                    resultado += num;
                }
            }

            System.out.println(resultado);
        }


    }
}

