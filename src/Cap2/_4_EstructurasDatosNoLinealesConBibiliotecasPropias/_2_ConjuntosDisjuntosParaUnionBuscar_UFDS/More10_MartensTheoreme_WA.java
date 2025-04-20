package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._2_ConjuntosDisjuntosParaUnionBuscar_UFDS;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

// Idea interesante: transformar un UFDS de Strings usando un índice dentro de una lista de palabras
// El UFDS se inicializa con 2*numLineas, ya que es el máximo número de palabras que pueden aparecer en el peor de los casos
// Adaptado desde https://github.com/RussellDash332/kattis/blob/main/src/M%C3%A5rten's%20Theorem/more10.py

// v1.0 - TLE en caso #11 usar FastReader
// v2.0 - Cambio TLE por WA !!!  Envío el código en Python y funciona correctamente
// Falta por revisar internamente el código (transformado a Java desde ChatGPT)


public class More10_MartensTheoreme_WA {

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

    //Implementación de un UFDS básico
        static class UFDS {
            int[] p, rank;

            public UFDS(int N) {
                p = new int[N];
                rank = new int[N];
                for (int i = 0; i < N; i++) p[i] = i;
            }

            int findSet(int i) {
                if (p[i] == i) return i;
                return p[i] = findSet(p[i]);
            }

            boolean isSameSet(int i, int j) {
                return findSet(i) == findSet(j);
            }

            void union(int i, int j) {
                if (!isSameSet(i, j)) {
                    int x = findSet(i), y = findSet(j);
                    if (rank[x] > rank[y]) {
                        p[y] = x;
                    } else {
                        p[x] = y;
                        if (rank[x] == rank[y]) rank[y]++;
                    }
                }
            }
        }

        //TrieNode para almacenar los sufijos de las palabras
        // https://www.geeksforgeeks.org/trie-insert-and-search/
        static class TrieNode {
            Map<Character, TrieNode> hijos = new HashMap<>();
            Integer index = null;
        }

        public static void main(String[] args) throws IOException {
            //Scanner scanner = new Scanner(System.in);
            Reader scanner = new Reader();

            //Número de líneas de la entrada
            int numLineasEntrada = Integer.parseInt(scanner.readLine());
            //Crear el UFDS - máximo 2*n palabras
            UFDS ufds = new UFDS(2 * numLineasEntrada);

            //Lista de palabras que se van a comprobar
            List<Integer> check = new ArrayList<>();
            //Mapa para almacenar las palabras y su índice
            Map<String, Integer> mapaPalabras = new HashMap<>();
            TrieNode root = new TrieNode();

            int contadorPalabras = 0;
            int numInstrucciones = 0;

            //Leer cada una de las instrucciones hasta llegar a numLineasEntrada
            while (numInstrucciones < numLineasEntrada) {
                numInstrucciones++;

                //Leer la línea de entrada y la separa en 3 partes
                String line = scanner.readLine();
                String[] parts = line.trim().split(" ");
                String palabra1 = parts[0], comando = parts[1], palabra2 = parts[2];

                if (!mapaPalabras.containsKey(palabra1)) mapaPalabras.put(palabra1, contadorPalabras++);
                if (!mapaPalabras.containsKey(palabra2)) mapaPalabras.put(palabra2, contadorPalabras++);

                for (String palabra : new String[]{palabra1, palabra2}) {
                    int indicePalabra = mapaPalabras.get(palabra);
                    TrieNode ptr = root;
                    // Obtiene el final de la palabra (reverse)
                    String sufijo = new StringBuilder(palabra).reverse().toString();
                    for (int i = 0; i < Math.min(3, sufijo.length()); i++) {
                        char c = sufijo.charAt(i);
                        ptr.hijos.putIfAbsent(c, new TrieNode());
                        ptr = ptr.hijos.get(c);
                        if (ptr.index != null) {
                            ufds.union(ptr.index, indicePalabra);
                        }
                    }
                    if (ptr.index == null) {
                        ptr.index = indicePalabra;
                    }

                    // Unir el índice de la palabra con los hijos y nietos
                    for (TrieNode child : ptr.hijos.values()) {
                        if (child.index != null) {
                            ufds.union(indicePalabra, child.index);
                        }
                        for (TrieNode grandchild : child.hijos.values()) {
                            if (grandchild.index != null) {
                                ufds.union(indicePalabra, grandchild.index);
                            }
                        }
                    }
                }

                //Comprobar si la instrucción es de unión o de comprobación
                if (comando.equals("is")) {
                    ufds.union(mapaPalabras.get(palabra1), mapaPalabras.get(palabra2));
                } else {
                    // Los que no son, se añaden a la lista de comprobación, pero con un offset fuera de rango
                    check.add(mapaPalabras.get(palabra1) * 2 * numLineasEntrada + mapaPalabras.get(palabra2));
                }
            }

            //Comprobar si hay algún par de palabras que estén unidas y que no lo deberían estar
            for (int h : check) {
                int a = h / (2 * numLineasEntrada);
                int b = h % (2 * numLineasEntrada);
                if (ufds.isSameSet(a, b)) {
                    System.out.println("wait what?");
                    return;
                }
            }

            System.out.println("yes");
        }
    }
