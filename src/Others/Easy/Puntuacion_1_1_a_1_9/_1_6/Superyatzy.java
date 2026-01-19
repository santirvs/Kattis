package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * v1 : Leer la cantidad de dados y la cantidad de trampas que podemos hacer
 *      Leer el valor de cada dado y guardarlo en una tabla de frecuencias
 *      Al final, podremos poner todos los dados iguales si la suma de los dados
 *      que no tienen el valor más frecuente es menor o igual a la cantidad
 *      de trampas que podemos hacer.
 */


import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;


public class Superyatzy {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //leer dados y trampas
        int numDados = sc.nextInt();
        int numTrampas = sc.nextInt();
        int[] frecuencias = new int[7];  // O=dummy, 1-6

        //Leer los dados
        for (int i=0; i<numDados;i++) {
            int valorDado = sc.nextInt();
            frecuencias[valorDado]++;
        }

        //Buscar la puntuación más frecuente
        int maximo = 0;
        for (int i=1; i<=6;i++) {
            if (frecuencias[i]>maximo) {
                maximo = frecuencias[i];
            }
        }

        //Puedo hacer suficientes trampas para cambiar todos los dados
        //a la frecuencia maxima?
        int numTrampasNecesarias = numDados - maximo;
        if (numTrampasNecesarias <= numTrampas) {
            System.out.println("Ja");
        } else {
            System.out.println("Nej");
        }


        sc.close();
    }
}

