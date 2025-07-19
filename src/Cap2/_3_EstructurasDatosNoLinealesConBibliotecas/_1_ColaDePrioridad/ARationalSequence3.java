package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._1_ColaDePrioridad;

// No veo como usar la cola con prioridad aquí tampoco, y es el mismo problema
// que el RationalSequence2, pero te dan la N y debes calcular la fracción
// La construcción del árbol es igual para cualquier p y q
// Pero la numeración de los nodos sigue el sistema binario
// Si el numero es mayor que 1, se ha llegado por la derecha
// Si el número es menor que 1, se ha llegado por la izquierda
//El enfoque del RationalSequence2 es este
// Si el número que buscamos lo hacemos ascender por el árbol hasta llegar a 1
// y nos apuntamos si ascendemos hacia la izquierda (1) o hacia la derecha (0)
// iremos construyendo el índice n. Al llegar a la raíz añadimos un 1
// Pero aquí, en lugar de construir el índice, lo que hacemos es construir la fracción
// El número que nos den lo pasamos a binario y lo recorremos de izquierda a derecha
// El primero siempre será un 1, lo ignoramos
// A continuación, si es un 0  (p/q --> (p+q)/q)
// Si es un 1,  (p/q --> p/(p+q))

import java.util.Scanner;

public class ARationalSequence3 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int numCasos = scan.nextInt();

        while (numCasos > 0) {
            int numCaso = scan.nextInt();
            String numero = Integer.toBinaryString(scan.nextInt());
            int numerador = 1;
            int denominador = 1;

            int index = 1;
            while (index < numero.length()) {
                if (numero.charAt(index) == '1') {
                    numerador += denominador;
                }
                else {
                    denominador += numerador;
                }
                index++;
            }

            System.out.println("" + numCaso + " " + numerador + "/" + denominador);

            numCasos--;
        }

    }
}