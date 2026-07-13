package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Usar un DSU para realizar grupos de amigos
 */


import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class Vinir {

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
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //String
        int numPersonas = sc.nextInt();
        int numConsultas = sc.nextInt();

        //Inicializar DSU
        UnionFind uf = new UnionFind(numPersonas+1); //La persona 0 es un fantasma

        //Procesar las consultas
        for (int q=0; q<numConsultas; q++) {
            int tipoConsulta = sc.nextInt();

            if (tipoConsulta == 1) {
                //Hacer amigos
                int persona1 = sc.nextInt();
                int persona2 = sc.nextInt();

                uf.unionSet(persona1, persona2);
            } else {
                //Consulta de cantidad de amigos
                int persona = sc.nextInt();

                int numAmigos = uf.sizeOfSet(persona) - 1;  // -1 porque yo no soy amigo de mí mismo

                System.out.println(numAmigos);
            }

        }



        sc.close();
    }
}

