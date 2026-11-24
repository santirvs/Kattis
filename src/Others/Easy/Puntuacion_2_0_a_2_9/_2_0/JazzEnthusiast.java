package Others.Easy.Puntuacion_2_0_a_2_9._2_0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class JazzEnthusiast {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numCanciones = sc.nextInt();
        int segundosSolapamiento = sc.nextInt();
        sc.nextLine();
        int segundosTotal = segundosSolapamiento;

        while (numCanciones-- > 0) {
            String tiempo = sc.nextLine();
            int segundosCancion = tiempoAsegundos(tiempo);

            segundosTotal += segundosCancion - segundosSolapamiento;
        }

        System.out.println(segundosAtiempo(segundosTotal));

    }

    private static String segundosAtiempo(int segundosTotal) {
        int horas = segundosTotal / (60*60);
        int restoHoras = segundosTotal % (60*60);
        int minutos = restoHoras / 60;
        int segundos = restoHoras % 60;

        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    private static int tiempoAsegundos(String tiempo) {
        String[] partes = tiempo.split(":");

        return  Integer.parseInt(partes[0])*60 + Integer.parseInt(partes[1]);
    }
}

