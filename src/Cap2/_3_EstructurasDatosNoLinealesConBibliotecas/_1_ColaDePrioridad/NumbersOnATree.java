package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._1_ColaDePrioridad;

// Poco que ver con un cola de prioridad, más que para ver como funciona un binary heap
// Además se puede ver una analogía con la numeración binaria
// N dígitos  --> N+1 bits todos activados a 1
// L --> ponemos a 0 el bit de la altura de la hoja
// R --> ponemos a 0 el bit de la derecha de la altura de la hora

// Caso #12: WA --> Tras hacer la v2 adaptada de https://github.com/mpfeifer1/Kattis/blob/master/numbertree.cpp
//              --> y ver el motivo del problema, cambio el tipo de dato de nivelNodo de int a long -> AC
//              --> no le veo el sentido, ya que 2^31 debería caber en un int.
//              --> hago el cast (int)(Math.pow(2, numNiveles+1) - 1); --> AC
//              --> con (int)Math.pow(2, numNiveles+1) - 1 --> WA ???¿¿¿¿

import java.io.*;

public class NumbersOnATree {

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

        void print(int i) {
            this.print("" + i);
        }

        void println(String s) {
            out.println(s);
            out.flush();
        }

        void println(int i) {
            this.println("" + i);
        }
    }


    public static void main(String[] args) throws Exception {
        FastIO io = new FastIO();

        //Lectura de datos

        String linea = io.nextLine();
        String[] partes = linea.split(" ");

        int numNiveles = Integer.parseInt(partes[0]);

        //Procesamiento
        int nivelNodo = (int)(Math.pow(2, numNiveles+1) - 1);

        //Caso especial directo, sin recorrido
        if (partes.length == 1) {
            //Salida
            System.out.println(nivelNodo);
            return;
        }

        char[] camino = partes[1].toCharArray();
        int resta = 0;
        char anterior = ' ';
        if (camino.length > 0) {
            anterior = camino[0];
            if (camino[0] == 'L') {
                resta = 1;
            } else resta = 2;
            nivelNodo -= resta;
        }
        for (int i=1; i<camino.length; i++) {
            if (camino[i] == 'L' && camino[i-1] == 'L') {
                //LL -> resta * 2
                resta = resta *2;
            } else if (camino[i] == 'R' && camino[i-1] == 'R') {
                //RR -> resta * 2
                resta = resta *2;
            } else if (camino[i] == 'R' && camino[i-1] == 'L') {
                //LR -> resta * 2 +1
                resta = resta *2 + 1;
            } else if (camino[i] == 'L' && camino[i-1] == 'R') {
                //RL -> resta * 2 -1
                resta = resta *2 - 1;
            }

            nivelNodo -=resta;
        }

        //Salida
        System.out.println(nivelNodo);


    }
}
