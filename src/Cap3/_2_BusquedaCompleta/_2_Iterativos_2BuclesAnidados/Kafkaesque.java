package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;

// Leer los números de secretarios necesarios y apuntarlos en una lista ordenada de las firmas necesarias
// Recorrer la fila de secretarios y comprobar si la firma del secretario es la que se necesita (la primera de la lista)
// Mientras queden firmas pendientes ir dando vueltas a la fila de secretarios
// El tiempo estimado es de O(n^2) en el peor de los casos, pero n <= 100 por lo que no debe ser un problema

// v1 -> AC
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Kafkaesque {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numFirmas = scan.nextInt(); // Número de firmas necesarias
        List<Integer> firmas = new ArrayList<>();
        for (int i = 0; i < numFirmas; i++) {
            firmas.add(scan.nextInt()); // Leer las firmas necesarias
        }

        //Recorrer la fila de secretarios
        int numRecorridos = 0; // Contador de veces que se recorre la fila
        while (!firmas.isEmpty()) {
            numRecorridos ++; // Incrementar el contador de recorridos
            //Recorrer la lista de firmas necesarias
            for (int i = 1; i <=100; i++) {
                // Si la firma del secretario es la que se necesita, se elimina de la lista
                if (!firmas.isEmpty() && firmas.get(0) == i) {
                    firmas.remove(0); // Eliminar la firma de la lista
                }
            }
        }

        // Imprimir el número de veces que se ha recorrido la fila
        System.out.println(numRecorridos);


    }
}