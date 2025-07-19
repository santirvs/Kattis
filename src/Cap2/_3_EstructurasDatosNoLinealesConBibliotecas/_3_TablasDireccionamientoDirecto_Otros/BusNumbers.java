package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._3_TablasDireccionamientoDirecto_Otros;

// Crear un SortedSet de autobuses
// Leer los autobuses y añadirlos al SortedSet
// Mostrar el primer autobús libre y recorrer el SortedSet hasta que el siguiente no sea consecutivo
// Si se han encontrado menos de 3, no mostrar guion.
// Mostrar el último autobús encontrado
// Seguir hasta que la lista quede vacía



import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class BusNumbers {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        // Número de habitaciones y creación del array de habitaciones
        int numAutobuses = scan.nextInt();
        SortedSet<Integer> autobuses = new TreeSet<Integer>();

        // Leer los autobuses encontrados y añadirlos al SortedSet
        for (int i = 0; i < numAutobuses; i++) {
            autobuses.add(scan.nextInt());
        }

        //Recorrer el HashSet hasta que el siguiente no sea consecutivo
        boolean primero = true;
        while (!autobuses.isEmpty()) {
            if (!primero) {
                System.out.print(" ");
            } else {
                primero = false;
            }
            int primerAutobus = autobuses.iterator().next();
            int autobus = primerAutobus;
            autobuses.remove(autobus);
            while (autobuses.contains(autobus + 1)) {
                autobus++;
                autobuses.remove(autobus);
            }
            if (autobus - primerAutobus >= 2) {
                System.out.print(primerAutobus + "-" + autobus);
            } else if (autobus == primerAutobus) {
                System.out.print(primerAutobus);
            } else
                System.out.print(primerAutobus + " " + autobus);
        }


        scan.close();
    }
}