package Others.Easy.Puntuacion_1_1_a_1_9._1_5;

// Leer la posición deseada
// Leer la cantidad de movimientos
// La bola empieza en el 2
// Leer todos los movimientos e intercambiar la bola si es necesario
// Si al final se ha acertado la posición, mover los otros dos vasos
// Sino, mover el vaso que tiene la bola a la posición deseada

import java.util.Locale;
import java.util.Scanner;


public class CupsAndBalls {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.UK);

        //Leer el número deseado
        int posFinalDeseada = sc.nextInt();

        //Leer la cantidad de movimientos
        int numMovs = sc.nextInt();

        //Inicialmente la bola siempre está en la posición 2
        int posicionBola = 2;

        //Leer los movimientos
        while (numMovs-- > 0) {
            int vaso1 = sc.nextInt();
            int vaso2 = sc.nextInt();

            //Intercambiar la posicion de la bola si es necesario
            if (vaso1==posicionBola) posicionBola = vaso2;
            else if (vaso2==posicionBola) posicionBola = vaso1;
        }

        //Ha acertado la posicion
        if (posFinalDeseada == posicionBola) {
            //Imprimir las otras dos posiciones
            String posiciones = "";
            for (int i=1; i<=3; i++) {
                if (i!=posicionBola) posiciones += " " + i;
            }
            System.out.println(posiciones.trim());
        }
        else {
            //No ha acertado la posición, llevar la bola a la posicion deseada
            System.out.println(posicionBola + " " + posFinalDeseada);
        }


        sc.close();
    }
}

