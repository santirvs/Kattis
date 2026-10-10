package Others.Easy.Puntuacion_2_0_a_2_9._2_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;

public class BagDeposit {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // Leer el número total de bultos N
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        int n = Integer.parseInt(line.trim());

        // Lista para mantener el valor de la cima de cada pila activa.
        // Usaremos búsqueda binaria para actualizar eficientemente las cimas en O(log K).
        ArrayList<Integer> pileTops = new ArrayList<Integer>();

        // Procesar cada bulto en el orden cronológico en el que llegan
        for (int i = 0; i < n; i++) {
            while (st == null || !st.hasMoreTokens()) {
                String l = br.readLine();
                if (l == null) break;
                st = new StringTokenizer(l);
            }
            if (!st.hasMoreTokens()) break;

            String bagId = st.nextToken(); // ID único de 4 dígitos del bulto (no afecta a la lógica de pilas)
            int collectionOrder = Integer.parseInt(st.nextToken()); // Orden en el que será recogido

            // Aplicamos la estrategia de Patience Sorting para encontrar la pila adecuada:
            // Buscamos la primera cima de pila que sea mayor o igual al orden de recogida actual.
            int insertionIndex = Collections.binarySearch(pileTops, collectionOrder);

            // Collections.binarySearch devuelve (-(punto de inserción) - 1) si el elemento no se encuentra exacto.
            if (insertionIndex < 0) {
                insertionIndex = -(insertionIndex + 1);
            }

            // Si encontramos una pila existente cuya cima puede recibir este bulto,
            // actualizamos la cima de esa pila con el nuevo valor.
            if (insertionIndex < pileTops.size()) {
                pileTops.set(insertionIndex, collectionOrder);
            } else {
                // Si ninguna pila existente es apta, abrimos una nueva pila añadiendo la cima al final.
                pileTops.add(collectionOrder);
            }
        }

        // El número total de pilas activas al finalizar el proceso es el tamaño de pileTops
        System.out.println(pileTops.size());
    }
}