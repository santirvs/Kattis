package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Por el hecho de fusionar, nunca van a quedar dos cartas repetidas
 * Guardar en un array de 0 a 11 las cartas existentes
 * Añadir n*3 a la posición 0
 * Comenzar la fusión:
 * añadir a la posición n+1 la cantidad/2 de la posicion n
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class MergingItems {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numItems = sc.nextInt();
        int[] items = new int[11];

        //Leer las cartas iniciales
        for (int i=0; i<numItems; i++) {
            items[sc.nextInt()]++;
        }

        //Leer el número de veces que se piden 3 items de nivel 0
        int numPeticiones = sc.nextInt();
        items[0] += numPeticiones*3;


        //Empezar la fusion
        for (int i=0; i<=9; i++) {
            items[i+1] += items[i]/2;
            items[i] = items[i]%2;
        }

        //Mostrar los resultados
        boolean primero = true;
        for (int i=0; i<=10; i++) {
            if (items[i]==1) {
                if (primero) primero = false;
                else System.out.print(" ");
                System.out.print(i);
            }
        }
        System.out.println();
    }
}

