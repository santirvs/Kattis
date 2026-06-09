package Others.Easy.Puntuacion_2_0_a_2_9._2_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Se puede mapear en un bitmask de 15 posiciones
// Hacer un BFS de las posibilidades y quedarnos con la mejor de ellas
// Hay 6 movimientos posibles:
//   horizontal: izq,der y viceversa
//   diagonal1:  arriba,abajo y viceversa
//   diagonal2:  arriba_izq-1,abajo_der+1 y viceversa

public class Pegs {

    static class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }

    public List<List<Position>> movs = new ArrayList(
            List.of(
                List.of( new Position(0,-1), new Position(0,1)),
                List.of( new Position(0,1), new Position(0,-1)),
                List.of( new Position(1,0), new Position(-1,0)),
                List.of( new Position(-1,0), new Position(0,-1)),
                List.of( new Position(-1,-1), new Position(1,1)),
                List.of( new Position(1,1), new Position(-1,-1))
                )
    );

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int tablero = 0;
        for (int i=14; i>=0; i--) {
            String isX = scan.next();
            if (isX.equals("X")) {
                tablero += 1 << i;
            }
        }

        //Comprobar la carga del tablero - OK
        System.out.println(Integer.toBinaryString(tablero));

    }
}