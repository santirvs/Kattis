package Cap2._1_EstructurasDatosConBibliotecas._12_ListaColaDeque;

// Usar una lista enlazada para simular el comportamiento de un editor de texto

// Caso #4: TLE -->  Las librerias de java no dan la talla...
//            -->  Hago una implementación propia con un array de tamaño máximo la secuencia de entrada y un índice para controlar la posición
//            -->  De nuevo TLE!!!
//            -->  La impresión final, en lugar de hacerla caracter a caracter, la hago con un StringBuilder
//            -->  AC!  0.16s

import java.io.*;
import java.util.ArrayList;

public class Backspace {

    static class FastIO {
        BufferedReader in;
        PrintWriter out;

        FastIO() {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        int nextInt() throws Exception {
            return Integer.parseInt(in.readLine());
        }

        String nextLine() throws Exception {
            return in.readLine();
        }

        String next() throws Exception {
            StringBuilder s = new StringBuilder();
            while (true) {
                int c = in.read();
                if (Character.isWhitespace(c) || c == -1) {
                    break;
                }
                s.append((char) c);
            }
            return s.toString();
        }

        void print(String s) {
            out.print(s);
            out.flush();
        }

        void println(String s) {
            out.println(s);
            out.flush();
        }
    }

    public static void main(String[] args) throws Exception {
        FastIO io = new FastIO();

        //Leer la secuencia de entrada
        String operaciones = io.nextLine();

        //Analizar la secuencia de entrada
        char[] lista = new char[operaciones.length()];  //El tamaño máximo de la lista es la longitud de la secuencia de entrada
        int pos = 0;
        for (int i=0; i<operaciones.length(); i++) {
            char c = operaciones.charAt(i);
            if (c == '<') {
                //Backspace
                if (pos > 0) {
                    pos--;
                }
            } else {
                lista[pos] = c;
                pos++;
            }
        }

        //Imprimir la secuencia resultante
        io.println(new StringBuilder().append(lista,0, pos).toString());


    }
}

