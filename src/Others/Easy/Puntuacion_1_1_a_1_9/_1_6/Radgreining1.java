package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * v1 : Leer el tamaño de la secuencia y el número de tramos
 *      Definir un array del tamaño de la secuencia inicializado a ?
 *      Para cada tramo:
 *          - Leer el tramo
 *          - Para cada caracter del tramo
 *              - Ver si su posición en la secuencia es ? o coindice con el caracter
 *                  -> Sí: reemplazar el caracter de la secuencia
 *                  -> No: error
 *      Al final del proceso:
 *          -> Hay error: Imprimir "Villa"
 *          -> No hay error: Imprimir la secuencia
 */


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class Radgreining1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer los datos
        int longitudSecuencia = sc.nextInt();
        int numFragmentos = sc.nextInt();

        //Declarar e inicializar la secuencia
        char[] secuencia = new char[longitudSecuencia];
        for (int i=0; i<longitudSecuencia; i++) {
            secuencia[i] = '?';
        }

        //Leer los fragmentos
        boolean error = false;
        while (numFragmentos-- > 0) {
            int posicion = sc.nextInt()-1;
            String fragmento = sc.nextLine().trim();

            for (int i=0; i<fragmento.length(); i++) {
                char valor = fragmento.charAt(i);
                if (secuencia[posicion+i] != '?' && secuencia[posicion+i]!=valor) {
                    error = true;
                } else {
                    secuencia[posicion+i] = valor;
                }
            }
        }

        if (error) {
            System.out.println("Villa");
        } else {
            System.out.println(secuencia);
        }


        sc.close();
    }
}

