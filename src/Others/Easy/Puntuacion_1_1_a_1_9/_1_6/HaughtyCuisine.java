package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Modo simple: memorizar el primer menú y recomendarlo siempre
 * Incluso se podría hacer sin memorizar: leer y escribir inmediatamente
 */

import java.io.IOException;
import java.util.Scanner;


public class HaughtyCuisine {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();  //Ignoro el número de menús

        //Memorizar el primer menú
        int numPlatos = sc.nextInt();
        String[] platos = new String[numPlatos];
        for (int i=0; i<numPlatos; i++) {
            platos[i] = sc.next();
        }

        //Ignorar el resto de menús

        //Imprimir el menú memorizado
        System.out.println(numPlatos);
        for (int i=0; i<numPlatos;i++) {
            System.out.println(platos[i]);
        }

        sc.close();
    }
}

