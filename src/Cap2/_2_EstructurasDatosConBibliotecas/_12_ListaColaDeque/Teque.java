package Cap2._2_EstructurasDatosConBibliotecas._12_ListaColaDeque;

// Una TQueue se puede implementar con dos Deques
// En este caso se implementa con dos ArrayList
// Insertar al inicio es insertar al inicio de la primera lista (izquierda)
// Insertar al final es insertar al final de la segunda lista (derecha)
// Insertar en medio es insertar al final de la primera lista (izquierda)
// Al acabar cualquier operación deben balancearse ambas listas: la izquierda no puede tener más de un elemento que la derecha

// Uso directamente FastIO ya que avisa que el juego de pruebas es largo
// Uso dos LinkedList para almacenar los elementos
// Caso #8: TLE --> Cambio LinkedList por ArrayList
//              --> Sigue dando TLE
//              --> Hay que hacer una implmentación propia de una lista
//              --> https://github.com/alif898/Kattis-Solutions/blob/main/TequeProcessor.java
//              --> AC por los pelos!  1.88 .. 1.99s  máximo eran 2s


import java.io.*;

public class Teque {

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

    static class myTeque {
        //Máximo habrá 10^6 elementos.
        //Dimensionar los arrays para la mitad de ese tamaño y conseguir así un acceso en O(1)
        int[] firstHalf; // new int[1000000];
        int[] secondHalf; //= new int[1000000];
        int firstStart;
        int firstSize;
        int secondStart;
        int secondSize;

        myTeque() {
            //En lugar de balancear las listas, se llevan por duplicado con un tamaño dimensionado al doble de lo necesario
            //Se empiezan las listas en la mitad de los arrays y en lugar de desplazar los elementos se desplazan los índices

            this.firstHalf = new int[1_000_000];
            this.secondHalf = new int[1_000_000];
            this.firstStart = 499999;
            this.firstSize = 0;
            this.secondStart = 499999;
            this.secondSize = 0;
        }

        void pushFront(int item) {
            if (firstSize == secondSize) {
                firstStart --;
                firstHalf[firstStart] = item;
                firstSize ++;
            } else {
                firstStart --;
                firstHalf[firstStart] = item;
                secondStart --;
                secondHalf[secondStart] = firstHalf[firstStart + firstSize];
                secondSize ++;
            }
        }

        void pushMiddle(int item) {
            if (firstSize == secondSize) {
                firstHalf[firstStart + firstSize] = item;
                firstSize ++;
            } else {
                secondStart --;
                secondHalf[secondStart] = item;
                secondSize ++;
            }
        }

        void pushBack(int item) {
            if (firstSize == secondSize) {
                secondHalf[secondStart + secondSize] = item;
                firstHalf[firstStart + firstSize] = secondHalf[secondStart];
                secondStart ++;
                firstSize ++;
            } else {
                secondHalf[secondStart + secondSize] = item;
                secondSize ++;
            }
        }

        int get(int index) {
            if (index >= firstSize) {
                return secondHalf[secondStart + index - firstSize];
            } else {
                return firstHalf[firstStart + index];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FastIO scan = new FastIO();

        myTeque teque = new myTeque();

        int numOperaciones = scan.nextInt();
        for (int i=0; i<numOperaciones; i++) {

            String operacion = scan.next();
            int valor = scan.nextInt();

            if (operacion.equals("push_back")) {
                teque.pushBack(valor);
            } else if (operacion.equals("push_front")) {
                teque.pushFront(valor);
            } else if (operacion.equals("push_middle")) {
                teque.pushMiddle(valor);
            }
            else {
                int pos = valor;
                scan.println(""+teque.get(pos));
            }

        }

    }
}

