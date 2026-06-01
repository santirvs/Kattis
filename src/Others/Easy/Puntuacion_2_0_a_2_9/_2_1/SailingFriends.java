package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// Aplicar el union-find para saber cuantos conjuntos disjuntos existen
// Recorrer la lista de propietarios y marcar su conjunto como que ya tiene barco
// Recorrer la lista de conjuntos y contar los que no tienen barco

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SailingFriends {

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


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int habitantes = sc.nextInt();
        int barcos = sc.nextInt();
        int parejas = sc.nextInt();

        UnionFind uf = new UnionFind(habitantes);

        //listaBarcos
        int[] listaBarcos = new int[barcos];
        for (int i=0; i<barcos;i++) {
            listaBarcos[i] = sc.nextInt();
        }

        //Recorrer las parejas
        for (int i=0; i<parejas; i++) {
            int h1 = sc.nextInt();
            int h2 = sc.nextInt();
            uf.unionSet(h1-1,h2-1);
        }

        //Recorrer los propietarios y marcar el conjunto como que ya tiene barco
        // No se usa el uf.numDisjointSets ya que cada conjunto se identifica por su representante
        boolean[] tieneBarco = new boolean[habitantes];
        for (int propietario : listaBarcos) {
            tieneBarco[uf.findSet(propietario - 1)] = true;
        }

        //Finalmente, contar los conjuntos que no tienen barco
        int numBarcosNecesarios = 0;
        for (int i = 0; i < habitantes; i++) {
            if (uf.findSet(i) == i) { // Validamos que 'i' sea el nodo raíz/líder de un conjunto
                if (!tieneBarco[i]) {
                    numBarcosNecesarios++;
                }
            }
        }

        System.out.println(numBarcosNecesarios);

    }
}
