package Others.Easy.Puntuacion_1_1_a_1_9._1_8;

/**
 * Nos piden una estación donde encontrarse, pero no la óptima!
 * Leemos todas las conexiones y las guardamos en un map <Integer, List<Integer>>
 * Añadimos a un Set todas las estaciones accesibles desde cada una de las estaciones de salida
 * Buscamos alguna estación en los dos conjuntos
 *
 * Entrada muy elevada --> Usar FastReader
 */


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class HappyHookup {

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
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


    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();

        //Leer los datos
        int numEstaciones = sc.nextInt();
        int numConexiones = sc.nextInt();

        //Leer las conexiones
        HashMap<Integer, List<Integer>> mapa = new HashMap<>();
        for (int i=0; i<numConexiones; i++) {
            int origen = sc.nextInt();
            int destino = sc.nextInt();
            if (mapa.containsKey(origen))
                mapa.get(origen).add(destino);
            else {
                ArrayList<Integer> a = new ArrayList<>();
                a.add(destino);
                mapa.put(origen,a);
            }
        }

        //Leer la estación de origen de cada uno
        Set<Integer> setA = new HashSet<>();
        LinkedList<Integer> listaA = new LinkedList<>();
        int a = sc.nextInt();
        listaA.add(a);
        setA.add(a);
        while (!listaA.isEmpty()) {
            int estacion = listaA.pollFirst();
            List<Integer> l = mapa.get(estacion);
            if (l != null) {
                for (Integer e : l) {
                    if (!setA.contains(e)) {
                        setA.add(e);
                        listaA.add(e);
                    }
                }
            }
        }

        Set<Integer> setB = new HashSet<>();
        LinkedList<Integer> listaB = new LinkedList<>();
        int b = sc.nextInt();
        listaB.add(b);
        setB.add(b);
        while (!listaB.isEmpty()) {
            int estacion = listaB.pollFirst();
            List<Integer> l = mapa.get(estacion);
            if (l!=null) {
                for (Integer e : l) {
                    if (!setB.contains(e)) {
                        setB.add(e);
                        listaB.add(e);
                    }
                }
            }
        }


        //Mirar si hay algun elemento en común en los dos Sets
        boolean encontrado = false;
        for (Integer sa: setA) {
            if (setB.contains(sa)) {
                System.out.println("yes");
                System.out.println(sa);
                encontrado=true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("no");
        }

    }
}

