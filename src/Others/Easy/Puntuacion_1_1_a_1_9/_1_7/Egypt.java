package Others.Easy.Puntuacion_1_1_a_1_9._1_7;

/**
 * Leer los lados del triangulo y aplicar el teorema de Pitágoras
 * No usar SQRT sino jugar con los cuadrados
 * Será necesario buscar el lado más largo de los 3 para determinar la hipotenusa
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class Egypt {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer los datos
        int lado1= sc.nextInt();
        int lado2= sc.nextInt();
        int lado3= sc.nextInt();

        while (lado1!=0 || lado2!=0 || lado3!=0) {

            int hipo = Math.max(lado1, Math.max(lado2, lado3));
            int cateto1, cateto2;
            if (hipo == lado1) {
                cateto1 = lado2;
                cateto2 = lado3;
            } else if (hipo == lado2) {
                cateto1= lado1;
                cateto2= lado3;
            } else {
                cateto1= lado1;
                cateto2= lado2;
            }

            //Verificar el teorema de Pitágoras
            if (hipo*hipo == cateto1*cateto1 + cateto2*cateto2) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }

            //Leer siguiente caso
            lado1= sc.nextInt();
            lado2= sc.nextInt();
            lado3= sc.nextInt();
        }

    }
}

