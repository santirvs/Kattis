package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;

// Parece un simple ejercicio de lectura de datos y array de frecuencias
// Hay mucho dato inútil que no sirve para nada (números de teléfono)
// En total hay hasta 10_000 llamadas y su duración es de hasta 10_000 segundos --> 10^8 segundos, que no supera el limite de memoria (10^9)
// Pero no tenemos un límite para start que puede llegar a 10^9, por lo que no podemos usar un array de frecuencias para almacenar las llamadas.
//
// Hay que plantearlo como fuerza bruta, guardamos las llamadas y luego respondemos a las consultas de duración de llamada.
// Recorriendo cada una de las llamadas y sumando las duraciones de las llamadas que se encuentren en el intervalo de tiempo dado.

//
// En tiempo es O(n) para apuntar las llamadas y O(n) para cada consulta de duración de llamada, con n

// v1. TLE en Caso de pruebas #2
// v2 --> Traduccion a C++  --> WA
// v3 --> Java + Reader --> WA  (se ha salvado el TLE, pero no se ha pasado al WA)
// v4 --> Hay que buscar qué caso falla
//        ERROR DE INTERPRETACIÓN:
//        No se trata de contar el máximo de llamadas activas a la vez en un intervalo,
//        sino la cantidad de llamadas diferentes que se encuentran activas en algún momento del intervalo.
//        Dejo esta versión aquí (que me ha quedado muy bonita!) y lo hago en otro ejercicio
//        --> AC!!

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class HappyTelephones {

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
        Reader scan = new Reader(); // Usamos el lector personalizado para mejorar la velocidad de lectura

        int numLlamadas = scan.nextInt(); // Número de llamadas
        int numIntervalos = scan.nextInt(); // Número de intervalos

        while (numLlamadas != 0 || numIntervalos != 0) {
            int[] duraciones = new int[numLlamadas]; // Array para almacenar las duraciones de las llamadas
            int[] inicios = new int[numLlamadas]; // Array para almacenar los inicios de las llamadas
            int minInicio = Integer.MAX_VALUE; // Variable para almacenar el inicio mínimo de las llamadas
            int maxFin = Integer.MIN_VALUE; // Variable para almacenar el fin máximo de las llamadas

            // Leer las llamadas
            for (int i = 0; i < numLlamadas; i++) {
                //Ignorar los números de teléfono
                scan.nextInt();
                scan.nextInt();
                //Leer el inicio y la duración de la llamada
                inicios[i] = scan.nextInt();
                duraciones[i] = scan.nextInt();

                minInicio = Math.min(minInicio, inicios[i]);
                maxFin = Math.max(maxFin, inicios[i]+duraciones[i]);
            }

            // Procesar cada intervalo y calcular cuantas llamadas se solapan con el intervalo
            for (int i = 0; i < numIntervalos; i++) {
                int inicioIntervalo = scan.nextInt();
                int finIntervalo = inicioIntervalo + scan.nextInt();
                int contadorLlamadas = 0;

                // Recorrer cada llamada y apuntar las llamadas que se solapen con el intervalo
                for (int llamada = 0; llamada < numLlamadas; llamada++) {
                    int inicioLlamada = inicios[llamada];
                    int finLlamada = inicioLlamada + duraciones[llamada];

                    // Si la llamada se solapa con el intervalo
                    if (finLlamada > inicioIntervalo && inicioLlamada < finIntervalo) {
                        contadorLlamadas++;
                    }
                }

                //Mostrar el resultado
                System.out.println(contadorLlamadas);
            }

            // Siguiente caso
            numLlamadas = scan.nextInt(); // Leer el siguiente número de llamadas
            numIntervalos = scan.nextInt(); // Leer el siguiente número de intervalos

        }

    }
}