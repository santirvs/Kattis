package Others.Easy.Puntuacion_1_1_a_1_9._1_6;

/**
 * Mantener la cola con un LinkedList
 */

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;


public class CutInLine {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        LinkedList<String> cola = new LinkedList<>();

        //Leer el estado inicial
        int numPersonasInicial = sc.nextInt();
        for (int i=0; i<numPersonasInicial; i++) {
            String nombre = sc.next();
            cola.addLast(nombre);
        }



        //Leer los movimientos
        int numMovimientos = sc.nextInt();
        //Saltar el salto de línea
        sc.nextLine();
        for (int i=0; i<numMovimientos; i++) {
            String[] mov = sc.nextLine().split(" ");

            if (mov[0].equals("cut")) {
                int pos = cola.indexOf(mov[2]);
                if (pos>=0) {
                    cola.add(pos, mov[1]);
                }
            } else if (mov[0].equals("leave")) {
                int pos = cola.indexOf(mov[1]);
                if (pos>=0) {
                    cola.remove(pos);
                }
            }
        }

        //mostrar la cola en el orden final
        while (!cola.isEmpty()) {
            System.out.println(cola.pollFirst());
        }


        sc.close();
    }
}

