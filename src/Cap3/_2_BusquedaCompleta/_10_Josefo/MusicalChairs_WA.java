package Cap3._2_BusquedaCompleta._10_Josefo;

// Problema de Josefo, pero con una variante: el salto es variable

// v1.  WA en Caso #4


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicalChairs_WA {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        // Leer el número de miembros
        int numMiembros = scan.nextInt();
        // Leer el salto de cada miembro y crear la lista de miembros
        List<Integer> saltos = new ArrayList<>();
        List<Integer> miembros = new ArrayList<>();
        for (int i = 0; i < numMiembros; i++) {
            saltos.add(scan.nextInt());
            miembros.add(i + 1); // Guardamos los miembros como números del 1 al numMiembros
        }
        int indice = 0; // Índice del miembro actual
        int salto = saltos.get(indice);
        int ultimoMiembro = -1;
        while (miembros.size() > 0) {
            // Calcular el índice basado en la longitud de la frase
            indice = (indice + salto - 1) % miembros.size(); // Seleccionamos el índice basado en la longitud de la frase
            ultimoMiembro = miembros.get(indice); // Guardamos el último miembro eliminado
            miembros.remove(indice); // Eliminar el nombre seleccionado y su salto correspondiente
            salto = saltos.get(indice);
            saltos.remove(indice);
        }

        // Imprimir el último miembro eliminado
        System.out.println(ultimoMiembro);
    }


}
