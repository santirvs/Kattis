package Cap2._1_EstructurasDatosConBibliotecas._12_ListaColaDeque;

// Hacer una lista enlazada donde se obtienen los elementos por el principio y se añaden por el final (jugadores)
// Implementar una lista de "equipos" que se componen de las combinaciones de dos jugadores (importa el orden!)
// Dos jugadores pueden formar dos equipos diferentes, según el orden en que han llegado primero
// A la hora de mostrar el resultado, si dos equipos empatan, debe mostrarse primero el que estableció el récord antes

// Caso #4: WA -->  Reviso  https://github.com/mpfeifer1/Kattis/blob/master/foosball.cpp
//                  y no veo nada que me haga pensar que el código está mal o que he interpretado mal el enunciado...
//                  Traduzco su solución desde Java

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class FoosballDynasty {

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

    static class Dinastia {
        String delantero;
        String defensa;
        int numVictorias;
    };


    public static void main(String[] args) throws Exception {
        FastIO io = new FastIO();

        //Lectura de datos
        int numJugadores = io.nextInt();

        // Leer los nombres de los jugadores
        LinkedList<String> listaNombres = new LinkedList<>();
        ArrayList<String> todosNombres = new ArrayList<>();

        //Me guardo la lista en una lista enlazada
        //Y en otra lista estática me guardo todos los nombres
        String[] temp = io.nextLine().split(" ");
        for (int jugador = 0; jugador < numJugadores; jugador++) {
            listaNombres.addLast(temp[jugador]);
            todosNombres.add(temp[jugador]);
        }

        // Leer los resultados de los partidos
        String results = io.nextLine();

        // Situación inicial
        String delanteroBlanco, defensaBlanco, delanteroNegro, defensaNegro;
        delanteroBlanco = listaNombres.pop();   //El primer jugador es el delantero del equipo blanco
        delanteroNegro = listaNombres.pop();    //El siguiente jugador es el delantero del equipo negro
        defensaBlanco = listaNombres.pop();     //El siguiente jugador es el defensa del equipo blanco
        defensaNegro = listaNombres.pop();      //El siguiente jugador es el defensa del equipo negro

        //Me guardo un mapa nombre --> Lista para indicar las partidas seguidas que lleva jugando un jugador en el instante i
        HashMap<String, ArrayList<Integer>> rachaPartidas = new HashMap<>();
        //Inicializo la lista de cada jugador a 0 partidas en el instante 0
        for (String i : todosNombres) {
            ArrayList<Integer> v = new ArrayList<>();
            v.add(0);
            rachaPartidas.put(i, v);
        }


        // Aquí me guardaré los ganadores de cada partido
        ArrayList<Dinastia> ganadores = new ArrayList<>();

        //Qué equipo ganó el partido anterior? Inicializo con cualquier valor diferente de B o W
        char prev = 'A';

        // Simular los partidos
        for (int index = 0; index < results.length(); index++) {

            // Se rompe la racha de partidas para todos los jugadores
            for (String i : todosNombres) {
                rachaPartidas.get(i).add(0);
            }

            //Excepto para los 4 que están jugando ahora, donde (eliminamos el último valor)...
            rachaPartidas.get(delanteroBlanco).remove(rachaPartidas.get(delanteroBlanco).size() - 1);
            rachaPartidas.get(defensaBlanco).remove(rachaPartidas.get(defensaBlanco).size() - 1);
            rachaPartidas.get(delanteroNegro).remove(rachaPartidas.get(delanteroNegro).size() - 1);
            rachaPartidas.get(defensaNegro).remove(rachaPartidas.get(defensaNegro).size() - 1);
            //...y añadimos uno más que la anterior
            rachaPartidas.get(delanteroBlanco).add(rachaPartidas.get(delanteroBlanco).get(rachaPartidas.get(delanteroBlanco).size() - 1) + 1);
            rachaPartidas.get(defensaBlanco).add(rachaPartidas.get(defensaBlanco).get(rachaPartidas.get(defensaBlanco).size() - 1) + 1);
            rachaPartidas.get(delanteroNegro).add(rachaPartidas.get(delanteroNegro).get(rachaPartidas.get(delanteroNegro).size() - 1) + 1);
            rachaPartidas.get(defensaNegro).add(rachaPartidas.get(defensaNegro).get(rachaPartidas.get(defensaNegro).size() - 1) + 1);

            // Crear la dinastía para el equipo que ha ganado
            Dinastia win = new Dinastia();
            // Han ganado los mismos que antes?
            if (results.charAt(index) == prev) {
                //Sí, se incrementa el número de victorias
                win.numVictorias = ganadores.get(ganadores.size() - 1).numVictorias + 1;
            } else {
                //No, es la primera victoria
                win.numVictorias = 1;
            }

            if (results.charAt(index) == 'W') {
                //Victoria del equipo blanco
                //Actualizo la dinastia ganadora
                win.delantero = delanteroBlanco;
                win.defensa = defensaBlanco;

                //Intercambio los jugadores del equipo blanco
                String aux = delanteroBlanco;
                delanteroBlanco = defensaBlanco;
                defensaBlanco = aux;

                //Elimino al defensa del equipo negro, el delantero pasa a la defensa y entra uno nuevo como delantero
                listaNombres.addLast(defensaNegro);
                defensaNegro = delanteroNegro;
                delanteroNegro = listaNombres.pollFirst();

                //Actualizar quien ganó la partida previa
                prev = 'W';
            }
            if (results.charAt(index) == 'B') {
                //Victoria del equipo negro
                //Actualizo la dinastia ganadora
                win.delantero = delanteroNegro;
                win.defensa = defensaNegro;

                //Intercambio los jugadores del equipo negro
                String aux = delanteroNegro;
                delanteroNegro = defensaNegro;
                defensaNegro = aux;

                //Elimino al defensa del equipo blanco, el delantero pasa a la defensa y entra uno nuevo como delantero
                listaNombres.addLast(defensaBlanco);
                defensaBlanco = delanteroBlanco;
                delanteroBlanco = listaNombres.pollFirst();
            }

            //Actualizo quien gano la partida anterior
            prev = results.charAt(index);
            //Añado la dinastía a la lista de ganadores
            ganadores.add(win);
        }

        // Busco el valor máximo de victorias
        int maxVictorias = 0;
        for (Dinastia i : ganadores) {
            maxVictorias = Math.max(maxVictorias, i.numVictorias);
        }

        // Imprimir el resultado
        for (int i = 0; i < ganadores.size(); i++) {
            //Imprimo todos los equipos que han conseguido el máximo de victorias
            //Como se registran cronológicamente, se imprimirán primero los que lo consiguieron antes
            if (ganadores.get(i).numVictorias == maxVictorias) {
                //Obtiene los jugadores del equipo ganador
                String winner1 = ganadores.get(i - maxVictorias + 1).delantero;
                String winner2 = ganadores.get(i - maxVictorias + 1).defensa;
                //Obtiene el número de partidas que llevan jugando en el momento de conseguir el récord
                int t1 = rachaPartidas.get(winner1).get(i);
                int t2 = rachaPartidas.get(winner2).get(i);
                //Imprime antes quien llevaba más tiempo jugando
                if (t1 >= t2) {
                    System.out.println(winner1 + " " + winner2);
                } else {
                    System.out.println(winner2 + " " + winner1);
                }
            }
        }

    }
}
