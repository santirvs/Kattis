package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// Buscar la cantidad de árboles --> Buscar los conjuntos diferentes
// Basarnos en un UFDS

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FacultyForest {


    // Clase UnionFind para gestionar los conjuntos disjuntos
    // con un contador de elementos vacíos
    static class UnionFind {
        private int[] p, rank, setSize, setEmpty;
        private int numSets;

        public UnionFind(int N) {
            p = new int[N];
            rank = new int[N];
            setSize = new int[N];
            setEmpty = new int[N];
            numSets = N;
            for (int i = 0; i < N; ++i) {
                p[i] = i;
                setSize[i] = 1;
                setEmpty[i] = 1;
            }
        }

        public int findSet(int i) {
            if (p[i] == i) return i;
            return p[i] = findSet(p[i]);
        }

        public boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        public int numDisjointSets() {
            return numSets;
        }

        public void unionSet(int i, int j) {
            if (isSameSet(i, j)) return;
            int x = findSet(i), y = findSet(j);
            if (rank[x] > rank[y]) {
                int temp = x; x = y; y = temp;
            }
            p[x] = y;
            if (rank[x] == rank[y]) rank[y]++;
            setSize[y] += setSize[x];
            setEmpty[y] += setEmpty[x];
            numSets--;
        }

        // Resta un elemento vacío al conjunto al que pertenece el elemento i
        public void fillSet(int i) {
            setEmpty[findSet(i)]--;
        }
        // Devuelve el tamaño del conjunto al que pertenece el elemento i
        public int sizeOfSet(int i) {
            return setSize[findSet(i)];
        }
        // Devuelve el número de elementos vacíos del conjunto al que pertenece el elemento i
        public int numEmptyOfSet(int i) {
            return setEmpty[findSet(i)];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numProfesores = sc.nextInt();
        int numConexiones = sc.nextInt();

        UnionFind uf = new UnionFind(numProfesores);

        for (int i=0; i<numConexiones; i++) {
            int profeA = sc.nextInt();
            int profeB = sc.nextInt();

            uf.unionSet(profeA-1, profeB-1);
        }

        //Resultado
        System.out.println(uf.numSets);

    }
}
