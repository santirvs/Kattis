package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._7_BST_Equilibrado_Set;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

// Leer los ficheros y los índices
// y guardarlos en dos TreeMaps diferentes  String -> String (nombre completo)

// TestCase #2: WA - Falta ordenar las salidas
// TestCase #2: WA - El nombre del fichero puede contener "_" y no se está teniendo en cuenta
//                   Eliminar los "_" desde el final  -> AC!

public class OrphanBackups {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        TreeMap<String,Boolean> indices = new TreeMap<>();
        ArrayList<String> ficherosHuerfanos = new ArrayList<>();

        //Leer los índices
        String indice = scan.nextLine();
        while (scan.hasNext() && !indice.equals("")) {
            indices.put(indice, false);     //Inicialmente no tiene fichero
            indice = scan.nextLine();       //Ignorar líneas en blanco
        }

        //Leer los ficheros
        while (scan.hasNext()) {
            String linea = scan.nextLine();
            if (linea.equals("")) break;    //Fin de los ficheros (entrada interactiva)

            String index = linea;
            for (int j = 0; j < 2; j++) {
                int lastUnderscore = index.lastIndexOf('_');
                if (lastUnderscore != -1) {
                    index = index.substring(0, lastUnderscore);
                }
            }

            if (indices.containsKey(index)) {
                indices.put(index, true);   //Marca que SÍ tiene fichero
            } else {
                ficherosHuerfanos.add(linea);  //Añade a la lista de huerfanos
            }
        }

        //Mostrar los ficheros huerfanos
        Collections.sort(ficherosHuerfanos);
        boolean noMismatches = true;
        for (String fichero: ficherosHuerfanos) {
            System.out.println("F " + fichero);
            noMismatches = false;
        }

        //Mostrar los índices sin fichero
        for (String index: indices.keySet()) {
            if (!indices.get(index)) {
                System.out.println("I " + index);
                noMismatches = false;
            }
        }

        //Si no hay ficheros huerfanos ni índices sin fichero
        if (noMismatches) {
            System.out.println("No mismatches.");
        }
    }
}