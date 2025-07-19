package Cap2._2_EstructurasDatosConBibliotecas._12_ListaColaDeque;

// Hacer una lista enlazada donde se obtienen los elementos por el principio y se añaden por el final (jugadores)
// Implementar una lista de "equipos" que se componen de las combinaciones de dos jugadores (importa el orden!)
// Dos jugadores pueden formar dos equipos diferentes, según el orden en que han llegado primero
// A la hora de mostrar el resultado, si dos equipos empatan, debe mostrarse primero el que estableció el récord antes

// Caso #4: WA -->  Reviso  https://github.com/mpfeifer1/Kattis/blob/master/foosball.cpp
//                  y no veo nada que me haga pensar que el código está mal

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class FoosballDynasty_WA {

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

    //Lista de jugadores
    static LinkedList<String> jugadores = new LinkedList<>();
    //Lista de dinastias
    static LinkedList<Dinastia> dinastias = new LinkedList<>();
    //Maxima puntuación
    static int maxPuntos = 0;

    static class Dinastia implements Comparable<Dinastia> {
        String nombreDinastia;
        int puntos = 0;
        int instanteRecord = Integer.MAX_VALUE;

        Dinastia(String nombreDinastia) {
            this.nombreDinastia = nombreDinastia;
        }

        void victoria(int instante) {
            puntos++;
            if (puntos > maxPuntos) {
                maxPuntos = puntos;
                instanteRecord = instante;
            }
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof Dinastia && ((Dinastia) o).nombreDinastia.equals(this.nombreDinastia));
        }

        @Override
        public int compareTo(Dinastia o) {
            if (o.puntos == this.puntos) {
                return this.instanteRecord - o.instanteRecord;
            }
            return o.puntos - this.puntos;
        }
    }

    static class Equipo {
        String ataque;
        String defensa;
        String primerJugador = "";

        void ganar(int instante) {
            //Intercambiar jugadores
            String aux = ataque;
            ataque = defensa;
            defensa = aux;
            //Añadir un punto
            String nomDinastia = nombreDinastia();
            Dinastia d = new Dinastia(nomDinastia);
            int pos = dinastias.indexOf(d);
            if (pos == -1) {
                dinastias.add(d);
                }
            else {
                d = dinastias.get(pos);
            }
            d.victoria(instante);
        }

        void perder() {
            jugadores.addLast(defensa);
            defensa = ataque;
            ataque = jugadores.pollFirst();
            primerJugador = defensa;
        }

        String nombreDinastia() {
            return primerJugador + " " + (ataque.equals(primerJugador)? defensa : ataque);
        }

        @Override
        public String toString() {
            return nombreDinastia();
        }
    }


    public static void main(String[] args) throws Exception {
        FastIO io = new FastIO();

        //Lectura de datos
        int numJugadores = io.nextInt();

        //Lectura de jugadores

        String[] jugadoresArray = io.nextLine().split(" ");
        for (int i = 0; i < numJugadores; i++) {
            jugadores.add(jugadoresArray[i]);
        }

        //Creación de equipos
        Equipo eqBlanco = new Equipo();
        Equipo eqNegro = new Equipo();

        //Asignar los primeros jugadores a los equipos
        eqBlanco.ataque = jugadores.pollFirst();
        eqNegro.ataque = jugadores.pollFirst();
        eqBlanco.defensa = jugadores.pollFirst();
        eqNegro.defensa = jugadores.pollFirst();
        eqBlanco.primerJugador = eqBlanco.ataque;
        eqNegro.primerJugador = eqNegro.ataque;

        //Jugar partidos
        char[] resultados = io.nextLine().toUpperCase().toCharArray();

        for (int i = 0; i < resultados.length; i++) {
            if (resultados[i] == 'W') {
                eqBlanco.ganar(i+1);
                eqNegro.perder();
            } else {
                eqNegro.ganar(i+1);
                eqBlanco.perder();
            }
        }

        //Mostrar resultado
        Collections.sort(dinastias);
        for (Dinastia d : dinastias) {
            if (d.puntos == maxPuntos) {
                io.println(d.nombreDinastia);
            }
            else
                break;
        }

    }
}

