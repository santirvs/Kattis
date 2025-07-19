package Cap2._2_EstructurasDatosConBibliotecas._10_Pila;

import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class EvenUp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        //Lectura de datos
        int numCartas = scan.nextInt();

        //Creamos la pila
        Stack<Integer> pila = new Stack<>();

        for (int i=0; i<numCartas; i++) {
            int carta = scan.nextInt();
            if (pila.isEmpty()) {
                pila.push(carta);
            }
            else {
                if ((pila.peek() + carta) % 2 == 0) {
                    pila.pop();
                }
                else {
                    pila.push(carta);
                }
            }
        }

        //Imprimimos el resultado
        System.out.println(pila.size());

    }

}
