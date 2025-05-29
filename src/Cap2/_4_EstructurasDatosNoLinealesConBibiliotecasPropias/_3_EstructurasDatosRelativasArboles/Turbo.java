package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._3_EstructurasDatosRelativasArboles;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*; // Importa utilidades como Scanner para entrada

public class Turbo {

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

    static class FenwickTree {
        //Array del acumulador de frecuencias
        private int[] sums;
        //Tamaño
        private int size;

        //Devuelve el 1 menos significativo del número pasado por parámetro
        // Less Significant One
        public int LSOne(int i) {
            return i & -i;
        }

        //Constructor segun el tamaño estimado
        public FenwickTree(int size) {
            this.size = size;
            this.sums = new int[size + 1];
        }

        //Actualización de los nodos del árbol
        public void update(int i, int value) {
            while (i <= size) {
                sums[i] += value;
                i += i & -i;
            }
        }

        //Suma los nodos del árbol
        public int sum(int i) {
            int s = 0;
            while (i > 0) {
                s += sums[i];
                i -= i & -i;
            }
            return s;
        }
    }

    public static void main(String[] args) throws IOException {
        Reader sc = new Reader(); // Para leer la entrada

        int nums = sc.nextInt(); // Tamaño del array de números
        int puntoMedio = nums / 2;
        if ((nums & 1) == 1) ++puntoMedio; // Si N es impar, redondeamos hacia arriba

        int fin = 2 * puntoMedio + nums;  // Rango máximo necesario para índice en BIT
        FenwickTree ft = new FenwickTree(1+fin);

        int izquierda = 1, derecha = nums; // Punteros para mover desde los extremos hacia el centro
        int[] posiciones = new int[nums + 1]; // Mapea el valor original a su "posición virtual"

        // Lee los valores y los asigna a una posición desplazada d + i
        for (int j = 1; j <= nums; ++j) {
            int num = sc.nextInt();                 // Lee valor original
            posiciones[num] = puntoMedio + j;       // Asigna posición desplazada
            ft.update(puntoMedio + j, 1);   // Marca presencia en BIT
        }

        // Proceso de reordenamiento con conteo de inversiones
        boolean alFinal = false;       // Alternador entre principio (false) y final (true)
        int i = 0;       // Contador de iteraciones
        while (i < nums) {
            if (alFinal) { // Si toca insertar desde el final
                // Calcula cuántos elementos hay a la izquierda de ord[b]
                System.out.println(ft.sum(fin - izquierda + 1) - ft.sum(posiciones[derecha]));
                ft.update(posiciones[derecha], -1);        // Elimina ord[derecha] de su posición
                ft.update(fin - izquierda + 1, 1);    // Lo pone en nueva posición al final
                --derecha;                    // Retrocede puntero de la derecha
            } else { // Si toca insertar desde el frente
                // Calcula cuántos elementos hay antes de ord[a]
                System.out.println(ft.sum(posiciones[izquierda]) - izquierda);
                ft.update(posiciones[izquierda], -1);        // Elimina ord[izquierda] de su posición original
                ft.update(izquierda, 1);              // Lo pone en la nueva posición al frente
                ++izquierda;                    // Avanza puntero de la izquierda
            }
            alFinal = !alFinal; // Alterna entre frente y atrás
            ++i;       // Siguiente iteración
        }

        sc.close(); // Cierra el lector de entrada
    }
}
