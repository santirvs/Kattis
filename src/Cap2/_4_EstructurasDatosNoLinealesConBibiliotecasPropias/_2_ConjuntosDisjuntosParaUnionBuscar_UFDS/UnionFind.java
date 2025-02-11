package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._2_ConjuntosDisjuntosParaUnionBuscar_UFDS;

import java.io.*;


// Caso de prueba #3 -> TLE  --> Cambio a BufferedReader
//    --> Sigue dando TLE, cambio a Reader y sigue dando TLE
//    --> Cambio implementacion de UnionFind de ArrayList<Integer> a int[]
//    --> Sigue dando TLE, cambio salida a BufferedWriter
//    --> Sigue dando TLE, cambio a otra implementación de UnionFind que sí da AC (UnionFind2)
//    --> Sigue dando TLE, cambio el reader a InputReader
//    --> Adapto e integro desde AC y modifico hasta conseguir TLE
//    --> Es la comparación de Strings en el bucle? Cambiar a char!!!  --> TLE
//    --> Es el parseo de las líneas con split? Efectivamente!!!  --> AC!
//    --> Cambio a Reader en lugar de BufferedReader  --> AC
//    --> Cambio a System.out en lugar de PrintWriter  --> TLE!

class UnionFind {


    static class Reader {
        final private int BUFFER_SIZE = 1 << 20;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }


 // Union-Find Disjoint Sets Library written in OOP manner, using both path compression and union by rank heuristics
    static class UnionFind_DS {                                              // OOP style
        private int[] p, rank, setSize;
        private int numSets;

        public UnionFind_DS(int N) {

            //Declarar e inicializar los vectores p, rank y setSize
            p = new int[N];
            rank = new int[N];
            setSize = new int[N];
            numSets = N;
            for (int i = 0; i < N; i++) {
                p[i] = i;
                rank[i] = 0;
                setSize[i] = 1;
            }
        }

        public int findSet(int i) {
            if (p[i] == i) return i;
            else {
                int ret = findSet(p[i]);
                p[i] = ret;
                return ret;
            }
        }

        public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

        public void unionSet(int i, int j) {
            if (!isSameSet(i, j)) {
                numSets--;
                int x = findSet(i);
                int y = findSet(j);
                // rank is used to keep the tree short
                if (rank[x] > rank[y]) { p[y]= x; setSize[x] = setSize[x] + setSize[y]; }
                else {
                    p[x] = y; setSize[y] = setSize[y] + setSize[x];
                    if (rank[x] == rank[y]) rank[y]=rank[y] + 1;
                }
            }
        }
        public int numDisjointSets() { return numSets; }
        public int sizeOfSet(int i) { return setSize[findSet(i)]; }
    }

    //Otra implementación de UnionFind, con éste no da TLE
    static class UnionFind2 {

        /**
         * Stores parent of corresponding element
         */
        private int[] parents;
        /**
         * Stores  size of sub tree, where corresponding element is the root
         */
        private int[] treeSizes;

        //Inicializa el array de padres y el tamaño de cada árbol
        public UnionFind2(int elements) {
            parents = new int[elements];
            treeSizes = new int[elements];
            for (int i = 0; i < elements; i++) {
                parents[i] = i;
                treeSizes[i] = 1;
            }
        }

        /**
         * Mezcla los dos sbconjuntos
         */
        public void unionSet(int elementA, int elementB) {
            int rootA = find(elementA);
            int rootB = find(elementB);
            if (rootA == rootB)
                return;

            if (treeSizes[rootA] < treeSizes[rootB]) {
                subdue(rootA, rootB);
            } else {
                subdue(rootB, rootA);
            }
        }

        private void subdue(int slave, int master) {
            parents[slave] = master;
            treeSizes[master] += treeSizes[slave];
        }

        /**
         * Finds group of given element and shortens the path while searching.
         */
        public int findWithReindex(int element) {
            if (element == parents[element]) {
                return element;
            } else {
                int root = find(parents[element]);
                parents[element] = root;
                return root;
            }
        }

        /**
         * Finds group of the given element.
         */
        public int find(int element) {
            int root = element;
            while (root != parents[root]) {
                // traverse upward
                root = parents[root];
            }
            return root;
        }

        public boolean isSameSet(int elementA, int elementB) {
            return find(elementA) == find(elementB);
        }
    }

/*
    public static void main_demo(String[] args) {
        System.out.printf("Assume that there are 5 disjoint sets initially\n");
        UnionFind_DS UF = new UnionFind_DS(5); // create 5 disjoint sets
        System.out.printf("%d\n", UF.numDisjointSets()); // 5
        UF.unionSet(0, 1);
        System.out.printf("%d\n", UF.numDisjointSets()); // 4
        UF.unionSet(2, 3);
        System.out.printf("%d\n", UF.numDisjointSets()); // 3
        UF.unionSet(4, 3);
        System.out.printf("%d\n", UF.numDisjointSets()); // 2
        System.out.printf("isSameSet(0, 3) = %b\n", UF.isSameSet(0, 3)); // will return false
        System.out.printf("isSameSet(4, 3) = %b\n", UF.isSameSet(4, 3)); // will return true
        for (int i = 0; i < 5; i++) // findSet will return 1 for {0, 1} and 3 for {2, 3, 4}
            System.out.printf("findSet(%d) = %d, sizeOfSet(%d) = %d\n", i, UF.findSet(i), i, UF.sizeOfSet(i));
        UF.unionSet(0, 3);
        System.out.printf("%d\n", UF.numDisjointSets()); // 1
        for (int i = 0; i < 5; i++) // findSet will return 3 for {0, 1, 2, 3, 4}
            System.out.printf("findSet(%d) = %d, sizeOfSet(%d) = %d\n", i, UF.findSet(i), i, UF.sizeOfSet(i));
    }
*/
    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader scan = new BufferedReader(new InputStreamReader(System.in), 1024 * 1024);
        Reader scan = new Reader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        //Leer los datos
        String linea[] = scan.readLine().split(" ");
        int numElementos = Integer.parseInt(linea[0]);
        int numOperaciones = Integer.parseInt(linea[1]);

        //Crear el UFDS
        UnionFind_DS uf = new UnionFind_DS(numElementos);

        while (numOperaciones-- > 0) {
            String line = scan.readLine();
            char operator = line.charAt(0);
            int pos = line.lastIndexOf(' ');
            int set1 = Integer.parseInt(line.substring(2, pos));
            int set2 = Integer.parseInt(line.substring(pos + 1, line.length()));

            if (operator == '?') {
                //Query
                if (uf.isSameSet(set1,set2))
                    out.println("yes");
                else
                    out.println("no");
            }
            else {
                //Join
                uf.unionSet(set1, set2);
            }

        }
        out.flush();
        out.close();
    }

}