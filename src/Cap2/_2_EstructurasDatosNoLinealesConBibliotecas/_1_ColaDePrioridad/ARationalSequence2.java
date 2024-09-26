package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._1_ColaDePrioridad;

// No veo como usar la cola con prioridad...
// La construcción del árbol es igual para cualquier p y q
// Pero la numeración de los nodos sigue el sistema binario
// Si el numero es mayor que 1, se ha llegado por la derecha
// Si el número es menor que 1, se ha llegado por la izquierda
// Si el número que buscamos lo hacemos ascender por el árbol hasta llegar a 1
// y nos apuntamos si ascendemos hacia la izquierda (1) o hacia la derecha (0)
// iremos construyendo el índice n. Al llegar a la raíz añadimos un 1

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ARationalSequence2 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt();

        while (numCasos > 0) {
            int numCaso = scan.nextInt();
            String[] numero  = scan.nextLine().split("/");
            int numerador = Integer.parseInt(numero[0].trim());
            int denominador = Integer.parseInt(numero[1].trim());

            int index = 0;
            int resultado = 0;

            while (numerador!=denominador) {
                if (numerador > denominador) {
                    resultado = resultado | 1 << index;
                    numerador -= denominador;
                }
                else {
                    denominador -= numerador;
                }
                index++;
            }
            resultado = resultado | 1 << index;

            System.out.println("" + numCaso + " " + resultado);

            numCasos--;
        }

    }
}