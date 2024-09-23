package Cap2._2_EstructurasDatosNoLinealesConBibliotecas._1_ColaDePrioridad;

// Usar una cola, una pila y una cola de prioridad
// Añadir los elementos segun llegan a las 3 estructuras
// Al extraer un elemento, ver cual de ellas coincide con el elemento extraído
// A medida que no coincidan, se eliminan la posibilidad de ser esa estructura


import java.io.*;
import java.util.*;

public class ICanGuessTheDataStructure {

    static long K;
    static long tiempo = 0;

    static class IntegerGreaterComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            //Lectura de los datos
            int N = scan.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new IntegerGreaterComparator());
            LinkedList<Integer> lista = new LinkedList<>();
            Stack<Integer> pila = new Stack<>();
            boolean esPila = true;
            boolean esCola = true;
            boolean esColaPrioridad = true;

            //Procesamiento
            for (int i = 0; i < N; i++) {
                int operacion = scan.nextInt();
                int valor = scan.nextInt();

                if (operacion == 1) {
                    pq.add(valor);
                    lista.add(valor);
                    pila.add(valor);
                } else {
                    if (pq.isEmpty() || pq.poll() != valor) {
                        esColaPrioridad = false;
                    }
                    if (lista.isEmpty() || lista.poll() != valor) {
                        esCola = false;
                    }
                    if (pila.isEmpty() || pila.pop() != valor) {
                        esPila = false;
                    }
                }
            }

            //Salida
            if (esColaPrioridad && !esCola && !esPila) {
                System.out.println("priority queue");
            } else if (esCola && !esColaPrioridad && !esPila) {
                System.out.println("queue");
            } else if (esPila && !esCola && !esColaPrioridad) {
                System.out.println("stack");
            } else if (!esCola && !esColaPrioridad && !esPila) {
                System.out.println("impossible");
            } else {
                System.out.println("not sure");
            }
        }


    }
}