package Others.Easy.Puntuacion_2_0_a_2_9._2_5;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FakeboolUnionFind {

    // Union-Find (Disjoint Set Union) con seguimiento del ID mínimo (cuenta más antigua)
    static class UnionFind {
        private int[] p, rank, minId;
        private int numSets;

        public UnionFind(int N) {  // Los elementos se numeran de 0 a N-1
            p = new int[N];
            rank = new int[N];
            minId = new int[N];
            numSets = N;
            for (int i = 0; i < N; ++i) {
                p[i] = i;
                minId[i] = i; // Inicialmente el ID mínimo de cada conjunto es sí mismo
            }
        }

        public int findSet(int i) {
            if (p[i] == i) return i;
            else return p[i] = findSet(p[i]);
        }

        public boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        public void unionSet(int i, int j) {
            int x = findSet(i), y = findSet(j);
            if (x == y) return;

            // Unimos por rango
            if (rank[x] > rank[y]) {
                int temp = x; x = y; y = temp;
            }
            p[x] = y;
            if (rank[x] == rank[y]) rank[y]++;

            // Actualizamos el ID mínimo del conjunto resultante
            minId[y] = Math.min(minId[x], minId[y]);

            numSets--;
        }

        // Devuelve el ID más antiguo (menor) del conjunto al que pertenece el elemento i
        public int getMinId(int i) {
            return minId[findSet(i)];
        }
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 20;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[256]; // Ampliado para evitar desbordamientos en líneas largas
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
    }

    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();

        String firstLine = sc.readLine();
        if (firstLine == null || firstLine.isEmpty()) return;
        String[] parts = firstLine.split(" ");
        int numItems = Integer.parseInt(parts[0]);
        int numQueries = Integer.parseInt(parts[1]);

        UnionFind uf = new UnionFind(numItems);

        StringBuilder sb = new StringBuilder(); // Para optimizar la salida por consola

        while (numQueries-- > 0) {
            String line = sc.readLine();
            if (line == null || line.isEmpty()) continue;
            String[] instruccion = line.split(" ");

            if (instruccion[0].equals("LEGAL")) {
                int id = Integer.parseInt(instruccion[1]);
                sb.append(uf.getMinId(id)).append("\n");
            } else {
                int itemOriginal = Integer.parseInt(instruccion[1]);
                int itemRepetido = Integer.parseInt(instruccion[2]);
                uf.unionSet(itemOriginal, itemRepetido);
            }
        }
        System.out.print(sb);
    }
}