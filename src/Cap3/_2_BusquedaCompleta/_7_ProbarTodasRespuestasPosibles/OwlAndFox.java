package Cap3._2_BusquedaCompleta._7_ProbarTodasRespuestasPosibles;

import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// A falta de una fórmula que nos de el resultado directo, probamos las posibilidades a partir de N-1 hasta 0
// y nos quedamos con el primer número que cumpla la condición
// v1.- TLE en Caso #2
// v2.- Es necesario buscar una fórmula o atajo para evitar TLE
//      Sobre el número original, buscar el primer dígito que no sea 0 y restarle 1
//      Sigue el TLE. Cambiar a FastReader  --> AC

public class OwlAndFox {

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
        //Scanner sc = new Scanner(System.in);
        Reader sc = new Reader();
        // Escritura rápida
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Leer el número de casos
        int numCasos = sc.nextInt();
        for (int i = 0; i < numCasos; i++) {
            // Leer el número a partir del cual se quiere calcular
            int n = sc.nextInt();
            //System.out.println(buscarNumeroAnterior(n));
            bw.write(buscarNumeroAnterior(n) + "\n");
        }

        bw.flush();
        bw.close();
        sc.close();
    }

    private static int buscarNumeroAnterior(int n) {
        String numero = String.valueOf(n);
        StringBuilder resultado = new StringBuilder();

        // Buscar el primer dígito que no sea 0 y restarle 1
        boolean encontrado = false;
        for (int i = numero.length()-1; i >= 0; i--) {
            char digito = numero.charAt(i);
            if (digito != '0' && !encontrado) {
                // Restar 1 al primer dígito que no sea 0
                resultado.insert(0,(char) (digito - 1));
                encontrado = true;
            } else {
                // Mantener los demás dígitos igual
                resultado.insert(0,digito);
            }
        }

        // Convertir el resultado a entero y devolverlo
        return Integer.parseInt(resultado.toString());
    }

    public static void main_v1(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer el número de casos
        int numCasos = sc.nextInt();
        for (int i = 0; i < numCasos; i++) {
            //Leer el número a partir del cual se quiere calcular
            int n = sc.nextInt();
            int sumaDigitosBuscada = sumaDigitos(n)-1;
            for (int j = n - 1; j >= 0; j--) {
                if (sumaDigitos(j) == sumaDigitosBuscada) {
                    System.out.println(j);
                    break; // Salimos del bucle al encontrar el primer número válido
                }
            }
        }
    }

    private static int sumaDigitos(int n) {
        int suma = 0;
        while (n > 0) {
            suma += n % 10; // Sumar el último dígito
            n /= 10; // Eliminar el último dígito
        }
        return suma;
    }
}
