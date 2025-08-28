package Cap3._3_DivideYVenceras._3_BusquedaTernariaYOtros;

// Estrategia de D&C. Búsqueda ternaria y otros
/*
Para tener 2.2 puntos de dificultad...  vaya tela!

Observación 1:
    Solo importa el valor relativo de los elementos, así que para facilitar después la comparación de igualdad
    de los árboles, reemplazamos cada elemento por su rango, donde el elemento más pequeño es rango 0.
    Esto se hace usando un array auxiliar ordenado.

Observación 2:
    La manera para representar el árbol es como un vector de pares<int,int>, children[tree],
    donde children[tree][node] = (hijo_izquierdo, hijo_derecho).
    Para insertar, empezamos desde la raíz y revisamos sus hijos, hasta llegar a un nodo donde podamos
    insertar el nuevo valor.

    Cuando comparamos BSTs, simplemente usamos "=" para comparar el contenido de children[i] y children[j]
    para comparar los árboles i y j.

Tiempo: O(n * k^2 + n^2)
Memoria: O(nk)

*/

import java.io.*;
import java.util.*;

public class CeilingFunction {

    static int numTechos, numCapas;
    static int[] capas = new int[21];
    static int[] capasOrdenadas = new int[21];
    static List<List<int[]>> children = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        // Lectura del número de techos y capas
        numTechos = scan.nextInt();
        numCapas = scan.nextInt();

        // Procesar cada techo
        for (int techo = 0; techo < numTechos; techo++) { // "ceiling"
            // Primero parseamos la entrada y hacemos que los valores sean distintos pero en [0, k-1]
            for (int capa = 0; capa < numCapas; capa++) {
                capas[capa] = scan.nextInt();
                capasOrdenadas[capa] = capas[capa];
            }
            Arrays.sort(capasOrdenadas, 0, numCapas); // ordenar

            for (int capa = 0; capa < numCapas; capa++) {
                capas[capa] = Arrays.binarySearch(capasOrdenadas, 0, numCapas, capas[capa]);
            }

            // Creamos un vector vacío temporal que se usará para expandir children
            List<int[]> temp = new ArrayList<>();
            for (int capa = 0; capa < numCapas; capa++) {
                temp.add(new int[]{-1, -1}); // cada nodo tiene (izq, der)
            }
            children.add(temp);

            int root = capas[0]; // el primer elemento es la raíz
            int curNode;
            for (int capa = 1; capa < numCapas; capa++) { // para cada elemento restante
                curNode = root;
                while (true) { // insertar en el BST
                    if (capas[capa] < curNode) {
                        if (children.get(techo).get(curNode)[0] == -1) {
                            // subárbol izquierdo vacío, podemos colocar aquí
                            children.get(techo).get(curNode)[0] = capas[capa];
                            break;
                        } else {
                            curNode = children.get(techo).get(curNode)[0];
                        }
                    } else { // arr[capa] > curNode ya que los valores son únicos
                        if (children.get(techo).get(curNode)[1] == -1) {
                            // subárbol derecho vacío, colocamos aquí
                            children.get(techo).get(curNode)[1] = capas[capa];
                            break;
                        } else {
                            curNode = children.get(techo).get(curNode)[1];
                        }
                    }
                }
            }
        }

        // Contar cuántos árboles son únicos
        int uniqueCount = 0;
        boolean unique;
        for (int techo = 0; techo < numTechos; techo++) {
            unique = true;
            for (int j = 0; j < techo; j++) {
                if (treesEqual(children.get(techo), children.get(j))) {
                    // no es único respecto a alguno anterior
                    unique = false;
                    break;
                }
            }
            if (unique) uniqueCount++;
        }

        //Mostrar el número de árboles únicos
        System.out.println(uniqueCount);
    }

    // Comparar dos árboles BST representados como listas de pares (izq, der)
    static boolean treesEqual(List<int[]> t1, List<int[]> t2) {
        if (t1.size() != t2.size()) return false;
        for (int i = 0; i < t1.size(); i++) {
            if (t1.get(i)[0] != t2.get(i)[0] || t1.get(i)[1] != t2.get(i)[1]) {
                return false;
            }
        }
        return true;
    }

}
