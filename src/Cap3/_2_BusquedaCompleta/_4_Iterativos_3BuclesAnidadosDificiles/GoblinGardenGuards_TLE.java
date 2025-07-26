package Cap3._2_BusquedaCompleta._4_Iterativos_3BuclesAnidadosDificiles;

// Fuerza bruta
// Probar las posiciones alcanzadas por los aspersores en el jardín
// Guardar las posiciones con duendes, teniendo en cuenta que puede haber varios duendes en la misma posición
// Guardar las posiciones de los aspersores y comprobar. Pueden haber varios aspersores en la misma posición,
// por lo que solo se usará un aspersor por posición que será el de mayor alcance.
// Para cada aspersor, se comprueban las posiciones alcanzadas y se eliminan los duendes.
// Al final, se comprueba el número de duendes restantes.

// v1. TLE en el caso #26
// v2. Usar Fast Input  --> TLE en el caso #26
// v3. Probar en C++ --> TLE en el caso #25 !!!
// v4. Eliminar los objetos Posicion y usar coordenadas enteras directamente (100_000 * x + y)  --> TLE en el caso #26
// v5. Canviar estratègia

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class GoblinGardenGuards_TLE {

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


    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        Reader scan = new Reader();

        // Leer el número de duendes y sus posiciones
        int numDuendes = scan.nextInt();
        int duendesEliminados = 0;
        HashMap<Integer,Integer> duendes = new HashMap<Integer,Integer>();
        for (int i = 0; i < numDuendes; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int posicion = 100_000 * x + y; // Usar coordenadas enteras directamente
            if (duendes.containsKey(posicion)) {
                // Si ya hay un duende en esta posición, incrementar el contador
                duendes.put(posicion, duendes.get(posicion) + 1);
            } else {
                duendes.put(posicion, 1);
            }
        }

        // Leer el número de aspersores, sus posiciones y alcances
        int numAspersores = scan.nextInt();
        HashMap<Integer, Integer> aspersores = new HashMap<Integer, Integer>();
        for (int i = 0; i < numAspersores; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int alcance = scan.nextInt();
            int posicion = 100_000 * x + y; // Usar coordenadas enteras directamente
            // Guardar el aspersor solo si es el de mayor alcance en esa posición
            if (!aspersores.containsKey(posicion) || aspersores.get(posicion) < alcance) {
                aspersores.put(posicion, alcance);
            }
        }

        // Recorrer los aspersores y verificar las posiciones alcanzadas
        for (int aspersor : aspersores.keySet()) {
            int alcance = aspersores.get(aspersor);

            // El rango que buscaremos será el de -alcance a +alcance en ambas direcciones
            // Para verificar si se alcanza una posición haremos x*x + y*y <= alcance*alcance

            // En cada posición, buscaremos si hay duendes y los eliminaremos
            int posXAspersor = aspersor / 100_000;
            int posYAspersor = aspersor % 100_000;
            int alcanceCuadrado = alcance * alcance;

            // Buscar en el cuadrante de posiciones alcanzadas por el aspersor
            for (int dx = -alcance; dx <= +alcance; dx++) {
                for (int dy = -alcance; dy <= +alcance; dy++) {
                    // Comprobar si la posición está dentro del alcance
                    if (dx * dx + dy * dy <= alcanceCuadrado) {
                        int posicionAlcanzada = 100_000 * (posXAspersor + dx) + (posYAspersor + dy);
                        // Si hay duendes en esta posición, eliminarlos
                        if (duendes.containsKey(posicionAlcanzada)) {
                            duendesEliminados += duendes.get(posicionAlcanzada);
                            duendes.remove(posicionAlcanzada);
                        }
                    }
                }
            }
        }

        //Imprimir el resultado
        System.out.println(numDuendes - duendesEliminados );


    }
}
