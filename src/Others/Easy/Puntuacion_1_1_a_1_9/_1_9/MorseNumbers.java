package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Mapear la duración de cada dígito
 * Contar lo que dura cada dígito teniendo en cuenta las separaciones
 */


import java.io.IOException;
import java.util.Scanner;


public class MorseNumbers {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[] duracionDigitos = { 19, 17, 15, 13, 11, 9, 11, 13, 15, 17};

        int cantidadNumeros = sc.nextInt();
        int duracion = 0;

        while (cantidadNumeros-- > 0) {
            String num = sc.next();

            for (int i=0; i<num.length(); i++) {
                char c = num.charAt(i);
                duracion+=duracionDigitos[c-'0'];
            }

            //3 unidades de separación entre cada dígito
            duracion += (num.length()-1) * 3;

            //hay siguiente número?
            if (cantidadNumeros>0) {
                duracion+=7;
            }
        }

        System.out.println(duracion);


        sc.close();
    }
}

