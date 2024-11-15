package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._7_BST_Equilibrado_Set;

import java.io.*;
import java.util.*;

// Crear una estructura BST que, además de guardar los números, acumule la cantidad de niveles que se han recorrido
// Caso de prueba #5: TLE - Cambio a fast input/output. Sigue el TLE

// Cambio de estrategia:
// 1.- Crear un Set que me permita saber si un número ya ha sido insertado
// 2.- Crear un array de int que me permita saber cuántos niveles se han recorrido para insertar un número
// 3.- Añadir el número al Set y calcular el coste de insertarlo en el BST: coste del anterior o posterior +1
//     Hay que recordar que un Set siempre está ordenado
// 4.- Imprimir el coste de insertar el número


public class BinarySearchTree {

     public static void main(String[] args) throws IOException {

        //Scanner scan = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int numValores = Integer.parseInt(in.readLine())-1;

        HashSet<Integer> seen = new HashSet<>();
        int[] dist = new int[numValores+2];

        long total = 0;

        for (int i = 0; i < numValores; i++) {
            int t = Integer.parseInt(in.readLine());
            seen.add(t);
            seen.iterator()
            int cost = 0;
            if(seen.lower(t) != null) {
                cost = Math.max(dist[seen.lower(t)], cost);
            }
            if(seen.higher(t) != null) {
                cost = Math.max(dist[seen.higher(t)], cost);
            }
            total += cost;
            dist[t] = cost+1;
            out.println(total);
        }

        BST arbol = new BST(Integer.parseInt(in.readLine()));
        int totalNiveles = 0;
        out.println(totalNiveles);

        while (numValores > 0) {
            totalNiveles += arbol.insert(Integer.parseInt(in.readLine()));
            out.println(totalNiveles);

            numValores--;
        }

        out.flush();
        out.close();

    }

}

/*

import java.io.*;
import java.util.*;

public class BST {
  public static void main(String[] args) throws IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  TreeMap<Integer, Integer> depths = new TreeMap<>();



        Integer floor, ceil, depth;
        long totalDepth = 0; //running total

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Integer newNode = Integer.parseInt(br.readLine());

            floor = depths.floorKey(newNode); //parent node if inserted on the right
            ceil = depths.ceilingKey(newNode); //parent node if inserted on the left

            if (floor == null) {
                if (ceil == null)
                    depth = 0; //Empty tree

                else
                    depth = depths.get(ceil) + 1; //only ceil has a value
            }

            else if (ceil == null)
                depth = depths.get(floor) + 1; //only floor has a value

            else
                depth = Math.max(depths.get(floor), depths.get(ceil)) + 1; //the one with the larger depth is where it will be inserted

            depths.put(newNode, depth); //store new nodes depth in the map
            totalDepth += depth;
            System.out.println(totalDepth);
        }
  }
}

*/