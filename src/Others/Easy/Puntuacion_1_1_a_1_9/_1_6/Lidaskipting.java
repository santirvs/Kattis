package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * v1 : Esto es tan simple como ver si el numero de la entrada es múltiplo de 3 o no
 *      El problema viene en que el numerito de la entrada puede tener hasta 100 dígitos
 *      y eso o se usa un BigInteger o no habrá forma de meterlo en ningun tipo de dato.
 *      Long (hasta 10^18)
 *      Double (hasta 10^308, pero con pérdida de precisión)
 *      Pero trabajar con BigInteger es muy lento y el límite es 1 seg!!!
 *      Pero sabemos que los múltiplos de 3 tienen una particularidad y es que sus dígitos suman un múltiplo de 3
 *      Así que sumaremos los dígitos y calcularemos el módulo 3
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class Lidaskipting {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer los datos
        String numero = sc.nextLine();

        int sumaDigitos = 0;
        for (int i=0; i<numero.length();i++) {
            sumaDigitos += numero.charAt(i)-'0';
        }

        if (sumaDigitos % 3 == 0)
            System.out.println("Jebb");
        else
            System.out.println("Neibb");

        sc.close();
    }
}

