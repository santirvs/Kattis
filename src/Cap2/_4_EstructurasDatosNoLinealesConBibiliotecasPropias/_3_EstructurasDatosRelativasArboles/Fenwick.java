package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._3_EstructurasDatosRelativasArboles;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

//Estructura de datos de árbol binario (FenwickTree)
//Usa long como array interno
//v1: TLE Caso #3 -> Uso FastInput
//v2: TLE Caso #3

class Reader {
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

class FenwickTree {
    //Array del acumulador de frecuencias
    private long[] sums;
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
        this.sums = new long[size + 1];
    }

    //Actualización de los nodos del árbol
    public void update(int i, int value) {
        while (i <= size) {
            sums[i] += value;
            i += i & -i;
        }
    }

    //Suma los nodos del árbol
    public long sum(int i) {
        long s = 0;
        while (i > 0) {
            s += sums[i];
            i -= i & -i;
        }
        return s;
    }
}

public class Fenwick {


    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        Reader sc = new Reader();

        //Lectura del tamaño del árbol y del número de consultas
        int n = sc.nextInt();
        int q = sc.nextInt();

        //Declara el árbol de Fenwick
        FenwickTree tree = new FenwickTree(n);

        //Tratamiento de las consultas
        while (q-- > 0) {
            String[] query = sc.readLine().split(" ");
            //Incrementa en v el elemento i+1
            if (query[0].equals("+")) {
                int i = Integer.parseInt(query[1]);
                int v = Integer.parseInt(query[2]);
                tree.update(i + 1, v);
            } else {
                //Muestra la suma hasta el elemento i
                int i = Integer.parseInt(query[1]);
                //El elemento 0 es un elemento de control
                if (i != 0) {
                    System.out.println(tree.sum(i));
                } else {
                    System.out.println(0);
                }
            }
        }

        sc.close();
    }
}


// Código original en C
// sacado de https://github.com/JonSteinn/Kattis-Solutions/blob/master/src/Fenwick%20Tree/C/main.c

//#include <stdio.h>
//#include <stdlib.h>
//
//typedef struct {
//long long* sums;
//int size;
//} FenwickTree;
//
//void update(FenwickTree* tree, int i, int value) {
//    while (i<=tree->size) {
//        tree->sums[i] += value;
//        i += i & -i;
//    }
//}
//
//long long sum(FenwickTree* tree, int i) {
//    long long s = 0;
//    while (i > 0) {
//        s += tree->sums[i];
//        i -= i & (-i);
//    }
//    return s;
//}
//
//FenwickTree* create(int size) {
//    FenwickTree* tree = (FenwickTree*)malloc(sizeof(FenwickTree));
//    tree->sums = calloc(size+1, sizeof(long long));
//    tree->size = size;
//    return tree;
//}
//
//void destroy(FenwickTree* tree) {
//    free(tree->sums);
//    free(tree);
//}
//
//int main() {
//    int n,q,i,v;
//    char c;
//    scanf("%d %d",&n,&q);
//    FenwickTree* tree = create(n);
//    while(q--) {
//        scanf(" %c", &c);
//        if (c == '+') {
//            scanf("%d %d", &i, &v);
//            update(tree, i+1, v);
//        } else {
//            scanf("%d", &i);
//            if (i) {
//                printf("%lld\n", sum(tree,i));
//            } else {
//                printf("0\n");
//            }
//        }
//    }
//    destroy(tree);
//    return 0;
//}