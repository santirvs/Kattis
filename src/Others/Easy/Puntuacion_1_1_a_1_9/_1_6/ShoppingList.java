package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Intersección de conjuntos
 * Crear una lista nueva sólo con los elementos comunes
 */

import java.util.*;

public class ShoppingList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<String> lista = new TreeSet();

        int numListas = sc.nextInt();
        int numItems = sc.nextInt();

        //Leer la primera lista
        for (int i=0; i<numItems;i++) {
            lista.add(sc.next());
        }

        //Leer el resto de listas.
        //Si un producto ya existe, pasa a la nueva lista
        for (int i=1;i<numListas;i++) {
            List<String> nuevaLista = new ArrayList();
            for (int j=0; j<numItems; j++) {
                String item = sc.next();
                if (lista.contains(item)) {
                    nuevaLista.add(item);
                }
            }
            lista.clear();
            lista.addAll(nuevaLista);
        }

        //Imprimir la lista
        System.out.println(lista.size());
        for (String i : lista) {
            System.out.println(i);
        }



    }
}