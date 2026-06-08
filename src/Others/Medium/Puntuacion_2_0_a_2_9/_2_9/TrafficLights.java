package Others.Medium.Puntuacion_2_0_a_2_9._2_9;

// Simular en un array de Mxn el estado de cada uno de los n semáforos a lo largo del tiempo
// n es menor de 10
// y M = 2.000.000 no es desmesurado  (realmente con el mcm de todas las duraciones sería suficiente)
// Lo calcularemos aproximadamente (los primos 1,2,3,5,7,11,13,17,19
// Finalmente, buscar la primera posición en la que todas las luces están en verde

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TrafficLights {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numSemaforos = scan.nextInt();
        int MAX_TABLA = 2000000;  // limite superior del mcm  primos:1,2,3,5,7,11,13,17,19 y que sea par y acabe en 0 (aprox. 500000)

        boolean[][] tabla = new boolean[numSemaforos][MAX_TABLA];  //Inicialmente, los semáforos están en rojo

        for (int i = 0; i < numSemaforos; i++) {
            int rojo = scan.nextInt();
            int verde = scan.nextInt();

            int pos = 0;
            while (pos < MAX_TABLA) {
                pos += rojo;
                for (int t = 0; t < verde && (pos + t) < MAX_TABLA; t++) {
                    tabla[i][pos+t] = true;  //marcar como verde
                }
                pos += verde;
            }
        }

        boolean todoEnVerde = false;
        int pos = -1;
        for (int i=0; i < MAX_TABLA && !todoEnVerde; i++) {
            todoEnVerde = true;
            for (int j=0; j <numSemaforos && todoEnVerde; j++) {
                todoEnVerde = tabla[j][i];
            }
            pos = i;
        }

        if (todoEnVerde)
            System.out.println(pos);
        else
            System.out.println(-1);
    }
}
