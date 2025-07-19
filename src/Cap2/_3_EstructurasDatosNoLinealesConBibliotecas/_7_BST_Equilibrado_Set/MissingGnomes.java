package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._7_BST_Equilibrado_Set;

import java.io.IOException;
import java.util.*;


// Caso 9: TLE
//  Cambio la lista de gnomosFaltantes de ArrayList a TreeSet  --> AC!
//

public class MissingGnomes {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> gnomosPresentes = new ArrayList<Integer>();
        TreeSet<Integer> gnomosFaltantes = new TreeSet<Integer>();

        int totalGnomos = scan.nextInt();
        int gnomos = scan.nextInt();

        //De entrada faltan todos los gnomos
        for (int i = 1; i <= totalGnomos; i++) {
            gnomosFaltantes.add(i);
        }

        //Leer los gnomos presentes, apuntarlos en la lista de presentes
        //y quitarlos de la lista de faltantes
        for (int i = 1; i <= gnomos; i++) {
            int gnomo = scan.nextInt();
            gnomosPresentes.add(gnomo);
            gnomosFaltantes.remove(gnomo);
        }

        //Mostrar los gnomos en orden
        //Añadir un gnomo ficticio a cada lista para evitar problemas de índices
        gnomosPresentes.add(totalGnomos+1);
        gnomosFaltantes.add(totalGnomos+1);
        for (int i = 0; i < totalGnomos; i++) {
            int gnomoPresente = gnomosPresentes.get(0);
            int gnomoFaltante = gnomosFaltantes.first();

            if (gnomoPresente < gnomoFaltante) {
                System.out.println(gnomoPresente);
                gnomosPresentes.remove(0);
            } else {
                System.out.println(gnomoFaltante);
                gnomosFaltantes.remove(gnomoFaltante);
            }

        }

    }
}