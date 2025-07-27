package Cap3._2_BusquedaCompleta._5_Iterativos_Permutacion;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// v1 -> TLE en Caso #5--> abortar si se encuentra una permutación con 0 repeticiones --> continua el TLE
// v2 : Cambiar planteamiento y usar DP con bitmask para evitar TLE

public class DanceRecital_TLE {

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


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Leer la cantidad de rutinas
        int numRutinas = scan.nextInt();
        String[] rutinas = new String[numRutinas];
        for (int i = 0; i < numRutinas; i++) {
            rutinas[i] = scan.next();
        }

        // Construir el array para generar las permutaciones [0...numRutinas-1]
        int[] numeros = new int[numRutinas];
        for (int i = 0; i < numRutinas; i++) {
            numeros[i] = i;
        }
        List<List<Integer>> resultado = new ArrayList<>();
        permutar(numeros, 0, resultado);

        // Para cada permutación, calcular el número de bailarinas que repiten rutina
        int minQuickChanges = Integer.MAX_VALUE;
        for (List<Integer> perm : resultado) {
            String anterior = rutinas[perm.get(0)];
            //System.out.print(anterior + " ");
            int quickChanges = 0;
            for (int i = 1; i < numRutinas; i++) {
                String actual = rutinas[perm.get(i)];
                quickChanges += requiereQuickChange(anterior, actual);
                anterior = actual;
                //System.out.print(anterior + " ");
            }
            //System.out.print(": " + quickChanges + "\n");
            minQuickChanges = Math.min(minQuickChanges, quickChanges);
            if (minQuickChanges == 0) {
                break; // Si encontramos una permutación con 0 repeticiones, podemos detenernos
            }
        }

        // Mostrar el mínimo de repeticiones  (Sumar 1 deducido a partir del último ejemplo)
        System.out.println(minQuickChanges);
    }

    private static int requiereQuickChange(String anterior, String actual) {
        int repeticiones = 0;
        for (int i = 0; i < anterior.length(); i++) {
            for (int j = 0; j < actual.length(); j++) {
                if (anterior.charAt(i) == actual.charAt(j)) {
                     repeticiones++; // Al menos hay una repetición
                }
            }
        }
        return repeticiones;
    }

    // Algoritmo de permutación por backtracking
    static void permutar(int[] numeros, int indice, List<List<Integer>> resultado) {
        if (indice == numeros.length) {
            List<Integer> lista = new ArrayList<>();
            for (int num : numeros) {
                lista.add(num);
            }
            resultado.add(lista);
        }

        for (int i = indice; i < numeros.length; i++) {
            intercambiar(numeros, indice, i);
            permutar(numeros, indice + 1, resultado);
            intercambiar(numeros, indice, i); // deshacer
        }
    }

    static void intercambiar(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}


