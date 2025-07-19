package Cap2._3_EstructurasDatosNoLinealesConBibliotecas._5_TablaDeHash_Facil;


import java.util.HashMap;
import java.util.Scanner;

// Leer las canastas encestadas y apuntarlas en un HashMap
// El primero que alcance la puntuacion indicada, gana
// Si nadie alcanza la puntuación, se imprime "No winner!

//Caso de prueba 9: WA!  --> Controlar que un jugador que ya ha ganado no pueda seguir sumando puntos -> AC


public class CompetitiveArcadeBasketball {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numJugadores = scan.nextInt();
        int puntuacionGanadora = scan.nextInt();
        int numCanastas = scan.nextInt();
        scan.nextLine();

        //Leer los jugadores y apuntarlos en un HashMap con puntuacion 0
        HashMap<String, Integer> marcador = new HashMap<String, Integer>();
        for (int i=0; i<numJugadores; i++) {
            marcador.put(scan.nextLine(), 0);
        }

        boolean winner = false;

        for (int i=0; i<numCanastas; i++) {
            String[] linea = scan.nextLine().split(" ");
            String jugador = linea[0];
            int puntos = Integer.parseInt(linea[1]);

            //Incrementar los puntos del jugador, si es que no ha ganado ya
            if (marcador.containsKey(jugador)) {
                puntos += marcador.get(jugador);
                if (puntos >= puntuacionGanadora) {
                    System.out.println(jugador + " wins!");
                    winner = true;
                    marcador.remove(jugador);
                }
                else {
                    marcador.put(jugador, puntos);
                }
            }
        }

        if (!winner) {
            System.out.println("No winner!");
        }
    }

}

