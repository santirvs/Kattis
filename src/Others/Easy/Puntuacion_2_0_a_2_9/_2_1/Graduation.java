package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// Aplicar un Union Find
// Todos los miembros de la misma columna deben ir con el mismo color

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Graduation {

    // Union-Find (Disjoint Set Union) Extended version (con elementos vacíos)
    static class UnionFind {
        private int[ ] p, rank, setSize, setEmpty;
        private int numSets;

        public UnionFind(int N) {  //Los elementos se numeran de 0 a N-1
            p = new int[N];
            rank = new int[N];
            setSize = new int[N];
            setEmpty = new int[N];
            numSets = N;
            for (int i = 0; i < N; ++i) {
                p[i] = i;
                setSize[i] = 1;
                setEmpty[i] = 1;         }    }

        // findSet devuelve el “representante del conjunto” (entre 0 y N-1), no se hace una numeración propia de los conjuntos!
        public int findSet(int i) {  if (p[i] == i) return i; else  return p[i] = findSet(p[i]);    }

        public boolean isSameSet(int i, int j) {  return findSet(i) == findSet(j);   }

        public int numDisjointSets() {  return numSets;  }

        public void unionSet(int i, int j) {
            if (isSameSet(i, j)) return;
            int x = findSet(i), y = findSet(j);
            if (rank[x] > rank[y]) {  int temp = x; x = y; y = temp;    }
            p[x] = y;
            if (rank[x] == rank[y]) rank[y]++;
            setSize[y] += setSize[x];
            setEmpty[y] += setEmpty[x];
            numSets--;    }

        // Resta un elemento vacío al conjunto al que pertenece el elemento i
        public void fillSet(int i) {  setEmpty[findSet(i)]--;  }

        // Devuelve el tamaño del conjunto al que pertenece el elemento i
        public int sizeOfSet(int i) {   return setSize[findSet(i)];    }

        // Devuelve el número de elementos vacíos del conjunto al que pertenece el elemento i
        public int numEmptyOfSet(int i) {   return setEmpty[findSet(i)];   }      }

    public static void main(String[] args) throws IOException {

        //Usar FastReader
        Scanner sc = new Scanner(System.in);

        //Leer las dimensiones del problema
        int numFilas = sc.nextInt();
        int numColumnas = sc.nextInt();
        int numClases = sc.nextInt();


        //Declarar la estructura UnionFind para gestionar los grupos de amigos
        UnionFind uf = new UnionFind(numClases);

        //Leer la matriz
        char[][] matriz = new char[numFilas][numColumnas];
        for (int fila = 0; fila < numFilas; fila++) {
            String sFila = sc.next();
            matriz[fila] = sFila.toCharArray();
        }


        //Recorrer las columnas
        for (int columna=0; columna<numColumnas; columna++) {
            //Tomar como referencia el primer elemento
            int primero = matriz[0][columna] - 'A';
            for (int fila = 1; fila < numFilas; fila ++) {
                int elemento = matriz[fila][columna] - 'A';
                if (primero != elemento) {
                    uf.unionSet(primero, elemento);
                }
            }
        }

        //La cantidad de conjuntos en el UnionFind es la cantidad de colores diferentes que podemos usar
        System.out.println(uf.numSets);
    }
}
