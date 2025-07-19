package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._7_BST_Equilibrado_Set;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// Leer todas las palabras en una lista
// Hacer todas las parejas de palabras
// Añadirlas a un TreeSet (Tree -> ordenado, Set -> elimina repetidos)
// Imprimir el contenido del TreeSet

public class CompoundWords {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        Set<String> combinaciones = new TreeSet<String>();
        ArrayList<String> palabras = new ArrayList<String>();

        //Leer palabras
        while ( scan.hasNext() ) {
            String palabra = scan.next();
            if (palabra.equals("0")) break;  //Test local
            palabras.add(palabra);
        }

        //Combinar palabras
        for (int i = 0; i < palabras.size(); i++) {
            for (int j = 0; j < palabras.size(); j++) {
                if (i!=j) {
                    combinaciones.add(palabras.get(i) + palabras.get(j));
                }
            }
        }

        //Mostrar palabras
        for (String palabra: combinaciones) {
            System.out.println(palabra);
        }

    }
}
