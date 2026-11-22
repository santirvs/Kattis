package Others.Easy.Puntuacion_1_1_a_1_9._1_9;

/**
 * Leer los datos
 * Trasladarlo a puntos estimados y puntos resueltos (media * num_problemas)
 * Restar puntos y restar problemas pendientes: la división será la media
 */


import java.io.IOException;
import java.util.Scanner;

public class ContestStruggles {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numTotalProblemas = sc.nextInt();
        int numProblemasResueltos = sc.nextInt();
        int dificultadTotal = sc.nextInt();
        int dificultadResueltos = sc.nextInt();

        double puntosTotal = numTotalProblemas * dificultadTotal;
        double puntosEstimados = numProblemasResueltos * dificultadResueltos;

        if (numTotalProblemas == numProblemasResueltos) {
            System.out.println("impossible");
        } else {

            double resultado = (puntosTotal - puntosEstimados) / (numTotalProblemas - numProblemasResueltos);

            if (resultado > 100 || resultado < 0) {
                System.out.println("impossible");
            } else {
                System.out.println(resultado);
            }
        }

        sc.close();
    }
}