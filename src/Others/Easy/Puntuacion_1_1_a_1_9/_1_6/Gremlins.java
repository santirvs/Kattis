package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Usar un diccionario para guardarnos la posicion original pos -> nombre
 * y un segundo diccionario para guardarnos la posicion actual nombre -> pos
 * La lectura del primer diccionario y segundo diccionario es trivial
 * Para resolver, hay que recorrer las posiciones del primer diccionario y acceder al segundo,
 * verificando que existan
 */

import java.io.IOException;
import java.util.*;


public class Gremlins {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numOriginal = sc.nextInt();
        int numActual = sc.nextInt();


        //Lectura de las posiciones originales
        HashMap<Integer, String> dicOriginal = new HashMap<Integer, String>();
        for(int pos=1; pos<=numOriginal; pos++) {
            String item = sc.next();
            dicOriginal.put(pos, item);
        }

        //Lectura de las posiciones actuales
        HashMap<String,Integer> dicActual= new HashMap<String,Integer>();
        for(int pos=1; pos<=numActual; pos++) {
            String item = sc.next();
            dicActual.put(item,pos);
        }

        //Mostrar la solución
        for (int pos=1; pos<=numOriginal; pos++) {
            String item = dicOriginal.get(pos);
            Integer posActual = dicActual.get(item);
            if (posActual == null) {
                System.out.println("stolen!");
            } else {
                System.out.println(posActual);
            }
        }

        sc.close();
    }
}

