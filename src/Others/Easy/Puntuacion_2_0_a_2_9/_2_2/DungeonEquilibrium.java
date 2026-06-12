package Others.Easy.Puntuacion_2_0_a_2_9._2_2;

/**
 * v1 : Leer todos los monstruos y añadirlos en un diccionario de Int,Int
 *      donde nos apuntamos la cantidad de monstruos que hay de cada nivel
 *      Despues recorremos el diccionario en orden:
 *        si la cantidad es menor que el nivel --> eliminarlos todos
 *        si la cantidad es mayor que el nivel --> eliminar la diferencia
 *
 */

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DungeonEquilibrium {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        //Leer la lista de monstruos y contarlos su frecuencia en un HashMap
        int numMonstruos = sc.nextInt();
        HashMap<Integer, Integer> mapa = new HashMap<>();
        while (numMonstruos-- > 0) {
            int nivel = sc.nextInt();

            if (mapa.containsKey(nivel)) mapa.put(nivel, mapa.get(nivel) +1);
            else mapa.put(nivel,1);
        }

        //Recorrer el HashMap y contar los que se necesitan eliminar
        int eliminar = 0;
        for (Integer k : mapa.keySet()) {
            if (mapa.get(k) < k) eliminar+=mapa.get(k);
            if (mapa.get(k) > k) eliminar+=mapa.get(k)-k;
        }

        //Mostrar el resultado
        System.out.println(eliminar);
    }
}