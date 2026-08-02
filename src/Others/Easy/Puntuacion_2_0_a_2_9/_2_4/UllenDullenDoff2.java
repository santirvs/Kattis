package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

/**
 * La canción tiene 13 pasos.
 *  - Si hay 13 o más personas --> ponemos al no familiar en la posición 13
 *  - Si hay menos de 13 personas --> ponemos al no familiar en la posición 13 mod personas
 */

import java.util.Scanner;

public class UllenDullenDoff2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numPersonas = sc.nextInt();
        String personas[] = new String[numPersonas+1];

        //Leer las personas
        for (int i=1; i<=numPersonas; i++) {
            personas[i] = sc.next();
        }

        //Calcular la posición donde debe ir
        int posPersona1 = 1;
        if (numPersonas >= 13) {
            posPersona1 = 13;
        } else if (numPersonas > 1) {
            posPersona1 = 13 % numPersonas;
        }

        //Intercambiar las posiciones
        String aux = personas[1];
        personas[1] = personas[posPersona1];
        personas[posPersona1] = aux;

        //Imprimir las personas en orden
        for (int i=1; i<=numPersonas; i++) {
            System.out.println(personas[i]);
        }



    }

}