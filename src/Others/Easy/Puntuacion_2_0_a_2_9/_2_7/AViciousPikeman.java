package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

/**
 * Aplicar la fórmula y acumular con cuidado de no excederse de 1 000 000 007
 * Inicialmente deben calcularse todos los tiempos de resolución y resolverlos de menor a mayor
 */

import java.util.Arrays;
import java.util.Scanner;

public class AViciousPikeman {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int MODULO = 1_000_000_007;

        int numProblemasConcurso = sc.nextInt();
        long duracionTotal = sc.nextInt();

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();


        long[] tiemposProblema = new long[numProblemasConcurso];
        tiemposProblema[0] = sc.nextInt();
        for (int i=1; i<numProblemasConcurso; i++) {
            tiemposProblema[i] = (( A*tiemposProblema[i-1] + B) % C) + 1;
        }

        //Ordenar los tiempos
        Arrays.sort(tiemposProblema);

        //Resolver los problemas
        long penalizacion = 0;
        int numProblemasResueltos = 0;
        long instanteUltimoAC = 0;
        boolean concursoFinalizado = false;
        for (int i=0; !concursoFinalizado && i<numProblemasConcurso; i++) {
            if (instanteUltimoAC + tiemposProblema[i] <= duracionTotal) {
                instanteUltimoAC += tiemposProblema[i];
                penalizacion = (penalizacion+instanteUltimoAC) % MODULO;
                numProblemasResueltos++;
            } else {
                concursoFinalizado = true;
            }
        }

        //Mostrar resultado
        System.out.println(numProblemasResueltos + " " + penalizacion);

    }
}