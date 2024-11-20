package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._7_BST_Equilibrado_Set;

import java.io.*;
import java.util.*;

// Crear una estructura BST que, además de guardar los números, acumule la cantidad de niveles que se han recorrido
// Caso de prueba #5: TLE - Cambio a fast input/output. Sigue el TLE

//          Cambio y uso un TreeMap para poder obtener el floor y el ceil de un número (un TreeMap es un BST)


public class BinarySearchTree {

    public static void main(String[] args) throws IOException {

        //Scanner scan = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


        TreeMap<Integer, Integer> bst = new TreeMap<>();
        Integer floor, ceil, profundidad;

        long totalNiveles = 0; //running total

        int numCasos = Integer.parseInt(in.readLine());

        for (int i = 0; i < numCasos; i++) {
            Integer newNode = Integer.parseInt(in.readLine());

            floor = bst.floorKey(newNode); //nodo padre si se inserta a la derecha
            ceil = bst.ceilingKey(newNode); //nodo padre si se inserta a la izquierda

            if (floor == null) {
                if (ceil == null)
                    profundidad = 0; //Arbol vacío
                else
                    profundidad = bst.get(ceil) + 1; //solo el techo tiene valor
            } else {
                if (ceil == null)
                    profundidad = bst.get(floor) + 1; //solo el suelo tiene valor
                else
                    profundidad = Math.max(bst.get(floor), bst.get(ceil)) + 1; // el mayor de los dos es donde se insertará
            }
            bst.put(newNode, profundidad); //guarda la nueva profundidad en el mapa

            totalNiveles += profundidad;
            System.out.println(totalNiveles);

        }
    }
}
