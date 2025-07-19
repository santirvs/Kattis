package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._8_BST_Equilibrado_Map;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

//  Caso de prueba #48: TLE
//  No es necesario actualizar la lista de preferencias de los equipos, basta con comprobar
//  si el jugador sigue disponible en la lista de jugadores pendientes  -> AC, pero Caso #49: TLE
//  Caso de prueba #49: TLE
//  Se cambia la lista de jugadores pendientes de ArrayList a TreeMap para acelerar la eliminación de jugadores -> AC
//

public class FantasyDraft {

    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        //Lee el numero de personas
        String[] partes = in.readLine().split(" ");
        int numTeams = Integer.parseInt(partes[0]);
        int tamanyoEquipo = Integer.parseInt(partes[1]);

        //Array de mapas para cada equipo
        Map<Integer, ArrayList<String>> equipos = new TreeMap<>();
        for (int i = 0; i < numTeams; i++) {
            equipos.put(i, new ArrayList<>());
        }

        //Lee los jugadores y los añade a los equipos
        for (int i = 0; i < numTeams; i++) {
            partes = in.readLine().split(" ");
            int numJugadores = Integer.parseInt(partes[0]);

            for (int j = 1; j <= numJugadores; j++) {
                String nomJugador = partes[j];
                equipos.get(i).add(partes[j]);
            }
        }

        //Lee los jugadores
        int numJugadores = Integer.parseInt(in.readLine());
        //Lista de jugadores pendientes en orden de elección general
        TreeMap<Integer, String> ordenJugadoresPendientes = new TreeMap<>();
        //TreeMap para guardar los jugadores pendientes de ser elegidos y su posición en la lista general
        TreeMap<String, Integer> jugadores = new TreeMap<>();

        for (int i = 0; i < numJugadores; i++) {
            String jugador = in.readLine();
            jugadores.put(jugador, i);
            ordenJugadoresPendientes.put(i, jugador);
        }

        //Empieza el draft
        //Inicializar la lista de jugadoresElegidos
        Map<Integer, ArrayList<String>> jugadoresElegidos = new TreeMap<>();
        for (int i = 0; i < numTeams; i++) {
            jugadoresElegidos.put(i, new ArrayList<>());
        }

        //Para cada ronda (tamanyo del equipo)
        for (int i = 0; i < tamanyoEquipo; i++) {
            //Para cada equipo
            for (int j = 0; j < numTeams; j++) {
                boolean escogido = false;
                // Si aún quedan jugadores en la lista de preferencias
                while  (!escogido && equipos.get(j).size() != 0) {
                    //Saca el primer jugador de la lista de preferencias
                    String jugador = equipos.get(j).remove(0);

                    //Comprueba si el jugador sigue disponible
                    if (jugadores.containsKey(jugador)) {
                        //Lo añade a la lista de jugadores elegidos
                        jugadoresElegidos.get(j).add(jugador);

                        //Lo elimina de la lista de jugadores pendientes
                        ordenJugadoresPendientes.remove(jugadores.get(jugador));
                        jugadores.remove(jugador);

                        escogido = true;
                    }
                }

                // Si no ha podido escoger a un jugador de la lista de preferencias de su equipo, se tira de la lista de pendientes
                if (!escogido) {
                    String jugador = ordenJugadoresPendientes.firstEntry().getValue();
                    jugadoresElegidos.get(j).add(jugador);

                    ordenJugadoresPendientes.remove(jugadores.get(jugador));
                    jugadores.remove(jugador);
                }

            }
        }

        //Imprime los jugadores elegidos
        for (int i = 0; i < numTeams; i++) {
            boolean primero = true;
            for (String jugador : jugadoresElegidos.get(i)) {
                if (!primero) out.print(" ");
                primero = false;
                out.print(jugador);
            }
            out.println();
        }



        out.flush();
        out.close();
        in.close();
    }

}
