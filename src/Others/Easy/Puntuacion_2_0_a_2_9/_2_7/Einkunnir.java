package Others.Easy.Puntuacion_2_0_a_2_9._2_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Einkunnir {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numPreguntas = sc.nextInt();
        int numAlumnos = sc.nextInt();

        char[] respuestas = new char[numPreguntas];

        for (int i=0; i<numPreguntas; i++) {
            respuestas[i]=sc.next().charAt(0);
        }

        for(int i=0; i<numAlumnos; i++) {
            String nombre = sc.next();
            int puntos = 0;
            for (int p=0; p<numPreguntas; p++) {
                char respuesta = sc.next().charAt(0);
                if (respuesta == respuestas[p]) {
                    puntos++;
                }
            }

            //Calcular la puntuación
            // Nota en escala de 0 a 10 sin redondear
            double notaExacta = (double) puntos * 10.0 / numPreguntas;

            // Redondear al paso de 0.5 más cercano
            // (e.g., multiplicar por 2, Math.round redondea .5 hacia arriba, y dividir por 2.0)
            double notaRedondeada = Math.round(notaExacta * 2.0) / 2.0;

            // Formatear con exactamente un decimal (e.g., 6.5, 8.0)
            System.out.printf(Locale.US, "%s: %.1f%n", nombre, notaRedondeada);

        }

    }
}