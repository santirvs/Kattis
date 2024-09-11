package Cap2._1_EstructurasDatosConBibliotecas._12_ListaColaDeque;

// Muy parecido al FerryLoadingIII, pero contando el número de viajes.
// Parto del código de FerryLoadingIII

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class FerryLoadingIV {

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
        int numCasos = io.nextInt();

        while (numCasos > 0) {

            //Leer la longitud del ferry y el número de coches
            String linea = io.nextLine();
            String[] partes = linea.split(" ");
            int capacidadFerry = Integer.parseInt(partes[0]) * 100; //Paso a cm que es como llega la longitud de los coches
            int numCoches = Integer.parseInt(partes[1]);

            //Inicializo listas para cada orilla
            LinkedList<Integer> listaDerecha = new LinkedList<>();
            LinkedList<Integer> listaIzquierda = new LinkedList<>();
            boolean enLaIzquierda = true;
            int numViajes =0;

            //Leer los coches
            for (int i=0; i<numCoches; i++) {
                linea = io.nextLine();
                partes = linea.split(" ");
                int longCoche = Integer.parseInt(partes[0]);
                String orilla = partes[1];
                if (orilla.equals("left")) {
                    listaIzquierda.add(longCoche);
                } else {
                    listaDerecha.add(longCoche);
                }
            }

            //Simulación
            int tiempo = 0;
            while (!listaDerecha.isEmpty() || !listaIzquierda.isEmpty()) {
                //Cargar el ferry
                LinkedList<Integer> listaActual = enLaIzquierda ? listaIzquierda : listaDerecha;
                int carga = 0;
                while (!listaActual.isEmpty() && carga < capacidadFerry) {
                    int disponible = capacidadFerry-carga;
                    if (listaActual.peek() <= disponible) {
                        carga+=listaActual.poll();
                    } else {
                        break;
                    }
                }
                //Independientemente de si hay carga o no, el ferry debe cruzar a la otra orilla
                // Si hay carga es evidente que debe cruzar.
                // Si no hay carga, solo cruzará si hay coches en la otra orilla (en general, en alguna orilla)

                if (carga !=0 || !listaDerecha.isEmpty() || !listaIzquierda.isEmpty()) {
                    //Cruzar el ferry
                    numViajes++;
                    enLaIzquierda = !enLaIzquierda;
                }
            }

            //Mostrar la salida
            io.println(numViajes);

            numCasos--;
        }

    }
}

