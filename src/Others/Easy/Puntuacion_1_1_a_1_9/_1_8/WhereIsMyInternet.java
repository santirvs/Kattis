package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

import java.io.IOException;
import java.io.InputStream;

/**
 * La casa 1 está conectada a Internet
 * Aplicar un UnionFind conectando casas
 * Finalizar listando todas las casas que no estén en el grupo de la casa 1
 *
 * Puede haber hasta 200.000 entradas ---> Usar FastScanner
 *
 */




public class WhereIsMyInternet {

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
        FR_Int sc = new FR_Int();

        int numCasas = sc.nextInt();
        UnionFind uf = new UnionFind(numCasas+1);

        int numCables = sc.nextInt();
        while (numCables-- > 0) {
            int inicio = sc.nextInt();
            int fin = sc.nextInt();

            uf.unionSet(inicio, fin);
        }

        //La casa 1 tiene internet, ¿en qué grupo está?
        int grupoSi = uf.findSet(1);

        //Recorrer los grupos. Mostrar todos aquellos que no estén en el grupo del Si
        for (int i=2; i<=numCasas; i++) {
            if (uf.findSet(i) != grupoSi) {
                System.out.println(i);
            }
        }
        //Si solo tengo un grupo (y el del 0), están todos conectados
        if (uf.numSets == 2) {
            System.out.println("Connected");
        }


    }

}