package Others.Easy.Puntuacion_1_1_a_1_9._1_4;

// Leer la cadena
// Separarlo por d
// Si sólo hay un valor, es que hay una única tirada
// Si hay más de un valor, el primero es el número de tiradas
// Separar por +
// Si hay un valor, es el número de caras del dado
// Si hay dos valores, tengo número de caras y suma final
// Calcular el promedio de la tirada

import java.util.Arrays;
import java.util.Scanner;

public class RollingTheDice {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer la cadena
        String str =  sc.nextLine();

        // Separarla por "d"
        String[] sep1 = str.split("d");

        int numLanzamientos = 1;
        String strNumCarasDado;
        int numCarasDado = 0;
        int numAnyadirFinal = 0;

        // Hay una o dos cadenas?
        if (sep1.length == 2) {
            numLanzamientos = Integer.parseInt(sep1[0]);
            strNumCarasDado = sep1[1];
        } else {
            numLanzamientos = 1;
            strNumCarasDado = sep1[0];
        }

        // Hay sumatorio final
        String[] sep2 = strNumCarasDado.split("\\+");
        numCarasDado = Integer.parseInt(sep2[0]);
        if (sep2.length == 2) {
            numAnyadirFinal = Integer.parseInt(sep2[1]);
        }

        //Calcular el resultado
        double result = (numCarasDado+1)/2.0*numLanzamientos +  numAnyadirFinal;

        System.out.println(result);

        sc.close();
    }
}

