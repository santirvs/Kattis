package Cap2._2_EstructurasDatosConBibliotecas._12_ListaColaDeque;

// Se requieren dos listas, una para cada orilla del rio

// Caso #2: WA --> La salida debe mostrarse en el mismo orden que se indican los coches en la llegada.
//             --> Como llegan en orillas diferentes es posible que no se carguen en el mismo orden
//             --> Sigue dando WA
//             --> Adopto solución de https://github.com/donaldong/kattis/blob/main/solutions/ferryloading3/ferryloading3.cpp
//             --> Veo que me he dejado el caso en que no hay coches para cargar pero ya han llegado a la otra orilla
//             --> Añado el caso y AC! 0.34s

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class FerryLoadingIII_Original {

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

    public static class Coche implements Comparable<Coche> {
        int llegada;
        int cruzado;
        int id;

        Coche(int llegada, int id) {
            this.llegada = llegada;
            this.id = id;
        }

        @Override
        public int compareTo(Coche o) {
            return this.id - o.id;
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
            int capacidadFerry = Integer.parseInt(partes[0]);
            int tiempoViaje = Integer.parseInt(partes[1]);
            int numCoches = Integer.parseInt(partes[2]);

            //Inicializo listas para cada orilla
            LinkedList<Coche> listaDerecha = new LinkedList<>();
            LinkedList<Coche> listaIzquierda = new LinkedList<>();
            ArrayList<Coche> listaLLegadas = new ArrayList<>();
            boolean enLaIzquierda = true;

            //Leer los coches
            for (int i=0; i<numCoches; i++) {
                linea = io.nextLine();
                partes = linea.split(" ");
                int tiempoCoche = Integer.parseInt(partes[0]);
                String orilla = partes[1];
                if (orilla.equals("left")) {
                    listaIzquierda.add(new Coche(tiempoCoche,i));
                } else {
                    listaDerecha.add(new Coche(tiempoCoche,i));
                }
            }

            //Simulación
            int tiempo = 0;
            while (!listaDerecha.isEmpty() || !listaIzquierda.isEmpty()) {
                //Cargar el ferry
                LinkedList<Coche> listaActual = enLaIzquierda ? listaIzquierda : listaDerecha;
                int carga = 0;
                while (!listaActual.isEmpty() && carga < capacidadFerry) {
                    if (listaActual.peek().llegada <= tiempo) {
                        carga++;
                        Coche c = listaActual.poll();
                        c.cruzado = tiempo+tiempoViaje;
                        listaLLegadas.add(c);
                    } else {
                        break;
                    }
                }
                if (carga == 0) {
                    /*
                    if (!Q[otraOrilla].isEmpty() && Q[otraOrilla].peek() <= tiempo) { orilla = otraOrilla; tiempo += tiempoViaje;}
                    else if (!Q[otraOrilla].isEmpty() && !Q[orilla].isEmpty() && Q[otraOrilla].peek() < Q[orilla].peek()) { tiempo = Q[otraOrilla].peek() + tiempoViaje; orilla = otraOrilla; }
                    else if (!Q[orilla].isEmpty()) tiempo = Q[orilla].peek();
                    else { tiempo = Q[otraOrilla].peek() + tiempoViaje;
                    */
                    int tiempoSiguienteCoche;
                    //No hay coches para cargar. Esperar en la misma orilla a que llegue el siguiente coche
                    int siguienteCocheDerecha = listaDerecha.isEmpty() ? Integer.MAX_VALUE : listaDerecha.peek().llegada;
                    int siguienteCocheIzquierda = listaIzquierda.isEmpty() ? Integer.MAX_VALUE : listaIzquierda.peek().llegada;
                    tiempoSiguienteCoche = Math.min(siguienteCocheDerecha, siguienteCocheIzquierda);
                    tiempo = Math.max(tiempo, tiempoSiguienteCoche);  //Puede ser que el coche ya haya llegado a la otra orilla
                    if (listaActual.isEmpty() || tiempo != listaActual.peek().llegada) {
                        //El siguiente coche llega antes a la otra orilla: habrá que cruzar el ferry
                        enLaIzquierda = !enLaIzquierda;
                        tiempo += tiempoViaje;
                    }
                } else {
                    //Cruzar el ferry
                    tiempo += tiempoViaje;
                    enLaIzquierda = !enLaIzquierda;
                }
            }

            //Mostrar la salida
            Collections.sort(listaLLegadas);
            for (Coche c : listaLLegadas) {
                io.println(c.cruzado);
            }

            numCasos--;
            //Salto de línia entre casos, excepto en el último
            if (numCasos > 0)
                io.println("");
        }

    }
}

