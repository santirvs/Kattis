package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Inicialmente cada uno tiene un juego
//  Alice tiene "fishing"
//  Bob tiene "golf"
//  Charlie tiene "hockey"
//  Nos guardaremos quién tiene cada juego y no qué juegos tiene cada uno
//  Leer el número de peticiones
//  Mostrar a quien hay que pedirle el juego o si ya se tiene


import java.util.Locale;
import java.util.Scanner;


public class VideoGames {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        // Leer el número de casos
        int numCasos = sc.nextInt();

        //Situacion inicial
        String quienTieneFishing = "alice";
        String quienTieneGolf = "bob";
        String quienTieneHockey = "charlie";

        // Para cada caso, leer la petición
        for (int i = 0; i < numCasos; i++) {
            String nombre = sc.next();
            sc.next(); sc.next(); sc.next();  // wants to play
            String juego = sc.next();
            String quienLoTiene = "";
            if (juego.equals("fishing")) {
                quienLoTiene = quienTieneFishing;
                quienTieneFishing = nombre;
            } else if (juego.equals("golf")) {
                quienLoTiene = quienTieneGolf;
                quienTieneGolf = nombre;
            } else {
                quienLoTiene = quienTieneHockey;
                quienTieneHockey = nombre;
            }

            if (quienLoTiene.equals(nombre)) {
                System.out.println(nombre + " already has " + juego);
            } else {
                System.out.println(nombre + " borrows " + juego + " from " + quienLoTiene);
            }

        }

        sc.close();
    }
}

