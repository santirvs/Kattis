package Others.Easy.Puntuacion_4_0_a_4_9._4_0;

// v1. Cargar la lista de monstruos en memoria
// Procesar cada consulta partiendo de la consulta anterior
// dado que la energia inicial es incremental
// WA en caso #4

// v2-> La potencia se va incrementando y puede desbordar. Debe usarse Long
// Supero el caso #4, pero TLE en caso 15.

// v3-> La solución es lineal, y la entrada no es excesivamente grande 2 * 10^5
// Pruebo con un FastInput -> AC


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MonstersInc {
//region Reader
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

    public Reader(String file_name) throws IOException {
        din = new DataInputStream(
                new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
        byte[] buf = new byte[64]; // line length
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

    public int nextInt() throws IOException {
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

    public long nextLong() throws IOException {
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

    public double nextDouble() throws IOException {
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

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0,
                BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException {
        if (din == null)
            return;
        din.close();
    }
}
//endRegion

    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        Reader scan = new Reader();

        //Leer los datos
        int numMonstruos = scan.nextInt();
        int[][] monstruos = new int[numMonstruos][2];

        for (int index=0; index < numMonstruos; index++) {
            monstruos[index][0]=scan.nextInt();
            monstruos[index][1]=scan.nextInt();
        }

        int numConsultas = scan.nextInt();
        int index = 0;
        int numMonstruosDerrotados = 0;
        long potenciaAcumulada = 0;

        while (numConsultas -- > 0) {
            long potencia = scan.nextLong();
            potencia += potenciaAcumulada;
            while (index < numMonstruos && potencia >= monstruos[index][0]) {
                potencia+=monstruos[index][1];
                potenciaAcumulada+=monstruos[index][1];
                numMonstruosDerrotados++;
                index++;
            }
            System.out.println(numMonstruosDerrotados);
        }
    }
}
