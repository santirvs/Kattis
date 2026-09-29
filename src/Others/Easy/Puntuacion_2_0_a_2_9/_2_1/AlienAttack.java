package Others.Easy.Puntuacion_2_0_a_2_9._2_1;

// Aplicar un Union Find
// Buscar el grupo más numeroso

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class AlienAttack {

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

    static class FR_Int {
        private InputStream in = System.in;
        private byte[] buffer = new byte[1 << 16];
        private int head = 0;
        private int tail = 0;

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = in.read(buffer, 0, buffer.length);
                if (tail <= 0) return -1;   // Fin de archivo
            }
            return buffer[head++];
        }

        public int nextInt() throws IOException {
            int c = read();
            // Ignorar espacios en blanco o saltos de línea (ASCII <= 32)
            while (c != -1 && c <= 32) {
                c = read();
            }

            if (c == -1) return -1; // EOF
            boolean negativo = false;
            if (c == '-') {
                negativo = true;
                c = read();
            }
            int res = 0;
            // Construir el número mientras el carácter sea visible (> 32)
            while (c > 32) {
                res = res * 10 + (c - '0');
                c = read();
            }
            return negativo ? -res : res;
        }
    }

    public static void main(String[] args) throws IOException {

        //Usar FastReader (más de 10.000 entradas)
        FR_Int sc = new FR_Int();

        //Leer las dimensiones del problema
        int numPersonas = sc.nextInt();
        int numAmistades = sc.nextInt();

        //Declarar la estructura UnionFind para gestionar los grupos de amigos
        UnionFind uf = new UnionFind(numPersonas+1);

        //Leer las amistades y unirlas
        while (numAmistades-- > 0) {
            int amigo1 = sc.nextInt();
            int amigo2 = sc.nextInt();
            uf.unionSet(amigo1, amigo2);
        }

        //Buscar el grupo con mayor número de amigos
        int maxAmigos = 0;
        for (int i=1; i<=numPersonas; i++) {
            maxAmigos = Math.max(maxAmigos, uf.sizeOfSet(i));
        }

        //Mostrar el resultado
        System.out.println(maxAmigos);
    }
}
