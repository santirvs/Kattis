package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Problema de pilas
// Definir un array de pilas
// Pasar los papeles de una pila a otra, pero a través de una pila auxiliar
// para mantener el orden


import java.util.Scanner;
import java.util.Stack;


public class PaperPilePandemonium {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Lectura del número de hojas y del número de pilas
        sc.nextInt();  // numHojas, no lo necesito
        int numPilas = sc.nextInt();

        //Definir el array de pilas
        Stack<Integer>[] pilas = new Stack[numPilas+1];

        //Cargar todas las pilas
        for (int index=1; index<=numPilas; index++) {
            pilas[index] = new Stack<Integer>();
            int numValores = sc.nextInt();
            while (numValores-- > 0) {
                pilas[index].push( sc.nextInt() );
            }
        }

        //Leer la cantidad de movimientos
        int numMovs = sc.nextInt();

        while (numMovs-- > 0) {
            int pilaOrigen = sc.nextInt();
            int pilaDestino = sc.nextInt();
            int numHojas = sc.nextInt();
            Stack<Integer> pilaAux = new Stack<Integer>();

            //Traspasar numHojas a la pila Auxiliar desde el origen
            for (int hoja=0; hoja<numHojas; hoja++) {
                pilaAux.push( pilas[pilaOrigen].pop() );
            }

            //Traspasar numHojas a la pila Destino desde pila Auxiliar
            while (!pilaAux.isEmpty()) {
                pilas[pilaDestino].push( pilaAux.pop() );
            }
        }

        //Para acabar, imprimir cada pila (desde el fondo a la cima)
        //Volvemos a usar una pila auxiliar
        for (int numPila =1; numPila <= numPilas; numPila++) {

            Stack<Integer> pilaAux = new Stack<>();

            while (!pilas[numPila].isEmpty()) {
                pilaAux.push( pilas[numPila].pop() );
            }

            boolean primero = true;
            while (!pilaAux.isEmpty()) {
                if (primero) primero=false;
                else System.out.print(" ");
                System.out.print( pilaAux.pop() );
            }
            System.out.println("");
         }


        sc.close();
    }
}

