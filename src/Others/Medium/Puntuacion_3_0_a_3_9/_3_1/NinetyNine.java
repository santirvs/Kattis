package Others.Medium.Puntuacion_3_0_a_3_9._3_1;

/*
    En este juego la estrategia es conseguir decir un número que sea múltiplo de 3,
    de esta forma alcanzaremos a decir el 99
    Como empezamos nosotros, tenemos las de perder, así que no importa el número (diremos siempre +1)
      --> pero hay un conjunto de pruebas donde el oponente siempre dice 2, con lo que nos condenamos a perder!
      --> así que responderemos siempre lo mismo que el contrario.
      --> pero hay un conjunto de pruebas que espera que hagamos esto, así que lo haremos aleatorio
    Eso sí, si el contrario no dice un múltiplo de 3, entonces nosotros pasaremos a decir el siguiente múltiplo de 3
    para consolidarnos en la posición ganadora
 */

import java.util.Random;
import java.util.Scanner;

public class NinetyNine {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("1");
        boolean salir = false;
        Random aleatorio = new Random();
        while (!salir) {
            int num = scan.nextInt();
            if (num==99) salir = true;
            else if (num%3 == 0) {
                //Seguimos en status perdedor, respondemos algo aleatorio
                System.out.println(num + aleatorio.nextInt(2) + 1);
            }
            else {
                //Podemos alcanzar una posición ganadora!
                //Debemos mostrar lo que falte para conseguir llegar al múltiplo de 3
                //y así consolidar la posición ganadora.
                int numMio = num + (3 - num%3);
                System.out.println(numMio);
                if (numMio == 99) salir = true;
            }
        }

        scan.close();
    }
}