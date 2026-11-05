package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class EgElskaHann {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        if (line == null || line.trim().isEmpty()) {
            return;
        }

        int n = Integer.parseInt(line.trim());

        // Usamos LinkedList en lugar de ArrayList.
        // Las eliminaciones en LinkedList son O(1) si ya tenemos un iterador en esa posición.
        LinkedList<Integer> petals = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            petals.add(i);
        }

        // Usamos un ListIterator para recorrer la lista de manera eficiente y circular.
        ListIterator<Integer> iterator = petals.listIterator();

        while (petals.size() > 1) {
            // 1. "He loves me": El pétalo actual se conserva.
            if (!iterator.hasNext()) {
                iterator = petals.listIterator(); // Reiniciamos si llegamos al final (circular)
            }
            iterator.next(); // Avanzamos sobre el pétalo que se salva

            // 2. "He loves me not": El siguiente pétalo es el que se debe arrancar.
            if (!iterator.hasNext()) {
                iterator = petals.listIterator(); // Reiniciamos si llegamos al final
            }
            iterator.next(); // Nos posicionamos en el pétalo a eliminar

            // Removemos el elemento actual de forma eficiente sin desplazar bloques de memoria
            iterator.remove();
        }

        // Imprimimos el único pétalo que sobrevivió.
        System.out.println(petals.getFirst());
    }
}