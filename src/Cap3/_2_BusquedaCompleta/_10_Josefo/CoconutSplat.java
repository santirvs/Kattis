package Cap3._2_BusquedaCompleta._10_Josefo;

// Problema de Josefo, con la variante de que los elementos se van transformando

import java.util.LinkedList;
import java.util.Scanner;

public class CoconutSplat {

    static final int INICIO = 0;   // estado inicial del jugador
    static final int PARTIDO = 1;  // con los cocos separados
    static final int ABAJO = 2;    // el coco hacia abajo

    static class Jugador {
        int numero; // número del jugador
        int estado; // número de cocos que tiene

        public Jugador(int numero, int estado) {
            this.numero = numero;
            this.estado = estado;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int salto = sc.nextInt(); // número de sílabas del juego
        int numJugadores = sc.nextInt(); // número de jugadores

        LinkedList<Jugador> jugadores = new LinkedList<>();
        for (int i = 0; i < numJugadores; i++) {
            jugadores.add(new Jugador(i + 1, INICIO)); // inicializar cada jugador con su número y estado inicial
        }

        int index = 0; // índice del jugador actual
        while (jugadores.size() > 1) {
            index = (index + salto-1) % jugadores.size();
            Jugador jugadorActual = jugadores.get(index);
            if (jugadorActual.estado == INICIO) {
                jugadorActual.estado = PARTIDO; // el jugador pasa al estado de partido
                jugadores.add(index+1, new Jugador(jugadorActual.numero, PARTIDO)); // añadir un nuevo jugador con el mismo número
                //El índice se mantiene en el mismo lugar
            } else if (jugadorActual.estado == PARTIDO) {
                jugadorActual.estado = ABAJO; // el jugador pasa al estado de abajo
                index++; // avanzar al siguiente elemento
            } else if (jugadorActual.estado == ABAJO) {
                jugadores.remove(index); // el elemento se elimina
                //El índice se mantiene en el mismo lugar (en realidad se pasa al siguiente)
            }
            // DEBUG: Imprimir el estado de los jugadores
            //ImprimirEstadoJugadores(jugadores);
        }

        // Imprimir el número del último jugador que queda
        System.out.println(jugadores.get(0).numero);

    }

    private static void ImprimirEstadoJugadores(LinkedList<Jugador> jugadores) {
        for (Jugador jugador : jugadores) {
            String estado = switch (jugador.estado) {
                case INICIO -> "O";
                case PARTIDO -> "(";
                case ABAJO -> "^";
                default -> "?"; // estado desco nocido
            };
            System.out.print(jugador.numero + estado + " ");
        }
        System.out.println();
    }
}
