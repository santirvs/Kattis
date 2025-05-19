package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._2_ConjuntosDisjuntosParaUnionBuscar_UFDS;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

// Apliación directa de un UFDS para gestionar los grupos

public class Tildes {


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


    // Clase UnionFind para gestionar los grupos
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

    public static void main(String[] args) throws IOException {
        //Lectura de datos
        //Scanner sc = new Scanner(System.in);
        Reader sc = new Reader();
        int numPersonas = sc.nextInt();
        int numPreguntas = sc.nextInt();
        //Definición del UFDS, según el número de cajones
        UnionFind UF = new UnionFind(numPersonas);

        //Lectura de los diferentes preguntas
        for (int item = 0; item < numPreguntas; item++) {

            String pregunta[] = sc.readLine().split(" ");
            //Grupos que se juntan
            if (pregunta[0].equals("t")) {
                //Unir los dos grupos
                int a = Integer.parseInt(pregunta[1]) - 1;
                int b = Integer.parseInt(pregunta[2]) - 1;
                UF.unionSet(a, b);
            } else if (pregunta[0].equals("s")) {
                //Mostrar el tamaño del grupo al que pertenece el elemento
                int a = Integer.parseInt(pregunta[1]) - 1;
                int setOfA = UF.findSet(a);
                int sizeOfSetA = UF.sizeOfSet(setOfA);
                System.out.println(sizeOfSetA);
            }

        }
        sc.close();
    }
}
