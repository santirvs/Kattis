package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

// Contar las veces que aparece un cada número
// Esa frecuencia nos indica el número de niños que pertenecen al mismo grupo de buenos amigos
// y que deberán ir en diferentes grupos de juego
// De cada grupo de amigos podremos colocar como máximo la cantidad de grupos de juego

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Keppni {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Leer los datos
        int numNinos = sc.nextInt();
        int maxGrupos = sc.nextInt();

        //Mapa de frecuencias
        HashMap<Integer, Integer> mf = new HashMap<>();
        for (int i=0; i<numNinos; i++) {
            int grupo = sc.nextInt();
            if (mf.containsKey(grupo)) mf.put(grupo, mf.get(grupo) + 1);
            else mf.put(grupo,1);
        }

        //Repasar el contador de frecuencias para contar los elementos que podemos
        // incluir en un grupo de juegos
        int contador = 0;
        for (int v : mf.values()) {
            contador += Math.min (v, maxGrupos);
        }

        //Mostrar el resultado
        System.out.println(contador);
    }

}