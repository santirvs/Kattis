package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

/**
 * Sabemos la cantidad de alumnos que han hecho la prueba (N)
 * Sabemos también la puntuación objetivo (P)
 * Y la puntuación de cada prueba (pi)
 * Para alcanzar la puntuación objetivo se necesitarán al menos (P*N - suma(pi)) / 100 pruebas
 * Pero cada nueva prueba nos incrementa el número de pruebas...
 * Se podría buscar una fórmula o se puede iterar hasta encontrar la cantidad
 * donde (P*N + 100*x) / (100 + x) >= P
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TeacherEvaluation {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int numAlumnos = sc.nextInt();
        int promedio = sc.nextInt();
        int sumaPuntos = 0;
        int pruebasFalsas = 0;

        for (int i=0; i<numAlumnos; i++) {
            sumaPuntos += sc.nextInt();
        }

        if (sumaPuntos > promedio * numAlumnos || (promedio == 100 && sumaPuntos < promedio * numAlumnos) ) {
            System.out.println("impossible");
        } else {
            //Buscar cuantos nos faltan hasta que encontremos la cantidad
            int puntosActuales = sumaPuntos + 100*pruebasFalsas;
            int puntosNecesarios = promedio * (numAlumnos + pruebasFalsas);

            while (puntosActuales / (numAlumnos + pruebasFalsas) < promedio) {

                pruebasFalsas += (puntosNecesarios - puntosActuales) / 100;
                if ((puntosNecesarios - puntosActuales) % 100 != 0) pruebasFalsas++;

                puntosActuales = sumaPuntos + 100*pruebasFalsas;
                puntosNecesarios = promedio * (numAlumnos + pruebasFalsas);
            }
            System.out.println(pruebasFalsas);
        }



    }
}