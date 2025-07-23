package Cap3._2_BusquedaCompleta.CalculoPrevio;

import java.util.ArrayList;
import java.util.Scanner;

// Leyendo el enunciado no me queda nada claro el funcionamiento del juego Mancala.
// Así que he buscado el funcionamiento en: https://mathcountsbabel.blogspot.com/p/tchoukaillon.html
// En esta lectura se explica el juego y se dan algunas pistas importantes para mantener una posición ganadora.:
// 1.- Coger siempre la casilla más cercana al Roumba que tenga una cantidad de fichas igual a la posición de la casilla.
// 2.- Se cogen todas las fichas de la casilla y se deja una ficha en cada una de las casillas anteriores hasta llegar a la casilla Roumba.
// Estas dos pistas son importantes para entender el funcionamiento del juego y cómo se pueden calcular las posiciones ganadoras.
// Además, en el enunciado se indica que dado cualquier número de casillas sólo existe una posición ganadora.
// Por lo tanto, podemos pre-calcular las posiciones ganadoras para cada número de casillas y guardarlas en un array.
// Construiremos las soluciones a partir de la solución con una casilla anterior que también es una posición ganadora.
// Por lo tanto, ¿como podemos llegar a la solución siguiente a partir de la anterior?
// Sabemos lo que hay que hacer para mantener la posición ganadora, así que haremos el paso opuesto:
// 1.- Restar una ficha de cada una de las casillas desde Roumba hasta una casilla con 0 fichas
// 2.- A la primera casilla con 0 fichas se le asigna el número de fichas que se ha restado (que deberá coincidir con la posición de la casilla).

// Precalcular todas las soluciones para cada número de casillas de 1 a 2000
// Atención a la presentación del resultado, que deben mostrarse los números en filas de un máximo de 10 números


public class Mancala {

    private static ArrayList<Integer>[] posicionesGanadoras = new ArrayList[2001];

    public static void main(String[] args) {
       generarPosicionesGanadoras();
       solve();
    }

    public static void generarPosicionesGanadoras() {
        posicionesGanadoras[0] = new ArrayList<>();
        // La posición ganadora para 1 casilla es 1
        posicionesGanadoras[1] = new ArrayList<>();
        posicionesGanadoras[1].add(1);

        // Calcular las posiciones ganadoras para cada número de casillas de 2 a 2000
        for (int i = 2; i <= 2000; i++) {
            posicionesGanadoras[i] = (ArrayList<Integer>) posicionesGanadoras[i-1].clone(); // Copiamos la posición ganadora de i-1 casillas
            // Restamos una ficha de cada casilla desde Roumba hasta la primera casilla con 0 fichas
            int pos = 0;
            // Buscamos la primera casilla con 0 fichas
            while (pos < posicionesGanadoras[i].size() && posicionesGanadoras[i].get(pos) > 0) {
                posicionesGanadoras[i].set(pos, posicionesGanadoras[i].get(pos) - 1); // Restamos una ficha de la casilla actual
                pos++; // Pasamos a la siguiente casilla
            }
            // Asignamos el número de fichas que se ha restado a la primera casilla con 0 fichas
            if (pos < posicionesGanadoras[i].size()) {
                posicionesGanadoras[i].set(pos, pos + 1); // La posición de la casilla es igual al número de fichas que se ha restado
            } else {
                // Si no hay más casillas, añadimos una nueva casilla con el número de fichas que se ha restado
                posicionesGanadoras[i].add(pos + 1);
            }

        }

        // Mostrar todas las posiciones ganadoras de 1 a 2000
//        for (int i = 1; i <= 2000; i++) {
//            System.out.print("Solución para " + i + ": " + posicionesGanadoras[i].toString() + " ");
//        }
    }

    public static void solve() {
        Scanner scan = new Scanner(System.in);
        int numCasos = scan.nextInt();
        while (numCasos-- > 0) {
            int numCaso = scan.nextInt();
            int n = scan.nextInt();
            ArrayList<Integer> solucion = posicionesGanadoras[n];

            // Imprimir la solución
            // Primera línea con el número de caso y número de casillas
            System.out.println(numCaso + " " + solucion.size());

            // A continuación, imprimir los números de la solución en filas de un máximo de 10 números
            for (int i = 0; i < solucion.size(); i++) {
                System.out.print(solucion.get(i));
                if ((i + 1) % 10 == 0 || i == solucion.size() - 1) {
                    System.out.println(); // Nueva línea cada 10 números o al final
                } else {
                    System.out.print(" "); // Espacio entre números
                }
            }
        }
    }
}
