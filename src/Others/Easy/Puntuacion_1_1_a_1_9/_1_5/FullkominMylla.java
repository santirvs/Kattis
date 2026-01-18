package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Cada ronda consta de 5 juegos, pero en el momento en que un jugador alcance 3 puntos, se acaba la ronda.
// La partida se juega a N rondas
// Leer las tiradas (en un String)
// Recorrer el String hasta que se encuentre el ganador de la partida


import java.util.Locale;
import java.util.Scanner;


public class FullkominMylla {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        int numRondas = sc.nextInt();
        sc.nextLine();
        String jugadas = sc.nextLine();

        int index=0;
        int juegosA = 0;
        int juegosH = 0;
        int rondasA = 0;
        int rondasH = 0;

        while (rondasA<numRondas && rondasH <numRondas) {
            char ganador = jugadas.charAt(index);

            //Incrementar el contador de juegos del ganador
            if (ganador == 'A')
                juegosA++;
            else
                juegosH++;

            //Si alguno ha ganado la ronda, incrementar en contador de rondas
            // y reset de los juegos de ambos jugadores
            if (juegosA == 3) {
                rondasA++;
                juegosA = 0;
                juegosH = 0;
            }
            if (juegosH == 3) {
                rondasH++;
                juegosA=0;
                juegosH=0;
            }

            index++;
        }

        //Mostrar el resultado
        if (rondasH==numRondas) {
            System.out.println("Arnar");
        } else {
            System.out.println("Hannes");
        }

        sc.close();
    }
}

