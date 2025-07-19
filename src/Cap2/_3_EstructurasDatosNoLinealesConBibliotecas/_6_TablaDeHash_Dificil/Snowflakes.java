package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._6_TablaDeHash_Dificil;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Leer los números y guardarlos en un HashSet
// Si el número ya está en el HashSet, reset y volver a empezar
// Si el número no está en el HashSet, añadirlo
// Cada vez que se hace un reset, revisar el tamaño del set antes de resetearlo
// Quedarse con el tamaño del set más grande

// Caso de prueba #3: WA --> Contemplar el caso 1,2,3,1,4  --> Debe devolver 4, no 3
//                           Hay que guardarse en una cola los números que se han ido añadiendo
//                           Cada vez que se añade un número, se añade a la cola
//                           Si el número ya está en el HashSet, se sacan números de la cola
//                           hasta que se saca el número repetido
//                           Sigue el WA  :-(
//                           Se me olvidó sacar el número repetido del HashSet


public class Snowflakes {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt();

        while (numCasos > 0) {

            int cantNumeros = scan.nextInt();

            HashSet<Integer> numeros = new HashSet<Integer>();
            Queue<Integer> cola = new LinkedList<Integer>();
            int maxCapacidad = 0;

            while (cantNumeros > 0) {

                int num = scan.nextInt();
                if (numeros.contains(num)) {
                    while (cola.peek() != num) {
                        numeros.remove(cola.poll());
                    }
                    numeros.remove(cola.poll());  // Sacar también el número repetido
                }
                numeros.add(num);
                cola.add(num);
                maxCapacidad = Math.max(maxCapacidad, numeros.size());

                cantNumeros--;
            }

            System.out.println(maxCapacidad);

            numCasos--;
        }
    }

}

