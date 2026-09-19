package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

import java.util.HashMap;
import java.util.Scanner;

public class KittenOnATree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       HashMap<Integer, Integer> arbol = new HashMap<>();

       int posGato = sc.nextInt();

       //Cargar la estructura de ramas del árbol
       int ramaFin = sc.nextInt();
       while (ramaFin!=-1) {
           String[] ramas = sc.nextLine().trim().split(" ");
           for (int i=0; i<ramas.length; i++) {
               arbol.put(Integer.parseInt(ramas[i]), ramaFin);
           }
           ramaFin = sc.nextInt();
       }

       //Buscar la rama de descenso del gato
       System.out.print(posGato);
       while (arbol.containsKey(posGato)) {
           posGato = arbol.get(posGato);
           System.out.print(" " + posGato);
       }
        System.out.println();

    }
}
